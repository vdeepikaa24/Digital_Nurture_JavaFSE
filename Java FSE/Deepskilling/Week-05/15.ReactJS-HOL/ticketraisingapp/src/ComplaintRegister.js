import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      // Generates a random ref ID upon component initialization
      NumberHolder: Math.floor(Math.random() * 100) 
    };
  }

  handleChange = (event) => {
    // Dynamically updates state based on the input's 'name' attribute
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const msg = `Thanks ${this.state.ename}\nYour Complaint was Submitted.\nTransaction ID is: ${this.state.NumberHolder}`;
    alert(msg);
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          {/* Name Input Field */}
          <div style={{ marginBottom: '15px' }}>
            <label htmlFor="ename" style={{ marginRight: '10px' }}>Name: </label>
            <input 
              type="text" 
              id="ename"
              name="ename" 
              value={this.state.ename} 
              onChange={this.handleChange} 
              required
            />
          </div>
          
          {/* Complaint Textarea Field */}
          <div style={{ marginBottom: '15px' }}>
            <label htmlFor="complaint" style={{ display: 'block', marginBottom: '5px' }}>Complaint: </label>
            <textarea 
              id="complaint"
              name="complaint" 
              value={this.state.complaint} 
              onChange={this.handleChange}
              rows="4" 
              cols="30"
              required
            />
          </div>
          
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;