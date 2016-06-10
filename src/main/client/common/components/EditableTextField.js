import React  from 'react'
import ReactDOM from 'react-dom'
import { FormControl, InputGroup, FormGroup, Glyphicon, Button } from 'react-bootstrap'
import { Link } from 'react-router'

export default class EditableTextField extends React.Component {

  constructor (props) {
    super(props)
    this.state = {
      isEditing : this.props.isEditing || false,
      value: this.props.value
    }
  }


  componentWillReceiveProps (nextProps) {
    if(this.state.value !== nextProps.value) this.setState({ value: nextProps.value })
  }

  edit () {
    this.setState({
      isEditing: true
    })
  }

  save () {
    console.log(this.refs['input'])
    console.log(this.refs)
    const value = ReactDOM.findDOMNode(this.refs.input).value
    if (value === this.state.value) {
      this.cancel()
      return
    }
    if (this.props.onChange) {
      console.log('saving... ' + value)
      this.props.onChange(value)
    }
    this.setState({
      isEditing: false,
      value
    })

  }
  cancel (e) {
    this.setState({
      isEditing: false
    })
  }
  handleKeyDown (e) {
    // if [Enter] or [Tab] is pressed
    if ((e.keyCode == 9 || e.keyCode == 13) && this.state.isEditing) {
      this.save()
    }
    // if [Esc] is pressed
    if (e.keyCode == 27) {
      this.cancel()
    }
  }

  render () {
    var iconStyle = {
      cursor: 'pointer'
    }

    const saveButton = (
      <InputGroup.Button>
        <Button
          onClick={(evt) => {
            evt.preventDefault()
            this.save()
          }}
        >
        <Glyphicon
          glyph='ok'
          style={iconStyle}
        />
        </Button> //feed.name.length > 11 ? feed.name.substr(0, 11) + '...' : feed.name
      </InputGroup.Button>
    )
    const displayValue = this.props.maxLength !== null && this.state.value && this.state.value.length > this.props.maxLength
          ? this.state.value.substr(0, this.props.maxLength) + '...'
          : this.state.value
    return (
      <div>
        {this.state.isEditing
          ? <FormGroup>
              <InputGroup>
                <FormControl
                  ref='input'
                  type={this.props.type ? this.props.type.toLowerCase() : 'text'}
                  min={this.props.min != null ? this.props.min : null}
                  step={this.props.step != null ? this.props.step : null}
                  placeholder={this.props.placeholder ? this.props.placeholder : ''}
                  autoFocus='true'
                  autoFocus='true'
                  onKeyDown={(e) => this.handleKeyDown(e)}
                  onFocus={(e) => e.target.select()}
                  /*onBlur={(e) => this.cancel(e)}*/
                  defaultValue={ this.state.value }
                />
                {saveButton}
              </InputGroup>
            </FormGroup>

          : <span
              title={this.state.value}
            >
              {this.props.link
                ? <Link to={this.props.link}>{displayValue}</Link>
                : displayValue || '(none)'
              }
              {'  '}
              <Button bsStyle='link'
                ref='editButton'
                tabIndex={this.props.tabIndex ? this.props.tabIndex : null}
                onClick={() => this.edit()}
                disabled={this.props.disabled !== null ? this.props.disabled : false}
              >
                <Glyphicon
                  style={iconStyle}
                  glyph={ 'pencil' }
                />
              </Button>
            </span>
        }
      </div>
    )
  }
}