package com.honey.scrapper.repository;

import com.honey.scrapper.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryCourseRepository implements CourseRepository{
    private final static Map<Long, Course> store = new HashMap<>();
    private static Long courseId = 0L;

    @Override
    public Course save(Course course) {
        store.put(++courseId, course);
        return course;
    }

    @Override
    public List<Course> findAllCourses() {
        return new ArrayList<>(store.values());
    }
}
