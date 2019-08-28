package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.feluu.pylife.adapters.AvWheelsAdapter;
import com.feluu.pylife.adapters.WheelsAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.models.ViewModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class WheelsTuneActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_list_wheels);

        ImageView leaveActivity;
        ImageView bgMain;
        TextView activityTitle;

        recyclerView = findViewById(R.id.recyclerView);
        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.top_title);

        activityTitle.setText(R.string.wheels_list_activity);
        leaveActivity.setOnClickListener((View v) -> finish());

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        setWheels();
        setAvailableWheels();
    }

    private void setWheels(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ListModel> wheelsList;
        wheelsList = new ArrayList<>();
        wheelsList.add(new ListModel(intToString(R.string.ahab_name), intToString(R.string.ahab_price), intToString(R.string.ahab_demont), null, null, R.drawable.ahab));
        wheelsList.add(new ListModel(intToString(R.string.classic_name), intToString(R.string.classic_price), intToString(R.string.classic_demont), null, null, R.drawable.classic));
        wheelsList.add(new ListModel(intToString(R.string.cutter_name), intToString(R.string.cutter_price), intToString(R.string.cutter_demont), null, null, R.drawable.cutter));
        wheelsList.add(new ListModel(intToString(R.string.dollar_name), intToString(R.string.dollar_price), intToString(R.string.dollar_demont), null, null, R.drawable.dollar));
        wheelsList.add(new ListModel(intToString(R.string.grove_name), intToString(R.string.grove_price), intToString(R.string.grove_demont), null, null, R.drawable.grove));
        wheelsList.add(new ListModel(intToString(R.string.import_name), intToString(R.string.import_price), intToString(R.string.import_demont), null, null, R.drawable.importy));
        wheelsList.add(new ListModel(intToString(R.string.mega_name), intToString(R.string.mega_price), intToString(R.string.mega_demont), null, null, R.drawable.mega));
        wheelsList.add(new ListModel(intToString(R.string.mesh_name), intToString(R.string.mesh_price), intToString(R.string.mesh_demont), null, null, R.drawable.mesh));
        wheelsList.add(new ListModel(intToString(R.string.offroad_name), intToString(R.string.offroad_price), intToString(R.string.offroad_demont), null, null, R.drawable.offroad));
        wheelsList.add(new ListModel(intToString(R.string.rimshine_name), intToString(R.string.rimshine_price), intToString(R.string.rimshine_demont), null, null, R.drawable.rimshine));
        wheelsList.add(new ListModel(intToString(R.string.rittle_name), intToString(R.string.rittle_price), intToString(R.string.rittle_demont), null, null, R.drawable.rittle));
        wheelsList.add(new ListModel(intToString(R.string.stalowe_name), intToString(R.string.stalowe_price), intToString(R.string.stalowe_demont), null, null, R.drawable.stalowe));
        wheelsList.add(new ListModel(intToString(R.string.switch_name), intToString(R.string.switch_price), intToString(R.string.switch_demont), null, null, R.drawable.switche));
        wheelsList.add(new ListModel(intToString(R.string.timer_name), intToString(R.string.timer_price), intToString(R.string.timer_demont), null, null, R.drawable.timer));
        wheelsList.add(new ListModel(intToString(R.string.twist_name), intToString(R.string.twist_price), intToString(R.string.twist_demont), null, null, R.drawable.twist));
        wheelsList.add(new ListModel(intToString(R.string.virtual_name), intToString(R.string.virtual_price), intToString(R.string.virtual_demont), null, null, R.drawable.virtual));
        wheelsList.add(new ListModel(intToString(R.string.wires_name), intToString(R.string.wires_price), intToString(R.string.wires_demont), null, null, R.drawable.wires));
        WheelsAdapter adapter = new WheelsAdapter(this, wheelsList);
        recyclerView.setAdapter(adapter);
    }

    private void setAvailableWheels(){
        Bundle extras = getIntent().getExtras();
        String avWheels = extras.getString("avWheels").toLowerCase();
        NestedScrollView nestedScrollView;
        ViewPager viewPager;
        CircleIndicator indicator;
        nestedScrollView = findViewById(R.id.nestedScrollView);
        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);

        if (avWheels.equalsIgnoreCase("error")) {
            viewPager.setVisibility(View.GONE);
            indicator.setVisibility(View.GONE);
            nestedScrollView.getParent().requestChildFocus(nestedScrollView, nestedScrollView);
        } else {
            List<ViewModel> models;
            models = new ArrayList<>();
            if (avWheels.contains("ahab")) {
                models.add(new ViewModel(R.drawable.ahab, intToString(R.string.ahab_name), intToString(R.string.ahab_price), intToString(R.string.ahab_demont), null));
            }
            if (avWheels.contains("classic")) {
                models.add(new ViewModel(R.drawable.classic, intToString(R.string.classic_name), intToString(R.string.classic_price), intToString(R.string.classic_demont), null));
            }
            if (avWheels.contains("cutter")) {
                models.add(new ViewModel(R.drawable.cutter, intToString(R.string.cutter_name), intToString(R.string.cutter_price), intToString(R.string.cutter_demont), null));
            }
            if (avWheels.contains("dollar")) {
                models.add(new ViewModel(R.drawable.dollar, intToString(R.string.dollar_name), intToString(R.string.dollar_price), intToString(R.string.dollar_demont), null));
            }
            if (avWheels.contains("grove")) {
                models.add(new ViewModel(R.drawable.grove, intToString(R.string.grove_name), intToString(R.string.grove_price), intToString(R.string.grove_demont), null));
            }
            if (avWheels.contains("import")) {
                models.add(new ViewModel(R.drawable.importy, intToString(R.string.import_name), intToString(R.string.import_price), intToString(R.string.import_demont), null));
            }
            if (avWheels.contains("mega") || (avWheels.contains("megi"))) {
                models.add(new ViewModel(R.drawable.mega, intToString(R.string.mega_name), intToString(R.string.mega_price), intToString(R.string.mega_demont), null));
            }
            if (avWheels.contains("mesh")) {
                models.add(new ViewModel(R.drawable.mesh, intToString(R.string.mesh_name), intToString(R.string.mesh_price), intToString(R.string.mesh_demont), null));
            }
            if (avWheels.contains("offroad") || avWheels.contains("off-road")) {
                models.add(new ViewModel(R.drawable.offroad, intToString(R.string.offroad_name), intToString(R.string.offroad_price), intToString(R.string.offroad_demont), null));
            }
            if (avWheels.contains("rimshine")) {
                models.add(new ViewModel(R.drawable.rimshine, intToString(R.string.rimshine_name), intToString(R.string.rimshine_price), intToString(R.string.rimshine_demont), null));
            }
            if (avWheels.contains("rittle")) {
                models.add(new ViewModel(R.drawable.rittle, intToString(R.string.rittle_name), intToString(R.string.rittle_price), intToString(R.string.rittle_demont), null));
            }
            if (avWheels.contains("stalowe")) {
                models.add(new ViewModel(R.drawable.stalowe, intToString(R.string.stalowe_name), intToString(R.string.stalowe_price), intToString(R.string.stalowe_demont), null));
            }
            if (avWheels.contains("switch")) {
                models.add(new ViewModel(R.drawable.switche, intToString(R.string.switch_name), intToString(R.string.switch_price), intToString(R.string.switch_demont), null));
            }
            if (avWheels.contains("timer")) {
                models.add(new ViewModel(R.drawable.timer, intToString(R.string.timer_name), intToString(R.string.timer_price), intToString(R.string.timer_demont), null));
            }
            if (avWheels.contains("twist")) {
                models.add(new ViewModel(R.drawable.twist, intToString(R.string.twist_name), intToString(R.string.twist_price), intToString(R.string.twist_demont), null));
            }
            if (avWheels.contains("virtual")) {
                models.add(new ViewModel(R.drawable.virtual, intToString(R.string.virtual_name), intToString(R.string.virtual_price), intToString(R.string.virtual_demont), null));
            }
            if (avWheels.contains("wires")) {
                models.add(new ViewModel(R.drawable.wires, intToString(R.string.wires_name), intToString(R.string.wires_price), intToString(R.string.wires_demont), null));
            }
            AvWheelsAdapter adapter = new AvWheelsAdapter(models, this);
            viewPager.setAdapter(adapter);
            nestedScrollView.getParent().requestChildFocus(nestedScrollView, nestedScrollView);
            indicator.setViewPager(viewPager);
        }
    }

    private String intToString(int Res) {
        return getResources().getString(Res);
    }
}
