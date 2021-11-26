const axios = require('axios');
const React = require('react');
const CommentList = require('./CommentList');
const CreateCommentForm = require('./CreateCommentForm');

class IdeaSelected extends React.Component {

  constructor(props) {
    super(props);
    this.state = {comments: [], attributes: []};
    this.onCreate = this.onCreate.bind(this);
    this.onDelete = this.onDelete.bind(this);
  }

  loadIdeas() {
    axios.get('/comments').then(response => {
      this.setState({comments: response.data});
    });
  }

  componentDidMount() {
    this.loadIdeas();
  }

  onCreate(newComment) {
    axios.post("/comments", newIdea).then(() => {
      this.loadComments();
    });
  }

  onDelete(comment) {
    axios.delete('/comments/' + comment.id).then(() => {
      this.loadComments();
    });
  }

  render() {
    return (
      <div class="container-fluid text-center">
        <h1 class="text-center mt-5 mb-4">IDEA 1</h1>
        <div class="card">
          <h5 class="text-left">DESCRIPTION IDEA 1:</h5>
            CONTENT OF IDEA 1. BLABLABLA.jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
            koooooooooooooooooooooooooooooooooooooooooooooooooooooo
            plllllllllllllllllllllllllllllllllllllllllllllllllllllll
        </div>

        <p>COMMENTS</p>
        <CreateCommentForm onCreate={this.onCreate}/>
        <CommentList comments={this.state.comments} onDelete={this.onDelete}/>
      </div>
    );

  }
}

module.exports = IdeaSelected;
