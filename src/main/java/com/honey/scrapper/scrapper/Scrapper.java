package com.honey.scrapper.scrapper;

import org.jsoup.nodes.Document;

public interface Scrapper {
    void scrap();

    void extractPagination(Document document);

    Document extractDocument();
}
