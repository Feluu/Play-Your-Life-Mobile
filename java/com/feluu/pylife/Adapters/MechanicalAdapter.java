package com.feluu.pylife.Adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.feluu.pylife.R;

import java.util.List;

public class MechanicalAdapter extends RecyclerView.Adapter<MechanicalAdapter.MechanicalViewHolder> {

    private Context mCtx;
    private List<Adapter> mechanicalList;

    public MechanicalAdapter(Context mCtx, List<Adapter> mechanicalList) {
        this.mCtx = mCtx;
        this.mechanicalList = mechanicalList;
    }

    @Override
    public MechanicalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.mechanical_layout, null);
        return new MechanicalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MechanicalViewHolder holder, int position) {
        Adapter mechanical = mechanicalList.get(position);

        holder.textViewName.setText(mechanical.getName());
        holder.textViewAllows.setText(mechanical.getFirst());
        holder.textViewPrice.setText(mechanical.getSecond());
        holder.textViewReturn.setText(mechanical.getThird());
        Glide
                .with(mCtx)
                .load(mCtx.getResources().getDrawable(mechanical.getImage()))
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        return mechanicalList.size();
    }

    class MechanicalViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewAllows, textViewPrice, textViewReturn;
        private ImageView imageView2;

        public MechanicalViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.wheelsName);
            textViewAllows = itemView.findViewById(R.id.allows);
            textViewPrice = itemView.findViewById(R.id.price);
            textViewReturn = itemView.findViewById(R.id.sReturn);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}