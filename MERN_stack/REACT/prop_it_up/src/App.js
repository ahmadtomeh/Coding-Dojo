import React from 'react';
import './App.css';

import PropItUp from './components/PropItUp';
var member = [
  { "id": 1, "firstName": "Ahmad", "lastName": "Tomeh", "age": 27, "hairColor": "Black" },
  { "id": 2, "firstName": "Thabet", "lastName": "Toma", "age": 23, "hairColor": "Black" },
  { "id": 3, "firstName": "Ra`d", "lastName": "Tomeh", "age": 23, "hairColor": "Black" },
  { "id": 4, "firstName": "Khalid", "lastName": "Ammar", "age": 23, "hairColor": "Brown" }
]

function App() {
  return (
    <div className="App">
      {member.map(person => {
        return <PropItUp 
        key={person.id}
        firstName={person.firstName}
        lastName={person.lastName}
        age={person.age}
        hairColor={person.hairColor} />
      })

      }
    </div>
  );
}

export default App;
