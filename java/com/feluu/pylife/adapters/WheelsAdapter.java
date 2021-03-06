package com.feluu.pylife.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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

        holder.cardContainer.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale));

        holder.textViewName.setText(wheels.getFirst());
        holder.textViewPrice.setText(wheels.getSecond());
        holder.textViewDemont.setText(wheels.getThird());
        Glide
                .with(mCtx)
                .load(wheels.getImage())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
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
        private CardView cardContainer;

        WheelsViewHolder(View itemView) {
            super(itemView);

            cardContainer = itemView.findViewById(R.id.card_view2);
            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewDemont = itemView.findViewById(R.id.demont);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
