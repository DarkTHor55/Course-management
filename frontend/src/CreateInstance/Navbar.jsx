import React, { useState } from 'react';

const Navbar = () => {

  return (
    <nav className="navbar">
      <div className="navbar-logo">Courses</div>
      <ul className="navbar-links">
        <li><a href="/home">Home</a></li>
        <li><a href="/create-course">CreateCourse</a></li>
        <li><a href="/search">Search</a></li>
        <li><a href="/courses">AllCourses</a></li>
      </ul>
      

      <style>{`
        .navbar {
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 10px 20px;
          background-color: #333;
          color: #fff;
        }

        .navbar-logo {
          font-size: 1.5em;
          font-weight: bold;
        }

        .navbar-links {
          list-style: none;
          display: flex;
          gap: 15px;
        }

        .navbar-links li {
          margin: 0;
        }

        .navbar-links a {
          color: #fff;
          text-decoration: none;
          font-weight: 500;
        }

        .navbar-links a:hover {
          color: #bbb;
        
      `}</style>
    </nav>
  );
};

export default Navbar;
