import React, { useState, useEffect } from 'react';
import PrecesServiceConfig from '../../config/VeikalsPageConfig';
import "../../static/css/Product.css";

function Product({ sortOrder, numProducts }) {
  const [preces, setPreces] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        let response;
        if (sortOrder === 'asc') {
          response = await PrecesServiceConfig.getPrecesOrderedByAsc();
        } else if (sortOrder === 'desc') {
          response = await PrecesServiceConfig.getPrecesOrderedByDesc();
        } else {
          response = await PrecesServiceConfig.getAllPreces();
        }

        if (Array.isArray(response.data)) {
          const limitedPreces = response.data.slice(0, numProducts);
          setPreces(limitedPreces);
        } else {
          console.error('Expected an array but got:', response.data);
          setPreces([]);
        }
      } catch (error) {
        console.error("Nevarēja iegūt preces!", error);
        setError(error.message);
      }
    };

    fetchData();
  }, [sortOrder, numProducts]);

  return (
    <>
      <div className="product-list">
        {preces.length > 0 ? (
          preces.map((prece) => (
            <div className="product-card" key={prece.idvp}>
              <img
                className="product-card-img"
                src={prece.veikals_prece_bildes}
                alt={prece.nosaukums}
              />
              <div className="product-card-details">
                <h3>{prece.nosaukums}</h3>
                <p>{prece.apraksts}</p>
                <p>Cena: {prece.cena} EUR</p>
              </div>
            </div>
          ))
        ) : (
          <div>No products available</div>
        )}
      </div>
      {error && <div>Error: {error}</div>}
    </>
  );
}

export default Product;
