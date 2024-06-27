import React, { useState, useEffect } from 'react';
import JaunumiServiceConfig from '../../config/JaunumuPageConfig';
import "../../static/css/Jaunums.css";

function Pasakums() {
  const [pasakumi, setPasakumi] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    JaunumiServiceConfig.getAllPasakumi()
      .then((response) => {
        if (Array.isArray(response.data)) {
          const sortedPasakumi = response.data.sort((a, b) => b.idPasakumi - a.idPasakumi);
          setPasakumi(sortedPasakumi);
        } else {
          console.error('Expected an array but got:', response.data);
          setPasakumi([]);
        }
      })
      .catch((error) => {
        console.error("Nevarēja iegūt jaunumus!", error);
        setError(error.message);
      });
  }, []);

  return (
    <>
      <div className="pasakumu-list">
        {pasakumi.length > 0 ? (
          <>
            {/* lielais pasakums */}
            {pasakumi.length > 0 && (
              <div className={`pasakums-card latest-pasakums`} key={pasakumi[0].idPasakumi}>
                <img
                  className="pasakums-card-img"
                  src={pasakumi[0].bildesUrl}
                  alt={pasakumi[0].nosaukums}
                />
                <div className="pasakums-card-details">
                  <h3>{pasakumi[0].nosaukums}</h3>
                  <p>{pasakumi[0].apraksts}</p>
                </div>
              </div>
            )}

            {/* mazie pasakumi labaja puse*/}
            {pasakumi.slice(1, 3).map((pasakums) => (
              <div className={`pasakums-card latest-small-pasakums`} key={pasakums.idPasakumi}>
                <img
                  className="pasakums-card-img"
                  src={pasakums.bildesUrl}
                  alt={pasakums.nosaukums}
                />
                <div className="pasakums-card-details">
                  <h3>{pasakums.nosaukums}</h3>
                  <p>{pasakums.apraksts}</p>
                </div>
              </div>
            ))}

            {/* Atdalosa linija */}
            <hr className="separator-line" />

            {/* Parada visus pasakumus */}
            {pasakumi.slice(3).map((pasakums) => (
              <div className="pasakums-card" key={pasakums.idPasakumi}>
                <img
                  className="pasakums-card-img"
                  src={pasakums.bildesUrl}
                  alt={pasakums.nosaukums}
                />
                <div className="pasakums-card-details">
                  <h3>{pasakums.nosaukums}</h3>
                  <p>{pasakums.apraksts}</p>
                </div>
              </div>
            ))}
          </>
        ) : (
          <div>No Pasakumi available</div>
        )}
      </div>
      {error && <div>Error: {error}</div>}
    </>
  );
}

export default Pasakums;
