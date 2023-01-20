package com.honey.scrapper;

public class Course {
    private String url;
//    private String img;
    private String title;
    private String instructor;
    private int price;
    private String discountPercent;

    public Course(String url, String title, String instructor, int price, String discountPercent) {
        this.url = url;
        this.title = title;
        this.instructor = instructor;
        this.price = price;
        this.discountPercent = discountPercent;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDiscountPercentage() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
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
