import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AuthorForm from '../components/AuthorForm';
import DeleteButton from '../components/DeleteButton';
import { Link, navigate } from '@reach/router';


const Update = (props) => {
    const { id } = props;
    const [author, setAuthor] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const [errors, setErrors] = useState([]);


    useEffect(() => {
        axios.get('http://localhost:8000/api/authors/' + id)
            .then(res => {
                setAuthor(res.data);
                setLoaded(true);
                console.log("getForDelete")
            })
            .catch(error => navigate("/error"))
    }, [id]);

    const updateAuthor = (author) => {
        axios.put('http://localhost:8000/api/authors/' + id, author)
            .then(res => {console.log(res); console.log("updated"); navigate("/")})
            .catch(err => {
                const errorResponse = err.response.data.errors; // Get the errors from err.response.data
                const errorArr = []; // Define a temp error array to push the messages in
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // Set Errors
                setErrors(errorArr);
            })
    }

    return (
        <div>
            <Link to={"/"}>Home</Link>
            <p>Edit this author</p>
            {errors.map((err, index) => (<p key={index}>{err}</p>))}
            {loaded && (<AuthorForm onSubmitProp={updateAuthor} initialName={author.name} />)}
            {/* <DeleteButton authorId={author._id} /> */}
        </div>
    )
}

export default Update;