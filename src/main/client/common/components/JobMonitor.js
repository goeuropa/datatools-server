import React, { PropTypes } from 'react'
import { ProgressBar, Button } from 'react-bootstrap'
import { Icon } from 'react-fa'

import SidebarPopover from './SidebarPopover'

export default class JobMonitor extends React.Component {

  static propTypes = {
    expanded: PropTypes.bool,
    jobMonitor: PropTypes.object,
    target: PropTypes.object,
    visible: PropTypes.func,
    close: PropTypes.func,
    removeRetiredJob: PropTypes.func
  }

  render () {
    const jobContainerStyle = {
      marginBottom: 20
    }

    const progressBarStyle = {
      marginBottom: 2
    }

    const statusMessageStyle = {
      fontSize: '12px',
      color: 'darkGray'
    }

    return (
      <SidebarPopover
        ref='statusPopover'
        title='Server Jobs'
        {...this.props}
      >
        {this.props.jobMonitor.retired.map(job => {
          return (
            <div key={`retired-${job.jobId}`} style={jobContainerStyle}>
              <div style={{ float: 'left' }}>
                {job.status && job.status.error
                  ? <Icon name='exclamation-circle'/>
                  : <Icon name='check'/>
                }
              </div>
              <div style={{ marginLeft: 25 }}>
                <div>
                  <strong>{job.name}</strong>
                  <Button
                    bsStyle='link'
                    onClick={() => this.props.removeRetiredJob(job)}
                  >
                    <Icon className='pull-right' name='times-circle'/>
                  </Button>
                </div>
                <div style={statusMessageStyle} >{job.status && job.status.error ? 'Error!' : 'Completed!'}</div>
              </div>
            </div>
          )
        })}
        {this.props.jobMonitor.jobs.length
          ? this.props.jobMonitor.jobs.map(job => {
              return (
                <div key={job.jobId} style={jobContainerStyle}>
                  <div style={{ float: 'left' }}>
                    <Icon name='spinner' pulse />
                  </div>
                  <div style={{ marginLeft: 25 }}>
                    <div>
                      <strong>{job.name}</strong>{/* <Button bsStyle='link'><Icon className='pull-right' name='times-circle'/></Button> */}
                    </div>
                    <ProgressBar label={`${job.status ? job.status.percentComplete : 0}%`} active={true} now={job.status ? job.status.percentComplete : 0} style={progressBarStyle} />
                    <div style={statusMessageStyle} >{job.status ? job.status.message : 'waiting'}</div>
                  </div>
                </div>
              )
            })
          : <p>No active jobs.</p>
        }
      </SidebarPopover>
    )
  }
}