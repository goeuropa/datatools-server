import React, { Component, PropTypes } from 'react'
import { Map, Marker, Popup, Polyline, TileLayer, FeatureGroup, ZoomControl, LayersControl, GeoJson } from 'react-leaflet'
import { divIcon, Browser } from 'leaflet'
import { Button, Dropdown, OverlayTrigger, Tooltip, Row, Col, ButtonGroup, MenuItem, SplitButton, FormGroup, ControlLabel } from 'react-bootstrap'
import { shallowEqual } from 'react-pure-render'
import {Icon} from 'react-fa'
import ll from 'lonlng'
import lineString from 'turf-linestring'
import bearing from 'turf-bearing'
import point from 'turf-point'
import along from 'turf-along'
import lineDistance from 'turf-line-distance'
import lineSlice from 'turf-line-slice'
import pointOnLine from 'turf-point-on-line'

import { generateUID } from '../../common/util/util'
import { getUserMetadataProperty } from '../../common/util/user'
import { getConfigProperty } from '../../common/util/config'
// import CircleMarkerWithLabel from './CircleMarkerWithLabel'
// import MarkerWithLabel from './MarkerWithLabel'
import MinuteSecondInput from './MinuteSecondInput'
// import StopMarkersLayer from './StopMarkersLayer'
import StopLayer from '../../scenario-editor/components/StopLayer'
import {polyline as getPolyline, getSegment} from '../../scenario-editor/utils/valhalla'

