package com.feluu.pylife.models;

public class ListModel {

    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    private String sixth;
    private String image;

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

    public String getFifth() {
        return fifth;
    }

    public String getSixth() { return sixth; }

    public String getImage() { return image; }

    public ListModel(String first, String second, String third, String fourth, String fifth, String sixth, String image) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.image = image;
    }


}