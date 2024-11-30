import React, { useEffect, useState, useCallback } from "react";
import Header from "./common/Header";
import JaunumuPageConfig from "../config/JaunumuPageConfig"; 
import Pasakums from "./jaunumuPage/pasakums";
import { useTranslation } from 'react-i18next';
import Footer from "./common/Footer";


function EventsPage() {
  const [error, setError] = useState(null);
  const { t } = useTranslation();
  const [value, setValue] = useState(new Date()); 

  const onChange = useCallback(
    (newValue) => {
      setValue(newValue);
    },
    []
  );


  return (
    <>
      <Header />
      <h1>{t('event')}</h1>
      
      <Pasakums /> 
      <Footer/>
    </>
  );
}

export default EventsPage;