export default class EditorMap extends Component {
  static propTypes = {
    activeSubEntity: PropTypes.string,
    activeEntityId: PropTypes.string,
    activeComponent: PropTypes.string,
    currentPattern: PropTypes.object,

    stops: PropTypes.array,
    stopTree: PropTypes.object,

    editSettings: PropTypes.object,
    mapState: PropTypes.object,
    feedSource: PropTypes.object,
    feedInfo: PropTypes.object,
    zoomToTarget: PropTypes.bool,

    entities: PropTypes.array,
    activeEntity: PropTypes.object,
    entityEdited: PropTypes.bool,
    offset: PropTypes.number,
    tripPatterns: PropTypes.array,

    updateActiveEntity: PropTypes.func,
    saveActiveEntity: PropTypes.func,
    setActiveEntity: PropTypes.func,
    updateControlPoint: PropTypes.func,
    newEntityClicked: PropTypes.func,

    updateMapSetting: PropTypes.func,
    addControlPoint: PropTypes.func,
    removeControlPoint: PropTypes.func,

    updateUserMetadata: PropTypes.func,
    user: PropTypes.object,

    sidebarExpanded: PropTypes.bool,
    hidden: PropTypes.bool,
    drawStops: PropTypes.bool // whether to draw stops or not (based on zoom level)
  }
  constructor (props) {
    super(props)
    this.state = {
      controlPoints: this.props.editSettings.controlPoints && this.props.editSettings.controlPoints.length
        ? this.props.editSettings.controlPoints[this.props.editSettings.controlPoints.length - 1]
        : []
    }
  }
  updateDimensions () {
    this.setState({width: window.innerWidth, height: window.innerHeight})
    this.refs.map && setTimeout(() => this.refs.map.leafletElement.invalidateSize(), 500)
  }
  componentWillMount () {
    this.updateDimensions()
    this.setState({willMount: true})
  }
  componentDidMount () {
    window.addEventListener('resize', () => this.updateDimensions())
    this.setState({willMount: false})
  }
  componentWillUnmount () {
    window.removeEventListener('resize', () => this.updateDimensions())
  }
  componentWillReceiveProps (nextProps) {
    if (nextProps.offset !== this.props.offset) {
      this.updateDimensions()
    }
    if (nextProps.editSettings.controlPoints && nextProps.editSettings.controlPoints.length && !shallowEqual(nextProps.editSettings.controlPoints, this.props.editSettings.controlPoints)) {
      this.setState({controlPoints: nextProps.editSettings.controlPoints[nextProps.editSettings.controlPoints.length - 1]})
    }
    if (nextProps.zoomToTarget && !shallowEqual(nextProps.zoomToTarget, this.props.zoomToTarget)) {
      // this.updateDimensions()
      this.setState({zoomToTarget: true})
    }
  }
  shouldComponentUpdate (nextProps, nextState) {
    // return true
    const shouldUpdate =
            !shallowEqual(nextState, this.state) ||
            this.props.hidden !== nextProps.hidden ||
            !shallowEqual(nextProps.mapState.routesGeojson, this.props.mapState.routesGeojson) ||
            (nextProps.activeComponent === 'stop' || nextProps.activeComponent === 'route') && nextProps.activeEntityId !== this.props.activeEntityId ||
            nextProps.activeEntity && this.props.activeEntity && nextProps.activeEntity.tripPatterns && !this.props.activeEntity.tripPatterns ||
            !shallowEqual(nextProps.feedSource, this.props.feedSource) ||
            nextProps.activeComponent !== this.props.activeComponent ||
            !this.props.activeEntity && nextProps.activeEntity ||
            // TODO: add bounds to shouldComponentUpdate and move mapZoom/bounds to mapState reducer
            nextProps.drawStops && !shallowEqual(nextProps.mapState.bounds, this.props.mapState.bounds) ||
            !shallowEqual(nextProps.drawStops, this.props.drawStops) ||
            !shallowEqual(nextProps.tripPatterns, this.props.tripPatterns) ||
            !shallowEqual(nextProps.zoomToTarget, this.props.zoomToTarget) ||
            !shallowEqual(nextProps.editSettings, this.props.editSettings) ||
            !shallowEqual(nextProps.activeSubEntity, this.props.activeSubEntity) ||
            !shallowEqual(nextProps.currentPattern, this.props.currentPattern) ||
            // nextProps.activeComponent === 'stop' && this.props.mapState.zoom !== nextProps.mapState.zoom ||
            nextProps.activeComponent === 'stop' && this.props.activeEntity && nextProps.activeEntity && (this.props.activeEntity.stop_lon !== nextProps.activeEntity.stop_lon || this.props.activeEntity.stop_lat !== nextProps.activeEntity.stop_lat) ||
            nextProps.activeEntityId !== this.props.activeEntityId ||
            nextProps.sidebarExpanded !== this.props.sidebarExpanded

    return shouldUpdate
  }
  zoomToEntity (entity) {
    if (entity && entity.id) {
      this.refs.map.leafletElement.panTo([entity.stop_lat, entity.stop_lon])
    }
  }
  getStopLatLng (latlng) {
    const precision = 100000000 // eight decimal places is accurate up to 1.1 meters
    return {stop_lat: Math.round(latlng.lat * precision) / precision, stop_lon: Math.round(latlng.lng % 180 * precision) / precision}
  }
  async extendPatternToStop (pattern, endPoint, stop) {
    let newShape = await getPolyline([endPoint, stop])
    if (newShape) {
      this.props.updateActiveEntity(pattern, 'trippattern', {shape: {type: 'LineString', coordinates: [...pattern.shape.coordinates, ...newShape]}})
      this.props.saveActiveEntity('trippattern')
      return true
    } else {
      this.props.updateActiveEntity(pattern, 'trippattern', {shape: {type: 'LineString', coordinates: [...pattern.shape.coordinates, ll.toCoordinates(stop)]}})
      this.props.saveActiveEntity('trippattern')
      return false
    }
  }
  async addStopToPattern (pattern, stop, index) {
    let patternStops = [...pattern.patternStops]

    let coordinates = pattern.shape && pattern.shape.coordinates
    let newStop = {stopId: stop.id, defaultDwellTime: 0, defaultTravelTime: 0}
    // if adding stop to end
    if (typeof index === 'undefined') {
      // if shape coordinates already exist, just extend them
      if (coordinates) {
        let endPoint = ll.toLatlng(coordinates[coordinates.length - 1])
        this.extendPatternToStop(pattern, endPoint, {lng: stop.stop_lon, lat: stop.stop_lat})
        .then(() => {
          patternStops.push(newStop)
          this.props.updateActiveEntity(pattern, 'trippattern', {patternStops: patternStops})
          this.props.saveActiveEntity('trippattern')
        })
      } else { // if shape coordinates do not exist, add pattern stop and get shape between stops (if multiple stops exist)
        patternStops.push(newStop)
        if (patternStops.length > 1) {
          let previousStop = this.props.stops.find(s => s.id === patternStops[patternStops.length - 2].stopId)
          console.log(previousStop)
          let geojson = await getSegment([[previousStop.stop_lon, previousStop.stop_lat], [stop.stop_lon, stop.stop_lat]], this.props.editSettings.followStreets)
          this.props.updateActiveEntity(pattern, 'trippattern', {patternStops: patternStops, shape: {type: 'LineString', coordinates: geojson.coordinates}})
          this.props.saveActiveEntity('trippattern')
        } else {
          this.props.updateActiveEntity(pattern, 'trippattern', {patternStops: patternStops})
          this.props.saveActiveEntity('trippattern')
        }
      }

      // if not following roads
      // this.props.updateActiveEntity(pattern, 'trippattern', {patternStops: patternStops, shape: {type: 'LineString', coordinates: coordinates}})
    } else { // if adding stop in middle
      patternStops.splice(index, 0, newStop)
      this.props.updateActiveEntity(pattern, 'trippattern', {patternStops: patternStops})
      this.props.saveActiveEntity('trippattern')
    }
    // TODO: add strategy for stop at beginning
  }
  async removeStopFromPattern (pattern, stop, index) {
    let patternGeojson = this.refs[pattern.id].leafletElement.toGeoJSON()
    console.log(patternGeojson.geometry.coordinates.length)

    let controlPointIndex = this.state.controlPoints.findIndex(cp => cp.stopId === stop.id)
    console.log('stop is controlPoint #' + controlPointIndex)
    let begin = this.state.controlPoints[controlPointIndex - 2] ? this.state.controlPoints[controlPointIndex - 1].point : null
    let end = this.state.controlPoints[controlPointIndex + 2] ? this.state.controlPoints[controlPointIndex + 1].point : null

    let coordinates = await this.handlePatternEdit(null, begin, end)

    // // update pattern
    // let patternGeojson = this.refs[pattern.id].leafletElement.toGeoJSON()
    // this.props.updateActiveEntity(pattern, 'trippattern', {shape: {type: 'LineString', coordinates: coordinates}})

    let patternStops = [...pattern.patternStops]
    patternStops.splice(index, 1)
    this.props.updateActiveEntity(pattern, 'trippattern', {patternStops: patternStops, shape: {type: 'LineString', coordinates: coordinates}})
    this.props.saveActiveEntity('trippattern')
  }
  handleControlPointDragEnd (e, timer, controlPointRef, controlPointIndex) {
    let patternGeojson = this.refs[this.props.currentPattern.id].leafletElement.toGeoJSON()

    // snap control point to line
    let controlPointLocation = e.target.toGeoJSON()
    let snapPoint = pointOnLine(patternGeojson, controlPointLocation)
    this.refs[controlPointRef].leafletElement.setLatLng(ll.toLatlng(snapPoint.geometry.coordinates))

    this.props.updateActiveEntity(this.props.currentPattern, 'trippattern', {shape: {type: 'LineString', coordinates: patternGeojson.geometry.coordinates}})

    if (typeof controlPointIndex !== 'undefined') {
      let lineSegment = lineSlice(point(patternGeojson.geometry.coordinates[0]), snapPoint, patternGeojson)

      // measure line segment
      let distTraveled = lineDistance(lineSegment, 'meters')
      this.props.updateControlPoint(controlPointIndex, snapPoint, distTraveled)
      // var stateUpdate = { controlPoints: {[controlPointIndex]: {point: { $set : snapPoint }, distance: {$set: distTraveled} }}}
      // this.setState(update(this.state, stateUpdate))
    }
    // clear timer
    if (timer) clearInterval(timer)
  }
  mapRightClicked (e) {
    if (this.props.activeComponent === 'stop') {
      // if newly created stop is selected
      let stopLatLng = this.getStopLatLng(e.latlng)
      if (this.props.activeEntity && this.props.activeEntity.id === 'new') {
        this.props.updateActiveEntity(this.props.activeEntity, this.props.activeComponent, stopLatLng)
        this.refs[this.props.activeEntity.id].leafletElement.setLatLng(e.latlng)
      } else if (this.props.entities && this.props.entities.findIndex(e => e.id === 'new') === -1) {
        this.props.newEntityClicked(this.props.feedSource.id, this.props.activeComponent,
          {
            stop_id: generateUID(),
            ...stopLatLng
          }
        )
      }
    }
  }
  mapBaseLayerChanged (e, layers) {
    const layer = layers.find(l => l.name === e.name)
    console.log('base layer changed', e)
    this.props.updateUserMetadata(this.props.user.profile, {editor: {map_id: layer.id}})
  }
  addControlPoint (pattern, latlng) {
    // console.log('adding control point at ' + latlng)
    // slice line
    let beginPoint = point(pattern.shape.coordinates[0])
    let clickPoint = point(ll.toCoordinates(latlng))
    let lineSegment = lineSlice(beginPoint, clickPoint, pattern.shape)

    // measure line segment
    let distTraveled = lineDistance(lineSegment, 'meters')
    let controlPoint = {distance: distTraveled, point: clickPoint}

    // find splice index based on shape dist traveled
    let index = 0
    for (var i = 0; i < this.state.controlPoints.length; i++) {
      if (distTraveled > this.state.controlPoints[i].distance) {
        index = i + 1
      } else {
        break
      }
    }
    // add control point
    this.props.addControlPoint(controlPoint, index)
  }
  async removeControlPoint (pattern, index, begin, end) {
    let coordinates = await this.handlePatternEdit(null, begin, end)

    // update pattern
    this.props.updateActiveEntity(pattern, 'trippattern', {shape: {type: 'LineString', coordinates: coordinates}})

    // remove controlPoint
    this.props.removeControlPoint(index)
  }
  async mapClicked (e) {
    // console.log(e.latlng)
    if (this.props.activeComponent === 'stop') {
      // find stop based on latlng
      let selectedStop = this.props.entities.find(stop => Math.round(stop.stop_lat * 1000) / 1000 === Math.round(e.latlng.lat * 1000) / 1000 && Math.round(stop.stop_lon * 1000) / 1000 === Math.round(e.latlng.lng * 1000) / 1000)
      console.log('map click selected -->', selectedStop)
      if (selectedStop) {
        if (this.props.activeEntity && this.props.activeEntity.id === selectedStop.id) {
          // do nothing, the user just clicked the current stop
        } else {
          this.props.setActiveEntity(this.props.feedSource.id, this.props.activeComponent, selectedStop)
        }
      }
    }
  }
  mapBoundsChanged (e) {
    if (this.state.zoomToTarget) {
      setTimeout(() => {
        this.setState({zoomToTarget: false})
      }, 200)
      return false
    } else {
      const zoom = e.target.getZoom()
      const bounds = e.target.getBounds()
      if (this.props.mapState.zoom !== zoom) {
        this.props.updateMapSetting({zoom})
      }
      if (!bounds.equals(this.props.mapState.bounds)) {
        this.props.updateMapSetting({bounds: e.target.getBounds()})
      }
    }
  }
  async handlePatternEdit (controlPointRef, begin, end) {
    let followRoad = this.props.editSettings.followStreets // !e.originalEvent.shiftKey
    let leafletPattern = this.refs[this.props.currentPattern.id].leafletElement
    let originalLatLngs
    let originalEndPoint
    let from, to
    let markerLatLng

    if (controlPointRef !== null) {
      markerLatLng = this.refs[controlPointRef].leafletElement.getLatLng()
    }

    // set from, to for endPoint if we have markerLatLng
    if (begin && markerLatLng) {
      from = begin
      to = [markerLatLng.lng, markerLatLng.lat]
    } else if (begin) { // set just from (when controlPoint is removed)
      from = begin
    } else if (end) { // set from for beginPoint
      from = [markerLatLng.lng, markerLatLng.lat]
    } else if (this.state.newLatLngs) { // if pattern has been previously edited, use that endpoint
      originalLatLngs = this.state.newLatLngs
      originalEndPoint = originalLatLngs[originalLatLngs.length - 1]
      from = [originalEndPoint.lng, originalEndPoint.lat]
    } else { // otherwise use the original endpoint
      originalLatLngs = this.props.currentPattern.shape.coordinates.map(c => ([c[1], c[0]]))
      originalEndPoint = originalLatLngs[originalLatLngs.length - 1]
      from = [originalEndPoint[1], originalEndPoint[0]] // [latLngs[latLngs.length - 1].lng, latLngs[latLngs.length - 1].lat]
      to = [markerLatLng.lng, markerLatLng.lat]
    }

    let latLngs = leafletPattern.toGeoJSON().geometry.coordinates

    if (from) {
      let points = [
        from.geometry ? from.geometry.coordinates : from
      ]
      if (to) {
        points.push(to)
      }
      if (end) {
        points.push(end.geometry.coordinates)
      }
      let newCoordinates
      let newSegment = await getSegment(points, followRoad)
      let originalSegment = lineString(latLngs)

      // slice line if middle control point
      if (end && begin) {
        let beginPoint = point(latLngs[0])
        let beginSlice = lineSlice(beginPoint, from, originalSegment)
        let endPoint = point(latLngs[latLngs.length - 1])
        let endSlice = lineSlice(end, endPoint, originalSegment)
        newCoordinates = [
          ...beginSlice.geometry.coordinates,
          ...newSegment.coordinates,
          ...endSlice.geometry.coordinates
        ]
      } else if (end) { // handle begin control point
        let endPoint = point(latLngs[latLngs.length - 1])
        let endSlice = lineSlice(end, endPoint, originalSegment)
        newCoordinates = [
          ...newSegment.coordinates,
          ...endSlice.geometry.coordinates
        ]
      } else { // append latlngs if end control point
        let beginPoint = point(latLngs[0])
        let beginSlice = lineSlice(beginPoint, from, originalSegment)
        newCoordinates = [
          ...beginSlice.geometry.coordinates,
          ...newSegment.coordinates
        ]
      }
      let leafletCoords = newCoordinates.map(coord => ll.fromCoordinates(coord))
      leafletPattern.setLatLngs(leafletCoords)
      // // add last coordinate as "stop"
      // let endPoint = newPath[newPath.length - 1]
      // // this.setState({patternStops: })

      return newCoordinates
    }
  }
  getMapComponents (component, entity, subEntity) {
    switch (component) {
      case 'route':
        let route = entity
        let bounds = this.refs.map && this.refs.map.leafletElement.getBounds()
        // get intervals along path for arrow icons
        let patternLength = this.props.currentPattern && this.props.currentPattern.shape ? lineDistance(this.props.currentPattern.shape, 'meters') : 0
        let zoom = this.refs.map ? this.refs.map.leafletElement.getZoom() : 11
        let iconInterval = zoom > 15
                      ? 200
                      : zoom > 14
                      ? 500
                      : zoom > 12
                      ? 2000
                      : zoom > 10
                      ? 4000
                      : zoom > 6
                      ? 8000
                      : 10000
                      // : 0.001 * Math.exp(zoom - 6) < 3 ? 3 : 0.001 * Math.exp(zoom - 3)

        // let directionIconInterval = patternLength / iconInterval // 2000 // meters
        let lengthsAlongPattern = []
        for (var i = 0; i < Math.floor(patternLength / iconInterval); i++) {
          let distance = i ? iconInterval * i : iconInterval / 2
          let position = along(this.props.currentPattern.shape, distance, 'meters')
          if (!bounds) continue
          if (position.geometry.coordinates[1] > bounds.getNorth() || position.geometry.coordinates[1] < bounds.getSouth() || position.geometry.coordinates[0] > bounds.getEast() || position.geometry.coordinates[0] < bounds.getWest()) {
            continue
          }
          lengthsAlongPattern.push([distance, position])
        }
        const circleIcon = divIcon({
          className: '',
          iconSize: [24, 24],
          html: `<i class="fa fa-times"/>`
        })
        let endPoint
        let beginPoint
        if (!route) {
          return null
        }
        let timer = null
        return (
          [
            <FeatureGroup ref='patterns'>
              {route && route.tripPatterns
                ? route.tripPatterns
                  .map(tp => {
                    const isActive = this.props.activeSubEntity === tp.id
                    let pattern = isActive ? this.props.currentPattern : tp
                    const latLngs = pattern.shape ? pattern.shape.coordinates.map(c => ([c[1], c[0]])) : []
                    // skip pattern if latlngs don't exist or some other pattern is active
                    if (!latLngs || !isActive && this.props.activeSubEntity) {
                      return null
                    }
                    beginPoint = latLngs[0]
                    endPoint = latLngs[latLngs.length - 1]

                    let lineColor = this.props.activeEntity.route_color && this.props.editSettings.editGeometry
                      ? '#F3F315' // yellow if editing
                      : this.props.activeEntity.route_color // otherwise, use route color if it exists
                      ? `#${this.props.activeEntity.route_color}`
                      : this.props.editSettings.editGeometry
                      ? '#F3F315' // yellow if editing
                      : 'blue'
                    return (
                      <Polyline
                        positions={this.state.newLatLngs || latLngs}
                        ref={pattern.id}
                        key={pattern.id}
                        onClick={e => isActive ? this.addControlPoint(pattern, e.latlng) : this.setState({editable: this.refs[pattern.id].leafletElement})}
                        lineCap='butt'
                        color={lineColor}
                        opacity={isActive ? 0.8 : 0.5}
                      />
                    )
                  })
                : null
              }
            </FeatureGroup>,
            <FeatureGroup
              ref='directionIcons'
            >
            {lengthsAlongPattern.length && this.refs[this.props.currentPattern.id] // && false
            ? lengthsAlongPattern.map((length, index) => {
              let distance = length[0]
              let position = length[1]

              let nextPosition = along(this.props.currentPattern.shape, distance + 5, 'meters')
              const dir = position && nextPosition ? bearing(position, nextPosition) : 0
              const cos = Math.cos(bearing * (Math.PI / 180))
              const sin = Math.sin(bearing * (Math.PI / 180))
              const icon = divIcon({
                className: '',
                iconAnchor: [50 * cos, 50 * sin],
                iconSize: [24, 24],
                html: `<i class="fa fa-circle"/>`
              })
              const color = '#000'
              const arrowIcon = divIcon({
                // html: `<span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x" style="color: #ffc0ff"></i><i class="fa fa-stack-1x fa-arrow-up" style="color: ${color}; transform: rotate(${dir}deg)"></i></span>`,
                html: `<i class="fa fa-arrow-up" style="color: ${color}; transform: rotate(${dir}deg)"></i>`,
                className: ''
              })
              if (!position || !position.geometry || !position.geometry.coordinates) {
                return null
              }
              return (
                <Marker
                  position={[position.geometry.coordinates[1], position.geometry.coordinates[0]]}
                  icon={arrowIcon}
                  ref={`directionIcon-${index}`}
                  key={`directionIcon-${index}`}
                  color='black'
                />
              )
            })
            : null
            }
            </FeatureGroup>,
            <FeatureGroup ref='controlPoints'>
              {this.props.stops.length && this.props.currentPattern && this.props.currentPattern.shape && this.props.editSettings.editGeometry
              ? this.state.controlPoints.map((s, index) => {
                // don't include controlPoint on end of segment (for now) or hidden controlPoints
                if (s.stopId && this.props.editSettings.snapToStops) {
                  return null
                }
                let nextStop
                let prevControlPoint = this.state.controlPoints[index - 1]
                let nextControlPoint = this.state.controlPoints[index + 1]

                for (var i = index + 1; i < this.state.controlPoints.length; i++) {
                  if (this.state.controlPoints[i].stopId) {
                    nextStop = this.state.controlPoints[i]
                  }
                }

                let begin = prevControlPoint
                          ? prevControlPoint.point
                          : along(this.props.currentPattern.shape, 0, 'meters')
                let end
                if (nextControlPoint) {
                  end = nextControlPoint.point
                }
                let position = s.point
                const color = s.permanent ? '#000' : '#888'
                const iconType = s.stopId ? 'fa-square' : 'fa-times'
                if (!position || !position.geometry || !position.geometry.coordinates) {
                  return null
                }
                const timesIcon = divIcon({
                  className: '',
                  iconSize: [24, 24],
                  html: `<i class="fa ${iconType}" style="color: ${color}"/>`
                })
                return (
                  <Marker
                    position={[position.geometry.coordinates[1], position.geometry.coordinates[0]]}
                    icon={timesIcon}
                    zIndexOffset={1000}
                    // key={Math.random()}
                    ref={`controlPoint-${index}`}
                    key={`controlPoint-${index}`}
                    draggable
                    onDragStart={(e) => {
                      const timerFunction = () => {
                        this.handlePatternEdit(`controlPoint-${index}`, begin, end)
                      }
                      timerFunction()
                      timer = setInterval(timerFunction, 500)
                    }}
                    onDragEnd={(e) => {
                      this.handleControlPointDragEnd(e, timer, `controlPoint-${index}`, index)
                    }}
                    onClick={(e) => {
                      console.log('control point clicked', e)
                      // only remove controlPoint if it's not based on pattern stop (i.e., has permanent prop)
                      if (!s.permanent) {
                        this.removeControlPoint(this.props.currentPattern, index, begin, end)
                      }
                    }}
                    color='black'
                  >
                  </Marker>
                )
              })
              : null
              }
              {beginPoint && this.props.editSettings.editGeometry && this.props.currentPattern
              ? <Marker
                  position={beginPoint}
                  icon={circleIcon}
                  ref='controlPointBegin'
                  draggable
                  onDragStart={(e) => {
                    let beginStop = this.props.stops.find(s => s.id === this.props.currentPattern.patternStops[0].stopId)
                    let begin = point([beginStop.stop_lon, beginStop.stop_lat])
                    const timerFunction = () => {
                      this.handlePatternEdit('controlPointBegin', null, begin)
                    }
                    timerFunction()
                    timer = setInterval(timerFunction, 1000)
                  }}
                  onDragEnd={(e) => {
                    this.handleControlPointDragEnd(e, timer, 'controlPointBegin')
                  }}
                  color='black'
                />
              : null
              }
            </FeatureGroup>,
            <FeatureGroup
              ref='patternStops'
            >
              {this.props.stops.length && this.props.currentPattern && !this.props.editSettings.hideStops
                ? this.props.currentPattern.patternStops && this.props.currentPattern.patternStops.map((s, index) => {
                  const stop = this.props.stops.find(ps => ps.id === s.stopId)
                  if (!stop) return null
                  const patternStopIcon = divIcon({
                    html: `<span title="${index + 1}. ${stop.stop_name}" class="fa-stack">
                            <i class="fa fa-circle fa-stack-2x"></i>
                            <strong class="fa-stack-1x fa-inverse calendar-text">${index + 1}</strong>
                          </span>`,
                    // html: `<span class="fa-stack fa-3x">
                    //         <i class="fa fa-bus fa-stack-2x" style="background-color: white"></i>
                    //         <strong class="fa-stack-1x fa-inverse calendar-text">27</strong>
                    //       </span>`,
                    // html: `<i class="fa fa-bus" style="color: ${color} border: 10px solid white"></i>`,
                    className: '',
                    iconSize: [24, 24]
                  })
                  return (
                    <Marker
                      position={[stop.stop_lat, stop.stop_lon]}
                      style={{cursor: 'move'}}
                      icon={patternStopIcon}
                      // label={`${index + 1} - ${stop.stop_name}`}
                      // labelOptions={{
                      //   // noHide: true,
                      //   direction: 'right'
                      // }}
                      // onClick={(e) => {
                      //
                      // }}
                      ref={`${this.props.currentPattern.id}-${s.stopId}-${index}`}
                      key={`${this.props.currentPattern.id}-${s.stopId}-${index}`}
                    >
                      <Popup>
                        <div
                          style={{minWidth: '200px'}}
                        >
                          <h5>{index + 1}. {stop.stop_name}</h5>
                          <Row>
                            <Col xs={12}>
                              <ButtonGroup className='pull-right'>
                                <Button
                                  bsStyle='primary'
                                  disabled={!this.props.entityEdited}
                                  onClick={() => {
                                    this.props.saveActiveEntity('trippattern')
                                  }}
                                >
                                  <Icon name='floppy-o'/>
                                </Button>
                                <OverlayTrigger overlay={<Tooltip>Edit stop</Tooltip>}>
                                <Button
                                  onClick={() => {
                                    this.props.setActiveEntity(this.props.feedSource.id, 'stop', stop)
                                  }}
                                >
                                  <Icon name='pencil'/>
                                </Button>
                                </OverlayTrigger>
                                <OverlayTrigger overlay={<Tooltip>Remove from pattern</Tooltip>}>
                                <Button
                                  bsStyle='danger'
                                  onClick={() => {
                                    this.removeStopFromPattern(this.props.currentPattern, stop, index)
                                  }}
                                >
                                  <Icon name='trash'/>
                                </Button>
                                </OverlayTrigger>
                                <Dropdown
                                  id={`split-button-basic-${i}`}
                                  onSelect={(key) => {
                                    this.addStopToPattern(this.props.currentPattern, stop, key)
                                  }}
                                >
                                  <Button
                                    bsStyle='success'
                                    disabled={index >= this.props.currentPattern.patternStops.length - 2}
                                    onClick={(e) => {
                                      this.addStopToPattern(this.props.currentPattern, stop)
                                    }}
                                  >
                                    <Icon name='plus'/>
                                  </Button>
                                  <Dropdown.Toggle bsStyle='success'/>
                                  <Dropdown.Menu style={{maxHeight: '200px', overflowY: 'scroll'}}>
                                    <MenuItem disabled={index >= this.props.currentPattern.patternStops.length - 2} value={this.props.currentPattern.patternStops.length} eventKey={this.props.currentPattern.patternStops.length}>
                                      Add to end (default)
                                    </MenuItem>
                                    {this.props.currentPattern.patternStops && this.props.currentPattern.patternStops.map((stop, i) => {
                                      let addIndex = this.props.currentPattern.patternStops.length - i
                                      if (index === this.props.currentPattern.patternStops.length - 1 && index === addIndex - 1) {
                                        return null
                                      }
                                      // disable adding stop to current position or directly before/after current position
                                      return (
                                        <MenuItem disabled={index >= addIndex - 2 && index <= addIndex} value={addIndex - 1} eventKey={addIndex - 1}>
                                          {addIndex === 1 ? 'Add to beginning' : `Insert as stop #${addIndex}`}
                                        </MenuItem>
                                      )
                                    })}
                                  </Dropdown.Menu>
                                </Dropdown>
                              </ButtonGroup>
                            </Col>
                          </Row>
                          <Row>
                            <Col xs={6}>
                              <FormGroup
                                controlId="formBasicText"
                                // style={{width: '40%'}}
                                /*validationState={this.getValidationState()}*/
                              >
                              <ControlLabel>Travel time</ControlLabel>
                              <MinuteSecondInput
                                seconds={s.defaultTravelTime}
                                onChange={(value) => {
                                  let patternStops = [...this.props.currentPattern.patternStops]
                                  patternStops[index].defaultTravelTime = value
                                  this.props.updateActiveEntity(this.props.currentPattern, 'trippattern', {patternStops: patternStops})
                                }}
                              />
                              </FormGroup>
                              </Col>
                              <Col xs={6}>
                              <FormGroup
                                controlId="formBasicText"
                                xs={6}
                                // style={{width: '40%'}}
                                /*validationState={this.getValidationState()}*/
                              >
                              <ControlLabel>Dwell time</ControlLabel>
                              <MinuteSecondInput
                                seconds={s.defaultDwellTime}
                                onChange={(evt) => {
                                  let patternStops = [...this.props.currentPattern.patternStops]
                                  patternStops[index].defaultDwellTime = +evt.target.value
                                  this.props.updateActiveEntity(this.props.currentPattern, 'trippattern', {patternStops: patternStops})
                                }}
                              />
                              </FormGroup>
                            </Col>
                          </Row>
                        </div>
                      </Popup>
                    </Marker>
                  )
                })
                : null
              }
            </FeatureGroup>
            ,
            <FeatureGroup
              ref='addableStops'
            >
              {
                this.props.stops.length && this.props.currentPattern && this.props.editSettings.addStops && this.props.mapState.zoom > 14
                ? this.props.stops
                  .filter(stop => {
                    if (!bounds) return false
                    if (stop.stop_lat > bounds.getNorth() || stop.stop_lat < bounds.getSouth() || stop.stop_lon > bounds.getEast() || stop.stop_lon < bounds.getWest()) {
                      return false
                    }
                    else {
                      return true
                    }
                  })
                  .map((stop, index) => {
                    if (!stop) return null
                    let patternStop = this.props.currentPattern.patternStops.find(ps => ps.stopId === stop.id)
                    if (patternStop) return null
                    const color = 'blue'
                    const busIcon = divIcon({
                      html: `<span class="fa-stack" style="opacity: 0.3">
                              <i class="fa fa-circle fa-stack-2x" style="color: #ffffff"></i>
                              <i class="fa fa-bus fa-stack-1x" style="color: ${color}"></i>
                            </span>`,
                      // html: `<i class="fa fa-bus" style="color: ${color} border: 10px solid white"></i>`,
                      className: '',
                      iconSize: [24, 24],
                    })
                    return (
                      <Marker
                        position={[stop.stop_lat, stop.stop_lon]}
                        // center={[stop.stop_lat, stop.stop_lon]}
                        style={{cursor: 'move'}}
                        // radius={4}
                        icon={busIcon}
                        // label={`${index + 1} - ${stop.stop_name}`}
                        ref={`${stop.id}-${index}`}
                        key={`${stop.id}-${index}`}
                      >
                        <Popup>
                          <div>
                            <h5>{stop.stop_name}</h5>
                            <SplitButton
                              title={<span><Icon name='plus'/> Add stop</span>}
                              id={`split-button-basic-${i}`}
                              bsStyle='success'
                              onSelect={(key) => {
                                this.addStopToPattern(this.props.currentPattern, stop, key)
                              }}
                              onClick={(e) => {
                                this.addStopToPattern(this.props.currentPattern, stop)
                              }}
                            >
                              <MenuItem value={this.props.currentPattern.patternStops.length} eventKey={this.props.currentPattern.patternStops.length}>
                                Add to end (default)
                              </MenuItem>
                              {this.props.currentPattern.patternStops && this.props.currentPattern.patternStops.map((stop, i) => {
                                let index = this.props.currentPattern.patternStops.length - i
                                return (
                                  <MenuItem value={index - 1} eventKey={index - 1}>
                                    {index === 1 ? 'Add to beginning' : `Insert as stop #${index}`}
                                  </MenuItem>
                                )
                              })}
                            </SplitButton>
                          </div>
                        </Popup>
                      </Marker>
                    )
                  })
                : null
              }
            </FeatureGroup>
          ]
        )
      case 'stop':
        // <StopMarkersLayer
        //   stops={this.props.stops}
        //   activeEntity={this.props.activeEntity}
        //   feedSource={this.props.feedSource}
        //   mapState={this.props.mapState}
        //   setActiveEntity={this.props.setActiveEntity}
        //   updateActiveEntity={this.props.updateActiveEntity}
        //   entityEdited={this.props.entityEdited}
        // />

        const paddedBounds = this.props.mapState.bounds.pad(0.05)
        var results = this.props.stopTree && this.props.drawStops
          ? this.props.stopTree.search({
            minX: paddedBounds.getWest(),
            minY: paddedBounds.getSouth(),
            maxX: paddedBounds.getEast(),
            maxY: paddedBounds.getNorth()
          })
          : []

        if (this.props.activeEntity && results.findIndex(r => r[2].id === this.props.activeEntity.id) === -1) {
          results.push([0, 0, this.props.activeEntity])
        }
        console.log(results)
        const outOfZoom = !this.props.drawStops
        console.log(this.props.mapState.bounds, paddedBounds)
        return [
          results ? results.map(result => {
            const stop = result[2]
            const isActive = this.props.activeEntity && this.props.activeEntity.id === stop.id
            const busIcon = divIcon({
              // html: `<span class="fa-stack bus-stop-icon">
              //         <i class="fa fa-circle fa-stack-2x bus-stop-icon-bg" style="color: blue"></i>
              //         <i class="fa fa-stack-1x fa-bus bus-stop-icon-fg"></i>
              //       </span>`,
              // html: `<span class="fa-stack">
              //         <i class="fa fa-circle fa-stack-2x"></i>
              //         <strong class="fa-stack-1x fa-inverse calendar-text">${index + 1}</strong>
              //       </span>`,
              html: `<span title="${stop.stop_name}" class="fa-stack bus-stop-icon" style="opacity: 0.6">
                      <i class="fa fa-circle fa-stack-2x" style="color: #ffffff"></i>
                      <i class="fa fa-bus fa-stack-1x" style="color: #000000"></i>
                    </span>`,
              className: '',
              iconSize: [24, 24],
            })
            const activeBusIcon = divIcon({
              html: `<span title="${stop.stop_name}" class="fa-stack bus-stop-icon">
                      <i class="fa fa-circle fa-stack-2x bus-stop-icon-bg" style="color: #000"></i>
                      <i class="fa fa-stack-1x fa-bus fa-inverse bus-stop-icon-fg"></i>
                    </span>`,
              className: '',
              iconSize: [24, 24],
            })
            const hidden = !isActive && outOfZoom
            if (hidden) {
              return null
            }
            if (isNaN(stop.stop_lat) || isNaN(stop.stop_lon)) {
              return null
            }
            const marker = (
              <Marker
                position={[stop.stop_lat, stop.stop_lon]}
                icon={isActive ? activeBusIcon : busIcon}
                zIndexOffset={isActive ? 1000 : 0}
                key={`${stop.id}`}
                ref={`${stop.id}`}
                // label={`${index + 1} - ${stop.stop_name}`}
                // opacity={hidden ? 0 : 1.0}
                draggable={isActive}
                onDragEnd={(e) => {
                  console.log(e)
                  let latlng = e.target.getLatLng()
                  let stopLatLng = this.getStopLatLng(latlng)
                  this.props.updateActiveEntity(this.props.activeEntity, this.props.activeComponent, stopLatLng)
                  this.refs[`${stop.id}`].leafletElement.setLatLng(latlng)
                }}
                onClick={(e) => {
                  // set active entity
                  if (!isActive)
                    this.props.setActiveEntity(this.props.feedSource.id, 'stop', stop)
                }}
              >
              </Marker>
            )
            return marker
          })
          : null
        ]
      default:
        return null
    }
  }

