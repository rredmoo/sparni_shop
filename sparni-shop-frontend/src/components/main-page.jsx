import React from "react";
import Header from "./common/Header";
import "../static/css/MainPage.css";
import SlideShow from "./mainPage/Slideshow";

function MainPage() {
  return (
    <>
    <Header />
    <div className="main-page-cover">
      <SlideShow />
      <h1 className="mainHeading">Par mums</h1>
    </div>
  </>
  );
}

export default MainPage;
