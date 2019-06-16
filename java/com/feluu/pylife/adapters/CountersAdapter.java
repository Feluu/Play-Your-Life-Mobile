package com.feluu.pylife.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;

import java.util.List;

public class CountersAdapter extends RecyclerView.Adapter<CountersAdapter.CountersViewHolder> {

    private Context mCtx;
    private List<ListModel> countersList;

    public CountersAdapter(Context mCtx, List<ListModel> countersList) {
        this.mCtx = mCtx;
        this.countersList = countersList;
    }

    @Override
    public CountersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.counters_layout, null);
        return new CountersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountersViewHolder holder, int position) {
        ListModel counters = countersList.get(position);

        holder.textViewName.setText(counters.getName());
        holder.textViewPrice.setText(counters.getFirst());
        holder.textViewRange.setText(counters.getSecond());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(counters.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return countersList.size();
    }

    class CountersViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPrice, textViewRange;
        private ImageView imageView2;

        public CountersViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewRange = itemView.findViewById(R.id.demont);
            textViewPrice = itemView.findViewById(R.id.price);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}