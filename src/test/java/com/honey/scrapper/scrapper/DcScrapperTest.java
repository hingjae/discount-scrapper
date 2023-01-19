package com.honey.scrapper.scrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DcScrapperTest {

    DcScrapper dcScrapper = new DcScrapper("https://www.dcinside.com/");

    @Test
    void scrap() {
        dcScrapper.scrap();
    }
}