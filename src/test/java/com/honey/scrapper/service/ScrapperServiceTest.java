package com.honey.scrapper.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ScrapperServiceTest {

    ScrapperService scrapperService = new ScrapperService();

    @Test
    void loadPage() {
        scrapperService.loadPage();
    }

}