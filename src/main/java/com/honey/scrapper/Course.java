package com.honey.scrapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Course {
    private String url;
    private String imgUrl;
    private String title;
    private String instructor;
    private String price; // 나중에 타입 수정해야함.
    private String discountPrice;
    private String discountPercent;

    public Course() {
    }

    public Course(String url, String imgUrl, String title, String instructor, String price, String discountPrice, String discountPercent) {
        this.url = url;
        this.imgUrl = imgUrl;
        this.title = title;
        this.instructor = instructor;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountPercent = discountPercent;
    }
}
