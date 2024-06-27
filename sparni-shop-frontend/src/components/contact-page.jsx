import React, { useState, useEffect } from 'react';
import Header from './common/Header';
import KontaktiPageConfig from '../config/KontaktiPageConfig';
import "../static/css/Product.css";

function KontaktiPage() {
    const [kontaktiList, setKontaktiList] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        KontaktiPageConfig.getAllKontakti()
            .then((response) => {
                setKontaktiList(response.data);
            })
            .catch((error) => {
                console.error('Nav iegūti kontakti:', error);
                setError(error.message);
            });
    }, []);

    return (
        <>
            <Header />
            <div>
                <h1>Kontaktu saraksts</h1>
                {kontaktiList.length > 0 ? (
                    <ul>
                        {kontaktiList.map((kontakti) => (
                            <li key={kontakti.idk}>
                                <strong>Nosaukums:</strong> {kontakti.nosaukums} <br />
                                <strong>Informacija:</strong> {kontakti.informacija}
                            </li>
                        ))}
                    </ul>
                ) : (
                    <p>Nav kontakti</p>
                )}
                {error && <p>Error: {error}</p>}
            </div>
        </>
    );
}

export default KontaktiPage;
