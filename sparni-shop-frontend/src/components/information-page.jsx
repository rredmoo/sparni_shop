import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import InformacijasPageConfig from "../config/InformacijasPageConfig";
import Informacija from "./informacijasPage/informacija";
import { useTranslation } from 'react-i18next';


function InformacijasPage() {
  const [error, setError] = useState(null);
  const { t } = useTranslation();

  return (
    <>
      <Header />
      <h1>{t('information')}</h1>
      <Informacija /> 

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default InformacijasPage;
