import React, { useState } from 'react';


const Hook = () => {
    const [firstname, setFirstname] = useState("");
    const [lastname, setLaststname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [ConfirmPassword, setConfirmPassword] = useState("");

    const createUser = (e) => {
        e.preventDefault();
        const newUser = { firstname, lastname, email, password, ConfirmPassword };
        console.log("Welcome", newUser);
    };

    return (
        <>
            <form onSubmit={createUser}>
                <div>
                    <label>First name: </label>
                    <input type="text" onChange={(e) => {setFirstname(e.target.value);console.log(e)} }/>
                </div>
                <div>
                    <label>Last name: </label>
                    <input type="text" onChange={(e) => setLaststname(e.target.value)} />
                </div>
                <div>
                    <label>Email Address: </label>
                    <input type="text" onChange={(e) => setEmail(e.target.value)} />
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" onChange={(e) => setPassword(e.target.value)} />
                </div>
                <div>
                    <label>Confirm Password: </label>
                    <input type="password" onChange={(e) => setConfirmPassword(e.target.value)} />
                </div>
                <input type="submit" value="Create User" />
            </form>

            <h1>Your Forms data :</h1>
            <h2>First Name : {firstname}</h2>
            <h2>Last Name : {lastname}</h2>
            <h2>Email : {email}</h2>
            <h2>Password : {password}</h2>
            <h2>Confirm Password : {ConfirmPassword}</h2>
        </>
    );
};

export default Hook;

