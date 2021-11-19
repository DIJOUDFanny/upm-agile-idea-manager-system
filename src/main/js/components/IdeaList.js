const React = require('react');
const Idea = require('./Idea');

class IdeaList extends React.Component {
  render() {
    const ideas = this.props.ideas.map(idea =>
      <Idea key={idea.id} idea={idea} onDelete={this.props.onDelete}/>
    );
    return (
      <div class="mt-4">
        <h2 class="text-center">List of existing ideas</h2>

        <table className="table">
          <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
          </tr>
          </thead>
          <tbody>
          {ideas}
          </tbody>
        </table>
      </div>
    )
  }
}

module.exports = IdeaList;
