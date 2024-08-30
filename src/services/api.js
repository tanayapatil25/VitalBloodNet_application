import axios from 'axios';

const API_URL = 'http://localhost:8080/api'; // Replace with your backend URL

// User-related API methods

export const fetchUserRequests = async (userId) => {
  try {
    const response = await axios.get(`${API_URL}/users/${userId}/requests`);
    return response.data;
  } catch (error) {
    console.error('Error fetching user requests:', error);
    throw error;
  }
};

export const fetchUserDonations = async (userId) => {
  try {
    const response = await axios.get(`${API_URL}/users/${userId}/donations`);
    return response.data;
  } catch (error) {
    console.error('Error fetching user donations:', error);
    throw error;
  }
};

export const createUserRequest = async (userId, requestData) => {
  try {
    const response = await axios.post(`${API_URL}/users/${userId}/requests`, requestData);
    return response.data;
  } catch (error) {
    console.error('Error creating user request:', error);
    throw error;
  }
};

// Hospital-related API methods

export const fetchHospitalRequests = async (hospitalId) => {
  try {
    const response = await axios.get(`${API_URL}/hospitals/${hospitalId}/requests`);
    return response.data;
  } catch (error) {
    console.error('Error fetching hospital requests:', error);
    throw error;
  }
};

export const createHospitalRequest = async (hospitalId, requestData) => {
  try {
    const response = await axios.post(`${API_URL}/hospitals/${hospitalId}/requests`, requestData);
    return response.data;
  } catch (error) {
    console.error('Error creating hospital request:', error);
    throw error;
  }
};

// Blood Bank-related API methods

export const fetchBloodBankRequests = async (bloodBankId) => {
  try {
    const response = await axios.get(`${API_URL}/bloodbanks/${bloodBankId}/requests`);
    return response.data;
  } catch (error) {
    console.error('Error fetching blood bank requests:', error);
    throw error;
  }
};

export const updateBloodBankRequestStatus = async (bloodBankId, requestId, status) => {
  try {
    const response = await axios.put(`${API_URL}/bloodbanks/${bloodBankId}/requests/${requestId}/status`, { status });
    return response.data;
  } catch (error) {
    console.error('Error updating blood bank request status:', error);
    throw error;
  }
};

export const fetchBloodBankDonations = async (bloodBankId) => {
  try {
    const response = await axios.get(`${API_URL}/bloodbanks/${bloodBankId}/donations`);
    return response.data;
  } catch (error) {
    console.error('Error fetching blood bank donations:', error);
    throw error;
  }
};

export const updateBloodBankInventory = async (bloodBankId, inventoryData) => {
  try {
    const response = await axios.put(`${API_URL}/bloodbanks/${bloodBankId}/inventory`, inventoryData);
    return response.data;
  } catch (error) {
    console.error('Error updating blood bank inventory:', error);
    throw error;
  }
};

// Donation-related API methods

export const createDonation = async (donationData) => {
  try {
    const response = await axios.post(`${API_URL}/donations`, donationData);
    return response.data;
  } catch (error) {
    console.error('Error creating donation:', error);
    throw error;
  }
};

export const fetchDonationDetails = async (donationId) => {
  try {
    const response = await axios.get(`${API_URL}/donations/${donationId}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching donation details:', error);
    throw error;
  }
};

// Authentication-related API methods

export const loginUser = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/auth/login`, { email, password });
    return response.data;
  } catch (error) {
    console.error('Error logging in user:', error);
    throw error;
  }
};

export const registerUser = async (userData) => {
  try {
    const response = await axios.post(`${API_URL}/auth/register`, userData);
    return response.data;
  } catch (error) {
    console.error('Error registering user:', error);
    throw error;
  }
};

export const loginHospital = async (contact, password) => {
  try {
    const response = await axios.post(`${API_URL}/auth/hospital/login`, { contact, password });
    return response.data;
  } catch (error) {
    console.error('Error logging in hospital:', error);
    throw error;
  }
};

export const loginBloodBank = async (contact, password) => {
  try {
    const response = await axios.post(`${API_URL}/auth/bloodbank/login`, { contact, password });
    return response.data;
  } catch (error) {
    console.error('Error logging in blood bank:', error);
    throw error;
  }
};