  getBounds (component, entities) {
    switch (component) {
      // case 'route':
      //   return entities.map(route => {
      //     return (
      //       null
      //     )
      //   })
      // case 'stop':
      //   return entities.map(stop => {
      //     return (
      //       null
      //     )
      //   })
      default:
        return null
    }
  }

  render () {
    const mapLayers = [
      {
        name: 'Streets',
        id: getConfigProperty('mapbox.map_id')
      },
      {
        name: 'Light',
        id: 'mapbox.light'
      },
      {
        name: 'Dark',
        id: 'mapbox.dark'
      },
      {
        name: 'Satellite',
        id: 'mapbox.streets-satellite'
      }
    ]
    const { feedSource, activeComponent, activeEntity } = this.props
    const offset = 0.005
    let feedSourceBounds = feedSource && feedSource.latestValidation && feedSource.latestValidation.bounds
      ? [[feedSource.latestValidation.bounds.north + offset, feedSource.latestValidation.bounds.west - offset], [feedSource.latestValidation.bounds.south - offset, feedSource.latestValidation.bounds.east + offset]]
      : [[60, 60], [-60, -20]]
    let bounds = this.state.zoomToTarget
      ? this.props.mapState.bounds
      : this.refs.map
      ? this.refs.map.leafletElement.getBounds()
      : feedSourceBounds

    let mapWidth = this.state.width - this.props.offset - (this.props.sidebarExpanded ? 150 : 50)

    const mapStyle = {
      height: '100%',
      width: `${mapWidth}px`,
      position: 'absolute',
      left: `${this.props.offset}px`
    }
    if (this.props.hidden) {
      mapStyle.display = 'none'
    }
    let mapProps = {
      ref: 'map',
      zoomControl: false,
      style: mapStyle,
      maxBounds: [[200, 180], [-200, -180]],
      onContextMenu: (e) => this.mapRightClicked(e),
      onClick: (e) => this.mapClicked(e),
      onZoomEnd: (e) => this.mapBoundsChanged(e),
      onMoveEnd: (e) => this.mapBoundsChanged(e),
      onBaseLayerChange: (e) => this.mapBaseLayerChanged(e, mapLayers),
      scrollWheelZoom: true
    }
    if (this.state.willMount || this.state.zoomToTarget) {
      mapProps.bounds = bounds
    }
    const activeMapLayerIndex = mapLayers.findIndex(l => l.id === getUserMetadataProperty(this.props.user.profile, 'editor.map_id'))
    return (
      <Map {...mapProps}>
        <ZoomControl position='topright' />
        <LayersControl position='topleft'>
          {mapLayers.map((layer, index) => (
            <LayersControl.BaseLayer
              name={layer.name}
              key={layer.id}
              checked={activeMapLayerIndex !== -1 ? index === activeMapLayerIndex : index === 0}
            >
              <TileLayer
                url={`https://api.tiles.mapbox.com/v4/${layer.id}/{z}/{x}/{y}${Browser.retina ? '@2x' : ''}.png?access_token=${getConfigProperty('mapbox.access_token')}`}
                attribution='<a href="https://www.mapbox.com/about/maps/" target="_blank">&copy; Mapbox &copy; OpenStreetMap</a> <a href="https://www.mapbox.com/map-feedback/" target="_blank">Improve this map</a>'
              />
            </LayersControl.BaseLayer>
          ))}
          <LayersControl.Overlay name='Route Alignments'>
            <FeatureGroup>
              {this.props.tripPatterns ? this.props.tripPatterns.map((tp) => {
                if (!tp.latLngs) return null
                return <Polyline key={`static-${tp.id}`} positions={tp.latLngs} weight={2} color='#888' />
              }) : null}
            </FeatureGroup>
          </LayersControl.Overlay>
          <LayersControl.Overlay
            // defaultChecked={this.props.activeComponent === 'stop' && this.props.entities}
            name='Stop Locations'
          >
            <StopLayer
              stops={this.props.tableData.stop}
            />
          </LayersControl.Overlay>
        </LayersControl>
        {
          this.getMapComponents(this.props.activeComponent, this.props.activeEntity, this.props.activeSubEntity)
        }
        {this.props.mapState.routesGeojson
          ? <GeoJson
              key={this.props.mapState.routesGeojson.key}
              data={this.props.mapState.routesGeojson}
            />
          : null
        }
      </Map>
    )
  }
}