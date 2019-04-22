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

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private Context mCtx;
    private List<ListModel> carsList;

    public CarsAdapter(Context mCtx, List<ListModel> carsList) {
        this.mCtx = mCtx;
        this.carsList = carsList;
    }

    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarsViewHolder holder, int position) {
        ListModel cars = carsList.get(position);

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

    class CarsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewVMax, textViewVMaxFMK, textViewTax, textViewReset;
        private ImageView imageView2;

        public CarsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewVMax = itemView.findViewById(R.id.vMax);
            textViewVMaxFMK = itemView.findViewById(R.id.vMaxFMK);
            textViewTax = itemView.findViewById(R.id.tax);
            textViewReset = itemView.findViewById(R.id.reset);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
