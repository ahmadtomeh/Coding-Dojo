import React, { useState } from 'react';

const AddBox = (props) => {
    const [box, setBox] = useState([]);
    const [color, setColor] = useState("")

    const handlesubmit = (e) => {
        e.preventDefault();
        setBox([ { 'color': color },...box])
        setColor("")
        props.onNewBox( [ { 'color': color },...box])
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