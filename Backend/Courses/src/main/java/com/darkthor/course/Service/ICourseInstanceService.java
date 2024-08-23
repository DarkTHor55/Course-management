package com.darkthor.course.Service;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.CourseInstance;
import com.darkthor.course.Request.CourseInstanceRequest;

import java.util.List;

public interface ICourseInstanceService {
    CourseInstance create(CourseInstanceRequest courseInstanceRequest) throws CourseException;

    List<CourseInstance> getAllInstancesByYear(int year);

    List<CourseInstance> getAllInstancesByYearAndBySemester(int year, int semester);

    List<CourseInstance> getAllInstancesByYearAndBySemesterAndById(int year, int semester, Long id);

    boolean deleteCourseInstance(int year, int semester, Long id);
}
