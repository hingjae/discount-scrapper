package com.honey.scrapper;

import java.util.ArrayList;
import java.util.List;

public class CourseList {
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void addItem(Course course) {
        courses.add(course);
    }
}
