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
    axios.get('/api/v1/ideas').then(response => {
      this.setState({ideas: response.data});
    });
  }

  componentDidMount() {
    this.loadIdeas();
  }

  onCreate(newIdea) {
    axios.post("api/v1/ideas", newIdea).then(() => {
      this.loadIdeas();
    });
  }

  onDelete(idea) {
    axios.delete('api/v1/ideas/' + idea.id).then(() => {
      this.loadIdeas();
    });
  }

  render() {
    return (
      <div>
        <CreateIdeaForm onCreate={this.onCreate}/>
        <IdeaList ideas={this.state.ideas} onDelete={this.onDelete}/>
      </div>
    );
  }
}

module.exports = App;