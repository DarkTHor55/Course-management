package com.darkthor.course.Service;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.CourseInstance;
import com.darkthor.course.Request.RequestCourseInstance;

import java.util.List;

public interface CourseInstanceService {
    CourseInstance create(RequestCourseInstance requestCourseInstance) throws CourseException;
    List<CourseInstance> getAllInstancesByYear(int year);
    List<CourseInstance> getAllInstancesByYearAndBySemester(int year, int semester);
    List<CourseInstance> getAllInstancesByYearAndBySemesterAndById(int year, int semester, Long id);
    boolean deleteCourseInstance(int year, int semester, Long id);
}
