package com.feluu.pylife;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.feluu.pylife.adapters.InfoAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Drawer result = null;

    private ScrollView scroll;
    private BottomNavigationView navigation;
    private TextView title;
    private CardView carsList, mechanicalTune, lightsTune, wheelsTune, spoilersTune, countersTune, casualJobs, lvJobs, sfJobs, fcJobs, lsJobs;
    private RelativeLayout home, info;
    private SharedPref sharedPref;

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
        ImageView menuImg;
        ImageView bgMain;
        ImageView bgInfo;
        SwitchCompat themeSwitch;
        scroll = findViewById(R.id.scroll);
        menuImg = findViewById(R.id.menuToggle);
        bgMain = findViewById(R.id.bgmain);
        bgInfo = findViewById(R.id.bginfo);
        themeSwitch = findViewById(R.id.themeSwitch);
        home = findViewById(R.id.home_layout);
        info = findViewById(R.id.info_layout);
        title = findViewById(R.id.textView1);
        carsList = findViewById(R.id.card_view1);
        mechanicalTune = findViewById(R.id.card_view2);
        lightsTune = findViewById(R.id.card_view3);
        wheelsTune = findViewById(R.id.card_view4);
        spoilersTune = findViewById(R.id.card_view11);
        countersTune = findViewById(R.id.card_view6);
        casualJobs = findViewById(R.id.card_view5);
        lvJobs = findViewById(R.id.card_view7);
        sfJobs = findViewById(R.id.card_view8);
        fcJobs = findViewById(R.id.card_view9);
        lsJobs = findViewById(R.id.card_view10);
        carsList.setVisibility(View.VISIBLE);
        mechanicalTune.setVisibility(View.GONE);
        lightsTune.setVisibility(View.GONE);
        wheelsTune.setVisibility(View.GONE);
        spoilersTune.setVisibility(View.GONE);
        countersTune.setVisibility(View.GONE);
        casualJobs.setVisibility(View.GONE);
        lvJobs.setVisibility(View.GONE);
        sfJobs.setVisibility(View.GONE);
        fcJobs.setVisibility(View.GONE);
        lsJobs.setVisibility(View.GONE);
        home.setVisibility(View.VISIBLE);
        info.setVisibility(View.GONE);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        menuImg.setOnClickListener((View v) -> result.openDrawer());

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
            bgInfo.setImageResource(R.drawable.bg_dark);
            themeSwitch.setChecked(true);
        }
        new AppUpdater(this)
            .setUpdateFrom(UpdateFrom.JSON)
            .setUpdateJSON("https://feluu.pl/update.json")
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
                        new SecondaryDrawerItem().withName(R.string.string_info).withIcon(FontAwesome.Icon.faw_info)
                )
                .withOnDrawerItemClickListener((View view, int position, IDrawerItem drawerItem) -> {
                    ConstraintLayout.LayoutParams noMargin = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    noMargin.setMargins(0, 0, 0, 0);
                    int dpToPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 47, getResources().getDisplayMetrics());
                    ConstraintLayout.LayoutParams margin = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    margin.setMargins(0, 0, 0, dpToPx);
                    if (position == 1) {
                        info.setVisibility(View.GONE);
                        home.setVisibility(View.VISIBLE);
                        navigation.setVisibility(View.VISIBLE);
                        scroll.setLayoutParams(margin);
                    }
                    if (position == 2) {
                        Toast.makeText(MainActivity.this, R.string.app_report_info, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("message/rfc822");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kontakt@feluu.pl"});
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Zgłoszenie błędu/propozycji w aplikacji Play Your Life Mobile");
                        try {
                            startActivity(Intent.createChooser(intent, "Wyślij e-mail..."));
                        } catch (ActivityNotFoundException ex) {
                            Toast.makeText(MainActivity.this, "Nie posiadasz zainstalowanej żadnej aplikacji do wysyłania e-mail.", Toast.LENGTH_SHORT).show();
                            ex.printStackTrace();
                        }
                    }
                    if (position == 4) {
                        home.setVisibility(View.GONE);
                        info.setVisibility(View.VISIBLE);
                        navigation.setVisibility(View.GONE);
                        scroll.setLayoutParams(noMargin);
                        ImageView backBtn;
                        backBtn = findViewById(R.id.menuToggleInfo);

                        ArrayList<ListModel> infoData = new ArrayList<>();
                        infoData.add(new ListModel(intToString(R.string.info_author), intToString(R.string.info_author_name), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                        infoData.add(new ListModel(intToString(R.string.info_app_version), intToString(R.string.versionName), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                        infoData.add(new ListModel(intToString(R.string.info_used), intToString(R.string.info_used_2), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                        infoData.add(new ListModel(intToString(R.string.info_github), intToString(R.string.info_github_link), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                        infoData.add(new ListModel(intToString(R.string.info_model), getDeviceName(), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
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
                            if (position_ == 1) {
                                new AppUpdater(MainActivity.this)
                                    .setUpdateFrom(UpdateFrom.JSON)
                                    .setUpdateJSON("https://feluu.pl/update.json")
                                    .start();
                            }
                            if (position_ == 2) {
                                String url = "https://feluu.pl/zasoby.html";
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
                    carsList.setVisibility(View.VISIBLE);
                    mechanicalTune.setVisibility(View.GONE);
                    lightsTune.setVisibility(View.GONE);
                    wheelsTune.setVisibility(View.GONE);
                    spoilersTune.setVisibility(View.GONE);
                    countersTune.setVisibility(View.GONE);
                    casualJobs.setVisibility(View.GONE);
                    lvJobs.setVisibility(View.GONE);
                    sfJobs.setVisibility(View.GONE);
                    fcJobs.setVisibility(View.GONE);
                    lsJobs.setVisibility(View.GONE);
                    scroll.fullScroll(ScrollView.FOCUS_UP);
                    return true;
                case R.id.navigation_prices:
                    title.setText(R.string.title_tune);
                    mechanicalTune.setVisibility(View.VISIBLE);
                    carsList.setVisibility(View.GONE);
                    lightsTune.setVisibility(View.VISIBLE);
                    wheelsTune.setVisibility(View.VISIBLE);
                    spoilersTune.setVisibility(View.VISIBLE);
                    countersTune.setVisibility(View.VISIBLE);
                    casualJobs.setVisibility(View.GONE);
                    lvJobs.setVisibility(View.GONE);
                    sfJobs.setVisibility(View.GONE);
                    fcJobs.setVisibility(View.GONE);
                    lsJobs.setVisibility(View.GONE);
                    scroll.fullScroll(ScrollView.FOCUS_UP);
                    return true;
                case R.id.navigation_earnings:
                    title.setText(R.string.title_earnings);
                    carsList.setVisibility(View.GONE);
                    mechanicalTune.setVisibility(View.GONE);
                    lightsTune.setVisibility(View.GONE);
                    wheelsTune.setVisibility(View.GONE);
                    spoilersTune.setVisibility(View.GONE);
                    countersTune.setVisibility(View.GONE);
                    casualJobs.setVisibility(View.VISIBLE);
                    lvJobs.setVisibility(View.VISIBLE);
                    sfJobs.setVisibility(View.VISIBLE);
                    fcJobs.setVisibility(View.VISIBLE);
                    lsJobs.setVisibility(View.VISIBLE);
                    scroll.fullScroll(ScrollView.FOCUS_UP);
                    return true;
            }
        }
    };

    public String intToString(int Res) {
        return getResources().getString(Res);
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }
        return phrase.toString();
    }

    public void carsListPage(View v) {
        Intent intent = new Intent(MainActivity.this, CarsListActivity.class);
        startActivity(intent);
    }

    public void mechanicalTunePage(View v) {
        Intent intent = new Intent(MainActivity.this, MechanicalTuneActivity.class);
        startActivity(intent);
    }

    public void lightsTunePage(View v) {
        Intent intent = new Intent(MainActivity.this, LightsTuneActivity.class);
        startActivity(intent);
    }

    public void wheelsTunePage(View v) {
        Intent intent = new Intent(MainActivity.this, WheelsTuneActivity.class);
        startActivity(intent);
    }

    public void spoilersTunePage(View v) {
        Intent intent = new Intent(MainActivity.this, SpoilersTuneActivity.class);
        startActivity(intent);
    }

    public void countersTunePage(View v) {
        Intent intent = new Intent(MainActivity.this, CountersTuneActivity.class);
        startActivity(intent);
    }

    public void casualJobsPage(View v) {
        Intent intent = new Intent(MainActivity.this, CasualJobsActivity.class);
        startActivity(intent);
    }

    public void LVJobsPage(View v) {
        Intent intent = new Intent(MainActivity.this, LVJobsActivity.class);
        startActivity(intent);
    }

    public void SFJobsPage(View v) {
        Intent intent = new Intent(MainActivity.this, SFJobsActivity.class);
        startActivity(intent);
    }

    public void FCJobsPage(View v) {
        Intent intent = new Intent(MainActivity.this, FCJobsActivity.class);
        startActivity(intent);
    }

    public void LSJobsPage(View v) {
        Intent intent = new Intent(MainActivity.this, LSJobsActivity.class);
        startActivity(intent);
    }

}
