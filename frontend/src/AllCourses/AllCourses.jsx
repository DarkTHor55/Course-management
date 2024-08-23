import React, { useState, useEffect } from 'react';
import Navbar from './Navbar';

const AllCourses = () => {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/courses');
        if (!response.ok) {
          throw new Error('Failed to fetch courses');
        }
        const data = await response.json();
        setCourses(data);
      } catch (error) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchCourses();
  }, []);

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/api/courses/${id}`, {
        method: 'DELETE',
      });
      if (!response.ok) {
        throw new Error('Failed to delete course');
      }
      setCourses(courses.filter(course => course.id !== id));
    } catch (error) {
      console.error('Error:', error.message);
    }
  };

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <><Navbar/>
    <div className="courses-page">
      <h1>Courses List</h1>
      {courses.length > 0 ? (
        courses.map(course => (
          <div key={course.id} className="course-item">
            <h2>{course.title}</h2>
            <p>Course Code: {course.courseCode}</p>
            <p>Description: {course.description}</p>
            <button onClick={() => handleDelete(course.id)}>Delete</button>
          </div>
        ))
      ) : (
        <p>No courses available.</p>
      )}
      <style>{`
        .courses-page {
          padding: 20px;
          max-width: 80%;
          margin: auto;
          font-family: Arial, sans-serif;
        }

        h1 {
          text-align: center;
          margin-bottom: 20px;
        }

        .course-item {
          background-color: #f9f9f9;
          padding: 15px;
          border-radius: 5px;
          margin-bottom: 10px;
          border: 1px solid #ddd;
        }

        .course-item h2 {
          margin: 0 0 10px;
        }

        button {
          padding: 10px 20px;
          border-radius: 4px;
          border: none;
          background-color: #dc3545;
          color: white;
          cursor: pointer;
        }

        button:hover {
          background-color: #c82333;
        }
      `}</style>
    </div>
    </>
  );
};

export default AllCourses;
