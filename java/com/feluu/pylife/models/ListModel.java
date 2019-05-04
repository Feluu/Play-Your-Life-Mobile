package com.feluu.pylife.models;

public class ListModel {

    private String name;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private int image;

    public String getName() {
        return name;
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

    public int getImage() {
        return image;
    }

    public ListModel(String name, String first, String second, String third, String fourth, int image) {
        this.name = name;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.image = image;
    }


}
