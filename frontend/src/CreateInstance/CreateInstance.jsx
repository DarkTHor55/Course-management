import React, { useState, useEffect } from 'react';
import Navbar from './Navbar';

const CreateCourseInstancePage = () => {
  const [year, setYear] = useState('');
  const [semester, setSemester] = useState('');
  const [selectedCourseId, setSelectedCourseId] = useState('');
  const [courses, setCourses] = useState([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    // Fetch courses to populate the dropdown
    const fetchCourses = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/courses');
        if (!response.ok) {
          throw new Error('Failed to fetch courses');
        }
        const data = await response.json();
        setCourses(data);
      } catch (error) {
        console.error('Error fetching courses:', error);
      }
    };

    fetchCourses();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const instance = {
      year,
      semester,
      courseId: selectedCourseId,
    };

    try {
      const response = await fetch('http://localhost:8080/api/instances', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(instance),
      });

      if (response.ok) {
        setMessage('Course instance created successfully!');
        setYear('');
        setSemester('');
        setSelectedCourseId('');
      } else {
        setMessage('Failed to create course instance.');
      }
    } catch (error) {
      setMessage(`Error: ${error.message}`);
    }
  };

  return (
    <>
      <Navbar />
      <div className="create-course-instance-page">
        <h1>Create a New Course Instance</h1>
        {message && <p>{message}</p>}
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Year</label>
            <input
              type="number"
              value={year}
              onChange={(e) => setYear(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label>Semester</label>
            <input
              type="text"
              value={semester}
              onChange={(e) => setSemester(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label>Course</label>
            <select
              value={selectedCourseId}
              onChange={(e) => setSelectedCourseId(e.target.value)}
              required
            >
              <option value="" disabled>Select a course</option>
              {courses.map((course) => (
                <option key={course.id} value={course.id}>
                  {course.title} ({course.courseCode})
                </option>
              ))}
            </select>
          </div>
          <button type="submit">Create Instance</button>
        </form>

        <style>{`
          .create-course-instance-page {
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
          .form-group select {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 1em;
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

export default CreateCourseInstancePage;
