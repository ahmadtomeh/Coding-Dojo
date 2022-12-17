import logo from './logo.svg';
import './App.css';
import Form from './components/Form';
import Display from './components/Display';
import { useState } from 'react';
import axios from 'axios';


function App() {
  const [pokemons, setPokemons] = useState([]);

  const butdisplay = () => {
    console.log("Hello user!")
    axios.get('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0')
    .then(response => {setPokemons(response.data.results)})
    
};
  return (
    <div className="App">
      <Form a = {butdisplay}/>
      <Display pokemons = {pokemons}/>
    </div>
  );
}

export default App;
