import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: { fullName: '', email: '', password: '' }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        // Updated to match the specific requirement
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        const validEmailRegex = /^\S+@\S+\.\S+$/;
        errors.email = validEmailRegex.test(value) ? '' : 'Email is not valid!';
        break;
      case 'password':
        // Updated to match the specific requirement
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }
    this.setState({ errors, [name]: value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const { errors, fullName, email, password } = this.state;
    
    // Check for errors and empty fields
    if (errors.fullName !== '') {
      alert(errors.fullName);
    } else if (errors.email !== '') {
      alert(errors.email);
    } else if (errors.password !== '') {
      alert(errors.password);
    } else if (fullName === '' || email === '' || password === '') {
      alert('All fields are required!');
    } else {
      alert('Valid Form');
    }
  }

render() {
    const containerStyle = { padding: '20px', maxWidth: '300px' };
    const rowStyle = { marginBottom: '15px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' };
    const labelStyle = { width: '80px', textAlign: 'left' };

    return (
      <div style={containerStyle}>
        <h2 style={{ color: 'red', textAlign: 'center' }}>Register Here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={rowStyle}>
            <label style={labelStyle}>Name: </label>
            <input type="text" name="fullName" onChange={this.handleChange} />
          </div>
          <div style={rowStyle}>
            <label style={labelStyle}>Email: </label>
            <input type="text" name="email" onChange={this.handleChange} />
          </div>
          <div style={rowStyle}>
            <label style={labelStyle}>Password: </label>
            <input type="password" name="password" onChange={this.handleChange} />
          </div>
          <div style={{ textAlign: 'center', marginTop: '20px' }}>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default Register;