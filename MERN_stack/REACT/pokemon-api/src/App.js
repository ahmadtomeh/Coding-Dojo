import logo from './logo.svg';
import './App.css';
import Form from './components/Form';
import Display from './components/Display';
import { useState } from 'react';


function App() {
  const [pokemons, setPokemons] = useState([]);

  const butdisplay = () => {
    console.log("Hello user!")
    fetch('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0')
        .then(response => response.json())
        .then(response => setPokemons(response.results))

};
  return (
    <div className="App">
      <Form a = {butdisplay}/>
      <Display pokemons = {pokemons}/>
    </div>
  );
}

export default App;
