package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.feluu.pylife.adapters.JobsAdapter;
import com.feluu.pylife.models.ViewModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class LVJobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        ImageView leaveActivity;
        ImageView bgMain;
        TextView title;
        ViewPager viewPager;
        JobsAdapter adapter;
        CircleIndicator indicator;
        List<ViewModel> models;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        title = findViewById(R.id.top_title);
        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);

        title.setText(R.string.lv_jobs_activity);

        leaveActivity.setOnClickListener((View v) -> finish());

        models = new ArrayList<>();

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mechanikjasny.png", intToString(R.string.mech_dolny_title), intToString(R.string.mech_dolny_earnings), intToString(R.string.mech_dolny_locations), intToString(R.string.mech_dolny_description)));
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mechanikjasny.png", intToString(R.string.mech_gorny_title), intToString(R.string.mech_gorny_earnings), intToString(R.string.mech_gorny_locations), intToString(R.string.mech_gorny_description)));
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mechanikjasny.png", intToString(R.string.mech_samolotow_title), intToString(R.string.mech_samolotow_earnings), intToString(R.string.mech_samolotow_locations), intToString(R.string.mech_samolotow_description)));
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/strazjasny.png", intToString(R.string.sm_lv_title), intToString(R.string.sm_lv_earnings), intToString(R.string.sm_lv_locations), intToString(R.string.sm_lv_description)));
        } else {
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mechanik.png", intToString(R.string.mech_dolny_title), intToString(R.string.mech_dolny_earnings), intToString(R.string.mech_dolny_locations), intToString(R.string.mech_dolny_description)));
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mechanik.png", intToString(R.string.mech_gorny_title), intToString(R.string.mech_gorny_earnings), intToString(R.string.mech_gorny_locations), intToString(R.string.mech_gorny_description)));
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/mechanik.png", intToString(R.string.mech_samolotow_title), intToString(R.string.mech_samolotow_earnings), intToString(R.string.mech_samolotow_locations), intToString(R.string.mech_samolotow_description)));
            models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/straz.png", intToString(R.string.sm_lv_title), intToString(R.string.sm_lv_earnings), intToString(R.string.sm_lv_locations), intToString(R.string.sm_lv_description)));
        }

        adapter = new JobsAdapter(models, this);

        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
