package com.feluu.pylife.Adapters;

public class Adapter {

    private int name;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int image;

    public Adapter(int name, int first, int second, int third, int fourth, int image) {
        this.name = name;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.image = image;
    }

    public int getName() {
        return name;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getImage() {
        return image;
    }
}
