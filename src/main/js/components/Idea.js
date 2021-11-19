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
        <th scope="row">{this.props.idea.id}</th>
        <td>{this.props.idea.name}</td>
        <td>{this.props.idea.description}</td>
        <td><button type="button" class="btn btn-danger" onClick={this.handleDelete}>Delete</button></td>
      </tr>
    )
  }
}

module.exports = Idea;
