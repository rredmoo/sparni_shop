import React, { useState } from 'react';
import axios from 'axios';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/login', 
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
            // Handle successful login (e.g., store tokens, redirect, etc.)
            if (response.status === 200) {
                // Redirect to admin page
                window.location.href = 'http://localhost:3000/admin';
            }
        } catch (error) {
            console.error('Login failed', error);
            // Handle login error (e.g., show error message)
        }
    };
    

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Username"
                required
            />
            <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
                required
            />
            <button type="submit">Login</button>
        </form>
    );
};

export default Login;
