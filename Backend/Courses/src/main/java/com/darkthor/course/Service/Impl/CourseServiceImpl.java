package com.darkthor.course.Service.Impl;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.Course;
import com.darkthor.course.Repository.CourseRepository;
import com.darkthor.course.Request.RequestCourse;
import com.darkthor.course.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public Course craeteCourse(@Valid RequestCourse requestCourse) {
        if (requestCourse == null)return null;
        Course course= Course.builder()
                .title(requestCourse.getTitle())
                .courseCode(requestCourse.getCourseCode())
                .description(requestCourse.getDescription())
                .instances(requestCourse.getInstances())
                .build();
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) throws CourseException {
        return courseRepository.findById(id).orElseThrow(() -> new CourseException(id));

    }

    @Override
    public boolean deleteCourseById(Long id) {
        if (!courseRepository.existsById(id))return false;
        else {
            courseRepository.deleteById(id);
            return true;
        }
    }
}
