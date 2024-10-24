import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ children }) => {
    const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true'; // Check the authentication status
    return isAuthenticated ? children : <Navigate to="/login" replace />;
};

export default ProtectedRoute;
