import React, { Component } from 'react';

class Student extends Component {
  render() {
    return (
      <div className="component-card">
        <h2>Student Details</h2>
        <p>Name: John Doe</p>
        <p>Roll Number: 12345</p>
        <p>Department: Computer Science</p>
      </div>
    );
  }
}

export default Student;
