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
          const sortedPasakumi = response.data.sort(
            (a, b) => b.idPasakumi - a.idPasakumi
          );
          setPasakumi(sortedPasakumi.slice(0, numPasakumi));
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
      <div className="pasakumi-container">
        {pasakumi.length > 0 ? (
          <>
            <div className="pasakumi-top">
              <div className="pasakumi-left">
                {/* Lielais pasakums */}
                {pasakumi.length > 0 && (
                  <div
                    className={`pasakums-card latest-pasakums`}
                    key={pasakumi[0].idPasakumi}
                  >
                    <img
                      className="pasakums-card-img-large"
                      src={pasakumi[0].bildesUrl}
                      alt={pasakumi[0].nosaukums}
                    />
                    <div className="pasakums-card-details">
                      <h3>{pasakumi[0].nosaukums}</h3>
                      <p>{pasakumi[0].apraksts}</p>
                    </div>
                  </div>
                )}
              </div>

              <div className="pasakumi-right">
                {/* Mazie pasakumi labajā pusē */}
                {pasakumi.slice(1, 3).map((pasakums) => (
                  <div
                    className={`pasakums-card latest-small-pasakums`}
                    key={pasakums.idPasakumi}
                  >
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
              </div>
            </div>

            <div className="pasakumi-under">
              {/* Mazie pasakumi zem */}
              {pasakumi.slice(3).map((pasakums) => (
                <div
                  className="pasakums-card rest-of-pasakumi"
                  key={pasakums.idPasakumi}
                >
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
            </div>
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
