package com.honey.scrapper.scrapper;

import com.honey.scrapper.Course;
import com.honey.scrapper.url.Url;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InfScrapper implements Scrapper {

    private String url = Url.INFLEARN.getText();
    private Connection conn;

    public InfScrapper() {
        this.conn = Jsoup.connect(url);
    }

    @Override
    public void scrap() {
        Document document = extractDocument();
        Elements timeDiscounted = document.select("div.courses_container");
        Elements courses = timeDiscounted.select("div.card");
        Elements coursesAtags = courses.select("a.course_card_front");

        extractInfo(coursesAtags);
    }

    private void extractInfo(Elements coursesAtags) {
        for (Element info : coursesAtags) {
            String url = info.select("a.course_card_front").attr("href");
            String title = info.select("div.course_title").text();
            String instructor = info.select("div.instructor").text();
            String price = info.select("div.price").text();
            String discountPercent = info.select("div.course_card_ribbon").text();
            Course course = new Course(url, title, instructor, Integer.parseInt(price), discountPercent);
        }
    }

    @Override
    public void extractPagination(Document document) {
        Elements pagination = document.select("nav.pagination");
        int pageLength = pagination.select("ul.pagination-list").select("li").size();
        System.out.println("pagination = " + pagination);
        System.out.println("pageLength = " + pageLength);
    }

    @Override
    public Document extractDocument() {
        try {
            Document document = conn.get();
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}