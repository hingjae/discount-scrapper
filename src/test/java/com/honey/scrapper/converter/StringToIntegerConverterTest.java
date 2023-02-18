package com.honey.scrapper.converter;

import com.honey.scrapper.domain.course.WonPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerConverterTest {

    DefaultConversionService conversionService = new DefaultConversionService();

    @Test
    void convert() {
        String test = "10";
        assertThat(conversionService.convert(test, Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        WonPrice wonPrice = conversionService.convert("₩1,000", WonPrice.class);
        assertThat(wonPrice).isEqualTo(new WonPrice("₩", 1000));
    }

    @Configuration
    static class WebConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new StringToWonConverter());
        }
    }
}