import React from "react";

const TabDisplay = (props) => {

    return(
        <div>
            {props.tab[0] && <p>{props.tab} content is showing here.</p>}
        </div>
    )
}

export default TabDisplay;