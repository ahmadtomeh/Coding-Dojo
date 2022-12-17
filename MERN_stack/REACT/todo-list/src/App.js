import React, { useState } from 'react';
import './App.css';

import Form from './components/Form';
import Display from './components/Display';

function App() {
  const [todos, setTodos] = useState([]);

  const addTask = ( newTask ) => {
    setTodos([...todos,newTask]);
  }
  const change=(e,item)=>{
    item.isDone?item.isDone=false:item.isDone=true
    item.isDone?item.status="line-through":item.status="none"
    setTodos([...todos])
  }
  const deleteOne=(id)=>{
      setTodos(todos.filter((e,item) => id !== item));
    }
  
  return (
    <div className="App">
      <Form  onNewTask = { addTask }/>
      <Display t = {todos} handleOnChange={change} handleOnClick={deleteOne}/>
    </div>
  );
}

export default App;
