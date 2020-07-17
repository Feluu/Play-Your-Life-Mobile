package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.feluu.pylife.adapters.MechanicalAdapter;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MechanicalTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_search);

        ImageView leaveActivity;
        ImageView bgMain;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        bgMain = findViewById(R.id.bgmain);
        activityTitle = findViewById(R.id.top_title);

        List<ListModel> mechanicalList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.mechanical_list_activity);
        leaveActivity.setOnClickListener((View v) -> finish());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mechanicalList = new ArrayList<>();

        if (sharedPref.loadNightModeState()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusColor));
            bgMain.setImageResource(R.drawable.bg_dark);
            mechanicalList.add(new ListModel(intToString(R.string.mk1_mechanical_name), intToString(R.string.mk1_allows), intToString(R.string.mk1_price), intToString(R.string.mk1_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.mk2_mechanical_name), intToString(R.string.mk2_allows), intToString(R.string.mk2_price), intToString(R.string.mk2_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.mk3_mechanical_name), intToString(R.string.mk3_allows), intToString(R.string.mk3_price), intToString(R.string.mk3_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.rh1_mechanical_name), intToString(R.string.rh1_allows), intToString(R.string.rh1_price), intToString(R.string.rh1_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.hydra_mechanical_name), intToString(R.string.hydra_allows), intToString(R.string.hydra_price), intToString(R.string.hydra_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.taxo_mechanical_name), intToString(R.string.taxo_allows), intToString(R.string.taxo_price), intToString(R.string.taxo_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.logi_mechanical_tune), intToString(R.string.logi_allows), intToString(R.string.logi_price), intToString(R.string.logi_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/ukladjasny.png"));
            mechanicalList.add(new ListModel(intToString(R.string.nos_ciagle_name), intToString(R.string.nos_ciagle_allows), intToString(R.string.nos_ciagle_price), intToString(R.string.nos_ciagle_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nos_ciagle.png"));
            mechanicalList.add(new ListModel(intToString(R.string.nos_impulsowe_name), intToString(R.string.nos_impulsowe_allows), intToString(R.string.nos_impulsowe_price), intToString(R.string.nos_impulsowe_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nos_impulsowe.png"));
        } else {
            mechanicalList.add(new ListModel(intToString(R.string.mk1_mechanical_name), intToString(R.string.mk1_allows), intToString(R.string.mk1_price), intToString(R.string.mk1_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.mk2_mechanical_name), intToString(R.string.mk2_allows), intToString(R.string.mk2_price), intToString(R.string.mk2_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.mk3_mechanical_name), intToString(R.string.mk3_allows), intToString(R.string.mk3_price), intToString(R.string.mk3_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.rh1_mechanical_name), intToString(R.string.rh1_allows), intToString(R.string.rh1_price), intToString(R.string.rh1_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.hydra_mechanical_name), intToString(R.string.hydra_allows), intToString(R.string.hydra_price), intToString(R.string.hydra_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.taxo_mechanical_name), intToString(R.string.taxo_allows), intToString(R.string.taxo_price), intToString(R.string.taxo_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.logi_mechanical_tune), intToString(R.string.logi_allows), intToString(R.string.logi_price), intToString(R.string.logi_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/uklad.png"));
            mechanicalList.add(new ListModel(intToString(R.string.nos_ciagle_name), intToString(R.string.nos_ciagle_allows), intToString(R.string.nos_ciagle_price), intToString(R.string.nos_ciagle_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nos_ciagle.png"));
            mechanicalList.add(new ListModel(intToString(R.string.nos_impulsowe_name), intToString(R.string.nos_impulsowe_allows), intToString(R.string.nos_impulsowe_price), intToString(R.string.nos_impulsowe_demont), null, null,"https://raw.githubusercontent.com/Msciciel55/Play-Your-Life-Mobile/master/res/drawable/nos_impulsowe.png"));
        }

        MechanicalAdapter adapter = new MechanicalAdapter(this, mechanicalList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
