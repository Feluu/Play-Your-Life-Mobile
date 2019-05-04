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

        lightsList.add(new ListModel(intToString(R.string.standard_lights_name), intToString(R.string.standard_price_l), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.standard));
        lightsList.add(new ListModel(intToString(R.string.xenon_ultra_name), intToString(R.string.xenon_ultra_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.ultraxenon));
        lightsList.add(new ListModel(intToString(R.string.xenon_plasma_name), intToString(R.string.xenon_plasma_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.plasmaxenon));
        lightsList.add(new ListModel(intToString(R.string.smd_led_name), intToString(R.string.smd_led_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.smdled));
        lightsList.add(new ListModel(intToString(R.string.led_yellow_name), intToString(R.string.led_yellow_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.ledyellow));
        lightsList.add(new ListModel(intToString(R.string.blue_vision_xenon_name), intToString(R.string.blue_vision_xenon_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.bluevisionxenon));
        lightsList.add(new ListModel(intToString(R.string.street_panther_name), intToString(R.string.street_panther_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.streetpanther));
        lightsList.add(new ListModel(intToString(R.string.ocean_blue_name), intToString(R.string.ocean_blue_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.oceanblue));
        lightsList.add(new ListModel(intToString(R.string.ocean_green_name), intToString(R.string.ocean_green_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.oceangreen));
        lightsList.add(new ListModel(intToString(R.string.orange_panoramix_name), intToString(R.string.orange_panoramix_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.orangepanoramix));
        lightsList.add(new ListModel(intToString(R.string.asterix_led_pulsar_name), intToString(R.string.asterix_led_pulsar_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.ledpulsar));
        lightsList.add(new ListModel(intToString(R.string.obelix_creme_name), intToString(R.string.obelix_creme_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.obelixcreme));
        lightsList.add(new ListModel(intToString(R.string.drastic_lime_name), intToString(R.string.drastic_lime_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.drasticlime));
        lightsList.add(new ListModel(intToString(R.string.drastic_blue_name), intToString(R.string.drastic_blue_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.drasticblue));
        lightsList.add(new ListModel(intToString(R.string.drastic_red_name), intToString(R.string.drastic_red_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.drasticred));
        lightsList.add(new ListModel(intToString(R.string.george_pink_name), intToString(R.string.george_pink_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.georgepink));
        lightsList.add(new ListModel(intToString(R.string.bagina_name), intToString(R.string.bagina_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.bagina));
        lightsList.add(new ListModel(intToString(R.string.lodowe_name), intToString(R.string.lodowe_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.lodowe));
        lightsList.add(new ListModel(intToString(R.string.betty_name), intToString(R.string.betty_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.betty));
        lightsList.add(new ListModel(intToString(R.string.vermillion_name), intToString(R.string.vermillion_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.vermillion));
        lightsList.add(new ListModel(intToString(R.string.rex_name), intToString(R.string.rex_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.rex));
        lightsList.add(new ListModel(intToString(R.string.roz_name), intToString(R.string.roz_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.roz));
        lightsList.add(new ListModel(intToString(R.string.claws_ward_name), intToString(R.string.claws_ward_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.clawsward));
        lightsList.add(new ListModel(intToString(R.string.pedobear_name), intToString(R.string.pedobear_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.pedobear));
        lightsList.add(new ListModel(intToString(R.string.light_phoenix_name), intToString(R.string.light_phoenix_price), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.phoenix_light));

        LightsAdapter adapter = new LightsAdapter(this, lightsList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
