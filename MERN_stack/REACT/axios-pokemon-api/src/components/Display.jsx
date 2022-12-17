import React from 'react'

const Display = (props) => {
    return (
        <div>
            <ol>
                {props.pokemons.length > 0 && props.pokemons.map(
                    (pokemon, index) => <li key={index}>{pokemon.name}</li>
                )}
            </ol>
        </div>
    )
}

export default Display
