const React = require('react');
const ReactDOM = require('react-dom');

class CreateCommentForm extends React.Component {

  constructor(props) {
    super(props);
    this.attributes = ['username', 'content'];
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    const newComment = {};
    this.attributes.forEach(attribute => {
      newComment[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
    });
    this.props.onCreate(newComment);

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
        <div id="createComment" className="modalDialog">
          <div>
            <div className={"container-fluid"}>
              <form className={"row justify-content-center"}>
                <div className={"container-fluid"}>
                  {inputs}
                  <div className={"row justify-content-center"}>
                    <button className="btn btn-primary col-auto" onClick={this.handleSubmit}>Save comment</button>
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

module.exports = CreateCommentForm;
