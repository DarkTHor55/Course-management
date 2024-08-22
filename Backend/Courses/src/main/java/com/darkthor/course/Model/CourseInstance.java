package com.darkthor.course.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Year is required")
    private Integer year;

    @NotNull(message = "Semester is required")
    private Integer semester;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
