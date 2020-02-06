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
