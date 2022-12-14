import React, { useState } from "react";

const Tabs = (props) => {
    const [tab, setTab] = useState([]);

    const handlesubmit = (e) =>{
        e.preventDefault();
        setTab([])
        props.onNewTab(tab)


    }

    return (
        <div>
            <form onSubmit={ handlesubmit }>
                <input value="Tab 1" type="submit" onClick={(e) => setTab(e.target.value)} />
                <input value="Tab 2" type="submit" onClick={(e) => setTab(e.target.value)} />
                <input value="Tab 3" type="submit" onClick={(e) => setTab(e.target.value)} />
            </form>
        </div>
    )
}

export default Tabs;