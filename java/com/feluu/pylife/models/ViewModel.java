package com.feluu.pylife.models;

public class ViewModel {

    private int image;
    private String first;
    private String second;
    private String third;
    private String fourth;

    public int getImage() {
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

    public ViewModel(int image, String first, String second, String third, String fourth) {
        this.image = image;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}
