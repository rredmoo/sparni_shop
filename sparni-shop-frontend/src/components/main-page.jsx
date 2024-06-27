import React from "react";
import Header from "./common/Header";
import "../static/css/MainPage.css";
import SlideShow from "./mainPage/Slideshow";

function MainPage() {
  return (
    <>
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
          
        </div>
      </div>
    </>
  );
}

export default MainPage;
