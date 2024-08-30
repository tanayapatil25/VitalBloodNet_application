import React, { useState } from 'react';
import { registerUser } from '../services/auth';

const RegisterPage = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [city, setCity] = useState('');
  const [bloodGroup, setBloodGroup] = useState('A_POS');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await registerUser({ name, email, password, city, bloodGroup });
      alert('Registration successful!');
    } catch (error) {
      console.error('Registration failed', error);
    }
  };

  return (
    <div className="register-page">
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        <label>Password:</label>
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        <label>City:</label>
        <input type="text" value={city} onChange={(e) => setCity(e.target.value)} />
        <label>Blood Group:</label>
        <select value={bloodGroup} onChange={(e) => setBloodGroup(e.target.value)}>
          <option value="A_POS">A+</option>
          <option value="A_NEG">A-</option>
          <option value="B_POS">B+</option>
          <option value="B_NEG">B-</option>
          <option value="AB_POS">AB+</option>
          <option value="AB_NEG">AB-</option>
          <option value="O_POS">O+</option>
          <option value="O_NEG">O-</option>
        </select>
        <button type="submit" className="btn">Register</button>
      </form>
    </div>
  );
};

export default RegisterPage;
