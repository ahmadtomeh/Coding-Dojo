import React, { useState } from 'react';

import logo from './logo.svg';
import './App.css';
import AddBox from './components/AddBox';
import BoxDisplay from './components/BoxDisplay';

function App() {
  const [currentBox, setCurrentBox] = useState([]);
  
  const youveBox = ( newBox ) => {
      setCurrentBox( newBox );
      console.log(newBox)
  }
  return (
    <div className="App">
      <AddBox onNewBox={ youveBox }/>
      <BoxDisplay box={ currentBox }/>
          </div>
  );
}

export default App;
