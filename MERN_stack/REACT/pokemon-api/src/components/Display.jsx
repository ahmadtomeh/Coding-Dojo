import React from 'react'

const Display = (props) => {
    return (
        <div>
            <ol>
                {props.pokemons.length > 0 && props.pokemons.map(
                    (pokemon, index) => {
                        return (<li key={index}>{pokemon.name} {pokemon.id}</li>)
                    }
                )}
            </ol>
        </div>
    )
}

export default Display
