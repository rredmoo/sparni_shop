import { useEffect, useState } from "react";
import EmailConfig from "../../config/EmailConfig";
import API from "../../Api";

function SendSelectedEmail() {
  const [emails, setEmails] = useState([]);
  const [selectedEmails, setSelectedEmails] = useState([]);
  const [subject, setSubject] = useState("");
  const [body, setBody] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    const emailData = {
      subject,
      body,
      selectedEmails,
    };

    console.log("Sending email data:", emailData);

    try {
      const response = await API.post(
        "/api/contact/send-selected-email",
        emailData
      );
      if (response.status === 200) {
        alert("Emails sent successfully");
        setSubject("");
        setBody("");
      }
    } catch (error) {
      console.error("Error sending emails", error);
      alert(
        "Failed to send emails: " +
          (error.response?.data?.message || error.message)
      );
    } finally {
      setLoading(false);
    }
  };

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
  }, []); 

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
            <button
              onClick={() => handleRemoveEmail(email)}
              style={{ marginLeft: "10px" }}
            >
              Remove
            </button>
          </li>
        ))}
      </ul>
    ) : (
      <p>No emails selected</p>
    );
  };

  return (
    <div>

      <div className="bulk-email">
      <select onChange={handleEmailSelection} value="" disabled={loading}>
        <option value="" disabled>
          Select an email
        </option>
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
        <br/>
      </div>
        <form onSubmit={handleSubmit}>
          <input
            className="searchCheck"
            type="text"
            value={subject}
            onChange={(e) => setSubject(e.target.value)}
            placeholder="Email subject"
            required
          />
          <textarea
            className="searchTextArea"
            value={body}
            onChange={(e) => setBody(e.target.value)}
            placeholder="Email body"
            required
          />
          <button type="submit" disabled={loading}>
            {loading ? "Sending..." : "Send Emails"}
          </button>
        </form>
      </div>
    </div>
  );
}

export default SendSelectedEmail;
