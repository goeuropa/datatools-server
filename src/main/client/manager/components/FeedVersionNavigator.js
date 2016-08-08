import React, {Component, PropTypes} from 'react'
import { Row, Col, ButtonGroup, ButtonToolbar, DropdownButton, MenuItem, Button, Glyphicon } from 'react-bootstrap'
import { browserHistory } from 'react-router'

import { isModuleEnabled, getComponentMessages } from '../../common/util/config'
import FeedVersionViewer from './FeedVersionViewer'
import EditableTextField from '../../common/components/EditableTextField'
import ConfirmModal from '../../common/components/ConfirmModal'

export default class FeedVersionNavigator extends Component {

  static propTypes = {
    deleteDisabled: PropTypes.bool,
    feedSource: PropTypes.object,
    feedVersionIndex: PropTypes.number,
    isPublic: PropTypes.bool,

    deleteFeedVersionConfirmed: PropTypes.func,
    downloadFeedClicked: PropTypes.func,
    feedVersionRenamed: PropTypes.func,
    gtfsPlusDataRequested: PropTypes.func,
    loadFeedVersionForEditing: PropTypes.func,
    newNotePostedForVersion: PropTypes.func,
    notesRequestedForVersion: PropTypes.func,
    validationResultRequested: PropTypes.func
  }

  constructor (props) {
    super(props)
  }

  componentWillReceiveProps (nextProps) {
  }

  render () {
    const versionTitleStyle = {
      fontSize: '24px',
      fontWeight: 'bold'
    }
    const versions = this.props.feedSource.feedVersions
    const messages = getComponentMessages('FeedVersionNavigator')
    const hasVersions = versions && versions.length > 0

    const sortedVersions = hasVersions && versions.sort((a, b) => {
      if (a.updated < b.updated) return -1
      if (a.updated > b.updated) return 1
      return 0
    })

    let version

    if (typeof this.props.feedVersionIndex === 'undefined') {
      return null
    } else if (hasVersions && versions.length >= this.props.feedVersionIndex) {
      version = sortedVersions[this.props.feedVersionIndex - 1]
    } else {
      console.log(`Error version ${this.props.feedVersionIndex} does not exist`)
    }

    const publicPrefix = this.props.isPublic ? '/public' : ''

    return (
      <div>
        <Row>
          {/* Version Navigation Widget and Name Editor */}
          <Col xs={12} sm={6} style={versionTitleStyle}>
            {hasVersions
              ? <div>
                  {/* Version Navigation/Selection Widget */}
                  <ButtonGroup>
                    {/* Previous Version Button */}
                    <Button href='#'
                      disabled={!hasVersions || !sortedVersions[this.props.feedVersionIndex - 2]}
                      onClick={() => browserHistory.push(`${publicPrefix}/feed/${version.feedSource.id}/version/${this.props.feedVersionIndex - 1}`)}
                    >
                      <Glyphicon glyph='arrow-left' />
                    </Button>

                    {/* Version Selector Dropdown */}
                    <DropdownButton href='#' id='versionSelector'
                      title={`${this.props.feedVersionIndex} ${messages.of} ${versions.length}`}
                      onSelect={(key) => browserHistory.push(`${publicPrefix}/feed/${version.feedSource.id}/version/${key}`)}
                    >
                      {versions.map((version, k) => {
                        k = k + 1
                        return <MenuItem key={k} eventKey={k}>{k}. {version.name}</MenuItem>
                      })}
                    </DropdownButton>

                    {/* Next Version Button */}
                    <Button href='#'
                      disabled={!hasVersions || !sortedVersions[this.props.feedVersionIndex]}
                      onClick={() => browserHistory.push(`${publicPrefix}/feed/${version.feedSource.id}/version/${this.props.feedVersionIndex + 1}`)}
                    >
                      <Glyphicon glyph='arrow-right' />
                    </Button>
                  </ButtonGroup>

                  <span>&nbsp;&nbsp;</span>

                  {/* Name Display / Editor */}
                  {this.props.isPublic
                    ? <span>{version.name}</span>
                    : <EditableTextField inline value={version.name}
                        disabled={this.props.isPublic}
                        onChange={(value) => this.props.feedVersionRenamed(version, value)}
                      />
                  }
                </div>
              : messages.noVersions
            }
          </Col>

          {/* Version-Specific Button Toolbar */}
          <Col xs={12} sm={6}>
            <ConfirmModal ref='confirm' />
            <ButtonToolbar className='pull-right'>

              {/* "Download Feed" Button */}
              <Button bsStyle='primary'
                disabled={!hasVersions}
                onClick={(evt) => this.props.downloadFeedClicked(version, this.props.isPublic)}
              >
                <Glyphicon glyph='download' /><span className='hidden-xs'> {messages.download}</span><span className='hidden-xs hidden-sm'> {messages.feed}</span>
              </Button>

              {/* "Load for Editing" Button */}
              {isModuleEnabled('editor') && !this.props.isPublic
                ? <Button bsStyle='success'
                    disabled={!hasVersions}
                    onClick={(evt) => {
                      this.refs.confirm.open({
                        title: messages.load,
                        body: messages.confirmLoad,
                        onConfirm: () => { this.props.loadFeedVersionForEditing(version) }
                      })
                    }}
                  >
                    <Glyphicon glyph='pencil' /><span className='hidden-xs'> {messages.load}</span>
                  </Button>
                : null
              }

              {/* "Delete Version" Button */}
              {!this.props.isPublic
                ? <Button bsStyle='danger'
                    disabled={this.props.deleteDisabled || !hasVersions || typeof this.props.deleteFeedVersionConfirmed === 'undefined'}
                    onClick={(evt) => {
                      this.refs.confirm.open({
                        title: `${messages.delete} ${messages.version}`,
                        body: messages.confirmDelete,
                        onConfirm: () => { this.props.deleteFeedVersionConfirmed(version) }
                      })
                    }}
                  >
                    <Glyphicon glyph='remove' /><span className='hidden-xs'> {messages.delete}</span><span className='hidden-xs hidden-sm'> {messages.version}</span>
                  </Button>
                : null
              }
            </ButtonToolbar>
          </Col>
        </Row>

        <Row><Col xs={12}><span>&nbsp;</span></Col></Row>

        {version
          ? <FeedVersionViewer
              version={version}
              validationResultRequested={(version) => {
                this.props.validationResultRequested(version, this.props.isPublic)
              }}
              gtfsPlusDataRequested={(version) => {
                this.props.gtfsPlusDataRequested(version)
              }}
              notesRequested={() => { this.props.notesRequestedForVersion(version) }}
              newNotePosted={(note) => { this.props.newNotePostedForVersion(version, note) }}
            />
          : <p>{messages.noVersionsExist}</p>
        }

      </div>
    )
  }
}