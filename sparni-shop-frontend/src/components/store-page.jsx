import React, { useState } from "react";
import Header from "./common/Header";
import Product from "./veikalsPage/product";
import { useTranslation } from "react-i18next"; 

function StorePage() {
  const [error, setError] = useState(null);
  const [sortOrder, setSortOrder] = useState(null);
  const { t } = useTranslation(); 

  const handleSortOrder = (order) => {
    setSortOrder(order);
  };

  return (
    <>
      <Header />
      <h1>{t('storeHeader')}</h1>
      <div>
        <button onClick={() => handleSortOrder('asc')}>{t('asc')}</button>
        <button onClick={() => handleSortOrder('desc')}>{t('dsc')}</button>
      </div>
      <Product sortOrder={sortOrder} />

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default StorePage;
