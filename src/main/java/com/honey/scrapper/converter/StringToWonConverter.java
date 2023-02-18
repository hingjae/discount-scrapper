package com.honey.scrapper.converter;

import com.honey.scrapper.domain.course.WonPrice;
import org.springframework.core.convert.converter.Converter;

public class StringToWonConverter implements Converter<String, WonPrice> {
    @Override
    public WonPrice convert(String source) {
        int wonIndex = source.indexOf("₩");
        String won = source.substring(0, wonIndex);
        Integer price = Integer.valueOf(source.substring(wonIndex + 1));
        return new WonPrice(won, price);
    }
}
