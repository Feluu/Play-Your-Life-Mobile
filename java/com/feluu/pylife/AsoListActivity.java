package com.feluu.pylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.feluu.pylife.adapters.AvWheelsAdapter;
import com.feluu.pylife.adapters.CyganAdapter;
import com.feluu.pylife.adapters.SalonAdapter;
import com.feluu.pylife.models.ViewModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class AsoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aso_list);

        ImageView leaveActivity;
        ImageView bgMain;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);

        leaveActivity.setOnClickListener((View v) -> finish());

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }

        setSalon();
        setKomis();
        setCygan();
    }

    private void setCygan() {
        ViewPager viewPager;
        CircleIndicator indicator;
        TextView cyganText;
        viewPager = findViewById(R.id.viewPager3);
        indicator = findViewById(R.id.indicator3);
        cyganText = findViewById(R.id.cyganText);

        List<ViewModel> models;
        models = new ArrayList<>();
        models.add(new ViewModel(R.drawable.bf, intToString(R.string.bf_name), intToString(R.string.cygan_bf_injection_cena), intToString(R.string.cygan_bf_injection_przebieg), null));
        models.add(new ViewModel(R.drawable.clover, intToString(R.string.clover_name), intToString(R.string.cygan_clover_cena), intToString(R.string.cygan_clover_przebieg), null));
        models.add(new ViewModel(R.drawable.perennial, intToString(R.string.perennial_name), intToString(R.string.cygan_perennial_cena), intToString(R.string.cygan_perennial_przebieg), null));
        models.add(new ViewModel(R.drawable.moonbeam, intToString(R.string.moonbeam_name), intToString(R.string.cygan_moonbeam_cena), intToString(R.string.cygan_moonbeam_przebieg), null));
        CyganAdapter adapter = new CyganAdapter(models, this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                if(position == 0 || position == 1) {
                    cyganText.setText(R.string.cygan_lv);
                } else if (position == 2 || position == 3) {
                    cyganText.setText(R.string.cygan_lb);
                } else {
                    cyganText.setText(R.string.cygan);
                }
            }
        });
    }

    private void setSalon() {
        ViewPager viewPager;
        CircleIndicator indicator;
        TextView salonText;
        viewPager = findViewById(R.id.viewPager1);
        indicator = findViewById(R.id.indicator1);
        salonText = findViewById(R.id.salonText);

        List<ViewModel> models;
        models = new ArrayList<>();
        models.add(new ViewModel(R.drawable.patriot, intToString(R.string.patriot_name), intToString(R.string.salon_patriot_cena), "gold", null));
        models.add(new ViewModel(R.drawable.glendale, intToString(R.string.glendale_name), intToString(R.string.salon_glendale_cena), "gold", null));
        models.add(new ViewModel(R.drawable.pcj600, intToString(R.string.pcj600_name), intToString(R.string.salon_pcj_cena), "all", null));
        models.add(new ViewModel(R.drawable.wayfarer, intToString(R.string.wayfarer_name), intToString(R.string.salon_wayfarer_cena), "all", null));
        models.add(new ViewModel(R.drawable.freeway, intToString(R.string.freeway_name), intToString(R.string.salon_freeway_cena), "all", null));
        models.add(new ViewModel(R.drawable.quad, intToString(R.string.quad_name), intToString(R.string.salon_quadbike_cena), "all", null));
        models.add(new ViewModel(R.drawable.blade, intToString(R.string.blade_name), intToString(R.string.salon_blade_cena), "all", null));
        models.add(new ViewModel(R.drawable.banshee, intToString(R.string.banshee_name), intToString(R.string.salon_banshee_cena), "all", null));
        models.add(new ViewModel(R.drawable.rancher, intToString(R.string.rancher_name), intToString(R.string.salon_rancher_cena), "all", null));
        SalonAdapter adapter = new SalonAdapter(models, this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                if(position == 0 || position == 1) {
                    salonText.setText(R.string.salon_gold);
                } else if (position == 6 || position == 7 || position == 8) {
                    salonText.setText(R.string.salon_doherty);
                } else {
                    salonText.setText(R.string.salon_motocykli);
                }
            }
        });
    }

    private void setKomis() {
        ViewPager viewPager;
        CircleIndicator indicator;
        viewPager = findViewById(R.id.viewPager2);
        indicator = findViewById(R.id.indicator2);

        List<ViewModel> models;
        models = new ArrayList<>();
        models.add(new ViewModel(R.drawable.supergt, intToString(R.string.supergt_name), intToString(R.string.komis_sgt_cena), "komis", null));
        models.add(new ViewModel(R.drawable.camper, intToString(R.string.camper_name), intToString(R.string.komis_camper_cena), "komis", null));
        models.add(new ViewModel(R.drawable.tampa, intToString(R.string.tampa_name), intToString(R.string.komis_tampa_cena), "komis", null));
        models.add(new ViewModel(R.drawable.burrito, intToString(R.string.burrito_name), intToString(R.string.komis_burrito_cena), "komis", null));
        models.add(new ViewModel(R.drawable.solair, intToString(R.string.solair_name), intToString(R.string.komis_solair_cena), "komis", null));
        models.add(new ViewModel(R.drawable.sabre, intToString(R.string.sabre_name), intToString(R.string.komis_sabre_cena), "komis", null));
        models.add(new ViewModel(R.drawable.premier, intToString(R.string.premier_name), intToString(R.string.komis_premier_cena), "komis", null));
        models.add(new ViewModel(R.drawable.buffalo, intToString(R.string.buffalo_name), intToString(R.string.komis_buff_cena), "komis", null));
        SalonAdapter adapter = new SalonAdapter(models, this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }

    private String intToString(int Res) {
        return getResources().getString(Res);
    }
}
