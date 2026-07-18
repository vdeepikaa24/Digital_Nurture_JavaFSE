import React from 'react';
import './App.css'; // Ensure you have this CSS file

function App() {
  return (
    <div className="container">
      <div className="column">
        <h1>Course Details</h1>
        <h3>Angular</h3>
        <p>4/5/2021</p>
        <h3>React</h3>
        <p>6/3/2021</p>
      </div>
      
      <div className="divider"></div>

      <div className="column">
        <h1>Book Details</h1>
        <h3>Master React</h3>
        <p>670</p>
        <h3>Deep Dive into Angular 11</h3>
        <p>800</p>
        <h3>Mongo Essentials</h3>
        <p>450</p>
      </div>

      <div className="divider"></div>

      <div className="column">
        <h1>Blog Details</h1>
        <h3>React Learning</h3>
        <p>Stephen Biz</p>
        <p>Welcome to learning React!</p>
        <h3>Installation</h3>
        <p>Schewzdenier</p>
        <p>You can install React from npm.</p>
      </div>
    </div>
  );
}

export default App;