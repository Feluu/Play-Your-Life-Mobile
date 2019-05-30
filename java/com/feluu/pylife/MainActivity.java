package com.feluu.pylife;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.feluu.pylife.adapters.InfoAdapter;
import com.feluu.pylife.models.ListModel;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private TextView title, desc;
    private CardView carsList, mechanicalTune, lightsTune, wheelsTune, casualJobs;
    private RelativeLayout home, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareDrawer(savedInstanceState);
        ImageView menuImg;
        scroll = findViewById(R.id.scroll);
        menuImg = findViewById(R.id.menuToggle);
        home = findViewById(R.id.home_layout);
        info = findViewById(R.id.info_layout);
        title = findViewById(R.id.textView1);
        desc = findViewById(R.id.textView2);
        carsList = findViewById(R.id.card_view1);
        mechanicalTune = findViewById(R.id.card_view2);
        lightsTune = findViewById(R.id.card_view3);
        wheelsTune = findViewById(R.id.card_view4);
        casualJobs = findViewById(R.id.card_view5);
        carsList.setVisibility(View.VISIBLE);
        mechanicalTune.setVisibility(View.GONE);
        lightsTune.setVisibility(View.GONE);
        wheelsTune.setVisibility(View.GONE);
        casualJobs.setVisibility(View.GONE);
        home.setVisibility(View.VISIBLE);
        info.setVisibility(View.GONE);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.openDrawer();
            }
        });

        new AppUpdater(this)
            .setUpdateFrom(UpdateFrom.JSON)
            .setUpdateJSON("https://feluu.pl/update.json")
            .start();
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
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
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
                            infoData.add(new ListModel(intToString(R.string.info_thanks), intToString(R.string.info_thanks_to_maszek), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                            infoData.add(new ListModel(intToString(R.string.info_github), intToString(R.string.info_github_link), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                            infoData.add(new ListModel(intToString(R.string.info_model), getDeviceName(), intToString(R.string.layout_null), intToString(R.string.layout_null), intToString(R.string.layout_null), R.string.layout_null));
                            ListView listView;
                            listView = findViewById(R.id.listView);

                            InfoAdapter adapter;
                            adapter = new InfoAdapter(infoData ,getApplicationContext());
                            listView.setAdapter(adapter);

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    if (position == 0) {
                                        String url = "https://pylife.pl/profile/31118-feluu/";
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        startActivity(i);
                                    }
                                    if (position == 2) {
                                        String url = "https://pylife.pl/profile/15447-sapdmaszek/";
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        startActivity(i);
                                    }
                                    if (position == 3) {
                                        String url = "https://github.com/Feluu/Play-Your-Life-Mobile";
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        startActivity(i);
                                    }
                                }
                            });

                            backBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    result.openDrawer();
                                }
                            });
                        }
                        return false;
                    }
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
                    desc.setText(R.string.desc_cars);
                    carsList.setVisibility(View.VISIBLE);
                    mechanicalTune.setVisibility(View.GONE);
                    lightsTune.setVisibility(View.GONE);
                    wheelsTune.setVisibility(View.GONE);
                    casualJobs.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_prices:
                    title.setText(R.string.title_tune);
                    desc.setText(R.string.desc_tune);
                    mechanicalTune.setVisibility(View.VISIBLE);
                    carsList.setVisibility(View.GONE);
                    lightsTune.setVisibility(View.VISIBLE);
                    wheelsTune.setVisibility(View.VISIBLE);
                    casualJobs.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_earnings:
                    title.setText(R.string.title_earnings);
                    desc.setText(R.string.desc_earnings);
                    carsList.setVisibility(View.GONE);
                    mechanicalTune.setVisibility(View.GONE);
                    lightsTune.setVisibility(View.GONE);
                    wheelsTune.setVisibility(View.GONE);
                    casualJobs.setVisibility(View.VISIBLE);
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

    public void casualJobsPage(View v) {
        Intent intent = new Intent(MainActivity.this, CasualJobsActivity.class);
        startActivity(intent);
    }

}
