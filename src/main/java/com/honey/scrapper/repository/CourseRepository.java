package com.honey.scrapper.repository;

import com.honey.scrapper.domain.Course;

import java.util.List;

public interface CourseRepository {
    Course save(Course course);

    List<Course> findAllCourses();

    void clear();
}
