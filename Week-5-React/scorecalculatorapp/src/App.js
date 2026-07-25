import './App.css';
import './Stylesheets/mystyle.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore
        Name="John Doe"
        School="Sunrise High School"
        Total={420}
        goal={75}
      />
    </div>
  );
}

export default App;
