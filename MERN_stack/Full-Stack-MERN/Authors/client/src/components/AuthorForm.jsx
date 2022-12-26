import { Link, navigate } from '@reach/router';
import React, { useState } from 'react'

export default (props) => {
    const { initialName, onSubmitProp } = props;
    const [name, setName] = useState(initialName);

    const onSubmitHandler = (e) => {
        e.preventDefault();
        onSubmitProp({ name });
        setName("")
    }

    const aaa = (e) => {
        navigate("/")
    }
    return (
        <div>
            
            <p>
                <label>Name : </label><br />
                
                <input type="text" onChange={(e) => setName(e.target.value)} value={name} />
            </p>
            <button onClick={onSubmitHandler}>Submit</button>
            <button onClick={aaa}>Cancel</button>
        </div>
    )
}
