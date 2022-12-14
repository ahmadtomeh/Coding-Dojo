
import './App.css';
import Tabs from './components/Tabs';
import TabDisplay from './components/TabDisplay';
import React,{ useState } from 'react';

function App() {
  const [currentTab, setCurrentTab] = useState([]);

  const youveTab = ( newTab ) => {
    setCurrentTab( newTab );
    console.log(newTab)
}
  return (
    <div className="App">
      <Tabs onNewTab={ youveTab }/>
      <TabDisplay  tab={ currentTab }/>
    </div>
  );
}

export default App;
