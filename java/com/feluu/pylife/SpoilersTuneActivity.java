package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.SpoilersAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class SpoilersTuneActivity extends AppCompatActivity {

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

        ImageView leaveActivity;
        ImageView bgMain;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.textView1);
        List<ListModel> spoilersList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.spoilers_list_activity);
        leaveActivity.setOnClickListener((View v) -> finish());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        spoilersList = new ArrayList<>();

        spoilersList.add(new ListModel(intToString(R.string.spoiler_pro_name), intToString(R.string.spoiler_pro_price), intToString(R.string.spoiler_pro_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_pro));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_win_name), intToString(R.string.spoiler_win_price), intToString(R.string.spoiler_win_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_win));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_race_name), intToString(R.string.spoiler_race_price), intToString(R.string.spoiler_race_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_race));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_worx_name), intToString(R.string.spoiler_worx_price), intToString(R.string.spoiler_worx_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_worx));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_fury_name), intToString(R.string.spoiler_fury_price), intToString(R.string.spoiler_fury_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_fury));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_alien_name), intToString(R.string.spoiler_alien_price), intToString(R.string.spoiler_alien_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_alien));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_xflow_name), intToString(R.string.spoiler_xflow_price), intToString(R.string.spoiler_xflow_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_x_flow));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_rijeka_name), intToString(R.string.spoiler_rijeka_price), intToString(R.string.spoiler_rijeka_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_rijeka));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_daytona_name), intToString(R.string.spoiler_daytona_price), intToString(R.string.spoiler_daytona_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_daytona));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_husar_name), intToString(R.string.spoiler_husar_price), intToString(R.string.spoiler_husar_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_husar));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_wingxl_name), intToString(R.string.spoiler_wingxl_price), intToString(R.string.spoiler_wingxl_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_wing_xl));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_gtwing_name), intToString(R.string.spoiler_gtwing_price), intToString(R.string.spoiler_gtwing_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_gt_wing));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_duo_name), intToString(R.string.spoiler_duo_price), intToString(R.string.spoiler_duo_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_duo));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_jdm_name), intToString(R.string.spoiler_jdm_price), intToString(R.string.spoiler_jdm_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_jdm));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_prelude_name), intToString(R.string.spoiler_prelude_price), intToString(R.string.spoiler_prelude_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_prelude));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_carbon_name), intToString(R.string.spoiler_carbon_price), intToString(R.string.spoiler_carbon_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_carbon));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_alienvi_name), intToString(R.string.spoiler_alienvi_price), intToString(R.string.spoiler_alienvi_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.spoiler_alien_vi));

        SpoilersAdapter adapter = new SpoilersAdapter(this, spoilersList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
