import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import KontaktiPageConfig from "../config/KontaktiPageConfig";
import KontaktiPage from "./kontaktiPage/kontakti";
import { useTranslation } from 'react-i18next';
import Footer from "./common/Footer";


function KontaktiSave() {
  const [error, setError] = useState(null);
  const { t } = useTranslation();

  return (
    <>
      <Header />
      <h1>{t('contacts')}</h1>
      <p>Nepieciešams pievienot kontaktus</p>
      <Footer/>
    </>
  );
}

export default KontaktiSave;
