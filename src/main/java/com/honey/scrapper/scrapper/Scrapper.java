package com.honey.scrapper.scrapper;

import com.honey.scrapper.Course;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface Scrapper {
    void scrap(Document document);

    int extractPagination(Document document);

    Document extractDocument(String url);

    Course extractInfo(Element info);

}
