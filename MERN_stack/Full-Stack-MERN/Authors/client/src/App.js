import logo from './logo.svg';
import './App.css';
import Main from './views/Main';
import { Router } from '@reach/router';
import New from './views/New';
import Update from './views/Update';
import NoAuthor from './views/NoAuthor';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Favorite Authors</h1>
        <Router>
          <Main path="/"/>
          <New path="/new"/>
          <NoAuthor path = "/error"/>
          <Update path="/:id/edit"/>
          </Router>
      </header>
    </div>
    );
}

export default App;
