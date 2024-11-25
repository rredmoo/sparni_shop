import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import "../../static/css/PasakumuDetails.css";

function PasakumsDetail() {
  const { idPasakumi } = useParams(); 
  const [event, setEvent] = useState(null); 
  const [error, setError] = useState(null); 
  const [loading, setLoading] = useState(true); 


  useEffect(() => {
    const fetchEventDetails = async () => {
      try {
        const response = await fetch(`http://localhost:8081/pasakumi/all/${idPasakumi}`);
        if (!response.ok) throw new Error('Event not found'); 

        const data = await response.json();
        setEvent(data); 
      } catch (err) {
        setError(err.message); 
      } finally {
        setLoading(false); 
      }
    };

    fetchEventDetails();
  }, [idPasakumi]);

  
  if (loading) return <div className="loading">...</div>;
  if (error) return <div className="error">Error: {error}</div>;
  if (!event) return <div className="error">Pasākums netika atrasts!</div>;

  return (
    <div className="pasakums-container">
      
      
      {/* nosaukums */}
      <div className="pasakums-header">
        <h1>{event.nosaukums}</h1>
      </div>

      <div className="pasakums-detail">
        {/* bild */}
        <img src={event.bildesUrl} alt={event.nosaukums} className="pasakums-image" />

        {/* dati */}
        <div className="event-info">
          <p><strong>Sākuma datums:</strong> {new Date(event.sakumaDatums).toLocaleString()}</p>
          <p><strong>beigu datums:</strong> {new Date(event.beiguDatums).toLocaleString()}</p>
          <p><strong>Vieta:</strong> {event.vieta}</p>
        </div>

        {/* apraksts */}
        <div className="event-description">
          <h3>Apraksts</h3>
          <p>{event.apraksts}</p>
        </div>
      </div>
    </div>
  );
}

export default PasakumsDetail;
