import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';

// User Login
export const login = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/login`, { email, password });
    return response.data;
  } catch (error) {
    console.error('Error logging in:', error);
    throw error;
  }
};

// User Registration
export const registerUser = async (userData) => {
  try {
    const response = await axios.post(`${API_URL}/register`, userData);
    return response.data;
  } catch (error) {
    console.error('Error registering user:', error);
    throw error;
  }
};

// Hospital Login
export const loginHospital = async (contact, password) => {
  try {
    const response = await axios.post(`${API_URL}/hospital/login`, { contact, password });
    return response.data;
  } catch (error) {
    console.error('Error logging in hospital:', error);
    throw error;
  }
};

// Blood Bank Login
export const loginBloodBank = async (contact, password) => {
  try {
    const response = await axios.post(`${API_URL}/bloodbank/login`, { contact, password });
    return response.data;
  } catch (error) {
    console.error('Error logging in blood bank:', error);
    throw error;
  }
};

// Logout
export const logout = async () => {
  try {
    const response = await axios.post(`${API_URL}/logout`);
    return response.data;
  } catch (error) {
    console.error('Error logging out:', error);
    throw error;
  }
};

// Password Reset Request
export const requestPasswordReset = async (email) => {
  try {
    const response = await axios.post(`${API_URL}/password-reset/request`, { email });
    return response.data;
  } catch (error) {
    console.error('Error requesting password reset:', error);
    throw error;
  }
};

// Password Reset
export const resetPassword = async (token, newPassword) => {
  try {
    const response = await axios.post(`${API_URL}/password-reset/reset`, { token, newPassword });
    return response.data;
  } catch (error) {
    console.error('Error resetting password:', error);
    throw error;
  }
};

// Change Password (Logged in users)
export const changePassword = async (oldPassword, newPassword) => {
  try {
    const response = await axios.put(`${API_URL}/password-change`, { oldPassword, newPassword });
    return response.data;
  } catch (error) {
    console.error('Error changing password:', error);
    throw error;
  }
};
