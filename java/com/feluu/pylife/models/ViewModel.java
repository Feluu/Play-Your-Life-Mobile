package com.feluu.pylife.models;

public class ViewModel {

    private String image;
    private String first;
    private String second;
    private String third;
    private String fourth;

    public String getImage() {
        return image;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }

    public String getFourth() {
        return fourth;
    }

    public ViewModel(String image, String first, String second, String third, String fourth) {
        this.image = image;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}
