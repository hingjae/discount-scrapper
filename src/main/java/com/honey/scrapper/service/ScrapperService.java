package com.honey.scrapper.service;

import com.honey.scrapper.Course;
import com.honey.scrapper.repository.CourseRepository;
import com.honey.scrapper.scrapper.Scrapper;
import com.honey.scrapper.url.Url;
import com.honey.scrapper.url.UrlBuilder;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScrapperService {

    //    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    Scrapper scrapper = ac.getBean("scrapper", Scrapper.class);
    private final Scrapper scrapper;
    private final CourseRepository courseRepository;

    private final String infUrl = Url.INFLEARN.getText();

    public List<Course> loadPage() {
        if (courseRepository.findAllCourses().size() == 0) {
            List<Course> courses = getCourses();
            return courses;
        }
        return courseRepository.findAllCourses();
    }

    public List<Course> getCourses() {
        Document document = scrapper.extractDocument(infUrl);
        int pageLength = scrapper.extractPagination(document);
        for (int i = 1; i <= pageLength; i++) {
            String infUrlPageup = UrlBuilder.pageUp(infUrl, i);
            document = scrapper.extractDocument(infUrlPageup);
            scrapper.scrap(document);
        }
        List<Course> courses = courseRepository.findAllCourses();
        return courses;
    }
}
