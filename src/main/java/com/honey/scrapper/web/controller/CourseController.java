package com.honey.scrapper.web.controller;

import com.honey.scrapper.domain.course.Course;
import com.honey.scrapper.domain.service.ScrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {

    private final ScrapperService scrapperService;

    @Autowired
    public CourseController(ScrapperService scrapperService) {
        this.scrapperService = scrapperService;
    }

    @GetMapping("/inflearn-courses")
    public String inflearnCourses(Model model) {
        List<Course> courses = scrapperService.loadPage();
        model.addAttribute("courses", courses);
        return "inflearnCourses";
    }

    @PostMapping("inflearn-courses-reload")
    public String inflearnCoursesReload() {
        scrapperService.refresh();
        return "redirect:/inflearn-courses";
    }
}
