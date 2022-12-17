import React, { useEffect, useState } from 'react'

const Form = (props) => {
    const [pokemon, setPokemon] = useState(null);

    const handleSubmit=(e)=>{
        e.preventDefault();
        props.a(pokemon);
    }
    return (
        <div>
            <form onSubmit={handleSubmit}>
            <button> Fetch Pokemon</button>
            </form>
        </div>
    )
}

export default Form;
