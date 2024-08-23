import React, { useState } from 'react';
import Navbar from './Navbar';

const CreateCoursePage = () => {
  const [title, setTitle] = useState('');
  const [courseCode, setCourseCode] = useState('');
  const [description, setDescription] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    const course = {
      title,
      courseCode,
      description,
    };

    try {
      const response = await fetch('http://localhost:8080/api/courses', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(course),
      });

      if (response.ok) {
        setMessage('Course created successfully!');
        setTitle('');
        setCourseCode('');
        setDescription('');
      } else {
        setMessage('Failed to create course.');
      }
    } catch (error) {
      setMessage(`Error: ${error.message}`);
    }
  };

  return (
    <>
      <Navbar />
      <div className="create-course-page">
        <h1>Create a New Course</h1>
        {message && <p>{message}</p>}
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label>Course Code</label>
            <input
              type="text"
              value={courseCode}
              onChange={(e) => setCourseCode(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label>Description</label>
            <textarea
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              required
            />
          </div>
          <button type="submit">Create Course</button>
        </form>

        <style>{`
          .create-course-page {
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
          }

          h1 {
            text-align: center;
            color: #333;
          }

          .form-group {
            margin-bottom: 15px;
          }

          .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
          }

          .form-group input,
          .form-group textarea {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 1em;
          }

          textarea {
            resize: vertical;
            height: 100px;
          }

          button {
            display: block;
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #646cff;
            color: #fff;
            font-size: 1.2em;
            cursor: pointer;
          }

          button:hover {
            background-color: #535bf2;
          }

          p {
            text-align: center;
            color: green;
            font-weight: bold;
          }
        `}</style>
      </div>
    </>
  );
};

export default CreateCoursePage;
