import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './AdminPanel.css';
import EmailServiceConfig from '../../config/AdminPageConfig';
import SendBulkEmail from './SendBulkEmail';

const AdminPanel = () => {
    const [epastiNoKlientiem, setEpastiNoKlientiem] = useState([]); //epasti
    const [filteredEpasti, setFilteredEpasti] = useState([]); //filtered emails
    const [searchQuery, setSearchQuery] = useState(''); //search query
    const [expandedRows, setExpandedRows] = useState([]);
    const navigate = useNavigate();
    const [error, setError] = useState(null);

    const handleLogout = () => {
        localStorage.removeItem('isAuthenticated');
        navigate('/main');
    };

    const toggleRow = (id) => {
        if (expandedRows.includes(id)) {
            setExpandedRows(expandedRows.filter(rowId => rowId !== id));
        } else {
            setExpandedRows([...expandedRows, id]);
        }
    };

    const isRowExpanded = (id) => expandedRows.includes(id);

    const truncateText = (text, wordLimit = 20) => {
        const words = text.split(' ');
        if (words.length > wordLimit) {
            return words.slice(0, wordLimit).join(' ') + '...';
        }
        return text;
    };

    useEffect(() => {
        const fetchEmails = async () => {
            try {
                const response = await EmailServiceConfig.getAllEmails();
                if (Array.isArray(response.data)) {
                    setEpastiNoKlientiem(response.data);
                    setFilteredEpasti(response.data); // Initialize filtered emails
                } else {
                    console.error('Expected an array but got:', response.data);
                    setEpastiNoKlientiem([]);
                }
            } catch (error) {
                console.error('Error fetching emails', error);
                setError(error.message);
            }
        };
        fetchEmails();
    }, []);

    useEffect(() => {
        // Filter emails based on search query
        const filtered = epastiNoKlientiem.filter(email =>
            email.userName.toLowerCase().includes(searchQuery.toLowerCase()) ||
            email.userEmail.toLowerCase().includes(searchQuery.toLowerCase()) ||
            email.topic.toLowerCase().includes(searchQuery.toLowerCase()) ||
            email.messageContent.toLowerCase().includes(searchQuery.toLowerCase())
        );
        setFilteredEpasti(filtered);
    }, [searchQuery, epastiNoKlientiem]); // Re-run filter on search change

    return (
        <div className="admin-panel">
            <nav className="sidebar">
                <h2 className="logo">Spārni Admin</h2>
                <ul className="menu">
                    <li><a href="#">Dashboard</a></li>
                    <li><a href="#">Products</a></li>
                    <li><a href="#">Orders</a></li>
                    <li><a href="#">Customers</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><button className="logout-button" onClick={handleLogout}>Log Out</button></li>
                </ul>
            </nav>
            <main className="main-content">
                <header className="header">
                    <h1>Sveiks, Admin</h1>
                    <p>Veikala pārvaldīšanas panelis</p>
                </header>
                <section>
                    <h3>Search Emails</h3>
                    <input
                        type="text"
                        placeholder="Search by username, email, topic, or message"
                        value={searchQuery}
                        onChange={(e) => setSearchQuery(e.target.value)} // Update search
                    />
                </section>
                <section>
                    <h3>Epasti no klientiem</h3>
                    {error && <p>Error: {error}</p>}
                    <table className="email-table">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Email</th>
                                <th>Topic</th>
                                <th>Message</th>
                                <th>Received At</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredEpasti.length > 0 ? (
                                filteredEpasti.map((email) => (
                                    <tr key={email.idenk} onClick={() => toggleRow(email.idenk)} className="clickable-row">
                                        <td>{email.userName}</td>
                                        <td>{email.userEmail}</td>
                                        <td>{email.topic}</td>
                                        <td>
                                            {isRowExpanded(email.idenk)
                                                ? email.messageContent
                                                : truncateText(email.messageContent)}
                                        </td>
                                        <td>{new Date(email.receivedAt).toLocaleString()}</td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="5">No emails available</td>
                                </tr>
                            )}
                        </tbody>
                    </table>
                </section>
                <br></br>
                <SendBulkEmail />
            </main>
        </div>
    );
};

export default AdminPanel;
