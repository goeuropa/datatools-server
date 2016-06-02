import React, {Component, PropTypes} from 'react'
import ReactDOM from 'react-dom'

import { Navbar, Nav, NavItem, NavDropdown, MenuItem, Glyphicon } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'
import { browserHistory, Link } from 'react-router'

import { isModuleEnabled } from '../util/config'

export default class DatatoolsNavbar extends Component {

  static propTypes = {
    title: PropTypes.string,
    username: PropTypes.string,
    managerUrl: PropTypes.string,
    editorUrl: PropTypes.string,
    userAdminUrl: PropTypes.string,
    alertsUrl: PropTypes.string,
    signConfigUrl: PropTypes.string,
    loginHandler: PropTypes.func,
    logoutHandler: PropTypes.func,
    resetPasswordHandler: PropTypes.func
  };

  render () {
    var userControl
    const messages = DT_CONFIG.messages.DatatoolsNavbar

    if (!this.props.username) {
      userControl = (<NavItem onClick={this.props.loginHandler} href='#'>{messages.login}</NavItem>)
    } else {
      userControl = (
        <NavDropdown title={
          <span><Glyphicon glyph='user' /> {this.props.username}</span>
        } id='basic-nav-dropdown'>
        <MenuItem onClick={() => browserHistory.push('/account')}>{messages.account}</MenuItem>
          <MenuItem onClick={this.props.resetPasswordHandler}>{messages.resetPassword}</MenuItem>
          <MenuItem onClick={this.props.logoutHandler}>{messages.logout}</MenuItem>
        </NavDropdown>
      )
    }
    let projectControl
    if (!this.props.username) {
      projectControl = ('')
    } else if (!this.props.projects || !this.props.projects.active) {
      projectControl = ('') // (<NavItem href='#'>No project selected</NavItem>)
    } else {
      let activeProject = this.props.projects.active
      projectControl = (
        <NavDropdown
          title={<span><Glyphicon glyph='briefcase' /> {activeProject.name}</span>}
          id='basic-nav-dropdown'
        >
          {this.props.projects.all.map(proj => {
            return (
              <MenuItem
                key={proj.id}
                onClick={(evt) =>{
                  evt.preventDefault()
                  this.props.setActiveProject(proj)
                }}
              >{proj.name}</MenuItem>
            )
          })}
        </NavDropdown>
      )
    }
    const navBarStyle = this.props.noMargin ? {marginBottom: 0} : {}

    return (
      <Navbar
        style={navBarStyle}
      >
        <Navbar.Header>
          <Navbar.Brand>
            <Link to='/'>{this.props.title}</Link>
          </Navbar.Brand>
          <Navbar.Toggle />
        </Navbar.Header>
        <Navbar.Collapse>
          <Nav>
            {this.props.managerUrl && this.props.username
              ? <LinkContainer to={this.props.managerUrl}>
                  <NavItem>{messages.manager}</NavItem>
                </LinkContainer>
              : null
            }
            {isModuleEnabled('editor') && this.props.editorUrl && this.props.username
              ? <NavItem href={this.props.editorUrl} active={this.props.editorUrl === '#'}>
                  {messages.editor}
                </NavItem>
              : null
            }
            {isModuleEnabled('alerts') && this.props.alertsUrl && this.props.username
              ? <LinkContainer to={this.props.alertsUrl}>
                  <NavItem>{messages.alerts}</NavItem>
                </LinkContainer>
              : null
            }
            {isModuleEnabled('user_admin') && this.props.userAdminUrl && this.props.userIsAdmin
              ? <LinkContainer to={this.props.userAdminUrl}>
                  <NavItem>{messages.users}</NavItem>
                </LinkContainer>
              : null
            }
            {isModuleEnabled('sign_config') && this.props.signConfigUrl && this.props.username
              ? <LinkContainer to={this.props.signConfigUrl}>
                  <NavItem>{messages.signConfig}</NavItem>
                </LinkContainer>
              : null
            }
          </Nav>
          <Nav pullRight>
            {projectControl}
            {this.props.docsUrl
              ? <NavItem href={this.props.docsUrl} active={this.props.docsUrl === '#'}>
                  <Glyphicon glyph='question-sign' /> {messages.guide}
                </NavItem>
              : null
            }
            {userControl}
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    )
  }
}