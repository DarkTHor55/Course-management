package com.darkthor.course.Request;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseInstanceRequest {
    private Integer year;
    private Integer semester;
    private Long courseId;
}