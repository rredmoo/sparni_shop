/* eslint-disable no-unused-vars */
import React, { useRef } from "react";
import "../../static/css/Contact.css";
import { useTranslation } from 'react-i18next';


function Contact() {
  const { t } = useTranslation();
  return (
    <div className="container">
      <div className="contactForm">

        <form>
          <div className="formRow">
            <div className="nameLeft">
              <label>{t('name')}</label>
              <input type="text" name="user_name"  placeholder={t('placeholder1')}  id="contactFieldName"/>
            </div>
            <div className="subjectRight">
              <label>{t('topic')}</label>
              <select name="user_reason">
                <option value="Casual">{t('topic1')}</option>
                <option value="Professional">{t('topic2')}</option>
                <option value="Issues">{t('topic3')}</option>
                <option value="Feedback">{t('topic4')}</option>
              </select>
            </div>
          </div>
          <label>{t('email')}</label>
          <input type="email" name="user_email" placeholder={t('placeholder2')} id="contactFieldEmail" required />
          <label>{t('message')}</label>
          <textarea className="message" name="message" placeholder={t('placeholder3')} id="contactFieldMessage" required></textarea>
          <button type="submit" id="sendButton">{t('send')}</button>
        </form>
      </div>
    </div>
  );
}

export default Contact;