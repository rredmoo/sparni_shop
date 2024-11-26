import React, { useState } from "react";
import Header from "./common/Header";
import Product from "./veikalsPage/product";
import { useTranslation } from "react-i18next";
import leftImage from "../static/img/leftImage.png";
import rightImageTop from "../static/img/rightImageTop.png";
import rightImageBottomLeft from "../static/img/rightImageBottomLeft.png";
import rightImageBottomRight from "../static/img/rightImageBottomRight.png";
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
        <div class="container">
          <div class="gallery">
            <figure class="gallery__item gallery__item--1">
              <img src={leftImage} alt="Gallery image 1" class="gallery__img" />
            </figure>
            <figure class="gallery__item gallery__item--2">
              <img
                src={rightImageTop}
                alt="Gallery image 2"
                class="gallery__img"
              />
            </figure>
            <figure class="gallery__item gallery__item--3">
              <img
                src={rightImageBottomLeft}
                alt="Gallery image 3"
                class="gallery__img"
              />
            </figure>
            <figure class="gallery__item gallery__item--4">
              <img
                src={rightImageBottomRight}
                alt="Gallery image 4"
                class="gallery__img"
              />
            </figure>
          </div>
        </div>

        <div>
          <button
            className="storeSortingButton"
            onClick={() => handleSortOrder("asc")}
          >
            {t("asc")}
          </button>
          <button onClick={() => handleSortOrder("desc")}>{t("dsc")}</button>
        </div>
        <div className="storeItems">
          <Product sortOrder={sortOrder} />
        </div>
      </div>
    </>
  );
}

export default StorePage;
