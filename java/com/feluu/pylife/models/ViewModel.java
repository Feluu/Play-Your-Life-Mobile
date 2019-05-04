package com.feluu.pylife.models;

public class ViewModel {

    private int Image;
    private String Title;
    private String Earnings;
    private String Locations;
    private String Description;

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public String getEarnings() {
        return Earnings;
    }

    public String getLocations() {
        return Locations;
    }

    public String getDescription() {
        return Description;
    }

    public ViewModel(int Image, String Title, String Earnings, String Locations, String Description) {
        this.Image = Image;
        this.Title = Title;
        this.Earnings = Earnings;
        this.Locations = Locations;
        this.Description = Description;
    }
}
