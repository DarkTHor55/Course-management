package com.darkthor.course.Service;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.Course;
import com.darkthor.course.Request.CourseRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface ICourseService {
    Course createCourse(@Valid CourseRequest courseRequest);

    List<Course> getAllCourses();

    Course getCourseById(Long id) throws CourseException;

    boolean deleteCourseById(Long id);
}
