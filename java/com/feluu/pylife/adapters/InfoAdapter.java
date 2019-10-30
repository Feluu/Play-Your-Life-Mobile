package com.feluu.pylife.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<ListModel> {

    private ArrayList<ListModel> dataSet;
    private Context mCtx;

    private static class ViewHolder {
        private TextView firstText, secondText;
    }

    public InfoAdapter(ArrayList<ListModel> data, Context mCtx) {
        super(mCtx, R.layout.info_layout, data);
        this.dataSet = data;
        this.mCtx = mCtx;

    }

   @NonNull
   @Override
   public View getView(int position, View convertView, @NonNull ViewGroup parent) {
       SharedPref sharedPref = new SharedPref(mCtx);
       ListModel adapter = getItem(position);
       ViewHolder viewHolder;
       if (convertView == null) {
           viewHolder = new ViewHolder();
           LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.info_layout, parent, false);
           viewHolder.firstText = convertView.findViewById(R.id.firstText);
           viewHolder.secondText = convertView.findViewById(R.id.secondText);
           convertView.setTag(viewHolder);
       } else {
           viewHolder = (ViewHolder) convertView.getTag();
       }
       if (adapter != null) {
           viewHolder.firstText.setText(adapter.getFirst());
           viewHolder.secondText.setText(adapter.getSecond());
       } else {
           Toast.makeText(mCtx, R.string.error, Toast.LENGTH_SHORT).show();
       }
       if (sharedPref.loadNightModeState()) {
           viewHolder.firstText.setTextColor(mCtx.getResources().getColor(R.color.colorInfo));
           viewHolder.secondText.setTextColor(mCtx.getResources().getColor(R.color.colorInfoT));
       }
       return convertView;
   }
}
