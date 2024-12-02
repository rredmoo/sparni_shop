import React, { useState } from 'react';
import API from '../../Api';
import './SendBulkEmail.css';

const SendBulkEmail = () => {
    const [subject, setSubject] = useState('');
    const [body, setBody] = useState('');
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);

        const emailData = {
            subject,
            body,
        };

        try {
            const response = await API.post('/api/contact/send-bulk-email', emailData);
            if (response.status === 200) {
                alert('Emails sent successfully');
                setSubject('');
                setBody('');
            }
        } catch (error) {
            console.error('Error sending emails', error);
            alert('Failed to send emails: ' + (error.response?.data?.message || error.message));
        } finally {
            setLoading(false);
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
                <button type="submit" disabled={loading}>
                    {loading ? 'Sending...' : 'Send Emails'}
                </button>
            </form>
        </div>
    );
};

export default SendBulkEmail;
