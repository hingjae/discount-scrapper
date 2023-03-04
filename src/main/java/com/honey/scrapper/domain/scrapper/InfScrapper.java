package com.honey.scrapper.domain.scrapper;

import com.honey.scrapper.domain.course.Course;
import com.honey.scrapper.domain.course.repository.CourseRepository;
import com.honey.scrapper.formatter.PriceFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class InfScrapper implements Scrapper {

    private final CourseRepository courseRepository;
    private final DefaultFormattingConversionService conversionService;

    @Autowired
    public InfScrapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.conversionService = new DefaultFormattingConversionService();
        conversionService.addFormatter(new PriceFormatter());
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
        log.info("page = {}", pageLength);
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
        Long price = priceFormat(info.select("div.price del").text()); //"₩1,000"
        Long discountPrice = priceFormat(info.select("div.price span").text()); //"₩1,000"
        int discountPercent = (int) Math.round((1 - ((double)discountPrice/price)) * 100);
//        String discountPercent = info.select("div.course_card_ribbon").text();
        return new Course(url, imgUrl, title, instructor, price, discountPrice, discountPercent);
    }

    private Long priceFormat(String price) {
        int pos = price.indexOf("₩");
        String removeWon = price.substring(pos + 1);
        Long convertPrice = conversionService.convert(removeWon, Long.class);
        return convertPrice;
    }

}