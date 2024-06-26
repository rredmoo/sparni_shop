import React from "react";
import { Navigate, Route, Routes, BrowserRouter as Router } from "react-router-dom";
import MainPage from "./components/main-page";
import StorePage from "./components/store-page";
import EventsPage from "./components/event-page";
import InformationPage from "./components/information-page";
import ContactsPage from "./components/contact-page";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Navigate to="/main" replace />} />
        <Route path="/main" element={<MainPage />} />
        <Route path="/store" element={<StorePage />} />
        <Route path="/events" element={<EventsPage />} />
        <Route path="/info" element={<InformationPage />} />
        <Route path="/contact" element={<ContactsPage />} />
      </Routes>
    </div>
  );
}

export default App;
