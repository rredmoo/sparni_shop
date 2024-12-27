import { useEffect, useState } from "react";
import EmailConfig from "../../config/EmailConfig";

function SendSelectedEmail() {
  const [emails, setEmails] = useState([]);
  const [selectedEmails, setSelectedEmails] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await EmailConfig.getSavedEmails(); 
        if (Array.isArray(response.data)) {
          setEmails(response.data);
        } else {
          console.error("Expected an array but got:", response.data);
          setEmails([]);
        }
      } catch (err) {
        console.error("Error fetching saved emails:", err);
        setError(err.message);
      }
    };

    fetchData();
  }, []); // Dependency array - runs only once

  // selection of emails
  const handleEmailSelection = (event) => {
    const value = event.target.value;
    if (value && !selectedEmails.includes(value)) {
      setSelectedEmails((prevSelectedEmails) => [...prevSelectedEmails, value]);
    }
  };

  // remove selected email
  const handleRemoveEmail = (email) => {
    setSelectedEmails(selectedEmails.filter((item) => item !== email));
  };

  // render list
  const renderSelectedEmails = () => {
    return selectedEmails.length > 0 ? (
      <ul>
        {selectedEmails.map((email, index) => (
          <li key={index}>
            {email} 
            <button onClick={() => handleRemoveEmail(email)} style={{ marginLeft: '10px' }}>Remove</button>
          </li>
        ))}
      </ul>
    ) : (
      <p>No emails selected</p>
    );
  };

  return (
    <div>
      <select onChange={handleEmailSelection} value="">
        <option value="" disabled>Select an email</option>
        {emails.length > 0 ? (
          emails.map((email) => (
            <option key={email.ide} value={email.epasts}>
              {email.epasts}
            </option>
          ))
        ) : (
          <option disabled>No emails available</option>
        )}
      </select>

      <div>
        <h3>Selected Emails:</h3>
        {renderSelectedEmails()}
      </div>
    </div>
  );
}

export default SendSelectedEmail;
