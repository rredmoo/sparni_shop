import React, { useState } from 'react';
import axios from 'axios';
import './SendBulkEmail.css';

const SendBulkEmail = () => {
    const [subject, setSubject] = useState('');
    const [body, setBody] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const emailData = {
            subject,
            body,
        };

        try {
            const response = await axios.post('http://localhost:8080/api/contact/send-bulk-email', emailData);
            alert('Emails sent successfully');
        } catch (error) {
            console.error('Error sending emails', error);
            alert('Failed to send emails: ' + error.message);
        }
    };

    return (
        <div className="bulk-email">
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={subject}
                    onChange={(e) => setSubject(e.target.value)}
                    placeholder="Email subject"
                    required
                />
                <textarea
                    value={body}
                    onChange={(e) => setBody(e.target.value)}
                    placeholder="Email body"
                    required
                />
                <button type="submit">Send Emails</button>
            </form>
        </div>
    );
};

export default SendBulkEmail;
