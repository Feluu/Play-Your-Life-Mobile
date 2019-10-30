package com.feluu.pylife.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.feluu.pylife.R;
import com.feluu.pylife.models.ViewModel;

import java.util.List;

public class JobsAdapter extends PagerAdapter {

    private List<ViewModel> models;
    private Context mCtx;

    public JobsAdapter(List<ViewModel> models, Context mCtx) {
        this.models = models;
        this.mCtx = mCtx;
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
        TextView title;
        TextView description;
        TextView earnings;
        TextView locations;
        LayoutInflater layoutInflater;

        layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.job_item, container, false);

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        earnings = view.findViewById(R.id.earnings);
        locations = view.findViewById(R.id.locations);
        description = view.findViewById(R.id.description);

        Glide
                .with(mCtx)
                .load(ContextCompat.getDrawable(mCtx, models.get(position).getImage()))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(imageView);
        title.setText(models.get(position).getFirst());
        earnings.setText(models.get(position).getSecond());
        locations.setText(models.get(position).getThird());
        description.setText(models.get(position).getFourth());

        int width = mCtx.getResources().getDisplayMetrics().widthPixels;
        int height = mCtx.getResources().getDisplayMetrics().heightPixels;
        int DPtoPX = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, mCtx.getResources().getDisplayMetrics());
        if (width * height <= 1024000) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DPtoPX);
            imageView.setLayoutParams(params);
        }

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
