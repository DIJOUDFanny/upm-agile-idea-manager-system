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
      <tr>
        <td>#{this.props.idea.id}</td>
        <td>{this.props.idea.name}</td>
        <td>{this.props.idea.description}</td>
        <td><button onClick={this.handleDelete}>Delete</button></td>
      </tr>
    )
  }
}

module.exports = Idea;
