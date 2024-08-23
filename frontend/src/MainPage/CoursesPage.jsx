import { useEffect, useState } from 'react';
import CourseItem from '../CourseItem';
import Navbar from './Navbar';

const CoursesPage = () => {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/courses');
        if (!response.ok) {
          throw new Error('fetching Api went wrong');
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

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <>
    <Navbar/>
    <div className="courses-page">
      <h1>Courses List</h1>
      {courses.length > 0 ? (
        courses.map(course => <CourseItem key={course.id} course={course} />)
      ) : (
        <p>No courses available.</p>
      )}
    </div>
    </>
  );
};

export default CoursesPage;
