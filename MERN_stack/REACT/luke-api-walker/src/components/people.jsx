import React from 'react';
import { useState, useEffect } from 'react';
import axios from 'axios';

const People = (props) => {

    const [people, setPeople] = useState({});

    useEffect(() => {
        axios.get(`https://swapi.dev/api/people/${props.id}`)
            .then(response => { setPeople(response.data) })
        console.log(people.homeworld)
    }, [props.id]);

    const [homeworld2, setHomeworld2] = useState("");


    useEffect(() => {
        axios.get(`${people.homeworld}`)
            .then(response => { setHomeworld2(response.data) })
    }, [people.homeworld]);

    console.log(homeworld2)

    const a = `${people.homeworld}`;
    const tName = a.match(/\d+/);
    console.log(tName);

    const str = `${people.homeworld}`;
    const replaced = str.replace(/\D/g, '');
    console.log(replaced);

    return (
        <div>
            <article>
                <h3> {people.name} </h3>
                <ul className="list-group">
                    <li className="list-group-item">   height:{people.height} </li>
                    <li className="list-group-item"> mass:{people.mass} </li>
                    <li className="list-group-item"> Hair Color: {people.hair_color} </li>
                    <li className="list-group-item"> Skin Color: {people.skin_color} </li>
                    <li className="list-group-item"> Home World: <a href={`/planets/${tName}`}>{homeworld2.name}</a> </li>
                </ul>
            </article>
        </div>
    )
}

export default People

// import React from 'react'


// const People = () => {
//     const [id, setId] = useState(0);
//     const [option, setOption] = useState("");

//     const handleOptions = (e) => {
//         setOption(e.target.value)
//     }

//     const handleId = (e) => {
//         setId(e.target.value);
//     }

//     const handleSubmit = (e) => {
//         e.preventDefault();
//         if (option === "People") {
//             navigate('/people/' + id)
//         }
//         else if (option === "Planets") {
//             navigate('/planets/' + id)
//         }
//         else {
//             navigate('/');
//         }
//     }
//     return (
//         <div>
//             <form onSubmit={handleSubmit}>

//                 <span>Search for :</span>
//                 <select onChange={handleOptions}>
//                     <option selected>Chose Your Topic ...</option>
//                     <option value="People">People</option>
//                     <option value="Planets">Planets</option>
//                 </select>
//                 <br />
//                 <span>ID :</span>
//                 <input type="number" value={id} onChange={handleId} />
//                 <input type="submit" value="Search" />

//             </form>
//         </div>
//     )
// }

// export default People
