const React = require('react');
const ReactDOM = require('react-dom');

class CreateIdeaForm extends React.Component {

  constructor(props) {
    super(props);
    this.attributes = ['name', 'description'];
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    const newIdea = {};
    this.attributes.forEach(attribute => {
      newIdea[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
    });
    this.props.onCreate(newIdea);

    // clear out the dialog's inputs
    this.attributes.forEach(attribute => {
      ReactDOM.findDOMNode(this.refs[attribute]).value = '';
    });

    // Navigate away from the dialog to hide it.
    window.location = "#";
  }

  render() {
    const inputs = this.attributes.map(attribute =>
      <p key={attribute}>
        <input type="text" placeholder={attribute} ref={attribute} className="field"/>
      </p>
    );

    return (
      <div>
        <div id="createIdea" className="modalDialog">
          <div>
            <h2>Create new idea</h2>

            <form>
              {inputs}
              <button onClick={this.handleSubmit}>Create</button>
            </form>
          </div>
        </div>
      </div>
    )
  }
}

module.exports = CreateIdeaForm;
