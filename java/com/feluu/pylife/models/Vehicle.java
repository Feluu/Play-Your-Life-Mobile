package com.feluu.pylife.models;

public class Vehicle {

    public String id, name, imageUrl, vmax, vmaxfmk, tax, reset, price, tune;

    public Vehicle(String id, String name, String imageUrl, String vmax, String vmaxfmk, String tax, String reset, String price, String tune) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.vmax = vmax;
        this.vmaxfmk = vmaxfmk;
        this.tax = tax;
        this.reset = reset;
        this.price = price;
        this.tune = tune;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public String getVmax() {
        return vmax;
    }

    public String getVmaxFMK() {
        return vmaxfmk;
    }

    public String getTax() {
        return tax;
    }

    public String getReset() {
        return reset;
    }

    public String getPrice() {
        return price;
    }

    public String getTune() {
        return tune;
    }

}
