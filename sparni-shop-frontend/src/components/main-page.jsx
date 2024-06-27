import React from "react";
import Header from "./common/Header";
import "../static/css/MainPage.css";
import { Link } from "react-router-dom";
import SlideShow from "./mainPage/Slideshow";
import Product from "./veikalsPage/product";
import Pasakums from "./jaunumuPage/pasakums";
import Footer from "./common/Footer";
import Contact from "./mainPage/Contact";

function MainPage() {
  return (
    <div className="all">
      <Header />
      <div className="main-page-cover">
        <div className="container">
          <SlideShow />
          <h1 className="mainHeading">Par mums</h1>
          <p className="text">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nunc
            quam, congue vitae mollis vitae, egestas eu risus. Ut ullamcorper
            quam vitae magna vestibulum, eu laoreet felis convallis. Quisque
            accumsan odio vel ipsum bibendum, ac scelerisque metus aliquam.
            Aliquam a dictum purus, id vestibulum justo. Vivamus ut felis
            imperdiet magna volutpat congue id eu massa. Orci varius natoque
            penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            Vivamus scelerisque lorem ullamcorper nibh pretium, et hendrerit
            ante iaculis. Cras dui lectus, tincidunt ac nulla eu, fringilla
            scelerisque dui. Integer condimentum gravida ante. Sed eget
            malesuada magna. Cras nec est vel nibh auctor consectetur luctus eu
            odio. Donec blandit enim vitae nulla euismod hendrerit. Donec
            malesuada leo a libero facilisis, vel placerat mauris posuere. Cras
            at nisi eros.
          </p>
          <p className="text">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nunc
            quam, congue vitae mollis vitae, egestas eu risus. Ut ullamcorper
            quam vitae magna vestibulum, eu laoreet felis convallis. Quisque
            accumsan odio vel ipsum bibendum, ac scelerisque metus aliquam.
            Aliquam a dictum purus, id vestibulum justo. Vivamus ut felis
            imperdiet magna volutpat congue id eu massa. Orci varius natoque
          </p>
          <hr/>
          <br />
          <h1 className="mainHeading">TOP3 preces</h1>
          <Product numProducts={3} />
          <Link className="main-page-button" to="/store">Apskatīt visas preces</Link>
          <br />
          <hr/>
          <h1 className="mainHeading">Jaunumi</h1>
          <Pasakums numPasakumi={3} />
          <br />
          <h1 className="mainHeading">Kontakti</h1>
          <Contact />
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default MainPage;
