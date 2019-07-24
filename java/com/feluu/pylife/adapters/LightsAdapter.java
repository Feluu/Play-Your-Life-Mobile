package com.feluu.pylife.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class LightsAdapter extends RecyclerView.Adapter<LightsAdapter.LightsViewHolder> implements Filterable {

    private Context mCtx;
    private List<ListModel> lightsList;
    private List<ListModel> lightsListFull;

    public LightsAdapter(Context mCtx, List<ListModel> lightsList) {
        this.mCtx = mCtx;
        this.lightsList = lightsList;
        lightsListFull = new ArrayList<>(lightsList);
    }

    @NonNull
    @Override
    public LightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lights_layout, parent, false);
        return new LightsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LightsViewHolder holder, int position) {
        ListModel lights = lightsList.get(position);

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

    @Override
    public Filter getFilter() {
        return lightsFilter;
    }

    private Filter lightsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ListModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(lightsListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ListModel model : lightsListFull) {
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
            lightsList.clear();
            lightsList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class LightsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPrice;
        private ImageView imageView2;

        LightsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewPrice = itemView.findViewById(R.id.price);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
