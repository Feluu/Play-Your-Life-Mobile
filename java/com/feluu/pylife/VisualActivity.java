package com.feluu.pylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.feluu.pylife.adapters.WheelsAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class VisualActivity extends AppCompatActivity {

    public RecyclerView recyclerView;

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

        ImageView leaveActivity;
        ImageView bgMain;
        TextView activityTitle;

        recyclerView = findViewById(R.id.recyclerView);
        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.top_title);

        activityTitle.setText("Tuning wizualny - " + getIntent().getStringExtra("carName"));
        leaveActivity.setOnClickListener((View v) -> finish());

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        setVisu();
    }

    private void setVisu() {
        String car = getIntent().getStringExtra("carName");
        if (car != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            List<ListModel> models;
            models = new ArrayList<>();
            if (car.equalsIgnoreCase("elegy")) {
                models.add(new ListModel(intToString(R.string.elegy_xflow_zderzak_przod_nazwa), intToString(R.string.elegy_xflow_zderzak_przod_cena), intToString(R.string.elegy_xflow_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_xflow_elegy));
                models.add(new ListModel(intToString(R.string.elegy_alien_zderzak_przod_nazwa), intToString(R.string.elegy_alien_zderzak_przod_cena), intToString(R.string.elegy_alien_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_alien_elegy));
                models.add(new ListModel(intToString(R.string.elegy_xflow_zderzak_tyl_nazwa), intToString(R.string.elegy_xflow_zderzak_tyl_cena), intToString(R.string.elegy_xflow_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_xflow_elegy));
                models.add(new ListModel(intToString(R.string.elegy_alien_zderzak_tyl_nazwa), intToString(R.string.elegy_alien_zderzak_tyl_cena), intToString(R.string.elegy_alien_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_alien_elegy));
                models.add(new ListModel(intToString(R.string.elegy_xflow_progi_nazwa), intToString(R.string.elegy_xflow_progi_cena), intToString(R.string.elegy_xflow_progi_demont), null, null, R.drawable.progi_xflow_elegy));
                models.add(new ListModel(intToString(R.string.elegy_alien_progi_nazwa), intToString(R.string.elegy_alien_progi_cena), intToString(R.string.elegy_alien_progi_demont), null, null, R.drawable.progi_alien_elegy));
                models.add(new ListModel(intToString(R.string.elegy_xflow_wloty_dach_nazwa), intToString(R.string.elegy_xflow_wloty_dach_cena), intToString(R.string.elegy_xflow_wloty_dach_demont), null, null, R.drawable.wloty_xflow_elegy));
                models.add(new ListModel(intToString(R.string.elegy_alien_wloty_dach_nazwa), intToString(R.string.elegy_alien_wloty_dach_cena), intToString(R.string.elegy_alien_wloty_dach_demont), null, null, R.drawable.wloty_alien_elegy));
                models.add(new ListModel(intToString(R.string.elegy_xflow_wydech_nazwa), intToString(R.string.elegy_xflow_wydech_cena), intToString(R.string.elegy_xflow_wydech_demont), null, null, R.drawable.wydech_xflow_elegy));
                models.add(new ListModel(intToString(R.string.elegy_alien_wydech_nazwa), intToString(R.string.elegy_alien_wydech_cena), intToString(R.string.elegy_alien_wydech_demont), null, null, R.drawable.wydech_alien_elegy));
            }
            if (car.equalsIgnoreCase("jester")) {
                models.add(new ListModel(intToString(R.string.jester_xflow_zderzak_przod_nazwa), intToString(R.string.jester_xflow_zderzak_przod_cena), intToString(R.string.jester_xflow_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_xflow_jester));
                models.add(new ListModel(intToString(R.string.jester_alien_zderzak_przod_nazwa), intToString(R.string.jester_alien_zderzak_przod_cena), intToString(R.string.jester_alien_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_alien_jester));
                models.add(new ListModel(intToString(R.string.jester_xflow_zderzak_tyl_nazwa), intToString(R.string.jester_xflow_zderzak_tyl_cena), intToString(R.string.jester_xflow_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_xflow_jester));
                models.add(new ListModel(intToString(R.string.jester_alien_zderzak_tyl_nazwa), intToString(R.string.jester_alien_zderzak_tyl_cena), intToString(R.string.jester_alien_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_alien_jester));
                models.add(new ListModel(intToString(R.string.jester_xflow_progi_nazwa), intToString(R.string.jester_xflow_progi_cena), intToString(R.string.jester_xflow_progi_demont), null, null, R.drawable.progi_xflow_jester));
                models.add(new ListModel(intToString(R.string.jester_alien_progi_nazwa), intToString(R.string.jester_alien_progi_cena), intToString(R.string.jester_alien_progi_demont), null, null, R.drawable.progi_alien_jester));
                models.add(new ListModel(intToString(R.string.jester_xflow_wloty_dach_nazwa), intToString(R.string.jester_xflow_wloty_dach_cena), intToString(R.string.jester_xflow_wloty_dach_demont), null, null, R.drawable.wloty_xflow_jester));
                models.add(new ListModel(intToString(R.string.jester_alien_wloty_dach_nazwa), intToString(R.string.jester_alien_wloty_dach_cena), intToString(R.string.jester_alien_wloty_dach_demont), null, null, R.drawable.wloty_alien_jester));
                models.add(new ListModel(intToString(R.string.jester_xflow_wydech_nazwa), intToString(R.string.jester_xflow_wydech_cena), intToString(R.string.jester_xflow_wydech_demont), null, null, R.drawable.wydech_xflow_jester));
                models.add(new ListModel(intToString(R.string.jester_alien_wydech_nazwa), intToString(R.string.jester_alien_wydech_cena), intToString(R.string.jester_alien_wydech_demont), null, null, R.drawable.wydech_alien_jester));
            }
            if (car.equalsIgnoreCase("sultan")) {
                models.add(new ListModel(intToString(R.string.sultan_xflow_zderzak_przod_nazwa), intToString(R.string.sultan_xflow_zderzak_przod_cena), intToString(R.string.sultan_xflow_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_xflow_sultan));
                models.add(new ListModel(intToString(R.string.sultan_alien_zderzak_przod_nazwa), intToString(R.string.sultan_alien_zderzak_przod_cena), intToString(R.string.sultan_alien_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_alien_sultan));
                models.add(new ListModel(intToString(R.string.sultan_xflow_zderzak_tyl_nazwa), intToString(R.string.sultan_xflow_zderzak_tyl_cena), intToString(R.string.sultan_xflow_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_xflow_sultan));
                models.add(new ListModel(intToString(R.string.sultan_alien_zderzak_tyl_nazwa), intToString(R.string.sultan_alien_zderzak_tyl_cena), intToString(R.string.sultan_alien_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_alien_sultan));
                models.add(new ListModel(intToString(R.string.sultan_xflow_progi_nazwa), intToString(R.string.sultan_xflow_progi_cena), intToString(R.string.sultan_xflow_progi_demont), null, null, R.drawable.progi_xflow_sultan));
                models.add(new ListModel(intToString(R.string.sultan_alien_progi_nazwa), intToString(R.string.sultan_alien_progi_cena), intToString(R.string.sultan_alien_progi_demont), null, null, R.drawable.progi_alien_sultan));
                models.add(new ListModel(intToString(R.string.sultan_xflow_wloty_dach_nazwa), intToString(R.string.sultan_xflow_wloty_dach_cena), intToString(R.string.sultan_xflow_wloty_dach_demont), null, null, R.drawable.wloty_xflow_sultan));
                models.add(new ListModel(intToString(R.string.sultan_alien_wloty_dach_nazwa), intToString(R.string.sultan_alien_wloty_dach_cena), intToString(R.string.sultan_alien_wloty_dach_demont), null, null, R.drawable.wloty_alien_sultan));
                models.add(new ListModel(intToString(R.string.sultan_xflow_wydech_nazwa), intToString(R.string.sultan_xflow_wydech_cena), intToString(R.string.sultan_xflow_wydech_demont), null, null, R.drawable.wydech_xflow_sultan));
                models.add(new ListModel(intToString(R.string.sultan_alien_wydech_nazwa), intToString(R.string.sultan_alien_wydech_cena), intToString(R.string.sultan_alien_wydech_demont), null, null, R.drawable.wydech_alien_sultan));
            }
            if (car.equalsIgnoreCase("uranus")) {
                models.add(new ListModel(intToString(R.string.uranus_xflow_zderzak_przod_nazwa), intToString(R.string.uranus_xflow_zderzak_przod_cena), intToString(R.string.uranus_xflow_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_xflow_uranus));
                models.add(new ListModel(intToString(R.string.uranus_alien_zderzak_przod_nazwa), intToString(R.string.uranus_alien_zderzak_przod_cena), intToString(R.string.uranus_alien_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_alien_uranus));
                models.add(new ListModel(intToString(R.string.uranus_xflow_zderzak_tyl_nazwa), intToString(R.string.uranus_xflow_zderzak_tyl_cena), intToString(R.string.uranus_xflow_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_xflow_uranus));
                models.add(new ListModel(intToString(R.string.uranus_alien_zderzak_tyl_nazwa), intToString(R.string.uranus_alien_zderzak_tyl_cena), intToString(R.string.uranus_alien_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_alien_uranus));
                models.add(new ListModel(intToString(R.string.uranus_xflow_progi_nazwa), intToString(R.string.uranus_xflow_progi_cena), intToString(R.string.uranus_xflow_progi_demont), null, null, R.drawable.progi_xflow_uranus));
                models.add(new ListModel(intToString(R.string.uranus_alien_progi_nazwa), intToString(R.string.uranus_alien_progi_cena), intToString(R.string.uranus_alien_progi_demont), null, null, R.drawable.progi_alien_uranus));
                models.add(new ListModel(intToString(R.string.uranus_xflow_wloty_dach_nazwa), intToString(R.string.uranus_xflow_wloty_dach_cena), intToString(R.string.uranus_xflow_wloty_dach_demont), null, null, R.drawable.wloty_xflow_uranus));
                models.add(new ListModel(intToString(R.string.uranus_alien_wloty_dach_nazwa), intToString(R.string.uranus_alien_wloty_dach_cena), intToString(R.string.uranus_alien_wloty_dach_demont), null, null, R.drawable.wloty_alien_uranus));
                models.add(new ListModel(intToString(R.string.uranus_xflow_wydech_nazwa), intToString(R.string.uranus_xflow_wydech_cena), intToString(R.string.uranus_xflow_wydech_demont), null, null, R.drawable.wydech_xflow_uranus));
                models.add(new ListModel(intToString(R.string.uranus_alien_wydech_nazwa), intToString(R.string.uranus_alien_wydech_cena), intToString(R.string.uranus_alien_wydech_demont), null, null, R.drawable.wydech_alien_uranus));
            }
            if (car.equalsIgnoreCase("stratum")) {
                models.add(new ListModel(intToString(R.string.stratum_xflow_zderzak_przod_nazwa), intToString(R.string.stratum_xflow_zderzak_przod_cena), intToString(R.string.stratum_xflow_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_xflow_stratum));
                models.add(new ListModel(intToString(R.string.stratum_alien_zderzak_przod_nazwa), intToString(R.string.stratum_alien_zderzak_przod_cena), intToString(R.string.stratum_alien_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_alien_stratum));
                models.add(new ListModel(intToString(R.string.stratum_xflow_zderzak_tyl_nazwa), intToString(R.string.stratum_xflow_zderzak_tyl_cena), intToString(R.string.stratum_xflow_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_xflow_stratum));
                models.add(new ListModel(intToString(R.string.stratum_alien_zderzak_tyl_nazwa), intToString(R.string.stratum_alien_zderzak_tyl_cena), intToString(R.string.stratum_alien_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_alien_stratum));
                models.add(new ListModel(intToString(R.string.stratum_xflow_progi_nazwa), intToString(R.string.stratum_xflow_progi_cena), intToString(R.string.stratum_xflow_progi_demont), null, null, R.drawable.progi_xflow_stratum));
                models.add(new ListModel(intToString(R.string.stratum_alien_progi_nazwa), intToString(R.string.stratum_alien_progi_cena), intToString(R.string.stratum_alien_progi_demont), null, null, R.drawable.progi_alien_stratum));
                models.add(new ListModel(intToString(R.string.stratum_xflow_wloty_dach_nazwa), intToString(R.string.stratum_xflow_wloty_dach_cena), intToString(R.string.stratum_xflow_wloty_dach_demont), null, null, R.drawable.wloty_xflow_stratum));
                models.add(new ListModel(intToString(R.string.stratum_alien_wloty_dach_nazwa), intToString(R.string.stratum_alien_wloty_dach_cena), intToString(R.string.stratum_alien_wloty_dach_demont), null, null, R.drawable.wloty_alien_stratum));
                models.add(new ListModel(intToString(R.string.stratum_xflow_wydech_nazwa), intToString(R.string.stratum_xflow_wydech_cena), intToString(R.string.stratum_xflow_wydech_demont), null, null, R.drawable.wydech_xflow_stratum));
                models.add(new ListModel(intToString(R.string.stratum_alien_wydech_nazwa), intToString(R.string.stratum_alien_wydech_cena), intToString(R.string.stratum_alien_wydech_demont), null, null, R.drawable.wydech_alien_stratum));
            }
            if (car.equalsIgnoreCase("perennial")) {
                models.add(new ListModel(intToString(R.string.perennial_przeciwmgielne_nazwa), intToString(R.string.perennial_przeciwmgielne_cena), intToString(R.string.perennial_przeciwmgielne_demont), null, null, R.drawable.przeciwmgielne_perennial));
                models.add(new ListModel(intToString(R.string.perennial_progi_nazwa), intToString(R.string.perennial_progi_cena), intToString(R.string.perennial_progi_demont), null, null, R.drawable.progi_perennial));
                models.add(new ListModel(intToString(R.string.perennial_twincylinder_wydech_nazwa), intToString(R.string.perennial_twincylinder_wydech_cena), intToString(R.string.perennial_twincylinder_wydech_demont), null, null, R.drawable.wydech_twincylinder_perennial));
                models.add(new ListModel(intToString(R.string.perennial_medium_wydech_nazwa), intToString(R.string.perennial_medium_wydech_cena), intToString(R.string.perennial_medium_wydech_demont), null, null, R.drawable.wydech_medium_perennial));
                models.add(new ListModel(intToString(R.string.perennial_large_wydech_nazwa), intToString(R.string.perennial_large_wydech_cena), intToString(R.string.perennial_large_wydech_demont), null, null, R.drawable.wydech_large_perennial));
            }
            if (car.equalsIgnoreCase("premier")) {
                models.add(new ListModel(intToString(R.string.premier_champ_maska_nazwa), intToString(R.string.premier_champ_maska_cena), intToString(R.string.premier_champ_maska_demont), null, null, R.drawable.maska_champ_premier));
                models.add(new ListModel(intToString(R.string.premier_fury_maska_nazwa), intToString(R.string.premier_fury_maska_cena), intToString(R.string.premier_fury_maska_demont), null, null, R.drawable.maska_fury_premier));
                models.add(new ListModel(intToString(R.string.premier_wloty_nazwa), intToString(R.string.premier_wloty_cena), intToString(R.string.premier_wloty_demont), null, null, R.drawable.wloty_premier));
                models.add(new ListModel(intToString(R.string.premier_twincylinder_wydech_nazwa), intToString(R.string.premier_twincylinder_wydech_cena), intToString(R.string.premier_twincylinder_wydech_demont), null, null, R.drawable.wydech_twincylinder_premier));
                models.add(new ListModel(intToString(R.string.premier_medium_wydech_nazwa), intToString(R.string.premier_medium_wydech_cena), intToString(R.string.premier_medium_wydech_demont), null, null, R.drawable.wydech_medium_premier));
            }
            if (car.equalsIgnoreCase("phoenix")) {
                models.add(new ListModel(intToString(R.string.phoenix_oval_wentylacja_nazwa), intToString(R.string.phoenix_oval_wentylacja_cena), intToString(R.string.phoenix_oval_wentylacja_demont), null, null, R.drawable.wentylacja_oval_phoenix));
                models.add(new ListModel(intToString(R.string.phoenix_square_wentylacja_nazwa), intToString(R.string.phoenix_square_wentylacja_cena), intToString(R.string.phoenix_square_wentylacja_demont), null, null, R.drawable.wentylacja_square_phoenix));
                models.add(new ListModel(intToString(R.string.phoenix_wloty_nazwa), intToString(R.string.phoenix_wloty_cena), intToString(R.string.phoenix_wloty_demont), null, null, R.drawable.wloty_phoenix));
                models.add(new ListModel(intToString(R.string.phoenix_progi_nazwa), intToString(R.string.phoenix_progi_cena), intToString(R.string.phoenix_progi_demont), null, null, R.drawable.progi_phoenix));
                models.add(new ListModel(intToString(R.string.phoenix_upsweptc_wydech_nazwa), intToString(R.string.phoenix_upsweptc_wydech_cena), intToString(R.string.phoenix_upsweptc_wydech_demont), null, null, R.drawable.wydechy_upsweptc_phoenix));
                models.add(new ListModel(intToString(R.string.phoenix_twincylinder_wydech_nazwa), intToString(R.string.phoenix_twincylinder_wydech_cena), intToString(R.string.phoenix_twincylinder_wydech_demont), null, null, R.drawable.wydechy_twincylinder_phoenix));
                models.add(new ListModel(intToString(R.string.phoenix_large_wydech_nazwa), intToString(R.string.phoenix_large_wydech_cena), intToString(R.string.phoenix_large_wydech_demont), null, null, R.drawable.wydechy_large_phoenix));
            }
            if (car.equalsIgnoreCase("zr-350")) {
                models.add(new ListModel(intToString(R.string.zr350_wloty_nazwa), intToString(R.string.zr350_wloty_cena), intToString(R.string.zr350_wloty_demont), null, null, R.drawable.wloty_zr350));
                models.add(new ListModel(intToString(R.string.zr350_progi_nazwa), intToString(R.string.zr350_progi_cena), intToString(R.string.zr350_progi_demont), null, null, R.drawable.progi_zr350));
                models.add(new ListModel(intToString(R.string.zr350_upsweptc_wydech_nazwa), intToString(R.string.zr350_upsweptc_wydech_cena), intToString(R.string.zr350_upsweptc_wydech_demont), null, null, R.drawable.wydechy_upsweptc_zr350));
                models.add(new ListModel(intToString(R.string.zr350_twincylinder_wydech_nazwa), intToString(R.string.zr350_twincylinder_wydech_cena), intToString(R.string.zr350_twincylinder_wydech_demont), null, null, R.drawable.wydechy_twincylinder_zr350));
                models.add(new ListModel(intToString(R.string.zr350_large_wydech_nazwa), intToString(R.string.zr350_large_wydech_cena), intToString(R.string.zr350_large_wydech_demont), null, null, R.drawable.wydechy_large_zr350));
                models.add(new ListModel(intToString(R.string.zr350_medium_wydech_nazwa), intToString(R.string.zr350_medium_wydech_cena), intToString(R.string.zr350_medium_wydech_demont), null, null, R.drawable.wydechy_medium_zr350));
            }
            if (car.equalsIgnoreCase("flash")) {
                models.add(new ListModel(intToString(R.string.flash_xflow_zderzak_przod_nazwa), intToString(R.string.flash_xflow_zderzak_przod_cena), intToString(R.string.flash_xflow_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_xflow_flash));
                models.add(new ListModel(intToString(R.string.flash_alien_zderzak_przod_nazwa), intToString(R.string.flash_alien_zderzak_przod_cena), intToString(R.string.flash_alien_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_alien_flash));
                models.add(new ListModel(intToString(R.string.flash_xflow_zderzak_tyl_nazwa), intToString(R.string.flash_xflow_zderzak_tyl_cena), intToString(R.string.flash_xflow_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_xflow_flash));
                models.add(new ListModel(intToString(R.string.flash_alien_zderzak_tyl_nazwa), intToString(R.string.flash_alien_zderzak_tyl_cena), intToString(R.string.flash_alien_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_alien_flash));
                models.add(new ListModel(intToString(R.string.flash_xflow_progi_nazwa), intToString(R.string.flash_xflow_progi_cena), intToString(R.string.flash_xflow_progi_demont), null, null, R.drawable.progi_xflow_flash));
                models.add(new ListModel(intToString(R.string.flash_alien_progi_nazwa), intToString(R.string.flash_alien_progi_cena), intToString(R.string.flash_alien_progi_demont), null, null, R.drawable.progi_alien_flash));
                models.add(new ListModel(intToString(R.string.flash_xflow_wloty_dach_nazwa), intToString(R.string.flash_xflow_wloty_dach_cena), intToString(R.string.flash_xflow_wloty_dach_demont), null, null, R.drawable.wloty_xflow_flash));
                models.add(new ListModel(intToString(R.string.flash_alien_wloty_dach_nazwa), intToString(R.string.flash_alien_wloty_dach_cena), intToString(R.string.flash_alien_wloty_dach_demont), null, null, R.drawable.wloty_alien_flash));
                models.add(new ListModel(intToString(R.string.flash_xflow_wydech_nazwa), intToString(R.string.flash_xflow_wydech_cena), intToString(R.string.flash_xflow_wydech_demont), null, null, R.drawable.wydech_xflow_flash));
                models.add(new ListModel(intToString(R.string.flash_alien_wydech_nazwa), intToString(R.string.flash_alien_wydech_cena), intToString(R.string.flash_alien_wydech_demont), null, null, R.drawable.wydech_alien_flash));
            }
            if (car.equalsIgnoreCase("tornado")) {
                models.add(new ListModel(intToString(R.string.tornado_chrome_zderzak_przod_nazwa), intToString(R.string.tornado_chrome_zderzak_przod_cena), intToString(R.string.tornado_chrome_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_chrome_tornado));
                models.add(new ListModel(intToString(R.string.tornado_slamin_zderzak_przod_nazwa), intToString(R.string.tornado_slamin_zderzak_przod_cena), intToString(R.string.tornado_slamin_zderzak_przod_demont), null, null, R.drawable.przedni_zderzak_slamin_tornado));
                models.add(new ListModel(intToString(R.string.tornado_chrome_zderzak_tyl_nazwa), intToString(R.string.tornado_chrome_zderzak_tyl_cena), intToString(R.string.tornado_chrome_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_chrome_tornado));
                models.add(new ListModel(intToString(R.string.tornado_slamin_zderzak_tyl_nazwa), intToString(R.string.tornado_slamin_zderzak_tyl_cena), intToString(R.string.tornado_slamin_zderzak_tyl_demont), null, null, R.drawable.tylni_zderzak_slamin_tornado));
                models.add(new ListModel(intToString(R.string.tornado_chrome_progi_nazwa), intToString(R.string.tornado_chrome_progi_cena), intToString(R.string.tornado_chrome_progi_demont), null, null, R.drawable.progi_chrome_tornado));
                models.add(new ListModel(intToString(R.string.tornado_chrome_wydech_nazwa), intToString(R.string.tornado_chrome_wydech_cena), intToString(R.string.tornado_chrome_wydech_demont), null, null, R.drawable.wydech_chrome_tornado));
                models.add(new ListModel(intToString(R.string.tornado_slamin_wydech_nazwa), intToString(R.string.tornado_slamin_wydech_cena), intToString(R.string.tornado_slamin_wydech_demont), null, null, R.drawable.wydech_slamin_tornado));
            }
            if (car.equalsIgnoreCase("blista")) {
                models.add(new ListModel(intToString(R.string.blista_race_maska_nazwa), intToString(R.string.blista_race_maska_cena), intToString(R.string.blista_race_maska_demont), null, null, R.drawable.maska_race_blista));
                models.add(new ListModel(intToString(R.string.blista_oval_wentylacja_nazwa), intToString(R.string.blista_oval_wentylacja_cena), intToString(R.string.blista_oval_wentylacja_demont), null, null, R.drawable.wentylacja_oval_blista));
                models.add(new ListModel(intToString(R.string.blista_wloty_nazwa), intToString(R.string.blista_wloty_cena), intToString(R.string.blista_wloty_demont), null, null, R.drawable.wloty_blista));
                models.add(new ListModel(intToString(R.string.blista_progi_nazwa), intToString(R.string.blista_progi_cena), intToString(R.string.blista_progi_demont), null, null, R.drawable.progi_blista));
                models.add(new ListModel(intToString(R.string.blista_twincylinder_wydech_nazwa), intToString(R.string.blista_twincylinder_wydech_cena), intToString(R.string.blista_twincylinder_wydech_demont), null, null, R.drawable.wydech_twincylinder_blista));
                models.add(new ListModel(intToString(R.string.blista_large_wydech_nazwa), intToString(R.string.blista_large_wydech_cena), intToString(R.string.blista_large_wydech_demont), null, null, R.drawable.wydech_large_blista));
            }
            WheelsAdapter adapter = new WheelsAdapter(this, models);
            recyclerView.setAdapter(adapter);
        }
        else {
            finish();
        }
    }

    private String intToString(int Res) {
        return getResources().getString(Res);
    }
}
