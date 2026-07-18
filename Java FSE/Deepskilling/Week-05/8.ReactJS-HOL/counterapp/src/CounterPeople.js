import React, { Component } from 'react';

class CounterPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '150px' }}>
        {/* Adjusted buttons and text to match the image exactly */}
        <button onClick={this.updateEntry} style={{ backgroundColor: '#90EE90', marginRight: '5px' }}>Login</button>
        <span style={{ marginRight: '100px' }}> {this.state.entrycount} People Entered!!!</span>
        
        <button onClick={this.updateExit} style={{ backgroundColor: '#90EE90', marginRight: '5px' }}>Exit</button>
        <span> {this.state.exitcount} People Left!!!</span>
      </div>
    );
  }
}

export default CounterPeople;