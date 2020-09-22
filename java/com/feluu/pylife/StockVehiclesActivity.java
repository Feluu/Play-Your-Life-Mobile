package com.feluu.pylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.feluu.pylife.Interface.IFirebaseLoadDone;
import com.feluu.pylife.adapters.StockVehiclesAdapter;
import com.feluu.pylife.models.VehicleStock;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class StockVehiclesActivity extends AppCompatActivity implements IFirebaseLoadDone, ValueEventListener {

    StockVehiclesAdapter adapter;

    ViewPager viewPager;
    CircleIndicator indicator;
    DatabaseReference vehStock;
    IFirebaseLoadDone iFirebaseLoadDone;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_cars);

        viewPager = findViewById(R.id.viewPager);
        TextView title = findViewById(R.id.title);
        indicator = findViewById(R.id.indicator);

        title.setOnTouchListener((View v, MotionEvent event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                int[] textLocation = new int[2];
                title.getLocationOnScreen(textLocation);
                if (event.getRawX() <= textLocation[0] + title.getTotalPaddingLeft()) {
                    finish();
                    return true;
                }
            }
            return true;
        });

        fetch();
    }

    private void fetch() {
        vehStock = FirebaseDatabase.getInstance().getReference().child("Asortyment");

        iFirebaseLoadDone = this;

        vehStock.addValueEventListener(this);
    }

    @Override
    public void onFirebaseLoadSuccess(List<VehicleStock> vehicleStockList) {
        adapter = new StockVehiclesAdapter(this, vehicleStockList);
        viewPager.setAdapter(adapter);

        indicator.setViewPager(viewPager);
    }

    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        List<VehicleStock> vehicleStockList = new ArrayList<>();
        for (DataSnapshot stockSnapShot:dataSnapshot.getChildren())
            vehicleStockList.add(stockSnapShot.getValue(VehicleStock.class));

        iFirebaseLoadDone.onFirebaseLoadSuccess(vehicleStockList);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        iFirebaseLoadDone.onFirebaseLoadFailed(databaseError.getMessage());
    }

    @Override
    protected void onDestroy() {
        vehStock.removeEventListener(this);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        vehStock.addValueEventListener(this);
        super.onResume();
    }

    @Override
    protected void onStop() {
        vehStock.removeEventListener(this);
        super.onStop();
    }
}