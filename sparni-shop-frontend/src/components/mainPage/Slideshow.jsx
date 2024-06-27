import React, { useEffect, useState } from "react";
import "../../static/css/ImageSlider.css";

function SlideShow() {
  const [slideIndex, setSlideIndex] = useState(1);

  useEffect(() => {
    const interval = setInterval(() => {
      plusSlides(1); 
    }, 2000); 

    return () => clearInterval(interval); 
  }, []); 

  const plusSlides = (n) => {
    setSlideIndex((prevIndex) => {
      let newIndex = prevIndex + n;
      if (newIndex > 3) newIndex = 1;
      if (newIndex < 1) newIndex = 3;
      return newIndex;
    });
  };

  const currentSlide = (n) => {
    setSlideIndex(n);
  };

  const showSlides = (n) => {
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");

    for (let i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
    }
    for (let i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
    }

    if (slides[n - 1]) slides[n - 1].style.display = "block";
    if (dots[n - 1]) dots[n - 1].className += " active";
  };

  useEffect(() => {
    showSlides(slideIndex);
  }, [slideIndex]);

  return (
    <>
      <div className="slideshow-container">
        <div className="mySlides fade">
          <div className="numbertext">1 / 3</div>
          <img
            src="https://www.visitventspils.com/app/uploads/2022/08/VHrS_-008_0822-1_WEB-1080x720.jpg"
            style={{ width: "100%" }}
            alt="Slide 1"
          />
        </div>

        <div className="mySlides fade">
          <div className="numbertext">2 / 3</div>
          <img
            src="https://www.visitventspils.com/app/uploads/2022/08/555_AM_111221_33_web-1080x720.jpg"
            style={{ width: "100%" }}
            alt="Slide 2"
          />
        </div>

        <div className="mySlides fade">
          <div className="numbertext">3 / 3</div>
          <img
            src="https://www.ventasbalss.lv/upload/news/3582/715x715_1ee8e74a4c88325c417a1ab96a6ae108.jpg"
            style={{ width: "100%" }}
            alt="Slide 3"
          />
        </div>

        <a className="prev" onClick={() => plusSlides(-1)}>
          &#10094;
        </a>
        <a className="next" onClick={() => plusSlides(1)}>
          &#10095;
        </a>
      </div>
      <br />
    </>
  );
}

export default SlideShow;
