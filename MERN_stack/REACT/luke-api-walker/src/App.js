import './App.css';
import {useState} from 'react';
import { navigate } from '@reach/router'
import People from './components/people';
import Planets from './components/planets';
import Error from './components/error';
import { Router } from '@reach/router';
import StarShips from './components/starships';

function App() {
  const [id, setId] = useState(0);
  const [option, setOption] = useState("");

  const handleOptions = (e) => {
    setOption(e.target.value);
  }

  const handleId = (e) => {
    setId(e.target.value);
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    if(option === "People"){
      navigate('/people/'+id)
    }
    else if(option === "Planets"){
      navigate('/planets/'+id)
    }
    else if(option === "Star Ships"){
      navigate('/starships/'+id)
    }
    else {
      navigate('/error');
    }

  }

  return (
    <div className="App" Style="margin-top: 0">
      <header className="App-header">
      <section>
        <form className="input-group mb-3" onSubmit={handleSubmit} >
          <span className="input-group-text"> Search For : </span>
          <select className="form-select form-select-lg" onChange={handleOptions} >
            <option selected> Choose your Topic ... </option>
            <option value="People">People</option>
            <option value="Planets">Planets</option>
            <option value="Star Ships">Star Ships</option>
          </select>
          <span className="input-group-text"> ID : </span>
          <input className="form-control form-control-lg" type="number" value={id} onChange={handleId} />
          <input className="btn btn-primary btn-lg" type="submit" value="Search"/>
        </form>
      </section>
      <br />
      <br />
      <Router>
        <People path="people/:id" id={id} />
        <Planets path="planets/:id" id={id} />
        <StarShips path="starships/:id" id={id} />
        <Error path="error" />
      </Router>
      </header>
    </div>
  );
}

export default App;