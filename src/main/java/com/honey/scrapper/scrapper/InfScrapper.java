package com.honey.scrapper.scrapper;

import com.honey.scrapper.Course;
import com.honey.scrapper.repository.CourseRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InfScrapper implements Scrapper {

    private final CourseRepository courseRepository;

    @Autowired
    public InfScrapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Document extractDocument(String url) {
        Connection conn = Jsoup.connect(url);
        try {
            Document document = conn.get();
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int extractPagination(Document document) {
        Elements pagination = document.select("nav.pagination");
        int pageLength = pagination.select("ul.pagination-list").select("li").size();
        return pageLength;
    }

    @Override
    public void scrap(Document document) {
        Elements timeDiscounted = document.select("div.courses_container");
        Elements courses = timeDiscounted.select("div.card");
        Elements coursesAtags = courses.select("a.course_card_front");

        for (Element info : coursesAtags) {
            Course course = extractInfo(info);
            courseRepository.save(course);
        }
    }

    @Override
    public Course extractInfo(Element info) {
        String url = info.select("a.course_card_front").attr("href");
        String imgUrl = info.select("img").attr("src");
        String title = info.select("div.course_title").text();
        String instructor = info.select("div.instructor").text();
        String price = info.select("div.price del").text();
        String discountPrice = info.select("div.price span").text();
        String discountPercent = info.select("div.course_card_ribbon").text();
        return new Course(url, imgUrl, title, instructor, price, discountPrice, discountPercent);
    }

}