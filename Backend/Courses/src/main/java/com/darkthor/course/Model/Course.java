package com.darkthor.course.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
        import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

        import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Title cannot exceed 50 characters")
    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "CourseCode is required")
    @Size(max = 20, message = "Course code cannot exceed 20 characters")
    private String courseCode;

    @Size(max = 999, message = "Description cannot exceed 999 characters")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseInstance> instances = new ArrayList<>();
}
