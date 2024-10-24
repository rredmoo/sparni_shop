import React, { useState } from "react";
import axios from "axios";
import "../../static/css/Contact.css";
import { useTranslation } from 'react-i18next';

function Contact() {
  const { t } = useTranslation();
  const [userName, setUserName] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [topic, setTopic] = useState('');
  const [messageContent, setMessageContent] = useState('');
  const [responseMessage, setResponseMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("Form submitted with values:", {
        userName,
        userEmail,
        topic,
        messageContent,
    });

    try {
        const response = await axios.post('http://localhost:8080/api/contact/send', {
            userName,
            userEmail,
            topic,
            messageContent,
        });

        setResponseMessage(response.data);
        console.log("Response from server:", response.data);
    } catch (error) {
        setResponseMessage('Error sending message: ' + error.message);
        console.error("Error details:", error); // Log the error for debugging
    }
};


  return (
    <div className="container">
      <div className="contactForm">
        <form onSubmit={handleSubmit}>
          <div className="formRow">
            <div className="nameLeft">
              <label>{t('name')}</label>
              <input type="text" value={userName} onChange={(e) => setUserName(e.target.value)} placeholder={t('placeholder1')} required />
            </div>
            <div className="subjectRight">
              <label>{t('topic')}</label>
              <select value={topic} onChange={(e) => setTopic(e.target.value)} required>
                <option value="Casual">{t('topic1')}</option>
                <option value="Professional">{t('topic2')}</option>
                <option value="Issues">{t('topic3')}</option>
                <option value="Feedback">{t('topic4')}</option>
              </select>
            </div>
          </div>
          <label>{t('email')}</label>
          <input type="email" value={userEmail} onChange={(e) => setUserEmail(e.target.value)} placeholder={t('placeholder2')} required />
          <label>{t('message')}</label>
          <textarea className="message" value={messageContent} onChange={(e) => setMessageContent(e.target.value)} placeholder={t('placeholder3')} required></textarea>
          <button type="submit" id="sendButton">{t('send')}</button>
        </form>
        {responseMessage && <p>{responseMessage}</p>}
      </div>
    </div>
  );
}

export default Contact;
