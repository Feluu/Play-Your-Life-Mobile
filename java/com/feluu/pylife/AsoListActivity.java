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
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/stratum.png", intToString(R.string.stratum_name), intToString(R.string.cygan_stratum_cena), intToString(R.string.cygan_stratum_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/yosemite.png", intToString(R.string.yosemite_name), intToString(R.string.cygan_yosemite_cena), intToString(R.string.cygan_yosemite_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/washington.png", intToString(R.string.washington_name), intToString(R.string.cygan_washington_cena), intToString(R.string.cygan_washington_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/esperanto.png", intToString(R.string.esperanto_name), intToString(R.string.cygan_esperanto_cena), intToString(R.string.cygan_esperanto_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/previon.png", intToString(R.string.previon_name), intToString(R.string.cygan_previon_cena), intToString(R.string.cygan_previon_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/intruder.png", intToString(R.string.intruder_name), intToString(R.string.cygan_intruder_cena), intToString(R.string.cygan_intruder_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/perennial.png", intToString(R.string.perennial_name), intToString(R.string.cygan_perennial_cena), intToString(R.string.cygan_perennial_przebieg), null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/moonbeam.png", intToString(R.string.moonbeam_name), intToString(R.string.cygan_moonbeam_cena), intToString(R.string.cygan_moonbeam_przebieg), null));
        CyganAdapter adapter = new CyganAdapter(models, this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                if(position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 5 ) {
                    cyganText.setText(R.string.cygan_lv);
                } else if (position == 6 || position == 7) {
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
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/merit.png", intToString(R.string.merit_name), intToString(R.string.salon_merit_cena), "gold", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/comet.png", intToString(R.string.comet_name), intToString(R.string.salon_comet_cena), "gold", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/stallion.png", intToString(R.string.stallion_name), intToString(R.string.salon_stallion_cena), "gold", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/blade.png", intToString(R.string.blade_name), intToString(R.string.salon_blade_cena), "all", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/banshee.png", intToString(R.string.banshee_name), intToString(R.string.salon_banshee_cena), "all", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/rancher.png", intToString(R.string.rancher_name), intToString(R.string.salon_rancher_cena), "all", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/euros.png", intToString(R.string.euros_name), intToString(R.string.salon_euros_cena), "all", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/faggio.png", intToString(R.string.faggio_name), intToString(R.string.salon_faggio_cena), "all", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/sanchez.png", intToString(R.string.sanchez_name), intToString(R.string.salon_sanchez_cena), "all", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/bf400.png", intToString(R.string.bf400_name), intToString(R.string.salon_bf400_cena), "all", null));
        SalonAdapter adapter = new SalonAdapter(models, this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                if(position == 0 || position == 1 || position == 2) {
                    salonText.setText(R.string.salon_gold);
                } else if (position == 3 || position == 4 || position == 5 || position == 6) {
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
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/zr350.png", intToString(R.string.zr350_name), intToString(R.string.komis_zr350_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uranus.png", intToString(R.string.uranus_name), intToString(R.string.komis_uranus_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/sentinelclassic.png", intToString(R.string.sentinelc_name), intToString(R.string.komis_sentinelclassic_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/sentinelcombi.png", intToString(R.string.sentinelk_name), intToString(R.string.komis_sentinelcombi_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/bobcat.png", intToString(R.string.bobcat_name), intToString(R.string.komis_bobcat_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/feltzer.png", intToString(R.string.feltzer_name), intToString(R.string.komis_feltzer_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/journey.png", intToString(R.string.journey_name), intToString(R.string.komis_journey_cena), "komis", null));
        models.add(new ViewModel("https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/admiral.png", intToString(R.string.admiral_name), intToString(R.string.komis_admiral_cena), "komis", null));
        SalonAdapter adapter = new SalonAdapter(models, this);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }

    private String intToString(int Res) {
        return getResources().getString(Res);
    }
}
