package com.honey.scrapper.service;

import com.honey.scrapper.domain.course.repository.MemoryCourseRepository;
import com.honey.scrapper.domain.service.ScrapperService;
import com.honey.scrapper.domain.scrapper.InfScrapper;
import org.junit.jupiter.api.Test;

class ScrapperServiceTest {

//    @Autowired
    ScrapperService scrapperService = new ScrapperService(new InfScrapper(new MemoryCourseRepository()), new MemoryCourseRepository());

    @Test
    void loadPage() {
        scrapperService.loadPage();
    }

}