package com.honey.scrapper.scrapper;

import com.honey.scrapper.Course;
import com.honey.scrapper.CourseList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface Scrapper {
    void scrap(Document document);

    int extractPagination(Document document);

    Document extractDocument(String url);

    Course extractInfo(Element info);

    CourseList getCourseList();
}
