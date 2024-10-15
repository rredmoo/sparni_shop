import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import KontaktiPageConfig from "../config/KontaktiPageConfig";
import KontaktiPage from "./kontaktiPage/kontakti";
import { useTranslation } from 'react-i18next';


function KontaktiSave() {
  const [error, setError] = useState(null);
  const { t } = useTranslation();

  return (
    <>
      <Header />
      <h1>{t('contacts')}</h1>

      <KontaktiPage />

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default KontaktiSave;
