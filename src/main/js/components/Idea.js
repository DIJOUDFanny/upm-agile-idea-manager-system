const React = require('react');

class Idea extends React.Component {
  render() {
    return (
      <tr>
        <td>#{this.props.idea.id}</td>
        <td>{this.props.idea.name}</td>
        <td>{this.props.idea.description}</td>
      </tr>
    )
  }
}

module.exports = Idea;
