package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.Adapters.Adapter;
import com.feluu.pylife.Adapters.WheelsAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WheelsTuneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wheels);

        ImageView leaveActivity;
        TextView activityTitle;
        final TextView availableWheels;

        leaveActivity = findViewById(R.id.exitActivity);
        activityTitle = findViewById(R.id.textView1);
        availableWheels = findViewById(R.id.available);

        List<Adapter> wheelsList;
        RecyclerView recyclerView;

        activityTitle.setText(R.string.wheels_list_activity);
        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wheelsList = new ArrayList<>();

        wheelsList.add(new Adapter(R.string.ahab_name, R.string.ahab_price, R.string.ahab_demont, R.string.layout_null, R.string.layout_null, R.drawable.ahab));
        wheelsList.add(new Adapter(R.string.classic_name, R.string.classic_price, R.string.classic_demont, R.string.layout_null, R.string.layout_null, R.drawable.classic));
        wheelsList.add(new Adapter(R.string.cutter_name, R.string.cutter_price, R.string.cutter_demont, R.string.layout_null, R.string.layout_null, R.drawable.cutter));
        wheelsList.add(new Adapter(R.string.dollar_name, R.string.dollar_price, R.string.dollar_demont, R.string.layout_null, R.string.layout_null, R.drawable.dollar));
        wheelsList.add(new Adapter(R.string.grove_name, R.string.grove_price, R.string.grove_demont, R.string.layout_null, R.string.layout_null, R.drawable.grove));
        wheelsList.add(new Adapter(R.string.import_name, R.string.import_price, R.string.import_demont, R.string.layout_null, R.string.layout_null, R.drawable.importy));
        wheelsList.add(new Adapter(R.string.mega_name, R.string.mega_price, R.string.mega_demont, R.string.layout_null, R.string.layout_null, R.drawable.mega));
        wheelsList.add(new Adapter(R.string.mesh_name, R.string.mesh_price, R.string.mesh_demont, R.string.layout_null, R.string.layout_null, R.drawable.mesh));
        wheelsList.add(new Adapter(R.string.offroad_name, R.string.offroad_price, R.string.offroad_demont, R.string.layout_null, R.string.layout_null, R.drawable.offroad));
        wheelsList.add(new Adapter(R.string.rimshine_name, R.string.rimshine_price, R.string.rimshine_demont, R.string.layout_null, R.string.layout_null, R.drawable.rimshine));
        wheelsList.add(new Adapter(R.string.rittle_name, R.string.rittle_price, R.string.rittle_demont, R.string.layout_null, R.string.layout_null, R.drawable.rittle));
        wheelsList.add(new Adapter(R.string.stalowe_name, R.string.stalowe_price, R.string.stalowe_demont, R.string.layout_null, R.string.layout_null, R.drawable.stalowe));
        wheelsList.add(new Adapter(R.string.switch_name, R.string.switch_price, R.string.switch_demont, R.string.layout_null, R.string.layout_null, R.drawable.switche));
        wheelsList.add(new Adapter(R.string.timer_name, R.string.timer_price, R.string.timer_demont, R.string.layout_null, R.string.layout_null, R.drawable.timer));
        wheelsList.add(new Adapter(R.string.twist_name, R.string.twist_price, R.string.twist_demont, R.string.layout_null, R.string.layout_null, R.drawable.twist));
        wheelsList.add(new Adapter(R.string.virtual_name, R.string.virtual_price, R.string.virtual_demont, R.string.layout_null, R.string.layout_null, R.drawable.virtual));
        wheelsList.add(new Adapter(R.string.wires_name, R.string.wires_price, R.string.wires_demont, R.string.layout_null, R.string.layout_null, R.drawable.wires));

        WheelsAdapter adapter = new WheelsAdapter(this, wheelsList);
        recyclerView.setAdapter(adapter);

        new Thread(new Runnable(){
            public void run(){
                final ArrayList<String> urls = new ArrayList<>();
                try {
                    URL url = new URL("https://feluu.pl/wheels.txt");
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(60000);
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String str;
                    while ((str = in.readLine()) != null) {
                        urls.add(str);
                    }
                    in.close();
                } catch (Exception e) {
                    availableWheels.setText(R.string.layout_cannot_retrieve_wheels);
                }
               WheelsTuneActivity.this.runOnUiThread(new Runnable(){
                    public void run(){
                        if (urls.size() == 0) {
                            availableWheels.setText(R.string.layout_cannot_retrieve_wheels);
                        } else {
                            availableWheels.setText(urls.get(0));
                        }
                    }
                });
            }
        }).start();
    }
}