import React from 'react'
import { Grid, Row, Col } from 'react-bootstrap'
import Helmet from 'react-helmet'

import CurrentStatusMessage from '../../common/containers/CurrentStatusMessage'
import ConfirmModal from '../../common/components/ConfirmModal'
import SelectFileModal from '../../common/components/SelectFileModal'
import ManagerNavbar from '../../common/containers/ManagerNavbar'

export default class PublicPage extends React.Component {

  constructor (props) {
    super(props)
  }

  showConfirmModal (props) {
    this.refs.confirmModal.open(props)
  }

  showSelectFileModal (props) {
    this.refs.selectFileModal.open(props)
  }

  render () {
    return (
      <div>
        <Helmet
          defaultTitle={DT_CONFIG.application.title}
          titleTemplate={`${DT_CONFIG.application.title} - %s`}
        />
        <ManagerNavbar
        />
        {this.props.children}
        <CurrentStatusMessage />
        <ConfirmModal ref='confirmModal'/>
        <SelectFileModal ref='selectFileModal'/>
      </div>
    )
  }
}