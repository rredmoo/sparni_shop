import React, { useState, useEffect } from 'react';
import InformacijasServiceConfig from '../../config/InformacijasPageConfig';
import "../../static/css/Informacija.css";
import { useTranslation } from 'react-i18next';

function Informacija({ numInfos }) {
  const [infos, setInfos] = useState([]);
  const [error, setError] = useState(null);
  const { t, i18n } = useTranslation();

  useEffect(() => {
    InformacijasServiceConfig.getAllInformacija()
      .then((response) => {
        if (Array.isArray(response.data)) {
          const limitedInfo = response.data.slice(0, numInfos);
          setInfos(limitedInfo);
        } else {
          console.error('Expected an array but got:', response.data);
          setInfos([]);
        }
      })
      .catch((error) => {
        console.error(t("errorProducts"), error);
        setError(error.message);
      });
  }, [numInfos, t]);

  return (
    <>
      <div className="informacijas-list">
        {infos.length > 0 ? (
          infos.map((info) => (
            <div className="informacijas-card" key={info.id_info}>
              <img
                className="informacijas-card-img"
                src={info.bildesUrl}
                alt={info.nosaukums}
              />
              <div className="informacijas-card-details">
                <h3>{info[`nosaukums${i18n.language === 'lv' ? 'Lv' : 'En'}`]}</h3>
                <p>{info[`apraksts${i18n.language === 'lv' ? 'Lv' : 'En'}`]}</p>
              </div>
            </div>
          ))
        ) : (
          <div>{t('noInformationAvailable')}</div>
        )}
      </div>
      {error && <div>{t('error')}: {error}</div>}
    </>
  );
}

export default Informacija;
