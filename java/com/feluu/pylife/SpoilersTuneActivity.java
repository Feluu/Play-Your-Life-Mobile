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
        activityTitle = findViewById(R.id.top_title);
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

        spoilersList.add(new ListModel(intToString(R.string.spoiler_pro_name), intToString(R.string.spoiler_pro_price), intToString(R.string.spoiler_pro_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_pro.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_win_name), intToString(R.string.spoiler_win_price), intToString(R.string.spoiler_win_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_win.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_race_name), intToString(R.string.spoiler_race_price), intToString(R.string.spoiler_race_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_race.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_worx_name), intToString(R.string.spoiler_worx_price), intToString(R.string.spoiler_worx_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_worx.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_fury_name), intToString(R.string.spoiler_fury_price), intToString(R.string.spoiler_fury_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_fury.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_alien_name), intToString(R.string.spoiler_alien_price), intToString(R.string.spoiler_alien_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_alien.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_xflow_name), intToString(R.string.spoiler_xflow_price), intToString(R.string.spoiler_xflow_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_x_flow.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_rijeka_name), intToString(R.string.spoiler_rijeka_price), intToString(R.string.spoiler_rijeka_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_rijeka.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_daytona_name), intToString(R.string.spoiler_daytona_price), intToString(R.string.spoiler_daytona_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_daytona.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_husar_name), intToString(R.string.spoiler_husar_price), intToString(R.string.spoiler_husar_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_husar.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_wingxl_name), intToString(R.string.spoiler_wingxl_price), intToString(R.string.spoiler_wingxl_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_wing_xl.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_gtwing_name), intToString(R.string.spoiler_gtwing_price), intToString(R.string.spoiler_gtwing_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_gt_wing.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_duo_name), intToString(R.string.spoiler_duo_price), intToString(R.string.spoiler_duo_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_duo.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_jdm_name), intToString(R.string.spoiler_jdm_price), intToString(R.string.spoiler_jdm_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_jdm.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_prelude_name), intToString(R.string.spoiler_prelude_price), intToString(R.string.spoiler_prelude_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_prelude.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_carbon_name), intToString(R.string.spoiler_carbon_price), intToString(R.string.spoiler_carbon_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_carbon.png"));
        spoilersList.add(new ListModel(intToString(R.string.spoiler_alienvi_name), intToString(R.string.spoiler_alienvi_price), intToString(R.string.spoiler_alienvi_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/spoiler_alien_vi.png"));

        SpoilersAdapter adapter = new SpoilersAdapter(this, spoilersList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}