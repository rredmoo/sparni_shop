import React, { useState, useEffect } from "react";
import JaunumiServiceConfig from "../../config/JaunumuPageConfig";
import "../../static/css/Jaunums.css";

function Pasakums({ numPasakumi }) {
  const [pasakumi, setPasakumi] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    JaunumiServiceConfig.getAllPasakumi()
      .then((response) => {
        if (Array.isArray(response.data)) {
          const limitedPasakumi = response.data.slice(0, numPasakumi);
          setPasakumi(limitedPasakumi); // Set state with limitedPasakumi
        } else {
          console.error("Expected an array but got:", response.data);
          setPasakumi([]);
        }
      })
      .catch((error) => {
        console.error("Nevarēja iegūt jaunumus!", error);
        setError(error.message);
      });
  }, [numPasakumi]);

  return (
    <>
      <div className="pasakumu-list">
        {pasakumi.length > 0 ? (
          pasakumi.map((pasakums) => (
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
          ))
        ) : (
          <div>No Pasakumi available</div>
        )}
      </div>
      {error && <div>Error: {error}</div>}
    </>
  );
}

export default Pasakums;
