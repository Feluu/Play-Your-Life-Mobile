package com.feluu.pylife.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ViewModel;

import java.util.List;

public class CyganAdapter extends PagerAdapter {

    private List<ViewModel> models;
    private Context context;

    public CyganAdapter(List<ViewModel> models, Context context) {
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
        TextView przebieg;
        LayoutInflater layoutInflater;

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cygan_layout, container, false);

        imageView = view.findViewById(R.id.imageView2);
        nazwa = view.findViewById(R.id.wheelsName);
        cena = view.findViewById(R.id.price);
        przebieg = view.findViewById(R.id.przebieg);

        nazwa.setText(models.get(position).getFirst());
        cena.setText(models.get(position).getSecond());
        przebieg.setText(models.get(position).getThird());
        Glide
                .with(context)
                .load(ContextCompat.getDrawable(context, models.get(position).getImage()))
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
