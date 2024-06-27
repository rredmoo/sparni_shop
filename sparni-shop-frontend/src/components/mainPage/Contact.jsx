/* eslint-disable no-unused-vars */
import React, { useRef } from "react";
import "../../static/css/Contact.css";

function Contact() {
  return (
    <div className="container">
      <div className="contactForm">

        <form>
          <div className="formRow">
            <div className="nameLeft">
              <label>Name:</label>
              <input type="text" name="user_name" placeholder="Enter your name/nickname" id="contactFieldName"/>
            </div>
            <div className="subjectRight">
              <label>Subject:</label>
              <select name="user_reason">
                <option value="Casual">Casual Mail</option>
                <option value="Professional">Professional</option>
                <option value="Issues">Bug report</option>
                <option value="Feedback">Feedback</option>
              </select>
            </div>
          </div>
          <label>Email:</label>
          <input type="email" name="user_email" placeholder="Enter your email" id="contactFieldEmail" required />
          <label>Message:</label>
          <textarea className="message" name="message" placeholder="Type your message here..." id="contactFieldMessage" required></textarea>
          <button type="submit" id="sendButton">Send</button>
        </form>
      </div>
    </div>
  );
}

export default Contact;