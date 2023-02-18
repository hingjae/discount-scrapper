package com.honey.scrapper.domain.scrapper;

import com.honey.scrapper.domain.course.Course;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface Scrapper {
    void scrap(Document document);

    int extractPagination(Document document);

    Document extractDocument(String url);

    Course extractInfo(Element info);

}
