import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './AdminPanel.css';
import EmailServiceConfig from '../../config/AdminPageConfig';
const AdminPanel = () => {
    const [epastiNoKlientiem, setEpastiNoKlientiem] = useState([]);
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
                <section className="dashboard">
                    <div className="stat-box">
                        <h3>Pieejamie produkti</h3>
                        <p>N/A</p>
                    </div>
                    <div className="stat-box">
                        <h3>Jauni pasūtījumi</h3>
                        <p>N/A</p>
                    </div>
                    <div className="stat-box">
                        <h3>Pēdējai automātiskai e-pasts pirms</h3>
                        <p>N/A</p>
                    </div>
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
                            {epastiNoKlientiem.length > 0 ? (
                                epastiNoKlientiem.map((email) => (
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
            </main>
        </div>
    );
};

export default AdminPanel;
