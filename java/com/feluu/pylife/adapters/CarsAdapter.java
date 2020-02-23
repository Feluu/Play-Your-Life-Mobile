package com.feluu.pylife.adapters;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.VisualActivity;
import com.feluu.pylife.models.ListModel;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> implements Filterable {

    private Context mCtx;
    private List<ListModel> carsList;
    private List<ListModel> carsListFull;
    private Activity activity;
    private final OnClickListener mOnClickListener = new MyOnClickListener();

    public CarsAdapter(Activity a, Context mCtx, List<ListModel> carsList) {
        this.activity = a;
        this.mCtx = mCtx;
        this.carsList = carsList;
        carsListFull = new ArrayList<>(carsList);
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        view.setOnClickListener(mOnClickListener);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        ListModel cars = carsList.get(position);

        holder.cardContainer.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale));
        holder.textViewName.setText(cars.getFirst());
        holder.textViewVMax.setText(cars.getSecond());
        holder.textViewVMaxFMK.setText(cars.getThird());
        holder.textViewTax.setText(cars.getFourth());
        holder.textViewReset.setText(cars.getFifth());
        Glide
                .with(mCtx)
                .load(ContextCompat.getDrawable(mCtx, cars.getImage()))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
        if (cars.getFirst().equalsIgnoreCase("elegy") || cars.getFirst().equalsIgnoreCase("jester") || cars.getFirst().equalsIgnoreCase("uranus") || cars.getFirst().equalsIgnoreCase("sultan") || cars.getFirst().equalsIgnoreCase("stratum") || cars.getFirst().equalsIgnoreCase("perennial") || cars.getFirst().equalsIgnoreCase("premier") || cars.getFirst().equalsIgnoreCase("zr-350") || cars.getFirst().equalsIgnoreCase("phoenix")) {
            holder.textViewWizu.setVisibility(View.VISIBLE);
        } else {
            holder.textViewWizu.setVisibility(View.GONE);
        }
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
                    if (model.getFirst().toLowerCase().contains(filterPattern)) {
                        filteredList.add(model);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            carsList.clear();
            carsList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class CarsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewVMax, textViewVMaxFMK, textViewTax, textViewReset, textViewWizu;
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
            textViewWizu = itemView.findViewById(R.id.wizu);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }

    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView carName = v.findViewById(R.id.wheelsName);
            String carNameS = carName.getText().toString();
            if (carNameS.equalsIgnoreCase("elegy") || carNameS.equalsIgnoreCase("jester") || carNameS.equalsIgnoreCase("sultan") || carNameS.equalsIgnoreCase("uranus") || carNameS.equalsIgnoreCase("stratum") || carNameS.equalsIgnoreCase("perennial") || carNameS.equalsIgnoreCase("premier") || carNameS.equalsIgnoreCase("zr-350") || carNameS.equalsIgnoreCase("phoenix")) {
                Intent intent = new Intent(activity, VisualActivity.class);
                intent.putExtra("carName", carNameS);
                activity.startActivity(intent);
            }
        }
    }
}
