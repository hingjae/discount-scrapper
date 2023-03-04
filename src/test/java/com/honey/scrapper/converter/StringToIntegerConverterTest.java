package com.honey.scrapper.converter;

import com.honey.scrapper.formatter.PriceFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerConverterTest {

    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

    @Test
    void convert() {
        conversionService.addConverter(new StringToWonConverter());
        conversionService.addFormatter(new PriceFormatter());
        String test = "10";
        assertThat(conversionService.convert(test, Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        assertThat(conversionService.convert("₩1000", Integer.class)).isEqualTo(1000);
//        int pos = price.indexOf("₩");
//        String removeWon = price.substring(pos + 1);
        Long convertWon = conversionService.convert("1,000", Long.class);

    }

    @Configuration
    static class WebConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new StringToWonConverter());
        }
    }
}