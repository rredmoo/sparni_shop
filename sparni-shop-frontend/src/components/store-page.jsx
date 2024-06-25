import React, { useEffect, useState } from "react";
import PrecesServiceConfig from "../config/VeikalsPageConfig";
import Header from "./common/Header";

function StorePage() {
  const [error, setError] = useState(null);
  const [preces, setPreces] = useState([]);

  useEffect(() => {
    PrecesServiceConfig.getAllPreces()
      .then((response) => {
        setPreces(response.data);
      })
      .catch((error) => {
        console.error("Nevarēja iegūt preces!", error);
        setError(error.message);
      });
  }, []);

  return (
    <>
      <Header />
      <h1>Pašlaik pieejamās preces</h1>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nosaukums</th>
            <th>Apraksts</th>
            <th>Cena</th>
            <th>Daudzums</th>
          </tr>
        </thead>
        <tbody>
          {preces.map((prece) => (
            <tr key={prece.idvp}>
              <td>{prece.idvp}</td>
              <td>{prece.nosaukums}</td>
              <td>{prece.apraksts}</td>
              <td>{prece.cena}</td>
              <td>{prece.daudzums}</td>
            </tr>
          ))}
        </tbody>
      </table>
      {error && <p>Error: {error}</p>}
    </>
  );
}

export default StorePage;
