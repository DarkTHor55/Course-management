package com.darkthor.course.Response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCourse {
    private boolean status;
    private String message;
}