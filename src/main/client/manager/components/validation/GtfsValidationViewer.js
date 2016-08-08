import React from 'react'
import { Panel, Table, Glyphicon, Button } from 'react-bootstrap'
import { browserHistory } from 'react-router'

import { isModuleEnabled, isExtensionEnabled, getComponentMessages } from '../../../common/util/config'

export default class GtfsValidationViewer extends React.Component {

  constructor (props) {
    super(props)
    this.state = { expanded: false }
  }

  componentWillReceiveProps (nextProps) {
    if(!nextProps.validationResult) this.setState({ expanded: false })
  }

  render () {

    const result = this.props.validationResult
    const messages = getComponentMessages('GtfsValidationViewer')

    const header = (
      <h3 onClick={() => {
        if(!result) this.props.validationResultRequested()
        this.setState({ expanded: !this.state.expanded })
      }}>
        <Glyphicon glyph='check' /> {messages.title}
      </h3>
    )

    let report = null
    let errors = {}
    result && result.errors.map(error => {
      if (!errors[error.file]) {
        errors[error.file] = []
      }
      errors[error.file].push(error)
    })
    if (result && errors) { // && result.loadStatus === 'SUCCESS') {
      report = (
        <div>
          <ResultTable
            title={messages.routeIssues}
            invalidValues={errors.routes}
          />

          <ResultTable
            title={messages.stopIssues}
            invalidValues={errors.stops}
          />

          <ResultTable
            title={messages.tripIssues}
            invalidValues={errors.trips}
          />

          <ResultTable
            title={messages.shapeIssues}
            invalidValues={errors.shapes}
          />

          <ResultTable
            title={'Other issues'}
            invalidValues={errors.null}
          />
        </div>
      )
    } else if (result) {
      report = (<div>{messages.noResults}</div>)
    }

    return (
      <Panel
        header={header}
        collapsible
        expanded={this.state.expanded}
      >
      <p>
        {isModuleEnabled('validator')
          ? <Button
              onClick={() => browserHistory.push(`/feed/${this.props.version.feedSource.id}/validation/${this.props.version.version}`)}
              bsSize='large'
              bsStyle='primary'
            >
              {messages.explorer}
            </Button>
          : null
        }
      </p>
        {report}
      </Panel>
    )
  }
}

class ResultTable extends React.Component {

  render () {
    const tableStyle = {
      tableLayout: 'fixed'
    }
    const messages = getComponentMessages('ResultTable')

    const breakWordStyle = {
      wordWrap: 'break-word',
      overflowWrap: 'break-word'
    }
    if (!this.props.invalidValues) {
      return (
        <Panel
          header={(<span><Glyphicon glyph='alert' /> {this.props.title} (0)</span>)}
          collapsible
        />
      )
    }
    return (
      <Panel
        header={(<span><Glyphicon glyph='alert' /> {this.props.title} ({this.props.invalidValues.length})</span>)}
        collapsible
      >
        <Table striped style={tableStyle}>
          <thead>
            <tr>
              <th>{messages.problemType}</th>
              <th>{messages.priority}</th>
              <th>{messages.affectedIds}</th>
              <th className='col-md-6'>{messages.description}</th>
            </tr>
          </thead>
          <tbody>
            {this.props.invalidValues.map(val => {
              return (
                <tr>
                  <td style={breakWordStyle}>{val.errorType}</td>
                  <td style={breakWordStyle}>{val.priority}</td>
                  <td style={breakWordStyle}>{val.affectedEntityId}</td>
                  <td className='col-md-4' style={breakWordStyle}>{val.message}</td>
                </tr>
              )
            })}
          </tbody>
        </Table>
      </Panel>
    )
  }
}