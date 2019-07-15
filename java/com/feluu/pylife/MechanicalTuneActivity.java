package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.feluu.pylife.adapters.MechanicalAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MechanicalTuneActivity extends AppCompatActivity {

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

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.textView1);

        List<ListModel> mechanicalList;
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

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
            mechanicalList.add(new ListModel(intToString(R.string.mk1_mechanical_name), intToString(R.string.mk1_allows), intToString(R.string.mk1_price), intToString(R.string.mk1_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.mk2_mechanical_name), intToString(R.string.mk2_allows), intToString(R.string.mk2_price), intToString(R.string.mk2_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.mk3_mechanical_name), intToString(R.string.mk3_allows), intToString(R.string.mk3_price), intToString(R.string.mk3_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.rh1_mechanical_name), intToString(R.string.rh1_allows), intToString(R.string.rh1_price), intToString(R.string.rh1_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.hydra_mechanical_name), intToString(R.string.hydra_allows), intToString(R.string.hydra_price), intToString(R.string.hydra_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.taxo_mechanical_name), intToString(R.string.taxo_allows), intToString(R.string.taxo_price), intToString(R.string.taxo_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.logi_mechanical_tune), intToString(R.string.logi_allows), intToString(R.string.logi_price), intToString(R.string.logi_demont), intToString(R.string.layout_null), R.drawable.ic_build_light));
            mechanicalList.add(new ListModel(intToString(R.string.nos_atrapa_name), intToString(R.string.nos_atrapa_allows), intToString(R.string.nos_atrapa_price), intToString(R.string.nos_atrapa_demont), intToString(R.string.layout_null), R.drawable.atrapa_nos));
            mechanicalList.add(new ListModel(intToString(R.string.nos_ciagle_name), intToString(R.string.nos_ciagle_allows), intToString(R.string.nos_ciagle_price), intToString(R.string.nos_ciagle_demont), intToString(R.string.layout_null), R.drawable.nos_ciagle));
            mechanicalList.add(new ListModel(intToString(R.string.nos_impulsowe_name), intToString(R.string.nos_impulsowe_allows), intToString(R.string.nos_impulsowe_price), intToString(R.string.nos_impulsowe_demont), intToString(R.string.layout_null), R.drawable.nos_impulsowe));
        } else {
            mechanicalList.add(new ListModel(intToString(R.string.mk1_mechanical_name), intToString(R.string.mk1_allows), intToString(R.string.mk1_price), intToString(R.string.mk1_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.mk2_mechanical_name), intToString(R.string.mk2_allows), intToString(R.string.mk2_price), intToString(R.string.mk2_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.mk3_mechanical_name), intToString(R.string.mk3_allows), intToString(R.string.mk3_price), intToString(R.string.mk3_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.rh1_mechanical_name), intToString(R.string.rh1_allows), intToString(R.string.rh1_price), intToString(R.string.rh1_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.hydra_mechanical_name), intToString(R.string.hydra_allows), intToString(R.string.hydra_price), intToString(R.string.hydra_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.taxo_mechanical_name), intToString(R.string.taxo_allows), intToString(R.string.taxo_price), intToString(R.string.taxo_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.logi_mechanical_tune), intToString(R.string.logi_allows), intToString(R.string.logi_price), intToString(R.string.logi_demont), intToString(R.string.layout_null), R.drawable.ic_build));
            mechanicalList.add(new ListModel(intToString(R.string.nos_atrapa_name), intToString(R.string.nos_atrapa_allows), intToString(R.string.nos_atrapa_price), intToString(R.string.nos_atrapa_demont), intToString(R.string.layout_null), R.drawable.atrapa_nos));
            mechanicalList.add(new ListModel(intToString(R.string.nos_ciagle_name), intToString(R.string.nos_ciagle_allows), intToString(R.string.nos_ciagle_price), intToString(R.string.nos_ciagle_demont), intToString(R.string.layout_null), R.drawable.nos_ciagle));
            mechanicalList.add(new ListModel(intToString(R.string.nos_impulsowe_name), intToString(R.string.nos_impulsowe_allows), intToString(R.string.nos_impulsowe_price), intToString(R.string.nos_impulsowe_demont), intToString(R.string.layout_null), R.drawable.nos_impulsowe));
        }

        MechanicalAdapter adapter = new MechanicalAdapter(this, mechanicalList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
