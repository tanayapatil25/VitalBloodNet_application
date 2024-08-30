import React, { createContext, useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login as loginService } from '../services/auth';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  const login = async (email, password) => {
    try {
      const loggedInUser = await loginService(email, password);
      setUser(loggedInUser);
      navigate('/user-dashboard'); // Redirect to dashboard based on role
    } catch (error) {
      console.error('Login failed', error);
    }
  };

  const logout = () => {
    setUser(null);
    navigate('/');
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// Custom hook to use the AuthContext
export const useAuth = () => {
  return useContext(AuthContext);
};
