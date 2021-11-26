const axios = require('axios');
const React = require('react');
const IdeaList = require('./IdeaList');
const CreateIdeaForm = require('./CreateIdeaForm');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {ideas: [], attributes: []};
    this.onCreate = this.onCreate.bind(this);
    this.onDelete = this.onDelete.bind(this);
  }

  loadIdeas() {
    axios.get('/ideas').then(response => {
      this.setState({ideas: response.data});
    });
  }

  componentDidMount() {
    this.loadIdeas();
  }

  onCreate(newIdea) {
    axios.post("/ideas", newIdea).then(() => {
      this.loadIdeas();
    });
  }

  onDelete(idea) {
    axios.delete('/ideas/' + idea.id).then(() => {
      this.loadIdeas();
    });
  }

  render() {
    return (
      <div class="container-fluid text-center">
        <h1 class="text-center mt-5 mb-4">IDEA HUB</h1>

        <IdeaList ideas={this.state.ideas} onDelete={this.onDelete}/>
        <button type="button" onclick="">Add a new idea</button>
      </div>
    );
    /*<CreateIdeaForm onCreate={this.onCreate}/>*/
  }
}

module.exports = App;
