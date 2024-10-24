import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './EmailSubmit.css';

const EmailSubmit = () => {
    const [email, setEmail] = useState('');
    const [error, setError] = useState('');
    const [isSubmitted, setIsSubmitted] = useState(false);

    const EMAIL_REGEX = /^[a-zA-Z0-9._%+-]{3,63}@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    useEffect(() => {
        // Check if there's a timestamp in local storage
        const lastSubmissionTime = localStorage.getItem('lastEmailSubmissionTime');
        if (lastSubmissionTime) {
            const currentTime = new Date().getTime();
            const timeElapsed = currentTime - lastSubmissionTime;

            // 300000 milliseconds == 5min
            if (timeElapsed < 300000) {
                setIsSubmitted(true);
            }
        }
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        if (!EMAIL_REGEX.test(email)) {
            setError('Please enter a valid email (3-63 characters before @).');
            return;
        }

        // Check if email can be submitted 
        const lastSubmissionTime = localStorage.getItem('lastEmailSubmissionTime');
        const currentTime = new Date().getTime();
        if (lastSubmissionTime && currentTime - lastSubmissionTime < 300000) {
            setError('You can only submit an email once every 5 minutes.');
            return;
        }

        const emailData = {
            epasts: email,
        };

        try {
            const response = await axios.post('http://localhost:8080/api/contact/client/email/save', emailData);
            alert(response.data);
            setEmail('');
            localStorage.setItem('lastEmailSubmissionTime', currentTime);
        } catch (error) {
            console.error('Error saving email', error);
            alert('Failed to save email: ' + error.message);
        }
    };

    return (
        <div className="email-submit">
            <form onSubmit={handleSubmit}>
                <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder="Enter your email"
                    required
                />
                <button type="submit" disabled={isSubmitted}>Submit</button>
                {error && <p className="error">{error}</p>}
            </form>
        </div>
    );
};

export default EmailSubmit;
