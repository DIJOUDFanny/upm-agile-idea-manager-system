const React = require('react');

class Comment extends React.Component {

  constructor(props) {
    super(props);
    this.handleDelete = this.handleDelete.bind(this);
  }

  handleDelete() {
    this.props.onDelete(this.props.comment);
  }

  render() {
    return (
      <tr align="center">
        <div class="card" onclick="">
        {this.props.comment.content}
        <button type="button" onclick={this.handleDelete()}>Delete</button>
        </div>

      </tr>
    )
  }
}

module.exports = Comment;
