package com.honey.scrapper.domain.course.repository;

import com.honey.scrapper.domain.course.Course;

import java.util.List;

public interface CourseRepository {
    Course save(Course course);

    List<Course> findAllCourses();

    void clear();
}
