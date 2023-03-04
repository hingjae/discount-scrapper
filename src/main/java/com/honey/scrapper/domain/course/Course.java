package com.honey.scrapper.domain.course;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;

@Getter @Setter @ToString
public class Course {
    private String url;
    private String imgUrl;
    private String title;
    private String instructor;
    // 가격은 타입 수정해야함.
    @NumberFormat(pattern = "###,###")
    private Long price;
    @NumberFormat(pattern = "###,###")
    private Long discountPrice;
    private double discountPercent;

    public Course() {
    }

    public Course(String url, String imgUrl, String title, String instructor, Long price, Long discountPrice, double discountPercent) {
        this.url = url;
        this.imgUrl = imgUrl;
        this.title = title;
        this.instructor = instructor;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountPercent = discountPercent;
    }
}
