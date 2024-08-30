import React, { useState } from 'react';

const RequestPageToUser = () => {
  const [bloodGroup, setBloodGroup] = useState('A_POS');
  const [quantity, setQuantity] = useState(1);
  const [userId, setUserId] = useState('');
  const [city, setCity] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle request submission to the backend
  };

  return (
    <div className="request-page">
      <h2>Request Blood from User</h2>
      <form onSubmit={handleSubmit}>
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
        <label>Quantity:</label>
        <input type="number" value={quantity} onChange={(e) => setQuantity(e.target.value)} />
        <label>User ID:</label>
        <input type="text" value={userId} onChange={(e) => setUserId(e.target.value)} />
        <label>City:</label>
        <input type="text" value={city} onChange={(e) => setCity(e.target.value)} />
        <button type="submit" className="btn">Submit Request</button>
      </form>
    </div>
  );
};

export default RequestPageToUser;
