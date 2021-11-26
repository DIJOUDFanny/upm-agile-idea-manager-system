const React = require('react');
const Comment = require('./Comment');

class CommentList extends React.Component {
  render() {
    const comments = this.props.comments.map(comment =>
      <Comment key={comment.id} comment={comment} onDelete={this.props.onDelete}/>
    );
    return (
      <div class="mt-4">
        <table className="table">
          <thead>
          <tr>
            <th scope="col"></th>
          </tr>
          </thead>
          <tbody>
          {comments}
          </tbody>
        </table>
      </div>
    )
  }
}

module.exports = CommentList;
