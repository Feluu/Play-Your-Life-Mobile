package com.feluu.pylife;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.feluu.pylife.adapters.InfoAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Drawer result = null;
    private InterstitialAd mInterstitialAd;
    private InterstitialAd mInterstitialAd2;

    private ScrollView scroll;
    private BottomNavigationView navigation;
    private TextView title;
    private CardView carsList, asoList, mechanicalTune, wizuTune, wheelsTune, casualJobs, lvJobs, sfJobs, fcJobs, lsJobs;
    private LinearLayout moto, tune, jobs;
    private RelativeLayout home, info;
    private SharedPref sharedPref;
    private int selectedItem;
    private boolean isClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareDrawer(savedInstanceState);
        ImageView menuImg, bgMain, bgInfo;
        LinearLayout line;
        SwitchCompat themeSwitch;
        scroll = findViewById(R.id.scrollView);
        menuImg = findViewById(R.id.menuToggle);
        bgMain = findViewById(R.id.bg_home);
        bgInfo = findViewById(R.id.bg_info);
        themeSwitch = findViewById(R.id.themeSwitch);
        home = findViewById(R.id.mainScreen);
        info = findViewById(R.id.infoScreen);
        title = findViewById(R.id.top_title);
        moto = findViewById(R.id.moto);
        tune = findViewById(R.id.tune);
        jobs = findViewById(R.id.jobs);
        line = findViewById(R.id.line);
        carsList = findViewById(R.id.card_view1);
        asoList = findViewById(R.id.card_view11);
        mechanicalTune = findViewById(R.id.card_view2);
        wizuTune = findViewById(R.id.card_view3);
        wheelsTune = findViewById(R.id.card_view4);
        casualJobs = findViewById(R.id.card_view5);
        lvJobs = findViewById(R.id.card_view7);
        sfJobs = findViewById(R.id.card_view8);
        fcJobs = findViewById(R.id.card_view9);
        lsJobs = findViewById(R.id.card_view10);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        menuImg.setOnClickListener((View v) -> result.openDrawer());

        MobileAds.initialize(this, (InitializationStatus initializationStatus) -> {
                mInterstitialAd = new InterstitialAd(MainActivity.this);
                mInterstitialAd.setAdUnitId("ca-app-pub-8752363920727159/7418950479");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                mInterstitialAd2 = new InterstitialAd(MainActivity.this);
                mInterstitialAd2.setAdUnitId("ca-app-pub-8752363920727159/7418950479");
        });

        try {
            URL url = new URL("https://msciciel55.github.io/Play-Your-Life-Mobile/wheels.txt");
            new ReadWheelsTask(this).execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
            bgInfo.setImageResource(R.drawable.bg_dark);
            line.setBackgroundColor(getResources().getColor(R.color.lineColorDark));
            themeSwitch.setChecked(true);
        }

        new AppUpdater(this)
            .setUpdateFrom(UpdateFrom.GITHUB)
            .setGitHubUserAndRepo("Msciciel55", "Play-Your-Life-Mobile")
            .start();

        themeSwitch.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            if (isChecked) {
                sharedPref.setNightModeState(true);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            } else {
                sharedPref.setNightModeState(false);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (moto.getVisibility() == View.VISIBLE) {
            motoAnim();
        } else if (tune.getVisibility() == View.VISIBLE) {
            tuneAnim();
        } else if (jobs.getVisibility() == View.VISIBLE) {
            jobsAnim();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isClicked = false;
    }

    private void prepareDrawer(Bundle savedInstanceState) {
        AccountHeader headerResult;
        final IProfile profile = new ProfileDrawerItem().withName("Play Your Life").withEmail("Mobile").withIcon(R.drawable.nav_logo);

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(true)
                .addProfiles(profile)
                .withSavedInstance(savedInstanceState)
                .withSelectionListEnabledForSingleProfile(false)
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.string_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.string_report_error).withIcon(FontAwesome.Icon.faw_comment).withSelectable(false),
                        new SectionDrawerItem().withName(R.string.string_others),
                        new SecondaryDrawerItem().withName(R.string.string_ad).withIcon(FontAwesome.Icon.faw_ad).withSelectable(false),
                        new SecondaryDrawerItem().withName(R.string.string_info).withIcon(FontAwesome.Icon.faw_info)
                )
                .withOnDrawerItemClickListener((View view, int position, IDrawerItem drawerItem) -> {
                    if (position == 1) {
                        info.setVisibility(View.GONE);
                        home.setVisibility(View.VISIBLE);
                        navigation.setVisibility(View.VISIBLE);
                        if (selectedItem == 0) {
                            title.setText(R.string.title_cars);
                        } else if (selectedItem == 1) {
                            title.setText(R.string.title_tune);
                        } else if (selectedItem == 2) {
                            title.setText(R.string.title_earnings);
                        }
                    }
                    if (position == 2) {
                        String url = "https://pylife.pl/profile/31118-feluu/";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                    if (position == 4) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                            mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                        } else if (mInterstitialAd2.isLoaded()) {
                            mInterstitialAd2.show();
                            mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                    }
                    if (position == 5) {
                        home.setVisibility(View.GONE);
                        info.setVisibility(View.VISIBLE);
                        navigation.setVisibility(View.GONE);
                        ImageView backBtn;
                        backBtn = findViewById(R.id.menuToggle);
                        title.setText(R.string.string_info);
                        ArrayList<ListModel> infoData = new ArrayList<>();
                        infoData.add(new ListModel(intToString(R.string.info_author), intToString(R.string.info_author_name), null, null, null, 0));
                        infoData.add(new ListModel(intToString(R.string.info_app_version), intToString(R.string.versionName), null, null, null, 0));
                        infoData.add(new ListModel(intToString(R.string.info_used), intToString(R.string.info_used_2), null, null, null, 0));
                        infoData.add(new ListModel(intToString(R.string.info_github), intToString(R.string.info_github_link), null, null, null, 0));
                        ListView listView;
                        listView = findViewById(R.id.listView);

                        InfoAdapter adapter;
                        adapter = new InfoAdapter(infoData ,getApplicationContext());
                        listView.setAdapter(adapter);

                        listView.setOnItemLongClickListener((AdapterView<?> parent, View view_, int position_, long id) -> {
                            if (position_ == 0) {
                                String url = "https://pylife.pl/profile/31118-feluu/";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                            if (position_ == 2) {
                                String url = "https://feluu.github.io/Play-Your-Life-Mobile/zasoby.html";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                            if (position_ == 3) {
                                String url = "https://github.com/Feluu/Play-Your-Life-Mobile";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                            return true;
                        });

                        backBtn.setOnClickListener((View v) -> result.openDrawer());
                    }
                    return false;
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    @Override
    public void onBackPressed() {
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else if (home.getVisibility() == View.GONE) {
            info.setVisibility(View.GONE);
            home.setVisibility(View.VISIBLE);
            result.setSelection(1);
        } else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                default:
                    return false;
                case R.id.navigation_cars:
                    title.setText(R.string.title_cars);
                    motoAnim();
                    tune.setVisibility(View.GONE);
                    jobs.setVisibility(View.GONE);
                    moto.setVisibility(View.VISIBLE);
                    scroll.scrollTo(0, 0);
                    selectedItem = 0;
                    return true;
                case R.id.navigation_prices:
                    title.setText(R.string.title_tune);
                    tuneAnim();
                    moto.setVisibility(View.GONE);
                    jobs.setVisibility(View.GONE);
                    tune.setVisibility(View.VISIBLE);
                    scroll.scrollTo(0, 0);
                    selectedItem = 1;
                    return true;
                case R.id.navigation_earnings:
                    title.setText(R.string.title_earnings);
                    jobsAnim();
                    moto.setVisibility(View.GONE);
                    tune.setVisibility(View.GONE);
                    jobs.setVisibility(View.VISIBLE);
                    scroll.scrollTo(0, 0);
                    selectedItem = 2;
                    return true;
            }
        }
    };

    private String intToString(int Res) {
        return getResources().getString(Res);
    }

    private void motoAnim() {
        carsList.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_left));
        asoList.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_left));
    }

    private void tuneAnim() {
        mechanicalTune.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_scale));
        wizuTune.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_scale));
        wheelsTune.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_scale));
    }

    private void jobsAnim() {
        casualJobs.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_right));
        lvJobs.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_right));
        sfJobs.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_right));
        fcJobs.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_right));
        lsJobs.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_right));
    }

    public void carsListPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, CarsListActivity.class);
            startActivity(intent);
        }
    }

    public void asoListPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, AsoListActivity.class);
            startActivity(intent);
        }
    }

    public void mechanicalTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, MechanicalTuneActivity.class);
            startActivity(intent);
        }
    }

    public void wizuTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, WizuTuneActivity.class);
            startActivity(intent);
        }
    }

    public void wheelsTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, WheelsTuneActivity.class);
            intent.putExtra("avWheels", sharedPref.loadAvailableWheels());
            startActivity(intent);
        }
    }

    public void casualJobsPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, CasualJobsActivity.class);
            startActivity(intent);
        }
    }

    public void LVJobsPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, LVJobsActivity.class);
            startActivity(intent);
        }
    }

    public void SFJobsPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, SFJobsActivity.class);
            startActivity(intent);
        }
    }

    public void FCJobsPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, FCJobsActivity.class);
            startActivity(intent);
        }
    }

    public void LSJobsPage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(MainActivity.this, LSJobsActivity.class);
            startActivity(intent);
        }
    }

    private static class ReadWheelsTask extends AsyncTask<URL, Void, String> {

        private WeakReference<MainActivity> activityWeakReference;
        private String str = null;

        ReadWheelsTask(MainActivity context) {
            activityWeakReference = new WeakReference<>(context);
        }

        @Override
        protected String doInBackground(URL... urls) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(urls[0].openStream()));
                str = in.readLine();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        @Override
        protected void onPostExecute(String result) {
            MainActivity activity = activityWeakReference.get();
            SharedPref sharedPref = new SharedPref(activity.getApplicationContext());
            String av = sharedPref.loadAvailableWheels();
            if (str == null && av != null) {
            } else if (str != null && !(str.contains("brak"))) {
                sharedPref.setAvailableWheels(str);
            } else {
                sharedPref.setAvailableWheels(null);
            }
        }
    }
}
