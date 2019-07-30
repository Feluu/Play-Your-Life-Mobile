package com.feluu.pylife.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> implements Filterable {

    private Context mCtx;
    private List<ListModel> carsList;
    private List<ListModel> carsListFull;

    public CarsAdapter(Context mCtx, List<ListModel> carsList) {
        this.mCtx = mCtx;
        this.carsList = carsList;
        carsListFull = new ArrayList<>(carsList);
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        ListModel cars = carsList.get(position);

        holder.cardContainer.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale));

        holder.textViewName.setText(cars.getName());
        holder.textViewVMax.setText(cars.getFirst());
        holder.textViewVMaxFMK.setText(cars.getSecond());
        holder.textViewTax.setText(cars.getThird());
        holder.textViewReset.setText(cars.getFourth());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(cars.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    @Override
    public Filter getFilter() {
        return carsFilter;
    }

    private Filter carsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ListModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(carsListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ListModel model : carsListFull) {
                    if (model.getName().toLowerCase().contains(filterPattern)) {
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
            carsList.clear();
            carsList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class CarsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewVMax, textViewVMaxFMK, textViewTax, textViewReset;
        private ImageView imageView2;
        private CardView cardContainer;

        CarsViewHolder(View itemView) {
            super(itemView);

            cardContainer = itemView.findViewById(R.id.card_view2);
            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewVMax = itemView.findViewById(R.id.vMax);
            textViewVMaxFMK = itemView.findViewById(R.id.vMaxFMK);
            textViewTax = itemView.findViewById(R.id.tax);
            textViewReset = itemView.findViewById(R.id.reset);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
