import React from 'react';

const CourseItem = ({ course }) => {
  return (
    <div className="course-item">
      <h2>{course.title}</h2>
      <p><strong>Code:</strong> {course.courseCode}</p>
      <p><strong>Description:</strong> {course.description}</p>
    </div>
  );
};

export default CourseItem;
