import logo from './logo.svg';
import './App.css';
import {Router} from '@reach/router';

import Home from './components/Home';
import Word from './components/Word';
import Style from './components/Style';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        
        <Router>
          <Home path="/home"/>
          <Word path="/:x" />
          <Style path="/:word/:color/:bcolor" />
        </Router>


      </header>
    </div>
  );
}

export default App;
