package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.CountersAdapter;
import com.feluu.pylife.models.ListModel;

import java.util.ArrayList;
import java.util.List;

public class CountersTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView leaveActivity;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        activityTitle = findViewById(R.id.textView1);

        List<ListModel> countersList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.counters_list_activity);
        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countersList = new ArrayList<>();

        countersList.add(new ListModel(intToString(R.string.standard_counter_name), intToString(R.string.standard_counter_price), intToString(R.string.standard_counter_range), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.standard_licznik));
        countersList.add(new ListModel(intToString(R.string.neo_name), intToString(R.string.neo_price), intToString(R.string.neo_range), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.neo));
        countersList.add(new ListModel(intToString(R.string.one_name), intToString(R.string.one_price), intToString(R.string.one_range), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.one));
        countersList.add(new ListModel(intToString(R.string.style_name), intToString(R.string.style_price), intToString(R.string.style_range), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.style));

        CountersAdapter adapter = new CountersAdapter(this, countersList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
