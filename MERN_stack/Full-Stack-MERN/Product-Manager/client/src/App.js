import logo from './logo.svg';
import './App.css';
import Main from './views/Main';
import { Router } from '@reach/router';
import Detail from './views/Detail';
import Update from './views/Update';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Main path="/"/>
          <Detail path="/:id"/>
          <Update path="/:id/edit"/>
          </Router>
      </header>
    </div>
    );
}

export default App;
