package com.honey.scrapper;

import com.honey.scrapper.scrapper.InfScrapper;
import com.honey.scrapper.scrapper.Scrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Scrapper scrapper() {
        return new InfScrapper();
    }
}
