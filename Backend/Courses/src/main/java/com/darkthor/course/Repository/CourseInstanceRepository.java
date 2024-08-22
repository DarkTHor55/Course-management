package com.darkthor.course.Repository;

import com.darkthor.course.Model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance,Long> {
        List<CourseInstance> findByYear(int year);
        List<CourseInstance> findByYearAndSemester(int year, int semester);
        List<CourseInstance> findByYearAndSemesterAndId(int year, int semester, Long id);
}
