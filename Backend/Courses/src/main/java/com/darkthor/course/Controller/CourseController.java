package com.darkthor.course.Controller;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.Course;
import com.darkthor.course.Request.RequestCourse;
import com.darkthor.course.Response.ResponseCourse;
import com.darkthor.course.Service.CourseService;
import com.darkthor.course.Service.Impl.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseService ;
    @PostMapping
    public ResponseEntity<ResponseCourse> create(@RequestBody @Valid RequestCourse course){
        ResponseCourse response = new ResponseCourse();
        Course course1 = courseService.craeteCourse(course);
        if(course1 == null){
            response.setStatus(false);
            response.setMessage("Course creation failed");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        else {
            response.setStatus(true);
            response.setMessage("Course created successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> courses = courseService.getAllCourses();
        if(courses == null || courses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) throws CourseException {
        Course course = courseService.getCourseById(id);
        if(course == null){
            return new ResponseEntity<>(new Course(),HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        boolean deleted = courseService.deleteCourseById(id);
        if(!deleted){
            return new ResponseEntity<>("Course deletion failed", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
        }
    }
}
