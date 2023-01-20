package com.honey.scrapper.scrapper;

import org.junit.jupiter.api.Test;

class DcScrapperTest {

    InfScrapper dcScrapper = new InfScrapper("https://www.dcinside.com/");

    @Test
    void scrap() {
        dcScrapper.scrap();
    }
}