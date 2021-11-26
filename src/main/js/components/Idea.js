const React = require('react');

class Idea extends React.Component {

  constructor(props) {
    super(props);
    this.handleDelete = this.handleDelete.bind(this);
  }

  handleDelete() {
    this.props.onDelete(this.props.idea);
  }

  render() {
    return (
      <tr align="center">
        <button class="card" onclick="">
        {this.props.idea.name}
        <p>{this.props.idea.description}</p>
        <p><i class="bi bi-hand-thumbs-up-fill">13</i>
        <i class="bi bi-hand-thumbs-down-fill">2</i></p>
        6com
        </button>

      </tr>
    )
  }
}

module.exports = Idea;
