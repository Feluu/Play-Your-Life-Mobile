package com.feluu.pylife.Adapters;

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

import java.util.List;

public class LightsAdapter extends RecyclerView.Adapter<LightsAdapter.LightsViewHolder> {

    private Context mCtx;
    private List<Adapter> lightsList;

    public LightsAdapter(Context mCtx, List<Adapter> lightsList) {
        this.mCtx = mCtx;
        this.lightsList = lightsList;
    }

    @Override
    public LightsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lights_layout, null);
        return new LightsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LightsViewHolder holder, int position) {
        Adapter lights = lightsList.get(position);

        holder.textViewName.setText(lights.getName());
        holder.textViewPrice.setText(lights.getFirst());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(lights.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return lightsList.size();
    }

    class LightsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPrice;
        private ImageView imageView2;

        public LightsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewPrice = itemView.findViewById(R.id.price);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}