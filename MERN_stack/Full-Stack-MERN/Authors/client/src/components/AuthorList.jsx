import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, navigate } from '@reach/router';
import DeleteButton from './DeleteButton';

const AuthorList = (props) => {
    const [authors, setAuthors] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors', authors)
            .then(res => setAuthors(res.data), console.log("rrr"));
    }, [authors])

    const removeFromDom = authorId => {
        axios.get('http://localhost:8000/api/authors')
        setAuthors(authors.filter(author => author._id != authorId))
    }

    const toEdit = authorId => {
        navigate("/" + authorId + "/edit")
        console.log(authorId + "aggg")
    }
    return (
        <div>
            <p>We have quotes by:</p>
            <table border="1">
                <thead>
                    <td>Author</td>
                    <td>Actions Available</td>
                </thead>
                <tbody>
                    {
                        authors.sort((a, b) => {
                            if (a.name < b.name) { return -1; }
                            if (a.name > b.name) { return 1; }
                            return 0;
                        }
                        )
                            .map((author, i) =>
                                <tr key={i}>
                                    <td>
                                        <p>{author.name}</p>
                                    </td>
                                    <td>
                                        <button onClick={() => toEdit(author._id)}>Edit</button>
                                        <DeleteButton authorId={author._id} successCallback={() => removeFromDom(author._id)} />
                                    </td>
                                </tr>
                            )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default AuthorList;