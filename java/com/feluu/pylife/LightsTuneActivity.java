package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.Adapters.Adapter;
import com.feluu.pylife.Adapters.LightsAdapter;

import java.util.ArrayList;
import java.util.List;

public class LightsTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView leaveActivity;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        activityTitle = findViewById(R.id.textView1);

        List<Adapter> lightsList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.lights_list_activity);
        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lightsList = new ArrayList<>();

        lightsList.add(new Adapter(R.string.standard_lights_name, R.string.standard_price_l, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.standardowe));
        lightsList.add(new Adapter(R.string.xenonultra_name, R.string.xenonultra_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.xenonultra));
        lightsList.add(new Adapter(R.string.xenonplasma_name, R.string.xenonplasma_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.xenonplasma));
        lightsList.add(new Adapter(R.string.smdled_name, R.string.smdled_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.smdled));
        lightsList.add(new Adapter(R.string.ledyellow_name, R.string.ledyellow_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.ledyellow));
        lightsList.add(new Adapter(R.string.philipsbluexenon_name, R.string.philipsbluexenon_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.philipsbluexenon));
        lightsList.add(new Adapter(R.string.streetpanther_name, R.string.streetpanther_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.streetpanther));
        lightsList.add(new Adapter(R.string.philipsoceanblue_name, R.string.philipsoceanblue_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.philipsoceanblue));
        lightsList.add(new Adapter(R.string.philipsoceangreen_name, R.string.philipsoceangreen_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.philipsoceangreen));
        lightsList.add(new Adapter(R.string.orangepanoramix_name, R.string.orangepanoramix_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.orangepanoramix));
        lightsList.add(new Adapter(R.string.asterixledpulsar_name, R.string.asterixledupulsar_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.asterixledpulsar));
        lightsList.add(new Adapter(R.string.obelixcreme_name, R.string.obelixcreme_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.obelixcreme));
        lightsList.add(new Adapter(R.string.drasticlime_name, R.string.drasticlime_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.drasticlime));
        lightsList.add(new Adapter(R.string.drasticblue_name, R.string.drasticblue_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.drasticblue));
        lightsList.add(new Adapter(R.string.drasticred_name, R.string.drasticred_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.drasticred));
        lightsList.add(new Adapter(R.string.georgepink_name, R.string.georgepink_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.georgepink));

        LightsAdapter adapter = new LightsAdapter(this, lightsList);
        recyclerView.setAdapter(adapter);
    }
}
