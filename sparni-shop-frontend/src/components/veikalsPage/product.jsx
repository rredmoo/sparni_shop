import React, { useState, useEffect } from 'react';
import PrecesServiceConfig from '../../config/VeikalsPageConfig';
import "../../static/css/Product.css";
import { useTranslation } from 'react-i18next';

function Product({ sortOrder, numProducts }) {
  const [preces, setPreces] = useState([]);
  const [error, setError] = useState(null);
  const { t } = useTranslation();
  
  const [selectedCurrency, setSelectedCurrency] = useState('EUR'); 
  const exchangeRate = 1.2; 

  
  useEffect(() => {
    const storedCurrency = localStorage.getItem('preferredCurrency');
    if (storedCurrency) {
      setSelectedCurrency(storedCurrency);
    }

    
    const handleCurrencyChange = () => {
      const updatedCurrency = localStorage.getItem('preferredCurrency');
      setSelectedCurrency(updatedCurrency); 
    };

    window.addEventListener('currencyChange', handleCurrencyChange);

    
    return () => {
      window.removeEventListener('currencyChange', handleCurrencyChange);
    };
  }, []);

  
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
        console.error(t("errorProducts"), error);
        setError(error.message);
      }
    };

    fetchData();
  }, [sortOrder, numProducts, t]);

  
  const convertPrice = (price, currency) => {
    if (currency === 'USD') {
      return price * exchangeRate;
    }
    return price;
  };

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

                
                <p>{t('priceProduct', {
                  value: convertPrice(prece.cena, selectedCurrency),
                  currency: selectedCurrency
                })}</p>
              </div>
            </div>
          ))
        ) : (
          <div>{t('NoProductsAvailable')}</div>
        )}
      </div>
      {error && <div>Error: {error}</div>}
    </>
  );
}

export default Product;
