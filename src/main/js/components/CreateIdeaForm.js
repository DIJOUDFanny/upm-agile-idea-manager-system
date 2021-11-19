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
      <div className={"container-fluid"}>
        <p className={"row justify-content-center"} key={attribute}>
          <input type="text" className={"form-control col-auto w-50"} placeholder={attribute} ref={attribute}/>
        </p>
      </div>
    );

    return (
      <div>
        <div id="createIdea" className="modalDialog">
          <div>
            <h2 class="text-center">Create a new idea</h2>

            <div className={"container-fluid"}>
              <form className={"row justify-content-center"}>
                <div className={"container-fluid"}>
                  {inputs}
                  <div className={"row justify-content-center"}>
                    <button className="btn btn-primary col-auto" onClick={this.handleSubmit}>Create</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

module.exports = CreateIdeaForm;
