import React from 'react';

const HomePage = () => {
  return (
    <div className="home-page" style={{ backgroundImage: `url('/bloodbackground.jpg')` }}>
      <div className="overlay">
        <h1>Welcome to VitalBloodNet</h1>
        <p>Your trusted partner in blood donation and requests</p>
        <div className="home-buttons">
          <a href="/login" className="btn">Login</a>
          <a href="/register" className="btn">Register</a>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
