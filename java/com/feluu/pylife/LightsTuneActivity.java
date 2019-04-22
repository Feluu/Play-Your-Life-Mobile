package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.LightsAdapter;
import com.feluu.pylife.models.ListModel;

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

        List<ListModel> lightsList;
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

        lightsList.add(new ListModel(R.string.standard_lights_name, R.string.standard_price_l, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.standard));
        lightsList.add(new ListModel(R.string.xenon_ultra_name, R.string.xenon_ultra_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.ultraxenon));
        lightsList.add(new ListModel(R.string.xenon_plasma_name, R.string.xenon_plasma_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.plasmaxenon));
        lightsList.add(new ListModel(R.string.smd_led_name, R.string.smd_led_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.smdled));
        lightsList.add(new ListModel(R.string.led_yellow_name, R.string.led_yellow_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.ledyellow));
        lightsList.add(new ListModel(R.string.blue_vision_xenon_name, R.string.blue_vision_xenon_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.bluevisionxenon));
        lightsList.add(new ListModel(R.string.street_panther_name, R.string.street_panther_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.streetpanther));
        lightsList.add(new ListModel(R.string.ocean_blue_name, R.string.ocean_blue_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.oceanblue));
        lightsList.add(new ListModel(R.string.ocean_green_name, R.string.ocean_green_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.oceangreen));
        lightsList.add(new ListModel(R.string.orange_panoramix_name, R.string.orange_panoramix_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.orangepanoramix));
        lightsList.add(new ListModel(R.string.asterix_led_pulsar_name, R.string.asterix_led_pulsar_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.ledpulsar));
        lightsList.add(new ListModel(R.string.obelix_creme_name, R.string.obelix_creme_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.obelixcreme));
        lightsList.add(new ListModel(R.string.drastic_lime_name, R.string.drastic_lime_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.drasticlime));
        lightsList.add(new ListModel(R.string.drastic_blue_name, R.string.drastic_blue_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.drasticblue));
        lightsList.add(new ListModel(R.string.drastic_red_name, R.string.drastic_red_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.drasticred));
        lightsList.add(new ListModel(R.string.george_pink_name, R.string.george_pink_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.georgepink));
        lightsList.add(new ListModel(R.string.bagina_name, R.string.bagina_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.bagina));
        lightsList.add(new ListModel(R.string.lodowe_name, R.string.lodowe_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.lodowe));
        lightsList.add(new ListModel(R.string.betty_name, R.string.betty_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.betty));
        lightsList.add(new ListModel(R.string.vermillion_name, R.string.vermillion_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.vermillion));
        lightsList.add(new ListModel(R.string.rex_name, R.string.rex_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.rex));
        lightsList.add(new ListModel(R.string.roz_name, R.string.roz_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.roz));
        lightsList.add(new ListModel(R.string.claws_ward_name, R.string.claws_ward_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.clawsward));
        lightsList.add(new ListModel(R.string.pedobear_name, R.string.pedobear_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.pedobear));
        lightsList.add(new ListModel(R.string.light_phoenix_name, R.string.light_phoenix_price, R.string.layout_null, R.string.layout_null, R.string.layout_null, R.drawable.phoenix_light));

        LightsAdapter adapter = new LightsAdapter(this, lightsList);
        recyclerView.setAdapter(adapter);
    }
}
