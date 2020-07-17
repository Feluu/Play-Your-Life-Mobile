package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.CountersAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class CountersTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView leaveActivity, bgMain;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.top_title);

        List<ListModel> countersList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.counters_list_activity);
        leaveActivity.setOnClickListener((View v) -> finish());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        countersList = new ArrayList<>();

        countersList.add(new ListModel(intToString(R.string.standard_counter_name), intToString(R.string.standard_counter_price), intToString(R.string.standard_counter_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/standard_licznik.png"));
        countersList.add(new ListModel(intToString(R.string.sportowy_name), intToString(R.string.sportowy_price), intToString(R.string.sportowy_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/sportowy.png"));
        countersList.add(new ListModel(intToString(R.string.neo_name), intToString(R.string.neo_price), intToString(R.string.neo_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/neo.png"));
        countersList.add(new ListModel(intToString(R.string.style_name), intToString(R.string.style_price), intToString(R.string.style_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/style.png"));
        countersList.add(new ListModel(intToString(R.string.ufo_name), intToString(R.string.ufo_price), intToString(R.string.ufo_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ufo.png"));
        countersList.add(new ListModel(intToString(R.string.smart_name), intToString(R.string.smart_price), intToString(R.string.smart_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/smart.png"));
        countersList.add(new ListModel(intToString(R.string.classicl_name), intToString(R.string.classicl_price), intToString(R.string.classicl_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/classicl.png"));
        countersList.add(new ListModel(intToString(R.string.one_name), intToString(R.string.one_price), intToString(R.string.one_range), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/one.png"));
        CountersAdapter adapter = new CountersAdapter(this, countersList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
