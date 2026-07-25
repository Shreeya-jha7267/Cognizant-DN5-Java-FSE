import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ Name, School, Total, goal }) {
  const average = Total / 5;
  const status = average >= goal ? 'Goal Achieved' : 'Goal Not Achieved';

  return (
    <div className="score-card">
      <h1>Score Calculator</h1>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total Score:</strong> {Total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}</p>
      <p className="result">{status}</p>
    </div>
  );
}

export default CalculateScore;
