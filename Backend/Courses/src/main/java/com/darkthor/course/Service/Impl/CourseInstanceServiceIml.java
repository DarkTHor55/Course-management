package com.darkthor.course.Service.Impl;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.Course;
import com.darkthor.course.Model.CourseInstance;
import com.darkthor.course.Repository.CourseInstanceRepository;
import com.darkthor.course.Repository.CourseRepository;
import com.darkthor.course.Request.CourseInstanceRequest;
import com.darkthor.course.Service.ICourseInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseInstanceServiceIml implements ICourseInstanceService {
    private final CourseRepository courseRepository;
    private final CourseInstanceRepository courseInstanceRepository;


    @Override
    public CourseInstance create(CourseInstanceRequest courseInstanceRequest) throws CourseException {
        if (courseInstanceRequest == null) {
            throw new IllegalArgumentException("Request data is null");
        }

        Course course = courseRepository.findById(courseInstanceRequest.getCourseId())
                .orElseThrow(() -> new CourseException("Course with ID " + courseInstanceRequest.getCourseId() + " not found"));

        CourseInstance courseInstance = CourseInstance.builder()
                .year(courseInstanceRequest.getYear())
                .semester(courseInstanceRequest.getSemester())
                .course(course)
                .build();

        return courseInstanceRepository.save(courseInstance);
    }

    @Override
    public List<CourseInstance> getAllInstancesByYear(int year) {
        return courseInstanceRepository.findByYear(year);
    }

    @Override
    public List<CourseInstance> getAllInstancesByYearAndBySemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    @Override
    public List<CourseInstance> getAllInstancesByYearAndBySemesterAndById(int year, int semester, Long id) {
        return courseInstanceRepository.findByYearAndSemesterAndId(year, semester, id);
    }

    @Override
    public boolean deleteCourseInstance(int year, int semester, Long id) {
        if (courseInstanceRepository.findByYearAndSemesterAndId(year, semester, id).isEmpty()) {
            return false;
        }
        courseInstanceRepository.deleteById(id);
        return true;
    }

    public List<CourseInstance> getAllInstances() {
        return courseInstanceRepository.findAll();
    }
}