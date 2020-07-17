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

public class CasualJobsActivity extends AppCompatActivity {

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
        title = findViewById(R.id.top_title);
        viewPager = findViewById(R.id.viewPager);

        title.setText(R.string.casual_jobs_activity);

        leaveActivity.setOnClickListener((View v) -> finish());

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        models = new ArrayList<>();
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/pizzaboy.jpg", intToString(R.string.pizza_title), intToString(R.string.pizza_earnings), intToString(R.string.pizza_locations), intToString(R.string.pizza_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/sweeper.jpg", intToString(R.string.sweeper_title), intToString(R.string.sweeper_earnings), intToString(R.string.sweeper_locations), intToString(R.string.sweeper_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/h1.jpg", intToString(R.string.h1_title), intToString(R.string.h1_earnings), intToString(R.string.h1_locations), intToString(R.string.h1_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/l1.jpg", intToString(R.string.l1_title), intToString(R.string.l1_earnings), intToString(R.string.l1_locations), intToString(R.string.l1_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/maveric.jpg", intToString(R.string.h2_title), intToString(R.string.h2_earnings), intToString(R.string.h2_locations), intToString(R.string.h2_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/crop.jpg", intToString(R.string.l2_title), intToString(R.string.l2_earnings), intToString(R.string.l2_locations), intToString(R.string.l2_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile//master/res/drawable/dron.jpg", intToString(R.string.l2d_title), intToString(R.string.l2d_earnings), intToString(R.string.l2d_locations), intToString(R.string.l2d_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/dune.jpg", intToString(R.string.dune_title), intToString(R.string.dune_earnings), intToString(R.string.dune_locations), intToString(R.string.dune_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/smieciarka.jpg", intToString(R.string.zgk_title), intToString(R.string.zgk_earnings), intToString(R.string.zgk_locations), intToString(R.string.zgk_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/lowisko.jpg", intToString(R.string.wed_title), intToString(R.string.wed_earnings), intToString(R.string.wed_locations), intToString(R.string.wed_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/bus.jpg", intToString(R.string.bus_title), intToString(R.string.bus_earnings), intToString(R.string.bus_locations), intToString(R.string.bus_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/hol.jpg", intToString(R.string.hol_title), intToString(R.string.hol_earnings), intToString(R.string.hol_locations), intToString(R.string.hol_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/way.jpg", intToString(R.string.kata_title), intToString(R.string.kata_earnings), intToString(R.string.kata_locations), intToString(R.string.kata_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/aparat.jpg", intToString(R.string.photo_title), intToString(R.string.photo_earnings), intToString(R.string.photo_locations), intToString(R.string.photo_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/tartak.png", intToString(R.string.tartak_title), intToString(R.string.tartak_earnings), intToString(R.string.tartak_locations), intToString(R.string.tartak_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/farma.png", intToString(R.string.farma_title), intToString(R.string.farma_earnings), intToString(R.string.farma_locations), intToString(R.string.farma_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/kutr.jpg", intToString(R.string.ryb_title), intToString(R.string.ryb_earnings), intToString(R.string.ryb_locations), intToString(R.string.ryb_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/lodolamacz.png", intToString(R.string.lodolamacz_title), intToString(R.string.lodolamacz_earnings), intToString(R.string.lodolamacz_locations), intToString(R.string.lodolamacz_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/kurier.jpg", intToString(R.string.kurier_title), intToString(R.string.kurier_earnings), intToString(R.string.kurier_locations), intToString(R.string.kurier_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nurek.jpg", intToString(R.string.nurek1_title), intToString(R.string.nurek1_earnings), intToString(R.string.nurek1_locations), intToString(R.string.nurek1_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nurek.jpg", intToString(R.string.nurek_title), intToString(R.string.nurek_earnings), intToString(R.string.nurek_locations), intToString(R.string.nurek_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/sv.png", intToString(R.string.sv_title), intToString(R.string.sv_earnings), intToString(R.string.sv_locations), intToString(R.string.sv_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/bet.png", intToString(R.string.bet_title), intToString(R.string.bet_earnings), intToString(R.string.bet_locations), intToString(R.string.bet_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/zlodziej.png", intToString(R.string.zlodziej_title), intToString(R.string.zlodziej_earnings), intToString(R.string.zlodziej_locations), intToString(R.string.zlodziej_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/taxi.jpg", intToString(R.string.taxi1_title), intToString(R.string.taxi1_earnings), intToString(R.string.taxi_locations), intToString(R.string.taxi_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/taxi.jpg", intToString(R.string.taxi2_title), intToString(R.string.taxi2_earnings), intToString(R.string.taxi_locations), intToString(R.string.taxi_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/taxi.jpg", intToString(R.string.taxi3_title), intToString(R.string.taxi3_earnings), intToString(R.string.taxi_locations), intToString(R.string.taxi_description)));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/taxi.jpg", intToString(R.string.taxi4_title), intToString(R.string.taxi4_earnings), intToString(R.string.taxi_locations), intToString(R.string.taxi_description)));
        adapter = new JobsAdapter(models, this);

        viewPager.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
