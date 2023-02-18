package com.honey.scrapper;

import com.honey.scrapper.converter.StringToIntegerConverter;
import com.honey.scrapper.converter.StringToWonConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new StringToWonConverter());
    }
}
