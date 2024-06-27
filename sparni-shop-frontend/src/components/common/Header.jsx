import React from "react";
import { Link } from "react-router-dom";
import "../../static/css/Header.css";
import SparniLogo from "../../static/img/sparni-logo.png";

function Header() {
  return (
    <>
      <div className="orangeBanner">
        <div className="scrolling-text">
          <p>
            Augstas kvalitātes amatnieku izstrādājumi, piegāde visā Latvijā caur
            DPD un Omniva
          </p>
          <p>
            Augstas kvalitātes amatnieku izstrādājumi, piegāde visā Latvijā caur
            DPD un Omniva
          </p>
        </div>
      </div>

      <div className="header-top">
        <img src={SparniLogo} alt="logo" className="sparni-logo" />
        <input type="text" placeholder="&#128270; Meklē preci.." className="search-input" />
        <div className="right-side">
        <select name="language" id="language">
              <option value="LV">LV</option>
              <option value="RU">RU</option>
            </select>
            <select name="currency" id="currency">
              <option value="EUR">EUR</option>
              <option value="USD">USD</option>
              <option value="RUB">RUB</option>
            </select>
        <Link className="cart-button" to="/cart"/>
        </div>
      </div>
      <header className="allnav">
        <hr />
        <nav>
          <Link to="/main">Sākums</Link>
          <Link to="/store">Veikals</Link>
          <Link to="/events">Jaunumi</Link>
          <Link to="/info">Informācija</Link>
          <Link to="/contact">Kontakti</Link>
        </nav>
      </header>
    </>
  );
}

export default Header;
