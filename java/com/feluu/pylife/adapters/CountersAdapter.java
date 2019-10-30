package com.feluu.pylife.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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

public class CountersAdapter extends RecyclerView.Adapter<CountersAdapter.CountersViewHolder> {

    private Context mCtx;
    private List<ListModel> countersList;

    public CountersAdapter(Context mCtx, List<ListModel> countersList) {
        this.mCtx = mCtx;
        this.countersList = countersList;
    }

    @NonNull
    @Override
    public CountersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.counters_layout, parent,false);
        return new CountersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountersViewHolder holder, int position) {
        ListModel counters = countersList.get(position);

        holder.cardContainer.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale));

        holder.textViewName.setText(counters.getFirst());
        holder.textViewPrice.setText(counters.getSecond());
        holder.textViewRange.setText(counters.getThird());
        Glide
                .with(mCtx)
                .load(ContextCompat.getDrawable(mCtx, counters.getImage()))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
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
        private CardView cardContainer;

        CountersViewHolder(View itemView) {
            super(itemView);

            cardContainer = itemView.findViewById(R.id.card_view2);
            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewRange = itemView.findViewById(R.id.demont);
            textViewPrice = itemView.findViewById(R.id.price);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
