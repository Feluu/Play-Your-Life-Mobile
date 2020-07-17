package com.feluu.pylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.feluu.pylife.utils.SharedPref;

public class WizuTuneActivity extends AppCompatActivity {

    private boolean isClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizu);

        ImageView leaveActivity;
        ImageView bgMain;

        bgMain = findViewById(R.id.bgmain);
        leaveActivity = findViewById(R.id.exitActivity);

        leaveActivity.setOnClickListener((View v) -> finish());

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isClicked = false;
    }

    public void lightsTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(WizuTuneActivity.this, LightsTuneActivity.class);
            startActivity(intent);
        }
    }

    public void spoilersTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(WizuTuneActivity.this, SpoilersTuneActivity.class);
            startActivity(intent);
        }
    }

    public void countersTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(WizuTuneActivity.this, CountersTuneActivity.class);
            startActivity(intent);
        }
    }

    public void UWizuTunePage(View v) {
        if (!isClicked) {
            isClicked = true;
            Intent intent = new Intent(WizuTuneActivity.this, UWizuTuneActivity.class);
            startActivity(intent);
        }
    }
}
