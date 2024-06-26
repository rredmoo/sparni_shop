import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import "../static/css/MainPage.css";
import SlideShow from "./mainPage/Slideshow";

function MainPage() {
  return (
    <>
      <Header />
      <SlideShow />
      <h1 className="mainHeading">Par mums</h1>

      
    </>
  );
}

export default MainPage;
