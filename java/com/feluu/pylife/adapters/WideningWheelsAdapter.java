package com.feluu.pylife.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ViewModel;

import java.util.List;

public class WideningWheelsAdapter extends PagerAdapter {

    private List<ViewModel> models;
    private Context context;

    public WideningWheelsAdapter(List<ViewModel> models, Context context) {
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
        TextView name;
        TextView price;
        TextView demont;
        LayoutInflater layoutInflater;

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.available_wheels_layout, container, false);

        imageView = view.findViewById(R.id.imageView2);
        name = view.findViewById(R.id.wheelsName);
        price = view.findViewById(R.id.price);
        demont = view.findViewById(R.id.demont);

        name.setText(models.get(position).getFirst());
        price.setText(models.get(position).getSecond());
        demont.setText(models.get(position).getThird());
        Glide
                .with(context)
                .load( models.get(position).getImage())
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