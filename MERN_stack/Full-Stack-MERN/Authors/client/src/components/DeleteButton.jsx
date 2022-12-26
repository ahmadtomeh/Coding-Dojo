import React from 'react'
import axios from 'axios';
    
export default props => {
    
    // const { authorId, successCallback } = props;
    
    const deleteAuthor = e => {
        axios.delete('http://localhost:8000/api/authors/' + props.authorId)
            .then(res=>{
                props.successCallback();
                console.log("ahmad")
            })
    }
    
    return (
        <button onClick={deleteAuthor}>
            Delete
        </button>
    )
}