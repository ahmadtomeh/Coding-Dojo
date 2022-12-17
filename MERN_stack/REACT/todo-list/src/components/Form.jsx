import React, { useState } from "react";

const Form = (props) =>{
    const [text, setText] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        setText("");
        props.onNewTask({'text': text,'isDone':false, status: "none"});
    }

    return(
        <form onSubmit={ handleSubmit }>
            <input value={text} type="text" onChange={(e) => setText(e.target.value)}/>
            <input type="submit" value="Add"/>            
        </form>
    )
}

export default Form;