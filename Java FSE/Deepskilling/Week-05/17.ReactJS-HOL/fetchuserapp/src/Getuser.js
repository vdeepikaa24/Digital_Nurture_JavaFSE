import React, { Component } from 'react';

class Getuser extends Component {
  state = {
    loading: true,
    person: null
  };

  // Lifecycle method to fetch data
  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }

  render() {
    if (this.state.loading) {
      return <div>Loading...</div>;
    }

    if (!this.state.person) {
      return <div>No user found</div>;
    }

    // Render user details
    const { name, picture } = this.state.person;
    return (
      <div>
        <h3>{name.title} {name.first}</h3>
        <img src={picture.large} alt="User" />
      </div>
    );
  }
}

export default Getuser;