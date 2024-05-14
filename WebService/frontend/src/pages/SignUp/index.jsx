// SignUp.js

import {useState} from "react";
import axios from "axios";
import '/src/style.css'; // CSS dosyasını içeri aktar

export function SignUp() {

    const [username, setUsername] = useState()
    const [email, setEmail] = useState()
    const [password, setPassword] = useState()
    const [passwordRepeat, setPasswordRepeat] = useState()

    const onSubmit = (event) =>{
        event.preventDefault()
        axios.post('/api/v1/users', { // endpoint
            username,
            email,
            password,
        })
    }

    return (
        <div className="form-container">
            <h1>Register</h1>
            <form onSubmit={onSubmit}>
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input id="username" type="text" value={username} onChange={(event) => setUsername(event.target.value)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input id="email" type="email" value={email} onChange={(event) => setEmail(event.target.value)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input id="password" type="password" value={password} onChange={(event) => setPassword(event.target.value)}/>
                </div>
                <div className="form-group">
                    <label htmlFor="passwordRepeat">Password Repeat</label>
                    <input id="passwordRepeat" type="password" value={passwordRepeat} onChange={(event) => setPasswordRepeat(event.target.value)}/>
                </div>
                <div className="form-group">
                    <button disabled={!password || password !== passwordRepeat}>Register</button>
                </div>
            </form>
        </div>
    );
}
