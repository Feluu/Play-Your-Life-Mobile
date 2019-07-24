package com.feluu.pylife.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;
import com.feluu.pylife.utils.SharedPref;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<ListModel> {

    private ArrayList<ListModel> dataSet;
    private Context mContext;

    private static class ViewHolder {
        private TextView firstText, secondText;
    }

    public InfoAdapter(ArrayList<ListModel> data, Context context) {
        super(context, R.layout.info_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }

   @NonNull
   @Override
   public View getView(int position, View convertView, @NonNull ViewGroup parent) {
       SharedPref sharedPref = new SharedPref(mContext);
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
       viewHolder.firstText.setText(adapter.getName());
       viewHolder.secondText.setText(adapter.getFirst());
       if (sharedPref.loadNightModeState()) {
           viewHolder.firstText.setTextColor(mContext.getResources().getColor(R.color.colorInfo));
           viewHolder.secondText.setTextColor(mContext.getResources().getColor(R.color.colorInfoT));
       }
       return convertView;
   }
}
