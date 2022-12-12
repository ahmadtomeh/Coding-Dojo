import React, { useState } from "react";

const BoxDisplay = (props) => {
    return (
        <>
        <h1>Current Boxes</h1>
            <div>
                {
                    props.box.map(
                        (item, i) =>
                            <div key={i}
                                style={{
                                    backgroundColor: item.color,
                                    width: "150px",
                                    height: "150px",
                                    margin: "15px",
                                    display: "inline-block",
                                    boxShadow:"10px 10px lightblue"
                                }} >
                            </div>
                    )
                }
            </div>
        </>
    )
}

export default BoxDisplay;