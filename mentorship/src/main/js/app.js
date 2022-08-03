'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {participants: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/participants'}).done(response => {
			this.setState({participants: response.entity._embedded.participants});
		});
	}

	render() {
		return (
			<ParticipantList participants={this.state.participants}/>
		)
	}
}

class ParticipantList extends React.Component{
	render() {
		const participants = this.props.participants.map(participant =>
			<Participant key={participant._links.self.href} participant={participant}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					{participants}
				</tbody>
			</table>
		)
	}
}

class Participant extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.participant.firstName}</td>
				<td>{this.props.participant.lastName}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)