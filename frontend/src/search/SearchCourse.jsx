import React, { useState } from 'react';
import Navbar from './Navbar';

const SearchCourse = () => {
  const [year, setYear] = useState('');
  const [semester, setSemester] = useState('');
  const [courseId, setCourseId] = useState('');
  const [searchResults, setSearchResults] = useState([]);

  const handleSearch = async () => {
    let url = `http://localhost:8080/api/instances`;

    if (year && semester && courseId) {
      url += `/${year}/${semester}/${courseId}`;
    } else if (year && semester) {
      url += `/${year}/${semester}`;
    } else if (year) {
      url += `/${year}`;
    }

    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error('API request failed');
      }
      const data = await response.json();
      setSearchResults(data);
    } catch (error) {
      console.error('Error fetching course instances:', error);
    }
  };

  return (
    <>
    <Navbar/>
    <div className="search-page">
      <h2>Search Course Instances</h2>
      <div className="search-form">
        <input
          type="text"
          placeholder="Year"
          value={year}
          onChange={(e) => setYear(e.target.value)}
        />
        <input
          type="text"
          placeholder="Semester"
          value={semester}
          onChange={(e) => setSemester(e.target.value)}
        />
        <input
          type="text"
          placeholder="Course ID"
          value={courseId}
          onChange={(e) => setCourseId(e.target.value)}
        />
        <button onClick={handleSearch}>Search</button>
      </div>

      <div className="search-results">
        {searchResults.length > 0 ? (
          searchResults.map(instance => (
            <div key={instance.id} className="course-item">
              <h3>{instance.course.title}</h3>
              <p>Course Code: {instance.course.courseCode}</p>
              <p>Description: {instance.course.description}</p>
              <p>Year: {instance.year}</p>
              <p>Semester: {instance.semester}</p>
            </div>
          ))
        ) : (
          <p>No results found.</p>
        )}
      </div>

      <style>{`
        .search-page {
          padding: 20px;
          max-width: 80%;
          margin: auto;
          font-family: Arial, sans-serif;
        }

        h2 {
          text-align: center;
          margin-bottom: 20px;
        }

        .search-form {
          margin-bottom: 30px;
          display: flex;
          justify-content: space-between;
          gap: 10px;
        }

        input {
          flex: 1;
          padding: 10px;
          border-radius: 4px;
          border: 1px solid #ddd;
        }

        button {
          padding: 10px 20px;
          border-radius: 4px;
          border: none;
          background-color: #007BFF;
          color: white;
          cursor: pointer;
        }

        button:hover {
          background-color: #0056b3;
        }

        .search-results {
          margin-top: 20px;
        }

        .course-item {
          background-color: #f9f9f9;
          padding: 15px;
          border-radius: 5px;
          margin-bottom: 10px;
          border: 1px solid #ddd;
        }

        .course-item h3 {
          margin: 0 0 10px;
        }
      `}</style>
    </div>
    </>
  );
};

export default SearchCourse;
