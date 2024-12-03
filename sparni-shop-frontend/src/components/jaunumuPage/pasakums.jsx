import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import JaunumiServiceConfig from "../../config/JaunumuPageConfig";
import "../../static/css/Jaunums.css";
import { useTranslation } from "react-i18next";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

function Pasakums({ numPasakumi }) {
  const [pasakumi, setPasakumi] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [searchTerm, setSearchTerm] = useState("");
  const [filteredPasakumi, setFilteredPasakumi] = useState([]);
  const [selectedDate, setSelectedDate] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { t, i18n } = useTranslation();
  const currentLanguage = i18n.language; 

  
  useEffect(() => {
    JaunumiServiceConfig.getCategories()
      .then((response) => {
        setCategories(response.data);
      })
      .catch((error) => {
        console.error(t("errorCategories"), error);
        setError(error.message);
      });
  }, [t]);

  
  useEffect(() => {
    const fetchEvents = () => {
      const apiCall = selectedCategory
        ? JaunumiServiceConfig.getPasakumiByCategory(selectedCategory)
        : JaunumiServiceConfig.getAllPasakumi();

      setLoading(true);

      apiCall
        .then((response) => {
          if (Array.isArray(response.data)) {
            const sortedPasakumi = response.data.sort(
              (a, b) => b.idPasakumi - a.idPasakumi
            );
            setPasakumi(sortedPasakumi.slice(0, numPasakumi));
            setFilteredPasakumi(sortedPasakumi);
          } else {
            console.error("Expected an array but got:", response.data);
            setPasakumi([]);
            setFilteredPasakumi([]);
          }
        })
        .catch((error) => {
          console.error(t("errorEvents"), error);
          setError(error.message);
        })
        .finally(() => setLoading(false));
    };

    fetchEvents();
  }, [numPasakumi, selectedCategory, t]);

  
  const handleDateChange = (date) => {
    setSelectedDate(date);

    if (date) {
      const formattedDate = date.toISOString().split("T")[0];

      setLoading(true);

      JaunumiServiceConfig.getEventsByDate(formattedDate)
        .then((response) => {
          if (Array.isArray(response.data)) {
            setPasakumi(response.data);
            setFilteredPasakumi(response.data);
          } else {
            setPasakumi([]);
            setFilteredPasakumi([]);
          }
        })
        .catch((error) => {
          console.error("Error fetching events by date:", error);
          setError(error.message);
          setPasakumi([]);
          setFilteredPasakumi([]);
        })
        .finally(() => setLoading(false));
    }
  };

  
  const handleCategoryChange = (event) => {
    setSelectedCategory(event.target.value);
  };

 
  const handleSearchInputChange = (event) => {
    setSearchTerm(event.target.value);
  };


  useEffect(() => {
    const filtered = pasakumi.filter((pasakums) => {
      const nosaukums =
        currentLanguage === "lv"
          ? pasakums.nosaukumsLv
          : pasakums.nosaukumsEn;
      const apraksts =
        currentLanguage === "lv"
          ? pasakums.aprakstsLv
          : pasakums.aprakstsEn;

      return (
        (nosaukums?.toLowerCase() || "").includes(searchTerm.toLowerCase()) ||
        (apraksts?.toLowerCase() || "").includes(searchTerm.toLowerCase())
      );
    });
    setFilteredPasakumi(filtered);
  }, [searchTerm, pasakumi, currentLanguage]);

  return (
    <>
      <div className="filter-bar">
       
        <div className="category-filter">
          <select
            id="category-select"
            onChange={handleCategoryChange}
            value={selectedCategory}
          >
           <option value="">{t("category.all")}</option>
            {categories.map((category) => (
              <option key={category.idpk} value={category.idpk}>
                {currentLanguage === "lv"
                  ? category.nosaukumsLv
                  : category.nosaukumsEn}
              </option>
            ))}
          </select>
        </div>

     
        <div className="search-bar">
          <input
            id="search-input"
            type="text"
            value={searchTerm}
            onChange={handleSearchInputChange}
            placeholder={t('searchBarPasakumi')}
          />
        </div>

       
        <div className="date-picker">
          <DatePicker
            selected={selectedDate}
            onChange={handleDateChange}
            placeholderText={t('datePicker')}
            dateFormat="yyyy-MM-dd"
            id="date-picker"
          />
        </div>
      </div>

   
      <div className="pasakumi-container">
        {loading ? (
          <div>{t("LoadingEvents")}</div>
        ) : error ? (
          <div>Error: {error}</div>
        ) : filteredPasakumi.length > 0 ? (
          <>
          
            <div className="pasakumi-top">
              <div className="pasakumi-left">
                {filteredPasakumi.length > 0 && (
                  <Link to={`/events/${filteredPasakumi[0].idPasakumi}`}>
                    <div
                      className={`pasakums-card latest-pasakums`}
                      key={filteredPasakumi[0].idPasakumi}
                    >
                      <img
                        className="pasakums-card-img-large"
                        src={filteredPasakumi[0].bildesUrl}
                        alt={
                          currentLanguage === "lv"
                            ? filteredPasakumi[0].nosaukumsLv
                            : filteredPasakumi[0].nosaukumsEn
                        }
                      />
                      <div className="pasakums-card-details">
                        <h3>
                          {currentLanguage === "lv"
                            ? filteredPasakumi[0].nosaukumsLv
                            : filteredPasakumi[0].nosaukumsEn}
                        </h3>
                        <p>
                          {currentLanguage === "lv"
                            ? filteredPasakumi[0].aprakstsLv
                            : filteredPasakumi[0].aprakstsEn}
                        </p>
                      </div>
                    </div>
                  </Link>
                )}
              </div>

             
              <div className="pasakumi-right">
                {filteredPasakumi.slice(1, 3).map((pasakums) => (
                  <Link to={`/events/${pasakums.idPasakumi}`} key={pasakums.idPasakumi}>
                    <div className={`pasakums-card latest-small-pasakums`}>
                      <img
                        className="pasakums-card-img"
                        src={pasakums.bildesUrl}
                        alt={
                          currentLanguage === "lv"
                            ? pasakums.nosaukumsLv
                            : pasakums.nosaukumsEn
                        }
                      />
                      <div className="pasakums-card-details">
                        <h3>
                          {currentLanguage === "lv"
                            ? pasakums.nosaukumsLv
                            : pasakums.nosaukumsEn}
                        </h3>
                        <p>
                          {currentLanguage === "lv"
                            ? pasakums.aprakstsLv
                            : pasakums.aprakstsEn}
                        </p>
                      </div>
                    </div>
                  </Link>
                ))}
              </div>
            </div>

           
            <div className="pasakumi-under">
              {filteredPasakumi.slice(3).map((pasakums) => (
                <Link to={`/events/${pasakums.idPasakumi}`} key={pasakums.idPasakumi}>
                  <div className="pasakums-card rest-of-pasakumi">
                    <img
                      className="pasakums-card-img"
                      src={pasakums.bildesUrl}
                      alt={
                        currentLanguage === "lv"
                          ? pasakums.nosaukumsLv
                          : pasakums.nosaukumsEn
                      }
                    />
                    <div className="pasakums-card-details">
                      <h3>
                        {currentLanguage === "lv"
                          ? pasakums.nosaukumsLv
                          : pasakums.nosaukumsEn}
                      </h3>
                      <p>
                        {currentLanguage === "lv"
                          ? pasakums.aprakstsLv
                          : pasakums.aprakstsEn}
                      </p>
                    </div>
                  </div>
                </Link>
              ))}
            </div>
          </>
        ) : (
          <div>{t("NoEventsAvailable")}</div>
        )}
      </div>
    </>
  );
}

export default Pasakums;
