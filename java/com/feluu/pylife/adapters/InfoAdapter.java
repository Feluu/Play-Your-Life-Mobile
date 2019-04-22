package com.feluu.pylife.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<ListModel> {

    ArrayList<ListModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        private TextView firstText, secondText;
    }

    public InfoAdapter(ArrayList<ListModel> data, Context context) {
        super(context, R.layout.info_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListModel adapter = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.info_layout, parent, false);
        viewHolder.firstText = convertView.findViewById(R.id.firstText);
        viewHolder.secondText = convertView.findViewById(R.id.secondText);
        viewHolder.firstText.setText(adapter.getName());
        viewHolder.secondText.setText(adapter.getFirst());
        return convertView;
    }
}
