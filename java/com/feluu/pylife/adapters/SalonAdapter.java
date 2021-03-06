package com.feluu.pylife.adapters;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ViewModel;

import java.util.List;

public class SalonAdapter extends PagerAdapter {

    private List<ViewModel> models;
    private Context context;

    public SalonAdapter(List<ViewModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView;
        TextView nazwa;
        TextView cena;
        TextView dostepne;
        TextView dostepneT;
        LayoutInflater layoutInflater;

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.salon_layout, container, false);

        imageView = view.findViewById(R.id.imageView2);
        nazwa = view.findViewById(R.id.wheelsName);
        cena = view.findViewById(R.id.price);
        dostepne = view.findViewById(R.id.dostepne);
        dostepneT = view.findViewById(R.id.dostepneT);

        nazwa.setText(models.get(position).getFirst());
        cena.setText(models.get(position).getSecond());
        if (models.get(position).getThird().equals("gold")) {
            dostepne.setTextColor(Color.parseColor("#FF8C00"));
            dostepne.setText("graczy GOLD");
        }
        if (models.get(position).getThird().equals("komis")) {
            dostepneT.setText("Średnia cena,\nnie zawiera podatku.");
            dostepne.setVisibility(View.GONE);
        }
        Glide
                .with(context)
                .load(models.get(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
