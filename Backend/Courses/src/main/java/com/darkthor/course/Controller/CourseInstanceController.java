package com.darkthor.course.Controller;

import com.darkthor.course.Exception.CourseException;
import com.darkthor.course.Model.CourseInstance;
import com.darkthor.course.Request.RequestCourseInstance;
import com.darkthor.course.Response.ResponseCourseInstance;
import com.darkthor.course.Service.Impl.CourseInstanceServiceIml;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/instances")
@RequiredArgsConstructor
public class CourseInstanceController {
    private final CourseInstanceServiceIml courseInstanceService;

    @PostMapping
    public ResponseEntity<ResponseCourseInstance> create(final @RequestBody @Valid RequestCourseInstance courseInstance) throws CourseException {
        CourseInstance courseInstance1 = courseInstanceService.create(courseInstance);
        ResponseCourseInstance responseCourseInstance = new ResponseCourseInstance();
        if (Objects.isNull(courseInstance1)) {
            responseCourseInstance.setStatus(false);
            responseCourseInstance.setMessage("CourseInstance is not created");
            return ResponseEntity.badRequest().body(responseCourseInstance);
        } else {
            responseCourseInstance.setStatus(true);
            responseCourseInstance.setMessage("CourseInstance is created successfully");
            return ResponseEntity.ok().body(responseCourseInstance);
        }
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<CourseInstance>> getAllInstancesByYear(final @PathVariable int year) {
        return ResponseEntity.ok(courseInstanceService.getAllInstancesByYear(year));
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getAllInstancesByYearAndBySemester(final @PathVariable int year, final @PathVariable int semester) {
        return ResponseEntity.ok(courseInstanceService.getAllInstancesByYearAndBySemester(year, semester));
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<List<CourseInstance>> getAllInstancesByYearAndBySemesterAndById(
            final @PathVariable int year, final @PathVariable int semester, final @PathVariable Long id) {
        return ResponseEntity.ok(courseInstanceService.getAllInstancesByYearAndBySemesterAndById(year, semester, id));
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<String> deleteCourseInstance(final @PathVariable int year, final @PathVariable int semester, final @PathVariable Long id) {
        boolean isDeleted = courseInstanceService.deleteCourseInstance(year, semester, id);
        ResponseCourseInstance responseCourseInstance = new ResponseCourseInstance();
        if (isDeleted) {
            responseCourseInstance.setStatus(true);
            responseCourseInstance.setMessage("CourseInstance is deleted successfully");
            return ResponseEntity.ok().body(responseCourseInstance.getMessage());
        } else {
            responseCourseInstance.setStatus(false);
            responseCourseInstance.setMessage("CourseInstance is not found");
            return ResponseEntity.badRequest().body("Can't Deleted With this id : " + id);

        }
    }

    @GetMapping()
    public ResponseEntity<List<CourseInstance>> getAllInstances() {
        return ResponseEntity.ok(courseInstanceService.getAllInstances());
    }
}
