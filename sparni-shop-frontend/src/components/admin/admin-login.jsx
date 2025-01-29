import React, { useState } from 'react';
import API from '../../Api';

import './Login.css';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await API.post('/login', 
                new URLSearchParams({
                    username: username,
                    password: password,
                }), 
                {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                }
            );

            if (response.status === 200) {
                localStorage.setItem('isAuthenticated', 'true');
                window.location.href = 'http://localhost:3000/admin';
            }
        } catch (error) {
            console.error('Login failed', error);
        }
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2 className="h2admin">Spārni Admin Login</h2>
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        placeholder="Username"
                        required
                        className="login-input"
                    />
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Password"
                        required
                        className="login-input"
                    />
                    <button type="submit" className="login-button">Login</button>
                </form>
            </div>
        </div>
    );
};

export default Login;
