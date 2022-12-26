import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AuthorForm from '../components/AuthorForm';
import AuthorList from '../components/AuthorList';
import { Link } from '@reach/router';

export default () => {
    const [authors, setAuthors] = useState([]);
    const [loaded, setLoaded] = useState(false);
    useEffect(()=>{
        axios.get("http://localhost:8000/api/authors")
            .then(res=> {
                setAuthors(res.data);
                setLoaded(true);
                console.log("aaa")
            });
    }, []);

    const removeFromDom = authorId => {
        setAuthors(authors.filter(author => author._id != authorId));
    }

    const createAuthor = author => {
        axios.post('http://localhost:8000/api/authors/new', author)
            .then(res=>{
                setAuthors([...authors, res.data]);
            })
    }

    return (
        <div>
            {/* <AuthorForm onSubmitProp={createAuthor} initialTitle = "" initialPrice = {0} initialDescription = ""/> */}
            <Link to = {"/new"}> Add an author</Link>
            
            {loaded && <AuthorList authors={authors} removeFromDom={removeFromDom}/>}

        </div>
    )
}