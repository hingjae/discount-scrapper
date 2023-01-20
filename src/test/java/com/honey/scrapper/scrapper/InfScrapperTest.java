package com.honey.scrapper.scrapper;

import org.junit.jupiter.api.Test;

class InfScrapperTest {

    InfScrapper infScrapper = new InfScrapper();

    @Test
    void scrap() {
        infScrapper.scrap();
    }

    @Test
    void extractPagination() {
        infScrapper.extractPagination(infScrapper.extractDocument());
    }
}