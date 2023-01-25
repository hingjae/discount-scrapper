package com.honey.scrapper.service;

import com.honey.scrapper.AppConfig;
import com.honey.scrapper.Course;
import com.honey.scrapper.scrapper.Scrapper;
import com.honey.scrapper.url.Url;
import com.honey.scrapper.url.UrlBuilder;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapperService {

//    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    Scrapper scrapper = ac.getBean("scrapper", Scrapper.class);
    private final Scrapper scrapper;

    @Autowired
    public ScrapperService(Scrapper scrapper) {
        this.scrapper = scrapper;
    }

    String infUrl = Url.INFLEARN.getText();

    public List<Course> loadPage() {
        List<Course> courses = getCourses();
        return courses;
    }

    private List<Course> getCourses() {
        Document document = scrapper.extractDocument(infUrl);
        int pageLength = scrapper.extractPagination(document);
        for (int i = 1; i <= pageLength; i++) {
            String infUrlPageup = UrlBuilder.pageUp(infUrl, i);
            document = scrapper.extractDocument(infUrlPageup);
            scrapper.scrap(document);
        }
        List<Course> courses = scrapper.getCourseList().getCourses();
        return courses;
    }
}
