package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.feluu.pylife.adapters.JobsAdapter;
import com.feluu.pylife.models.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CasualJobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casual_jobs);

        ImageView leaveActivity;
        ViewPager viewPager;
        JobsAdapter adapter;
        List<ViewModel> models;

        viewPager = findViewById(R.id.viewPager);
        leaveActivity = findViewById(R.id.exitActivity);

        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        models = new ArrayList<>();
        models.add(new ViewModel(R.drawable.pizzaboy, R.string.pizza_title, R.string.pizza_earnings, R.string.pizza_locations, R.string.pizza_description));
        models.add(new ViewModel(R.drawable.sweeper, R.string.sweeper_title, R.string.sweeper_earnings, R.string.sweeper_locations, R.string.sweeper_description));
        models.add(new ViewModel(R.drawable.h1, R.string.h1_title, R.string.h1_earnings, R.string.h1_locations, R.string.h1_description));
        models.add(new ViewModel(R.drawable.l1, R.string.l1_title, R.string.l1_earnings, R.string.l1_locations, R.string.l1_description));
        models.add(new ViewModel(R.drawable.maveric, R.string.h2_title, R.string.h2_earnings, R.string.h2_locations, R.string.h2_description));
        models.add(new ViewModel(R.drawable.crop, R.string.l2_title, R.string.l2_earnings, R.string.l2_locations, R.string.l2_description));
        models.add(new ViewModel(R.drawable.dron, R.string.l2d_title, R.string.l2d_earnings, R.string.l2d_locations, R.string.l2d_description));
        models.add(new ViewModel(R.drawable.dune, R.string.dune_title, R.string.dune_earnings, R.string.dune_locations, R.string.dune_description));
        models.add(new ViewModel(R.drawable.smieciarka, R.string.zgk_title, R.string.zgk_earnings, R.string.zgk_locations, R.string.zgk_description));
        models.add(new ViewModel(R.drawable.lowisko, R.string.wed_title, R.string.wed_earnings, R.string.wed_locations, R.string.wed_description));
        models.add(new ViewModel(R.drawable.bus, R.string.bus_title, R.string.bus_earnings, R.string.bus_locations, R.string.bus_description));
        models.add(new ViewModel(R.drawable.hol, R.string.hol_title, R.string.hol_earnings, R.string.hol_locations, R.string.hol_description));
        models.add(new ViewModel(R.drawable.way, R.string.kata_title, R.string.kata_earnings, R.string.kata_locations, R.string.kata_description));
        models.add(new ViewModel(R.drawable.aparat, R.string.photo_title, R.string.photo_earnings, R.string.photo_locations, R.string.photo_description));
        models.add(new ViewModel(R.drawable.kutr, R.string.ryb_title, R.string.ryb_earnings, R.string.ryb_locations, R.string.ryb_description));
        models.add(new ViewModel(R.drawable.kurier, R.string.kurier_title, R.string.kurier_earnings, R.string.kurier_locations, R.string.kurier_description));
        models.add(new ViewModel(R.drawable.nurek, R.string.nurek_title, R.string.nurek_earnings, R.string.nurek_locations, R.string.nurek_description));
        models.add(new ViewModel(R.drawable.sv, R.string.sv_title, R.string.sv_earnings, R.string.sv_locations, R.string.sv_description));
        models.add(new ViewModel(R.drawable.bet, R.string.bet_title, R.string.bet_earnings, R.string.bet_locations, R.string.bet_description));
        models.add(new ViewModel(R.drawable.zlodziej, R.string.zlodziej_title, R.string.zlodziej_earnings, R.string.zlodziej_locations, R.string.zlodziej_description));
        models.add(new ViewModel(R.drawable.taxi, R.string.taxi1_title, R.string.taxi1_earnings, R.string.taxi_locations, R.string.taxi_description));
        models.add(new ViewModel(R.drawable.taxi, R.string.taxi2_title, R.string.taxi2_earnings, R.string.taxi_locations, R.string.taxi_description));
        models.add(new ViewModel(R.drawable.taxi, R.string.taxi3_title, R.string.taxi3_earnings, R.string.taxi_locations, R.string.taxi_description));
        models.add(new ViewModel(R.drawable.taxi, R.string.taxi4_title, R.string.taxi4_earnings, R.string.taxi_locations, R.string.taxi_description));

        adapter = new JobsAdapter(models, this);

        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
    }
}
