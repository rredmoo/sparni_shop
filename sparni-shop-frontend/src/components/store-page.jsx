// MainPage.js
import React, { useEffect, useState } from 'react';
import AtlaidesServiceConfig from '../config/VeikalsPageConfig';
import Header from './common/Header';

function MainPage() {
    const [error, setError] = useState(null);

    return (
        <>
            <Header />
            <h1>Pašlaik pieejamās preces</h1>
            {error && <p>Error: {error}</p>}
        </>
    );
}

export default MainPage;
