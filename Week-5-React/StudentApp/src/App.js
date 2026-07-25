import React, { Component } from 'react';
import './App.css';
import Student from './Components/Student';
import Home from './Components/Home';
import School from './Components/School';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Student />
        <Home />
        <School />
      </div>
    );
  }
}

export default App;
