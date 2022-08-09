'use strict';
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {requests: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/requests'}).done(response => {
			this.setState({requests: response.entity._embedded.requests});
		});
	}

	render() {
		return (
			<RequestList requests={this.state.requests}/>
		)
	}
}

class RequestList extends React.Component{
	render() {
		const requests = this.props.requests.map(request =>
			<Request key={request._links.self.href} request={request}/>
		);
		return (
		<div class="table-responsive">
			<table className="table .table-striped">
				<tbody>
					<tr>
						<th>Requestor</th>
						<th>Description</th>
						<th>Tags</th>
					</tr>
					{requests}
				</tbody>
			</table>
		</div>
		)
	}
}

class Request extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.request.initiator}</td>
				<td>{this.props.request.request}</td>
				<td>{this.props.request.tags}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)