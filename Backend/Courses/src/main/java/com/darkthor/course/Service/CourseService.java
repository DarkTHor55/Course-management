package com.darkthor.course.Service;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.Course;
import com.darkthor.course.Request.RequestCourse;
import jakarta.validation.Valid;

import java.util.List;

public interface CourseService {
    Course craeteCourse(@Valid RequestCourse requestCourse);

    List<Course> getAllCourses();

    Course getCourseById(Long id) throws CourseException;

    boolean deleteCourseById(Long id);
}
