package com.feluu.pylife.models;

public class VehicleStock {

    public String nazwa, obraz, cena, miejsce, dodatkowe;

    public VehicleStock() {

    }

    public VehicleStock(String nazwa, String obraz, String cena, String miejsce, String dodatkowe) {
        this.nazwa = nazwa;
        this.obraz = obraz;
        this.cena = cena;
        this.miejsce = miejsce;
        this.dodatkowe = dodatkowe;
    }

    public String getName() {
        return nazwa;
    }

    public String getImageURL() {
        return obraz;
    }

    public String getPrice() {
        return cena;
    }

    public String getLocation() {
        return miejsce;
    }

    public String getAdditionalInfo() {
        return dodatkowe;
    }

}
