import React, { useState } from "react";
import Header from "./common/Header";
import Product from "./veikalsPage/product";
import { useTranslation } from "react-i18next"; 
import StoreBanner from "../static/img/storeBanner.png";
import "../static/css/Store.css";

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
      <div className="main-page-cover">
      <img src={StoreBanner} alt="Store Page Banner" className="storeBannerImage" />
      <h1>{t('storeHeader')}</h1>
      <div>
        <button className="storeSortingButton" onClick={() => handleSortOrder('asc')}>{t('asc')}</button>
        <button onClick={() => handleSortOrder('desc')}>{t('dsc')}</button>
      </div>
      <Product sortOrder={sortOrder} />
      </div>
    </>
  );
}

export default StorePage;
