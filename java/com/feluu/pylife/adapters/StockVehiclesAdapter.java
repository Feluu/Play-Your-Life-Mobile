package com.feluu.pylife.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.feluu.pylife.R;
import com.feluu.pylife.models.VehicleStock;

import java.util.List;

public class StockVehiclesAdapter extends PagerAdapter {

    Context mCtx;
    List<VehicleStock> vehicleStockList;

    public StockVehiclesAdapter(Context mCtx, List<VehicleStock> vehicleStockList) {
        this.mCtx = mCtx;
        this.vehicleStockList = vehicleStockList;
    }

    @Override
    public int getCount() {
        return vehicleStockList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView nameTxt, priceTxt, locTxt, add_infoTxt;
        ImageView imageImg;
        LayoutInflater inflater;
        inflater = LayoutInflater.from(mCtx);

        View itemView = inflater.inflate(R.layout.item_vehicle_stock, container, false);

        nameTxt = itemView.findViewById(R.id.nazwaText);
        imageImg = itemView.findViewById(R.id.pojazdObraz);
        priceTxt = itemView.findViewById(R.id.cenaText);
        locTxt = itemView.findViewById(R.id.miejsceText);
        add_infoTxt = itemView.findViewById(R.id.dodatkowe_infoText);

        nameTxt.setText(vehicleStockList.get(position).getName());
        Glide
                .with(mCtx)
                .load(vehicleStockList.get(position).getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageImg);
        priceTxt.setText(vehicleStockList.get(position).getPrice().concat("€"));
        locTxt.setText(vehicleStockList.get(position).getLocation());
        add_infoTxt.setText(vehicleStockList.get(position).getAdditionalInfo());

        container.addView(itemView);

        return itemView;
    }
}

