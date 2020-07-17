package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.feluu.pylife.adapters.WideningWheelsAdapter;
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
        setWideningWheels();
    }

    private void setWheels(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ListModel> wheelsList;
        wheelsList = new ArrayList<>();
        wheelsList.add(new ListModel(intToString(R.string.ahab_name), intToString(R.string.ahab_price), intToString(R.string.ahab_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ahab.png"));
        wheelsList.add(new ListModel(intToString(R.string.classic_name), intToString(R.string.classic_price), intToString(R.string.classic_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/classic.png"));
        wheelsList.add(new ListModel(intToString(R.string.cutter_name), intToString(R.string.cutter_price), intToString(R.string.cutter_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/cutter.png"));
        wheelsList.add(new ListModel(intToString(R.string.dollar_name), intToString(R.string.dollar_price), intToString(R.string.dollar_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/dollar.png"));
        wheelsList.add(new ListModel(intToString(R.string.grove_name), intToString(R.string.grove_price), intToString(R.string.grove_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/grove.png"));
        wheelsList.add(new ListModel(intToString(R.string.import_name), intToString(R.string.import_price), intToString(R.string.import_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/importy.png"));
        wheelsList.add(new ListModel(intToString(R.string.mega_name), intToString(R.string.mega_price), intToString(R.string.mega_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mega.png"));
        wheelsList.add(new ListModel(intToString(R.string.mesh_name), intToString(R.string.mesh_price), intToString(R.string.mesh_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mesh.png"));
        wheelsList.add(new ListModel(intToString(R.string.offroad_name), intToString(R.string.offroad_price), intToString(R.string.offroad_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/offroad.png"));
        wheelsList.add(new ListModel(intToString(R.string.rimshine_name), intToString(R.string.rimshine_price), intToString(R.string.rimshine_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rimshine.png"));
        wheelsList.add(new ListModel(intToString(R.string.rittle_name), intToString(R.string.rittle_price), intToString(R.string.rittle_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rittle.png"));
        wheelsList.add(new ListModel(intToString(R.string.stalowe_name), intToString(R.string.stalowe_price), intToString(R.string.stalowe_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/stalowe.png"));
        wheelsList.add(new ListModel(intToString(R.string.switch_name), intToString(R.string.switch_price), intToString(R.string.switch_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/switche.png"));
        wheelsList.add(new ListModel(intToString(R.string.timer_name), intToString(R.string.timer_price), intToString(R.string.timer_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/timer.png"));
        wheelsList.add(new ListModel(intToString(R.string.twist_name), intToString(R.string.twist_price), intToString(R.string.twist_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/twist.png"));
        wheelsList.add(new ListModel(intToString(R.string.virtual_name), intToString(R.string.virtual_price), intToString(R.string.virtual_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/virtual.png"));
        wheelsList.add(new ListModel(intToString(R.string.wires_name), intToString(R.string.wires_price), intToString(R.string.wires_demont), null, null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/wires.png"));
        WheelsAdapter adapter = new WheelsAdapter(this, wheelsList);
        recyclerView.setAdapter(adapter);
    }

    private void setAvailableWheels() {
        Bundle extras = getIntent().getExtras();
        NestedScrollView nestedScrollView;
        ViewPager viewPager;
        CircleIndicator indicator;
        LinearLayout avWheelsLayout;
        String avWheels = null;
        nestedScrollView = findViewById(R.id.nestedScrollView);
        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);
        avWheelsLayout = findViewById(R.id.avWheelsLayout);
        try {
            if (extras != null) {
                avWheels = extras.getString("avWheels").toLowerCase();
            }
        } catch (Exception e) {
            nestedScrollView.getParent().requestChildFocus(nestedScrollView, nestedScrollView);
        }

        if (avWheels != null) {
            List<ViewModel> models;
            models = new ArrayList<>();
            if (avWheels.contains("ahab")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ahab.png", intToString(R.string.ahab_name), intToString(R.string.ahab_price), intToString(R.string.ahab_demont), null));
            }
            if (avWheels.contains("classic")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/classic.png", intToString(R.string.classic_name), intToString(R.string.classic_price), intToString(R.string.classic_demont), null));
            }
            if (avWheels.contains("cutter")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/cutter.png", intToString(R.string.cutter_name), intToString(R.string.cutter_price), intToString(R.string.cutter_demont), null));
            }
            if (avWheels.contains("dollar")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/dollar.png", intToString(R.string.dollar_name), intToString(R.string.dollar_price), intToString(R.string.dollar_demont), null));
            }
            if (avWheels.contains("grove")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/grove.png", intToString(R.string.grove_name), intToString(R.string.grove_price), intToString(R.string.grove_demont), null));
            }
            if (avWheels.contains("import")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/importy.png", intToString(R.string.import_name), intToString(R.string.import_price), intToString(R.string.import_demont), null));
            }
            if (avWheels.contains("mega") || (avWheels.contains("megi"))) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mega.png", intToString(R.string.mega_name), intToString(R.string.mega_price), intToString(R.string.mega_demont), null));
            }
            if (avWheels.contains("mesh")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mesh.png", intToString(R.string.mesh_name), intToString(R.string.mesh_price), intToString(R.string.mesh_demont), null));
            }
            if (avWheels.contains("offroad") || avWheels.contains("off-road")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/offroad.png", intToString(R.string.offroad_name), intToString(R.string.offroad_price), intToString(R.string.offroad_demont), null));
            }
            if (avWheels.contains("rimshine")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rimshine.png", intToString(R.string.rimshine_name), intToString(R.string.rimshine_price), intToString(R.string.rimshine_demont), null));
            }
            if (avWheels.contains("rittle")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rittle.png", intToString(R.string.rittle_name), intToString(R.string.rittle_price), intToString(R.string.rittle_demont), null));
            }
            if (avWheels.contains("stalowe")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/stalowe.png", intToString(R.string.stalowe_name), intToString(R.string.stalowe_price), intToString(R.string.stalowe_demont), null));
            }
            if (avWheels.contains("switch")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/switche.png", intToString(R.string.switch_name), intToString(R.string.switch_price), intToString(R.string.switch_demont), null));
            }
            if (avWheels.contains("timer")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/timer.png", intToString(R.string.timer_name), intToString(R.string.timer_price), intToString(R.string.timer_demont), null));
            }
            if (avWheels.contains("twist")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/twist.png", intToString(R.string.twist_name), intToString(R.string.twist_price), intToString(R.string.twist_demont), null));
            }
            if (avWheels.contains("virtual")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/virtual.png", intToString(R.string.virtual_name), intToString(R.string.virtual_price), intToString(R.string.virtual_demont), null));
            }
            if (avWheels.contains("wires")) {
                models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/wires.png", intToString(R.string.wires_name), intToString(R.string.wires_price), intToString(R.string.wires_demont), null));
            }
            AvWheelsAdapter adapter = new AvWheelsAdapter(models, this);
            viewPager.setAdapter(adapter);
            avWheelsLayout.setVisibility(View.VISIBLE);
            nestedScrollView.getParent().requestChildFocus(nestedScrollView, nestedScrollView);
            indicator.setViewPager(viewPager);
        }
    }
    private void setWideningWheels() {
        ViewPager viewPager;
        CircleIndicator indicator;
        viewPager = findViewById(R.id.viewPager11);

        List<ViewModel> models;
        models = new ArrayList<>();
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oponyjasny.png", intToString(R.string.uw_name), intToString(R.string.uw_price), intToString(R.string.uw_demont), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oponyjasny.png", intToString(R.string.szerokie_name), intToString(R.string.szerokie_price), intToString(R.string.szerokie_demont), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oponyjasny.png", intToString(R.string.waskie_name), intToString(R.string.waskie_price), intToString(R.string.waskie_demont), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/oponyjasny.png", intToString(R.string.ut_name), intToString(R.string.ut_price), intToString(R.string.ut_demont), null));
        WideningWheelsAdapter adapter = new WideningWheelsAdapter(models, this);
        viewPager.setAdapter(adapter);

    }

    private String intToString(int Res) {
        return getResources().getString(Res);
    }
}