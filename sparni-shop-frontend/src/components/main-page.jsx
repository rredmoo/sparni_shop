import React from "react";
import Header from "./common/Header";
import "../static/css/MainPage.css";
import { Link } from "react-router-dom";
import SlideShow from "./mainPage/Slideshow";
import Product from "./veikalsPage/product";
import Pasakums from "./jaunumuPage/pasakums";
import Footer from "./common/Footer";
import Contact from "./mainPage/Contact";
import { useTranslation } from "react-i18next"; 
import EmailSubmit from './mainPage/EmailSubmit';

function MainPage() {
  const { t } = useTranslation(); 

  return (
    <div className="all">
      <Header />
      <div className="main-page-cover">
        <div className="container">
          <SlideShow />

          <h1 className="mainHeading">{t('aboutUs')}</h1>
          
          <p className="text">
            {t('text_1')}
          </p>
         
          <p className="text">
            {t('text_2')}
          </p>
         
          <hr/>
          <br />
         
          <h1 className="mainHeading">{t('topProducts')}</h1>
          
          <Product numProducts={3} />
          <Link className="main-page-button" to="/store">{t('viewAllProducts')}</Link>
          <br />
          <hr/>
          <h1 className="mainHeading">{t('latestNews')}</h1>
          <Pasakums numPasakumi={3} />
          <br />
          <EmailSubmit />
          <h1 className="mainHeading">{t('contactUs')}</h1>
          <Contact />
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default MainPage;
