import React, { useState, useEffect } from "react";
import Header from "./common/Header";
import KontaktiPageConfig from "../config/KontaktiPageConfig";
import "../static/css/MainPage.css";
import Footer from "./common/Footer";
import Contact from "./mainPage/Contact";

function KontaktiPage() {
  const [kontaktiList, setKontaktiList] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    KontaktiPageConfig.getAllKontakti()
      .then((response) => {
        setKontaktiList(response.data);
      })
      .catch((error) => {
        console.error("Nav iegūti kontakti:", error);
        setError(error.message);
      });
  }, []);

  return (
    <div className="main-page-cover">
      <Header />
      <div className="container">
        <div style={{ display: "flex", flexDirection: "row-reverse" }}>
          <img
            src="https://scontent.frix5-1.fna.fbcdn.net/v/t39.30808-6/304305481_582293090263823_6288500434435968889_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=cc71e4&_nc_ohc=_TzTWi2n0v8Q7kNvgFJCD8T&_nc_ht=scontent.frix5-1.fna&oh=00_AYDwpbOaAbAhMmfjzT960YlI_-SzeJTSwsI0T5twRD68eA&oe=668379AC"
            style={{
              width: "50%",
              height: "auto",
              margin: "50px 0 50px 100px",
              border: "2px solid #000",
            }}
            alt="Kontakti image"
          />
          <div>
            <h1 style={{ margin: "20px 0" }}>Kontaktu saraksts</h1>
            {kontaktiList.length > 0 ? (
              <ul>
                {kontaktiList.map(({ idk, nosaukums, informacija }) => (
                  <li key={idk}>
                    {nosaukums} <br />
                    {informacija} <br />
                  </li>
                ))}
              </ul>
            ) : (
              <p>Nav kontakti</p>
            )}
            <article style={{ margin: "20px 0" , fontSize: "1.6rem", fontFamily: "Arial, sans-serif", fontWeight: 400 , lineHeight: "1.5" }} className="article-center" >
              Rekvizīti: <br />
              SUVENĪRU SALONS "VENTIŅPŪRLAD" <br />
              Skolas iela 3 <br />
              Ventspils, LV-3601 <br />
              PVN Nr. LV40008057629 <br />
              Banka, kods: XXXXX <br />
              Konta Nr.: <br />
              LVXXXXXXXXXXXXXXXXXXX <br />
            </article>
            {error && <p>Error: {error}</p>}
          </div>
        </div>
        <Contact />
      </div>
      <Footer />
    </div>
  );
}

export default KontaktiPage;
