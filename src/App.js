import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import UserDashboard from './pages/UserDashboard';
import HospitalDashboard from './pages/HospitalDashboard';
import BloodBankDashboard from './pages/BloodBankDashboard';
import RequestPageToBank from './pages/RequestPageToBank';
import RequestPageToUser from './pages/RequestPageToUser';
import NotFound from './pages/NotFound';
import PrivateRoute from './components/PrivateRoute';

function App() {
  return (
    <div className="app">
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        
        {/* Private Routes */}
        <Route
          path="/user-dashboard"
          element={<PrivateRoute><UserDashboard /></PrivateRoute>}
        />
        <Route
          path="/hospital-dashboard"
          element={<PrivateRoute><HospitalDashboard /></PrivateRoute>}
        />
        <Route
          path="/bloodbank-dashboard"
          element={<PrivateRoute><BloodBankDashboard /></PrivateRoute>}
        />
        <Route
          path="/request-to-bank"
          element={<PrivateRoute><RequestPageToBank /></PrivateRoute>}
        />
        <Route
          path="/request-to-user"
          element={<PrivateRoute><RequestPageToUser /></PrivateRoute>}
        />
        
        {/* Catch-all for 404 pages */}
        <Route path="*" element={<NotFound />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
