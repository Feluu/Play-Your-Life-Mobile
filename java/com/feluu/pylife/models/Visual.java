package com.feluu.pylife.models;

public class Visual {

    public String name, price, demont, imageUrl;

    public Visual() {
    }

    public Visual(String name, String price, String demont, String imageUrl) {
        this.name = name;
        this.price = price;
        this.demont = demont;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDemont() {
        return demont;
    }

    public String getImageURL() {
        return imageUrl;
    }
}
