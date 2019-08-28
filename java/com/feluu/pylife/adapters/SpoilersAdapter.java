package com.feluu.pylife.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;

import java.util.ArrayList;
import java.util.List;

public class SpoilersAdapter extends RecyclerView.Adapter<SpoilersAdapter.SpoilersViewHolder> implements Filterable {

    private Context mCtx;
    private List<ListModel> spoilersList;
    private List<ListModel> spoilersListFull;

    public SpoilersAdapter(Context mCtx, List<ListModel> spoilersList) {
        this.mCtx = mCtx;
        this.spoilersList = spoilersList;
        spoilersListFull = new ArrayList<>(spoilersList);
    }

    @NonNull
    @Override
    public SpoilersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.wheels_layout, parent, false);
        return new SpoilersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpoilersViewHolder holder, int position) {
        ListModel spoilers = spoilersList.get(position);

        holder.cardContainer.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale));

        holder.textViewName.setText(spoilers.getFirst());
        holder.textViewPrice.setText(spoilers.getSecond());
        holder.textViewDemont.setText(spoilers.getThird());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(spoilers.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return spoilersList.size();
    }

    @Override
    public Filter getFilter() {
        return spoilersFilter;
    }

    private Filter spoilersFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ListModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(spoilersListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ListModel model : spoilersListFull) {
                    if (model.getFirst().toLowerCase().contains(filterPattern)) {
                        filteredList.add(model);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            spoilersList.clear();
            spoilersList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class SpoilersViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPrice, textViewDemont;
        private ImageView imageView2;
        private CardView cardContainer;

        SpoilersViewHolder(View itemView) {
            super(itemView);

            cardContainer = itemView.findViewById(R.id.card_view2);
            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewDemont = itemView.findViewById(R.id.demont);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
