package com.honey.scrapper.url;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlBuilderTest {

    UrlBuilder urlBuilder = new UrlBuilder();

    @Test
    void 다음페이지_url_추출() {
        String url = "https://www.inflearn.com/courses?discounted=true&order=seq";
        String newUrl = urlBuilder.pageUp(url, 1);
        System.out.println("newUrl = " + newUrl);
    }
}