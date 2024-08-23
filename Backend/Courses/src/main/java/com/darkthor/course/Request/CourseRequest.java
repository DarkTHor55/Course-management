package com.darkthor.course.Request;

import com.darkthor.course.Model.CourseInstance;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {
    @NotEmpty(message = "Title is required")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @NotEmpty(message = "Course code is required")
    @Size(max = 20, message = "Course code cannot exceed 20 characters")
    private String courseCode;

    @Size(max = 999, message = "Description cannot exceed 999 characters")
    private String description;

    private List<CourseInstance> instances = new ArrayList<>();

}
