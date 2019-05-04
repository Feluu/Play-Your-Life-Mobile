package com.feluu.pylife;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feluu.pylife.adapters.WheelsAdapter;
import com.feluu.pylife.models.ListModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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
        TextView wheels;

        leaveActivity = findViewById(R.id.exitActivity);
        activityTitle = findViewById(R.id.textView1);
        wheels = findViewById(R.id.available);

        List<ListModel> wheelsList;
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

        wheelsList.add(new ListModel(intToString(R.string.ahab_name), intToString(R.string.ahab_price), intToString(R.string.ahab_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.ahab));
        wheelsList.add(new ListModel(intToString(R.string.classic_name), intToString(R.string.classic_price), intToString(R.string.classic_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.classic));
        wheelsList.add(new ListModel(intToString(R.string.cutter_name), intToString(R.string.cutter_price), intToString(R.string.cutter_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.cutter));
        wheelsList.add(new ListModel(intToString(R.string.dollar_name), intToString(R.string.dollar_price), intToString(R.string.dollar_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.dollar));
        wheelsList.add(new ListModel(intToString(R.string.grove_name), intToString(R.string.grove_price), intToString(R.string.grove_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.grove));
        wheelsList.add(new ListModel(intToString(R.string.import_name), intToString(R.string.import_price), intToString(R.string.import_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.importy));
        wheelsList.add(new ListModel(intToString(R.string.mega_name), intToString(R.string.mega_price), intToString(R.string.mega_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.mega));
        wheelsList.add(new ListModel(intToString(R.string.mesh_name), intToString(R.string.mesh_price), intToString(R.string.mesh_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.mesh));
        wheelsList.add(new ListModel(intToString(R.string.offroad_name), intToString(R.string.offroad_price), intToString(R.string.offroad_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.offroad));
        wheelsList.add(new ListModel(intToString(R.string.rimshine_name), intToString(R.string.rimshine_price), intToString(R.string.rimshine_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.rimshine));
        wheelsList.add(new ListModel(intToString(R.string.rittle_name), intToString(R.string.rittle_price), intToString(R.string.rittle_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.rittle));
        wheelsList.add(new ListModel(intToString(R.string.stalowe_name), intToString(R.string.stalowe_price), intToString(R.string.stalowe_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.stalowe));
        wheelsList.add(new ListModel(intToString(R.string.switch_name), intToString(R.string.switch_price), intToString(R.string.switch_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.switche));
        wheelsList.add(new ListModel(intToString(R.string.timer_name), intToString(R.string.timer_price), intToString(R.string.timer_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.timer));
        wheelsList.add(new ListModel(intToString(R.string.twist_name), intToString(R.string.twist_price), intToString(R.string.twist_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.twist));
        wheelsList.add(new ListModel(intToString(R.string.virtual_name), intToString(R.string.virtual_price), intToString(R.string.virtual_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.virtual));
        wheelsList.add(new ListModel(intToString(R.string.wires_name), intToString(R.string.wires_price), intToString(R.string.wires_demont), intToString(R.string.layout_null), intToString(R.string.layout_null), R.drawable.wires));

        WheelsAdapter adapter = new WheelsAdapter(this, wheelsList);
        recyclerView.setAdapter(adapter);

        try {
            URL url = new URL("https://feluu.pl/wheels.txt");
            new ReadWheelsTask().execute(url);
        } catch (MalformedURLException e) {
            wheels.setText(R.string.layout_cannot_retrieve_wheels);
        }
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }

    private class ReadWheelsTask extends AsyncTask<URL, Void, String> {

        String str = null;

        @Override
        protected String doInBackground(URL... urls) {
            TextView wheels = findViewById(R.id.available);
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(urls[0].openStream()));
                str = in.readLine();
                in.close();
            } catch (IOException e) {
                wheels.setText(R.string.layout_cannot_retrieve_wheels);
            }
            return str;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView wheels = findViewById(R.id.available);
            wheels.setText(str);
        }
    }
}
