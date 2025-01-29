import React from "react";
import {
  Navigate,
  Route,
  Routes,
  BrowserRouter as Router,
} from "react-router-dom";
import MainPage from "./components/main-page";
import StorePage from "./components/store-page";
import EventsPage from "./components/event-page";
import InformationPage from "./components/information-page";
import KontaktiPage from "./components/kontakti-page";
import PasakumsDetail from "./components/jaunumuPage/PasakumsDetail";
import ProtectedRoute from "./components/admin/ProtectedRoute";
import AdminPanel from "./components/admin/AdminPanel";
import AdminLogin from "./components/admin/admin-login";
import ShoppingCart from "./components/payments/ShoppingCart";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Navigate to="/main" replace />} />
        <Route path="/main" element={<MainPage />} />
        <Route path="/store" element={<StorePage />} />
        <Route path="/events" element={<EventsPage />} />
        <Route path="/events/:idPasakumi" element={<PasakumsDetail />} />
        <Route path="/info" element={<InformationPage />} />
        <Route path="/contact" element={<KontaktiPage />} />
        <Route path="/cart" element={<ShoppingCart />} />

        <Route path="/login" element={<AdminLogin />} />
        <Route
          path="/admin"
          element={
            <ProtectedRoute>
              <AdminPanel />
            </ProtectedRoute>
          }
        />
      </Routes>
    </div>
  );
}

export default App;
