import React, { useState } from 'react';

const AddBox = (props) => {
    const [box, setBox] = useState([]);
    const [color, setColor] = useState("")

    const handlesubmit = (e) => {
        e.preventDefault();
        setBox([...box, { 'color': color }])
        setColor("")
        props.onNewBox( [...box, { 'color': color }] );
        
    };
    return (
        <div>
            <form onSubmit={ handlesubmit }>
                <label>Color</label>
                <input value={color} type="text" onChange={(e) => setColor(e.target.value)} />
                <input type="submit" value="Add" />
            </form>
        </div>
    );
};

export default AddBox;