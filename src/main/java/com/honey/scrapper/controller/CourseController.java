package com.honey.scrapper.controller;

import com.honey.scrapper.Course;
import com.honey.scrapper.service.ScrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("inflearn-courses-load")
    public String inflearnCoursesLoad() {
        scrapperService.refresh();
        return "redirect:/inflearn-courses";
    }
}
