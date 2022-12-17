
import React from 'react'

const Word = (props) => {

    if (isNaN(props.x) === true) {
        return (
            <h1>The Word Is: {props.x}</h1>
        )
    }
    else {
        return (
            <h1>The Number Is: {props.x}</h1>
        )
    }
}

export default Word
