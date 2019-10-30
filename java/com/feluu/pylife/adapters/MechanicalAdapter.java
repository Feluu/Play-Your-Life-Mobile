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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ListModel;

import java.util.ArrayList;
import java.util.List;

public class MechanicalAdapter extends RecyclerView.Adapter<MechanicalAdapter.MechanicalViewHolder> implements Filterable {

    private Context mCtx;
    private List<ListModel> mechanicalList;
    private List<ListModel> mechanicalListFull;

    public MechanicalAdapter(Context mCtx, List<ListModel> mechanicalList) {
        this.mCtx = mCtx;
        this.mechanicalList = mechanicalList;
        mechanicalListFull = new ArrayList<>(mechanicalList);
    }

    @NonNull
    @Override
    public MechanicalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.mechanical_layout, parent, false);
        return new MechanicalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MechanicalViewHolder holder, int position) {
        ListModel mechanical = mechanicalList.get(position);

        holder.cardContainer.setAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.fade_scale));

        holder.textViewName.setText(mechanical.getFirst());
        holder.textViewAllows.setText(mechanical.getSecond());
        holder.textViewPrice.setText(mechanical.getThird());
        holder.textViewReturn.setText(mechanical.getFourth());
        Glide
                .with(mCtx)
                .load(ContextCompat.getDrawable(mCtx, mechanical.getImage()))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return mechanicalList.size();
    }

    @Override
    public Filter getFilter() {
        return mechanicalFilter;
    }

    private Filter mechanicalFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ListModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mechanicalListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ListModel model : mechanicalListFull) {
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
            mechanicalList.clear();
            mechanicalList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class MechanicalViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewAllows, textViewPrice, textViewReturn;
        private ImageView imageView2;
        private CardView cardContainer;

        MechanicalViewHolder(View itemView) {
            super(itemView);

            cardContainer = itemView.findViewById(R.id.card_view2);
            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewAllows = itemView.findViewById(R.id.allows);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewReturn = itemView.findViewById(R.id.sReturn);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
