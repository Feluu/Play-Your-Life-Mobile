package com.feluu.pylife;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.VehiclesAdapter;
import com.feluu.pylife.models.Vehicle;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class VehListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VehiclesAdapter adapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veh_list);

        recyclerView = findViewById(R.id.recyclerView);
        TextView title = findViewById(R.id.title);

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        fetch();
    }

    private void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Pojazdy");

        FirebaseRecyclerOptions<Vehicle> options =
                new FirebaseRecyclerOptions.Builder<Vehicle>()
                        .setQuery(query, (@NonNull DataSnapshot snapshot) ->
                                new Vehicle(Objects.requireNonNull(snapshot.child("id").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("nazwa").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("obraz").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("vmax").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("vmaxfmk").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("podatek").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("zerowanie").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("cena").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("stan_tune").getValue()).toString())
                        )
                        .build();

        adapter = new VehiclesAdapter(this, options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}