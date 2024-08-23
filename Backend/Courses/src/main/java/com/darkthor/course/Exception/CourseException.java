package com.darkthor.course.Exception;

public class CourseException extends Exception {
    public CourseException(String message) {
        super(message);
    }

    public CourseException(Long id) {
        super("Course with ID " + id + " not found");
    }
}