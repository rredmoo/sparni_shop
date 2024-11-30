import React, { useState, useEffect } from "react";
import Header from "./common/Header";
import KontaktiPageConfig from "../config/KontaktiPageConfig";
import "../static/css/kontakti-page.css";
import Footer from "./common/Footer";
import Contact from "./mainPage/Contact";
import { useTranslation } from 'react-i18next';


function KontaktiPage() {
  const [kontaktiList, setKontaktiList] = useState([]);
  const [error, setError] = useState(null);
  const { t } = useTranslation();

  useEffect(() => {
    KontaktiPageConfig.getAllKontakti()
      .then((response) => {
        setKontaktiList(response.data);
      })
      .catch((error) => {
        console.error(t("errorContact"), error);
        setError(error.message);
      });
  }, []);


  return (
    <>
      <Header />
      <div className="main-page-cover">
        <div className="container">
          <h1>{t("contactList")}</h1>
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
            <p>{t("noContacts")}</p>
          )}

          <Contact />
        </div>
        <Footer />
      </div>
    </>
  );
}

export default KontaktiPage;
