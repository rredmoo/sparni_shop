import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../../static/css/Header.css";
import SparniLogo from "../../static/img/sparni-logo.png";
import { useTranslation } from "react-i18next";

function Header() {
  const { t, i18n } = useTranslation();
  const [selectedLanguage, setSelectedLanguage] = useState('lv');
  const [selectedCurrency] = useState('EUR');

  useEffect(() => {
    const storedLanguage = localStorage.getItem('preferredLanguage');
    if (storedLanguage) {
      i18n.changeLanguage(storedLanguage);
      setSelectedLanguage(storedLanguage);
    }

    const storedCurrency = localStorage.getItem('preferredCurrency');
    if (storedCurrency) {
      
    }
  }, [i18n]);

  const changeLanguage = (lang) => {
    i18n.changeLanguage(lang);
    localStorage.setItem('preferredLanguage', lang);
    setSelectedLanguage(lang);
  };

  return (
    <>
      <div className="orangeBanner">
        <div className="scrolling-text">
          <p className="text">{t('textHeader')}</p>
          <p>{t('textHeader')}</p>
        </div>
      </div>

      <div className="header-top">
        <img src={SparniLogo} alt="logo" className="sparni-logo" />
        <input
          type="text"
          placeholder={t('searchBar')}
          className="search-input"
        />
        <div className="right-side">
        
          <select
            name="language"
            id="language"
            value={selectedLanguage}
            onChange={(e) => changeLanguage(e.target.value)}
          >
            <option value="lv">LV</option>
            <option value="en">EN</option>
          </select>

         
          <select
            name="currency"
            id="currency"
            value={selectedCurrency}
            disabled 
          >
            <option value="EUR">EUR</option>
          </select>

          <Link className="cart-button" to="/cart" />
        </div>
      </div>

      <header className="allnav">
        <hr />
        <nav>
          <Link to="/main">{t('nav.home')}</Link>
          <Link to="/store">{t('nav.store')}</Link>
          <Link to="/events">{t('nav.events')}</Link>
          <Link to="/info">{t('nav.info')}</Link>
          <Link to="/contact">{t('nav.contact')}</Link>
        </nav>
      </header>
    </>
  );
}

export default Header;
