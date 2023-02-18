package com.honey.scrapper.domain.course;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
public class WonPrice {
    private String won;

    @NumberFormat(pattern = "###,###")
    private Integer price;

    public WonPrice(String won, Integer price) {
        this.won = won;
        this.price = price;
    }
}
