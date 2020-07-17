package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.LightsAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class LightsTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_search);

        ImageView leaveActivity, bgMain;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.top_title);

        List<ListModel> lightsList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.lights_list_activity);
        leaveActivity.setOnClickListener((View v) -> finish());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        lightsList = new ArrayList<>();

        lightsList.add(new ListModel(intToString(R.string.standard_lights_name), intToString(R.string.standard_price_l), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/standard.png"));
        lightsList.add(new ListModel(intToString(R.string.asterix_led_pulsar_name), intToString(R.string.asterix_led_pulsar_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ledpulsar.png"));
        lightsList.add(new ListModel(intToString(R.string.bagina_name), intToString(R.string.bagina_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/bagina.png"));
        lightsList.add(new ListModel(intToString(R.string.betty_name), intToString(R.string.betty_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/betty.png"));
        lightsList.add(new ListModel(intToString(R.string.choineczka_name), intToString(R.string.choineczka_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/choineczka.png"));
        lightsList.add(new ListModel(intToString(R.string.chrumchrum_name), intToString(R.string.chrumchrum_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/chrumchrum.png"));
        lightsList.add(new ListModel(intToString(R.string.citrus_mix_name), intToString(R.string.citrus_mix_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/citrusmix.png"));
        lightsList.add(new ListModel(intToString(R.string.claws_ward_name), intToString(R.string.claws_ward_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/clawsward.png"));
        lightsList.add(new ListModel(intToString(R.string.crock_name), intToString(R.string.crock_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/crock.png"));
        lightsList.add(new ListModel(intToString(R.string.delfinek_name), intToString(R.string.delfinek_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/delfinek.png"));
        lightsList.add(new ListModel(intToString(R.string.drastic_blue_name), intToString(R.string.drastic_blue_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/drasticblue.png"));
        lightsList.add(new ListModel(intToString(R.string.drastic_lime_name), intToString(R.string.drastic_lime_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/drasticlime.png"));
        lightsList.add(new ListModel(intToString(R.string.drastic_red_name), intToString(R.string.drastic_red_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/drasticred.png"));
        lightsList.add(new ListModel(intToString(R.string.flamingi_name), intToString(R.string.flamingi_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/flamingi.png"));
        lightsList.add(new ListModel(intToString(R.string.george_pink_name), intToString(R.string.george_pink_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/georgepink.png"));
        lightsList.add(new ListModel(intToString(R.string.gold_dream_name), intToString(R.string.gold_dream_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/golddream.png"));
        lightsList.add(new ListModel(intToString(R.string.heaven_name), intToString(R.string.heaven_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/heaven.png"));
        lightsList.add(new ListModel(intToString(R.string.laa_laa_name), intToString(R.string.laa_laa_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/laa_laa.png"));
        lightsList.add(new ListModel(intToString(R.string.led_yellow_name), intToString(R.string.led_yellow_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ledyellow.png"));
        lightsList.add(new ListModel(intToString(R.string.lodowe_name), intToString(R.string.lodowe_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/lodowe.png"));
        lightsList.add(new ListModel(intToString(R.string.mamba_name), intToString(R.string.mamba_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mamba.png"));
        lightsList.add(new ListModel(intToString(R.string.nosek_rudolfa_name), intToString(R.string.nosek_rudolfa_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nosekrudolfa.png"));
        lightsList.add(new ListModel(intToString(R.string.obelix_creme_name), intToString(R.string.obelix_creme_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/obelixcreme.png"));
        lightsList.add(new ListModel(intToString(R.string.light_oceanic_name), intToString(R.string.light_oceanic_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oceanic_lampka.png"));
        lightsList.add(new ListModel(intToString(R.string.orange_panoramix_name), intToString(R.string.orange_panoramix_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/orangepanoramix.png"));
        lightsList.add(new ListModel(intToString(R.string.pastelowa_zielen_name), intToString(R.string.pastelowa_zielen_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/pastelowa_zielen.png"));
        lightsList.add(new ListModel(intToString(R.string.pastelowy_fiolet_name), intToString(R.string.pastelowy_fiolet_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/pastelowy_fiolet.png"));
        lightsList.add(new ListModel(intToString(R.string.pedobear_name), intToString(R.string.pedobear_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/pedobear.png"));
        lightsList.add(new ListModel(intToString(R.string.blue_vision_xenon_name), intToString(R.string.blue_vision_xenon_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/bluevisionxenon.png"));
        lightsList.add(new ListModel(intToString(R.string.ocean_blue_name), intToString(R.string.ocean_blue_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oceanblue.png"));
        lightsList.add(new ListModel(intToString(R.string.ocean_green_name), intToString(R.string.ocean_green_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oceangreen.png"));
        lightsList.add(new ListModel(intToString(R.string.light_phoenix_name), intToString(R.string.light_phoenix_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/phoenix_light.png"));
        lightsList.add(new ListModel(intToString(R.string.piaskowy_name), intToString(R.string.piaskowy_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/piaskowy.png"));
        lightsList.add(new ListModel(intToString(R.string.pkb_name), intToString(R.string.pkb_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/pkb.png"));
        lightsList.add(new ListModel(intToString(R.string.po_name), intToString(R.string.po_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/po.png"));
        lightsList.add(new ListModel(intToString(R.string.prosiaczek_name), intToString(R.string.prosiaczek_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/prosiaczek.png"));
        lightsList.add(new ListModel(intToString(R.string.rechotka_name), intToString(R.string.rechotka_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rechotka.png"));
        lightsList.add(new ListModel(intToString(R.string.rex_name), intToString(R.string.rex_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rex.png"));
        lightsList.add(new ListModel(intToString(R.string.roz_name), intToString(R.string.roz_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/roz.png"));
        lightsList.add(new ListModel(intToString(R.string.shrek_name), intToString(R.string.shrek_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/shrek.png"));
        lightsList.add(new ListModel(intToString(R.string.smd_led_name), intToString(R.string.smd_led_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/smdled.png"));
        lightsList.add(new ListModel(intToString(R.string.specter_name), intToString(R.string.specter_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/specter.png"));
        lightsList.add(new ListModel(intToString(R.string.street_panther_name), intToString(R.string.street_panther_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/streetpanther.png"));
        lightsList.add(new ListModel(intToString(R.string.szmaragd_name), intToString(R.string.szmaragd_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/szmaragd.png"));
        lightsList.add(new ListModel(intToString(R.string.vermillion_name), intToString(R.string.vermillion_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/vermillion.png"));
        lightsList.add(new ListModel(intToString(R.string.xenon_plasma_name), intToString(R.string.xenon_plasma_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/plasmaxenon.png"));
        lightsList.add(new ListModel(intToString(R.string.xenon_ultra_name), intToString(R.string.xenon_ultra_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ultraxenon.png"));
        lightsList.add(new ListModel(intToString(R.string.zeus_name), intToString(R.string.zeus_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/zeus.png"));
        lightsList.add(new ListModel(intToString(R.string.ziemiste_name), intToString(R.string.ziemiste_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ziemiste.png"));
        lightsList.add(new ListModel(intToString(R.string.lososiowe_name), intToString(R.string.lososiowe_price), null, null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/lososiowe.png"));

        LightsAdapter adapter = new LightsAdapter(this, lightsList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
