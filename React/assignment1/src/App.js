import React, { useState } from 'react';
import './App.css';
import UserInput from './UserInput/UserInput';
import Team from "./Team/Team";

function App() {
  const [teams, setTeamDetails] = useState({
    teams: [
      { name: 'RCB', captain: "Virat Kohli", players: ['Parthiv', 'ABD'] },
      { name: 'CSK', captain: "Suresh Raina", players: [] },
      { name: 'KXIP', captain: "Ashwin", players: ['MS Dhoni', 'Ravindra Jadeja'] }
    ]
  }
  );
  return (
    <div>
      <h1 className="App">Assignment 1</h1>
      <UserInput />
      {teams.teams.map(team => {
        return <Team
          name={team.name}
          captain={team.captain}
          players={team.players}
        />
      })}
    </div>
  );
}

export default App;
