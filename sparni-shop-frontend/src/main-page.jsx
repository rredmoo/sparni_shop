// MainPage.js
import React, { useEffect, useState } from 'react';
import AtlaidesServiceConfig from './MainPageConfig';

function MainPage() {
    const [atlaides, setAtlaides] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        AtlaidesServiceConfig.getAllAtlaide()
            .then(response => {
                setAtlaides(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the atlaides!', error);
                setError(error.message);
            });
    }, []);

    return (
        <div>
            <h2>Atlaides</h2>
            {error && <p>Error: {error}</p>}
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Discount Amount</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                    </tr>
                </thead>
                <tbody>
                    {atlaides.map(atlaide => (
                        <tr key={atlaide.ida}>
                            <td>{atlaide.ida}</td>
                            <td>{atlaide.atlaidesApmers}</td>
                            <td>{new Date(atlaide.sakumaDatums).toLocaleString()}</td>
                            <td>{new Date(atlaide.beiguDatums).toLocaleString()}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default MainPage;
