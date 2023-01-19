package com.honey.scrapper.scrapper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DcScrapper {

    final String dcUrl;
    Connection conn;

    public DcScrapper(String dcUrl) {
        this.dcUrl = dcUrl;
        this.conn = Jsoup.connect(dcUrl);
    }

//    final String dcUrl = "https://www.dcinside.com/";
//    Connection conn = Jsoup.connect(dcUrl);

    public void scrap() {
        Document document = extractDocument();
        Elements tableHeader = document.select("div.time_best");
        Elements title = tableHeader.select("div.tablist");
        for (Element element : title) {
            System.out.println("element = " + element.text());
        }
    }

    private Document extractDocument() {
        try {
            Document document = conn.get();
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
