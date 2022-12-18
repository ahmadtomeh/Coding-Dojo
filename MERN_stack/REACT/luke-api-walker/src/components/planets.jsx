import React from 'react';
import {useState, useEffect} from 'react';
import axios from 'axios';

const Planets = (props) => {
    
    const [planets, setPlanets] = useState("");

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/planets/${props.id}`)
            .then(response=>{setPlanets(response.data)})
    }, [props.id]);


    return (
        <div>
            <article>
                <h3> {planets.name} </h3>
                <ul className="list-group">
                    <li className="list-group-item">Climate: {planets.climate} </li>
                    <li className="list-group-item">Terrain: {planets.terrain} </li>
                    <li className="list-group-item">Surface Water: {planets.surface_water} </li>
                    <li className="list-group-item">Population: {planets.population} </li>
                </ul>
            </article>
        </div>
    )

}

export default Planets