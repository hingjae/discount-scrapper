package com.honey.scrapper.service;

import com.honey.scrapper.scrapper.InfScrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ScrapperServiceTest {

//    @Autowired
    ScrapperService scrapperService = new ScrapperService(new InfScrapper());

    @Test
    void loadPage() {
        scrapperService.loadPage();
    }

}