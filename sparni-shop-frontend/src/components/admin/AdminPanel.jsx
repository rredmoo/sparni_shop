import React from 'react';
import { useNavigate } from 'react-router-dom';
import './AdminPanel.css';

const AdminPanel = () => {

    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem('isAuthenticated');
        navigate('/main');
    };

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
            </main>
        </div>
    );
};

export default AdminPanel;
