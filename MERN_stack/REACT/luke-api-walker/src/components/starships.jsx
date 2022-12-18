import axios from 'axios';
import React, { useEffect, useState } from 'react'

const StarShips = (props) => {
    const [starships, setStarShips] = useState("");

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/starships/${props.id}`)
            .then(response=>{setStarShips(response.data)})
    }, [props.id]);


    return (
        <div>
            <article>
                <h3> {starships.name} </h3>
                <ul className="list-group">
                    <li className="list-group-item">Climate: {starships.model} </li>
                    <li className="list-group-item">Terrain: {starships.manufacturer} </li>
                    <li className="list-group-item">Surface Water: {starships.consumables} </li>
                    <li className="list-group-item">Population: {starships.crew} </li>
                </ul>
            </article>
        </div>
    )
}

export default StarShips;