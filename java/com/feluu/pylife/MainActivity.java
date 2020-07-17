package com.feluu.pylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.feluu.pylife.adapters.PagerAdapter;
import com.feluu.pylife.fragments.HomeFragment;
import com.feluu.pylife.fragments.JobsFragment;
import com.feluu.pylife.fragments.TuneFragment;
import com.google.firebase.database.FirebaseDatabase;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ChipNavigationBar chipNavigationBar;
    private boolean isClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        prepareNavMenu();
        prepareViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isClicked = false;
        //chipNavigationBar.setItemSelected(viewPager.getCurrentItem(), true);
    }

    private void prepareNavMenu() {
        chipNavigationBar = findViewById(R.id.nav);
        chipNavigationBar.setItemSelected(R.id.dom, true);

        chipNavigationBar.setOnItemSelectedListener((int i) -> {
            switch (i) {
                default:
                    break;
                case R.id.dom:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.tuning:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.prace:
                    viewPager.setCurrentItem(2);
                    break;
            }
        });
    }
    
    private void prepareViewPager() {
        HomeFragment homeFragment = new HomeFragment();
        TuneFragment tuneFragment = new TuneFragment();
        JobsFragment jobsFragment = new JobsFragment();
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(homeFragment);
        pagerAdapter.addFragment(tuneFragment);
        pagerAdapter.addFragment(jobsFragment);

        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch(position) {
                    default:
                        chipNavigationBar.setItemSelected(R.id.dom, true);
                        break;
                    case 1:
                        chipNavigationBar.setItemSelected(R.id.tuning, true);
                        break;
                    case 2:
                        chipNavigationBar.setItemSelected(R.id.prace, true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void onClickListener(View v) {
        if (!isClicked) {
            isClicked = true;
            switch(v.getId()) {
                case R.id.listaPojazdow:
                    Intent intent = new Intent(getApplicationContext(), VehListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.asortymentPojazdow:
                    Toast.makeText(this, "Aso pojazdów", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.poradniki:
                    Toast.makeText(this, "Poradniki", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radio:
                    Toast.makeText(this, "Radio", Toast.LENGTH_SHORT).show();
                    //startStream();
                    break;
                case R.id.premiePrace:
                    //Toast.makeText(this, "Premie prace", Toast.LENGTH_SHORT).show();
                    //Intent intent2 = new Intent(getApplicationContext(), WebViewActivity.class);
                    //intent2.putExtra("IDENTYFIKATOR_STRONY", "premie");
                    //startActivity(intent2);
                    break;
                case R.id.felgiSamochodowe:
                    Toast.makeText(this, "Felgi", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tuningMechaniczny:
                    Toast.makeText(this, "Tuning mechaniczny", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tuningWizualny:
                    Toast.makeText(this, "Tuning wizualny", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.urzedoweLV:
                    Toast.makeText(this, "Urzedowe LV", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.urzedoweSF:
                    Toast.makeText(this, "Urzedowe SF", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.urzedoweLS:
                    Toast.makeText(this, "Urzedowe LS", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.urzedoweFC:
                    Toast.makeText(this, "Urzedowe FC", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dorywcze:
                    Toast.makeText(this, "Dorywcze", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    /*private void startStream() {
        Intent serviceIntent = new Intent(MainActivity.this, MusicService.class);
        serviceIntent.setAction(MusicService.ACTION_PLAY);
        startService(serviceIntent);
        bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder _service) {

            MusicService.LocalBinder binder = (MusicService.LocalBinder) _service;
            service = binder.getServiceInstance(); //Get instance of your service!
            service.registerClient(MainActivity.this); //Activity register in the service as client for callabcks!
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {

        }
    };*/
}