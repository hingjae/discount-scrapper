package com.honey.scrapper.scrapper;

import com.honey.scrapper.domain.course.repository.MemoryCourseRepository;
import com.honey.scrapper.domain.scrapper.InfScrapper;
import com.honey.scrapper.url.Url;
import com.honey.scrapper.url.UrlBuilder;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

class InfScrapperTest {

    InfScrapper infScrapper = new InfScrapper(new MemoryCourseRepository());
    String url = Url.INFLEARN.getText();
    Document document = infScrapper.extractDocument(url);

    @Test
    void scrap() {
        infScrapper.scrap(document);
    }

    @Test
    void extractPagination() {
        infScrapper.extractPagination(infScrapper.extractDocument(url));
    }

    @Test
    void pageUp_and_extractDocument() {
        int page = infScrapper.extractPagination(infScrapper.extractDocument(url));
    }

    @Test
    void pageUp() {
        url = UrlBuilder.pageUp(url, 2);
        System.out.println("url = " + url);
    }

}