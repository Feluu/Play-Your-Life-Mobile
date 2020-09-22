package com.feluu.pylife.Interface;

import com.feluu.pylife.models.VehicleStock;

import java.util.List;

public interface IFirebaseLoadDone {

    void onFirebaseLoadSuccess(List<VehicleStock> vehicleStockList);
    void onFirebaseLoadFailed(String message);
}
