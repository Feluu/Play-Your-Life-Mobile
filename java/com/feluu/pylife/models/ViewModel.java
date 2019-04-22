package com.feluu.pylife.models;

public class ViewModel {

    private int Image;
    private int Title;
    private int Earnings;
    private int Locations;
    private int Description;

    public ViewModel(int Image, int Title, int Earnings, int Locations, int Description) {
        this.Image = Image;
        this.Title = Title;
        this.Earnings = Earnings;
        this.Locations = Locations;
        this.Description = Description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getTitle() {
        return Title;
    }

    public void setTitle(int title) {
        Title = title;
    }

    public int getEarnings() {
        return Earnings;
    }

    public void setEarnings(int earnings) {
        Earnings = earnings;
    }

    public int getLocations() {
        return Locations;
    }

    public void setLocations(int locations) {
        Locations = locations;
    }

    public int getDescription() {
        return Description;
    }

    public void setDescription(int description) {
        Description = description;
    }

}
