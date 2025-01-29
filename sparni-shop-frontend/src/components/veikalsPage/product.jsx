import React, { useState, useEffect } from "react";
import PrecesServiceConfig from "../../config/VeikalsPageConfig";
import "../../static/css/Product.css";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";
import SparniLogo from "../../static/img/sparni-logo.png";
import axios from "axios"; // Ensure axios is imported

function Product({ sortOrder, numProducts }) {
  const [preces, setPreces] = useState([]);
  const [error, setError] = useState(null);
  const { t } = useTranslation();
  const [selectedCurrency, setSelectedCurrency] = useState("EUR");
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const [basketId] = useState(1); // Assuming you have a way to retrieve the basket ID

  useEffect(() => {
    const fetchData = async () => {
      try {
        let response;
        if (sortOrder === "asc") {
          response = await PrecesServiceConfig.getPrecesOrderedByAsc();
        } else if (sortOrder === "desc") {
          response = await PrecesServiceConfig.getPrecesOrderedByDesc();
        } else {
          response = await PrecesServiceConfig.getAllPreces();
        }

        if (Array.isArray(response.data)) {
          const limitedPreces = response.data.slice(0, numProducts);
          setPreces(limitedPreces);
        } else {
          console.error("Expected an array but got:", response.data);
          setPreces([]);
        }
      } catch (error) {
        console.error(t("errorProducts"), error);
        setError(error.message);
      }
    };

    fetchData();
  }, [sortOrder, numProducts, t]);

  const handleProductClick = (prece) => {
    setSelectedProduct(prece);
    setShowModal(true);
  };

  const closeModal = () => {
    setShowModal(false);
    setSelectedProduct(null);
  };

  const addToBasket = async () => {
    try {
      const response = await axios.post("/basket/item/add", null, {
        params: {
          basketId,
          productId: selectedProduct.idvp, // assuming `idvp` is the product ID
          count: 1, // defaulting to 1 item for now
        },
      });

      console.log(response.data);
      alert(t("productAddedToBasket"));
      closeModal();
    } catch (error) {
      console.error("Error adding product to basket:", error);
      alert(t("errorAddingProductToBasket"));
    }
  };

  return (
    <>
      <div className="product-list">
        {preces.length > 0 ? (
          preces.map((prece) => (
            <div
              className="product-card"
              key={prece.idvp}
              onClick={() => handleProductClick(prece)}
            >
              <img
                className="product-card-img"
                src={prece.veikals_prece_bildes}
                alt={prece.nosaukums}
              />
              <div className="product-card-details">
                <h3>{prece.nosaukums}</h3>
                <p>
                  {t("priceProduct", {
                    value: prece.cena,
                    currency: selectedCurrency,
                  })}
                </p>
              </div>
            </div>
          ))
        ) : (
          <div>{t("NoProductsAvailable")}</div>
        )}
      </div>

      {showModal && selectedProduct && (
        <div className="modal">
          <div className="modal-content">
            <header className="allnav">
              <nav className="Modal-nav">
                <Link to="/main">{t("nav.home")}</Link>
                <Link to="/events">{t("nav.events")}</Link>

                <img src={SparniLogo} alt="logo" className="sparni-logo" />

                <Link to="/info">{t("nav.info")}</Link>
                <Link to="/contact">{t("nav.contact")}</Link>
              </nav>
              <hr />
            </header>
            <span className="modal-close" onClick={closeModal}>
              &times;
            </span>
            <div className="modal-body">
              <img
                src={selectedProduct.veikals_prece_bildes}
                alt={selectedProduct.nosaukums}
                className="modal-img"
              />
              <div className="modal-details">
                <h2>{selectedProduct.nosaukums}</h2>
                <p className="modul-price">
                  {t("priceProduct", {
                    value: selectedProduct.cena,
                    currency: selectedCurrency,
                  })}
                </p>
                <button className="btn-basket" onClick={addToBasket}>
                  {t("Uz Grozu")}
                </button>
                <p>{selectedProduct.apraksts}</p>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
}

export default Product;
