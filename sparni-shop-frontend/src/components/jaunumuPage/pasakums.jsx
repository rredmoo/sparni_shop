import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import JaunumiServiceConfig from "../../config/JaunumuPageConfig";
import "../../static/css/Jaunums.css";
import { useTranslation } from 'react-i18next';
import DatePicker from 'react-datepicker'; 
import 'react-datepicker/dist/react-datepicker.css'; 

function Pasakums({ numPasakumi }) {
  const [pasakumi, setPasakumi] = useState([]);  
  const [categories, setCategories] = useState([]);  
  const [selectedCategory, setSelectedCategory] = useState('');  
  const [searchTerm, setSearchTerm] = useState('');  
  const [filteredPasakumi, setFilteredPasakumi] = useState([]);  
  const [selectedDate, setSelectedDate] = useState(null);  
  const [loading, setLoading] = useState(true);  
  const [error, setError] = useState(null);  
  const { t } = useTranslation();

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
      const formattedDate = date.toISOString().split('T')[0];  

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
    const filtered = pasakumi.filter((pasakums) =>
      pasakums.nosaukums.toLowerCase().includes(searchTerm.toLowerCase()) || 
      pasakums.apraksts.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredPasakumi(filtered);
  }, [searchTerm, pasakumi]);

  return (
    <>
      <div className="filter-bar">
        {/* Category dropdown */}
        <div className="category-filter">
          <select id="category-select" onChange={handleCategoryChange} value={selectedCategory}>
            <option value="">{t('Viss')}</option>
            {categories.map((category) => (
              <option key={category.idpk} value={category.idpk}>
                {category.nosaukums}
              </option>
            ))}
          </select>
        </div>

        {/* Search bar */}
        <div className="search-bar">
          <input
            id="search-input"
            type="text"
            value={searchTerm}
            onChange={handleSearchInputChange}
            placeholder={t('Meklēt pasākumu...')}
          />
        </div>

        {/* Date picker */}
        <div className="date-picker">
          <DatePicker
            selected={selectedDate}
            onChange={handleDateChange}
            placeholderText={t('Kārtot pēc datuma...')}
            dateFormat="yyyy-MM-dd"
            id="date-picker"
          />
        </div>
      </div>

      {/* Event list */}
      <div className="pasakumi-container">
        {loading ? (
          <div>{t('LoadingEvents')}</div>
        ) : error ? (
          <div>Error: {error}</div>
        ) : filteredPasakumi.length > 0 ? (
          <>
            {/* Display the first large event */}
            <div className="pasakumi-top">
              <div className="pasakumi-left">
                {filteredPasakumi.length > 0 && (
                  <Link to={`/events/${filteredPasakumi[0].idPasakumi}`}>
                    <div className={`pasakums-card latest-pasakums`} key={filteredPasakumi[0].idPasakumi}>
                      <img
                        className="pasakums-card-img-large"
                        src={filteredPasakumi[0].bildesUrl}
                        alt={filteredPasakumi[0].nosaukums}
                      />
                      <div className="pasakums-card-details">
                        <h3>{filteredPasakumi[0].nosaukums}</h3>
                        <p>{filteredPasakumi[0].apraksts}</p>
                      </div>
                    </div>
                  </Link>
                )}
              </div>

              {/* Small events on the right */}
              <div className="pasakumi-right">
                {filteredPasakumi.slice(1, 3).map((pasakums) => (
                  <Link to={`/events/${pasakums.idPasakumi}`} key={pasakums.idPasakumi}>
                    <div className={`pasakums-card latest-small-pasakums`}>
                      <img
                        className="pasakums-card-img"
                        src={pasakums.bildesUrl}
                        alt={pasakums.nosaukums}
                      />
                      <div className="pasakums-card-details">
                        <h3>{pasakums.nosaukums}</h3>
                        <p>{pasakums.apraksts}</p>
                      </div>
                    </div>
                  </Link>
                ))}
              </div>
            </div>

            {/* Display the rest of the events */}
            <div className="pasakumi-under">
              {filteredPasakumi.slice(3).map((pasakums) => (
                <Link to={`/events/${pasakums.idPasakumi}`} key={pasakums.idPasakumi}>
                  <div className="pasakums-card rest-of-pasakumi">
                    <img
                      className="pasakums-card-img"
                      src={pasakums.bildesUrl}
                      alt={pasakums.nosaukums}
                    />
                    <div className="pasakums-card-details">
                      <h3>{pasakums.nosaukums}</h3>
                      <p>{pasakums.apraksts}</p>
                    </div>
                  </div>
                </Link>
              ))}
            </div>
          </>
        ) : (
          <div>{t('NoEventsAvailable')}</div>
        )}
      </div>
    </>
  );
}

export default Pasakums;
