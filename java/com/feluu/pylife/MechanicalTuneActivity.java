package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.feluu.pylife.Adapters.Adapter;
import com.feluu.pylife.Adapters.MechanicalAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MechanicalTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView leaveActivity;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        activityTitle = findViewById(R.id.textView1);

        List<Adapter> mechanicalList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.mechanical_list_activity);
        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mechanicalList = new ArrayList<>();

        mechanicalList.add(new Adapter(R.string.mk1_mechanical_name, R.string.mk1_allows, R.string.mk1_price, R.string.mk1_demont, R.string.layout_null, R.drawable.ic_build));
        mechanicalList.add(new Adapter(R.string.mk2_mechanical_name, R.string.mk2_allows, R.string.mk2_price, R.string.mk2_demont, R.string.layout_null, R.drawable.ic_build));
        mechanicalList.add(new Adapter(R.string.mk3_mechanical_name, R.string.mk3_allows, R.string.mk3_price, R.string.mk3_demont, R.string.layout_null, R.drawable.ic_build));
        mechanicalList.add(new Adapter(R.string.rh1_mechanical_name, R.string.rh1_allows, R.string.rh1_price, R.string.rh1_demont, R.string.layout_null, R.drawable.ic_build));
        mechanicalList.add(new Adapter(R.string.hydra_mechanical_name, R.string.hydra_allows, R.string.hydra_price, R.string.hydra_demont, R.string.layout_null, R.drawable.ic_build));
        mechanicalList.add(new Adapter(R.string.taxo_mechanical_name, R.string.taxo_allows, R.string.taxo_price, R.string.taxo_demont, R.string.layout_null, R.drawable.ic_build));
        mechanicalList.add(new Adapter(R.string.logi_mechanical_tune, R.string.logi_allows, R.string.logi_price, R.string.logi_demont, R.string.layout_null, R.drawable.ic_build));

        MechanicalAdapter adapter = new MechanicalAdapter(this, mechanicalList);
        recyclerView.setAdapter(adapter);
    }
}
