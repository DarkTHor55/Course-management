package com.darkthor.course.Controller;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.Course;
import com.darkthor.course.Request.CourseRequest;
import com.darkthor.course.Response.ResponseCourse;
import com.darkthor.course.Service.Impl.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl courseService;

    @PostMapping
    public ResponseEntity<ResponseCourse> create(final @RequestBody @Valid CourseRequest course) {
        Course course1 = courseService.createCourse(course);
        if (Objects.isNull(course1)) {
            ResponseCourse response = ResponseCourse.builder().status(false).message("Course creation failed").build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            ResponseCourse response = ResponseCourse.builder().status(true).message("Course created successfully").build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> courses = courseService.getAllCourses();
        if (Objects.isNull(courses) || courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(final @PathVariable Long id) throws CourseException {
        Course course = courseService.getCourseById(id);
        if (Objects.isNull(course)) {
            return new ResponseEntity<>(new Course(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(final @PathVariable Long id) {
        boolean deleted = courseService.deleteCourseById(id);
        if (deleted) {
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Course deletion failed", HttpStatus.NOT_FOUND);

        }
    }
}
