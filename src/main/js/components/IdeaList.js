const React = require('react');
const Idea = require('./Idea');

class IdeaList extends React.Component {
  render() {
    const ideas = this.props.ideas.map(idea =>
      <Idea key={idea.id} idea={idea} onDelete={this.props.onDelete}/>
    );
    return (
      <table>
        <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
        </tr>
        </thead>
        <tbody>
        {ideas}
        </tbody>
      </table>
    )
  }
}

module.exports = IdeaList;
