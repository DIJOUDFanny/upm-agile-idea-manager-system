const axios = require('axios');
const React = require('react');
const IdeaList = require('./IdeaList');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {ideas: []};
  }

  componentDidMount() {
    axios.get('/api/v1/ideas').then(response => {
      this.setState({ideas: response.data});
    });
  }

  render() {
    return (
      <IdeaList ideas={this.state.ideas}/>
    )
  }
}

module.exports = App;
