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
        <i class="bi bi-hand-thumbs-up-fill">13</i>
        <i class="bi bi-hand-thumbs-down-fill">2</i>
        6
        </tr>
    )
  }
}

module.exports = Idea;
