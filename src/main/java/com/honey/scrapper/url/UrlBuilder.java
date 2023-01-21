package com.honey.scrapper.url;

public class UrlBuilder {
    public static String pageUp(String url, int pageNumber) {
        url = url + "&page=" + pageNumber;
        return url;
    }
}
