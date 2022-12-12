import React, { useState } from 'react';


const Hook = () => {
    const [firstname, setFirstname] = useState("");
    const [lastname, setLaststname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [ConfirmPassword, setConfirmPassword] = useState("");
    const [FirstnameError, setFirstnameError] = useState("");
    const [LaststnameError, setLaststnameError] = useState("");
    const [EmailError, setEmailError] = useState("");
    const [PasswordError, setPasswordError] = useState("");
    const [ConfirmPasswordError, setConfirmPasswordError] = useState("");

    const createUser = (e) => {
        e.preventDefault();
        const newUser = { firstname, lastname, email, password, ConfirmPassword };
        console.log("Welcome", newUser);
    };
    const handleFirstname = (e) => {
        setFirstname(e.target.value);
        if(e.target.value.length < 1) {
            setFirstnameError("");
        } else if(e.target.value.length < 2) {
            setFirstnameError("Firstname must be 2 characters or longer!");
        } else {
            setFirstnameError("");
        }
    }

    const handleLaststname = (e) => {
        setLaststname(e.target.value);
        if(e.target.value.length < 1) {
            setLaststnameError("");
        } else if(e.target.value.length < 2) {
            setLaststnameError("Laststname must be 2 characters or longer!");
        } else {
            setLaststnameError("");
        }
    }
    
    const handleEmail = (e) => {
        setEmail(e.target.value);
        if(e.target.value.length < 1) {
            setEmailError("");
        } else if(e.target.value.length < 2) {
            setEmailError("Email must be 2 characters or longer!");
        } else {
            setEmailError("");
        }
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
        if(e.target.value.length < 1) {
            setPasswordError("");
        } else if(e.target.value.length < 8) {
            setPasswordError("Password must be 8 characters or longer!");
        } else {
            setPasswordError("");
        }
    }

    const handleConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
        if(e.target.value.length < 1) {
            setConfirmPasswordError("");
        } else if(e.target.value.length < 8) {
            setConfirmPasswordError("ConfirmPassword must be 8 characters or longer!");
        } else {
            setConfirmPasswordError("");
        }
    }
    return (
        <>
            <form onSubmit={createUser}>
                <div>
                    <label>First name: </label>
                    <input type="text" onChange={handleFirstname}/>
                    {
                    FirstnameError ?
                    <p style={{color:'red'}}>{ FirstnameError }</p> :
                    ''
                }
                </div>
                <div>
                    <label>Last name: </label>
                    <input type="text" onChange={handleLaststname} />
                    {
                    LaststnameError ?
                    <p style={{color:'red'}}>{ LaststnameError }</p> :
                    ''
                }
                </div>
                <div>
                    <label>Email Address: </label>
                    <input type="text" onChange={handleEmail} />
                    {
                    EmailError ?
                    <p style={{color:'red'}}>{ EmailError }</p> :
                    ''
                }
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" onChange={handlePassword} />
                    {
                    PasswordError ?
                    <p style={{color:'red'}}>{ PasswordError }</p> :
                    ''
                }
                </div>
                <div>
                    <label>Confirm Password: </label>
                    <input type="password" onChange={handleConfirmPassword} />
                    {
                    ConfirmPasswordError ?
                    <p style={{color:'red'}}>{ ConfirmPasswordError }</p> :
                    ''
                }
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

