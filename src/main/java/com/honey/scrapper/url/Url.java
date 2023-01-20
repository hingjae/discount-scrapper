package com.honey.scrapper.url;

public enum Url {
    INFLEARN("https://www.inflearn.com/courses?discounted=true&order=seq");

    private String text;

    Url(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
