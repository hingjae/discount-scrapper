package com.honey.scrapper;

public class Course {
    private String url;
    private String imgUrl;
    private String title;
    private String instructor;
    private String price;
    private String discountPrice;
    private String discountPercent;

    public Course(String url, String imgUrl, String title, String instructor, String price, String discountPrice, String discountPercent) {
        this.url = url;
        this.imgUrl = imgUrl;
        this.title = title;
        this.instructor = instructor;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountPercent = discountPercent;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPercentage() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public String toString() {
        return "Course{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", instructor='" + instructor + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercent +
                '}';
    }
}
