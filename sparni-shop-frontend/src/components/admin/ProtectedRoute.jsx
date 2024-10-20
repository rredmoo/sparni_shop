import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ element: Component }) => {
    const isAuthenticated = !!localStorage.getItem('token');  // You could check cookies or tokens

    return isAuthenticated ? (
        <Component />
    ) : (
        <Navigate to="/login" />  // Redirect to login if not authenticated
    );
};

export default ProtectedRoute;
