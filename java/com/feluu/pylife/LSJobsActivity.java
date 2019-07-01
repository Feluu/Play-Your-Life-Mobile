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

public class LSJobsActivity extends AppCompatActivity {

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
        List<ViewModel> models;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        title = findViewById(R.id.textView1);
        viewPager = findViewById(R.id.viewPager);

        title.setText(R.string.ls_jobs_activity);

        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        models = new ArrayList<>();

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
            models.add(new ViewModel(R.drawable.ic_build_light, intToString(R.string.mech_ls_title), intToString(R.string.mech_ls_earnings), intToString(R.string.mech_ls_locations), intToString(R.string.mech_ls_description)));
            models.add(new ViewModel(R.drawable.ic_build_light, intToString(R.string.mech_pc_title), intToString(R.string.mech_pc_earnings), intToString(R.string.mech_pc_locations), intToString(R.string.mech_pc_description)));
            models.add(new ViewModel(R.drawable.ic_badge_light, intToString(R.string.sm_ls_title), intToString(R.string.sm_ls_earnings), intToString(R.string.sm_ls_locations), intToString(R.string.sm_ls_description)));
        } else {
            models.add(new ViewModel(R.drawable.ic_build, intToString(R.string.mech_ls_title), intToString(R.string.mech_ls_earnings), intToString(R.string.mech_ls_locations), intToString(R.string.mech_ls_description)));
            models.add(new ViewModel(R.drawable.ic_build, intToString(R.string.mech_pc_title), intToString(R.string.mech_pc_earnings), intToString(R.string.mech_pc_locations), intToString(R.string.mech_pc_description)));
            models.add(new ViewModel(R.drawable.ic_badge, intToString(R.string.sm_ls_title), intToString(R.string.sm_ls_earnings), intToString(R.string.sm_ls_locations), intToString(R.string.sm_ls_description)));
        }

        adapter = new JobsAdapter(models, this);

        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
