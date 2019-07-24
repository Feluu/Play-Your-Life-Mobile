package com.feluu.pylife.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
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

public class WheelsAdapter extends RecyclerView.Adapter<WheelsAdapter.WheelsViewHolder> {

    private Context mCtx;
    private List<ListModel> wheelsList;

    public WheelsAdapter(Context mCtx, List<ListModel> wheelsList) {
        this.mCtx = mCtx;
        this.wheelsList = wheelsList;
    }

    @NonNull
    @Override
    public WheelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.wheels_layout, parent, false);
        return new WheelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WheelsViewHolder holder, int position) {
        ListModel wheels = wheelsList.get(position);

        holder.textViewName.setText(wheels.getName());
        holder.textViewPrice.setText(wheels.getFirst());
        holder.textViewDemont.setText(wheels.getSecond());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(wheels.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return wheelsList.size();
    }

    class WheelsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPrice, textViewDemont;
        private ImageView imageView2;

        WheelsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewDemont = itemView.findViewById(R.id.demont);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
