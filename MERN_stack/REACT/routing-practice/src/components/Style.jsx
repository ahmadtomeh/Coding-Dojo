import React from 'react'

const Style = (props) => {
    if (isNaN(props.word) === true) {
        return (
            <h1 style={{ backgroundColor: props.bcolor, color: props.color }}>The Word Is : {props.word}</h1>
        )
    }
    else {
        return (
            <h1 style={{ backgroundColor: props.bcolor, color: props.color }}>The Number Is : {props.word}</h1>
        )
    }
}

export default Style
