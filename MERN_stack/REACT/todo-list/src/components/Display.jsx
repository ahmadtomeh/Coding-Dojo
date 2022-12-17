import React, { useState } from "react";

const BoxDisplay = (props) => {
    return (
        <>
            <h1>Current Boxes</h1>
            <div>
                {
                    props.t.map(
                        (item, i) =>
                            <div key={i}>
                                <p>
                                <span style = {{textDecorationLine:item.status}}>{item.text}</span>
                                <input type="checkBox" checked={item.isDone} onChange={(e) => props.handleOnChange(e, item)} />
                                <button onClick={(e) => props.handleOnClick(i)}>Delete</button>
                                </p>
                            </div>
                    )
                }
            </div>
        </>
    )
}

export default BoxDisplay;