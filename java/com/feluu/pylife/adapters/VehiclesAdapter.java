package com.feluu.pylife.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.R;
import com.feluu.pylife.VehResultActivity;
import com.feluu.pylife.models.Vehicle;
import com.feluu.pylife.utils.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class VehiclesAdapter extends FirebaseRecyclerAdapter<Vehicle, VehiclesAdapter.VehiclesViewHolder> {

    private Context mCtx;

    public VehiclesAdapter(Context mCtx, FirebaseRecyclerOptions<Vehicle> options) {
        super(options, true);
        this.mCtx = mCtx;
    }

    @Override
    @NonNull
    public VehiclesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_vehicle, parent, false);

        return new VehiclesViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(VehiclesViewHolder holder, int position, Vehicle model) {
        holder.addVehicle(model.getName(), model.getImageURL(), model.getVmax(), model.getVmaxFMK(), model.getTax(), model.getReset(), model.getPrice());

        if (model.getTune().toLowerCase().equals("tak")) {
            holder.visuTxt.setVisibility(View.VISIBLE);
        }

        holder.rootView.setOnClickListener((View view) -> {
            Intent intent = new Intent(mCtx, VehResultActivity.class);

            intent.putExtra("URL_OBRAZU", model.getImageURL());
            intent.putExtra("NAZWA_POJAZDU", model.getName());
            intent.putExtra("ID_POJAZDU", model.getId());

            mCtx.startActivity(intent);
        });
    }

    @Override
    protected boolean filterCondition(Vehicle model, String filterPattern) {
        return model.getName().toLowerCase().contains(filterPattern);
    }

    class VehiclesViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxt, vmaxTxt, vmaxFmkTxt, taxTxt, resetTxt, priceTxt, visuTxt;
        ImageView imageImg;
        RelativeLayout rootView;

        VehiclesViewHolder(View itemView) {
            super(itemView);

            rootView = itemView.findViewById(R.id.root);
            nameTxt = itemView.findViewById(R.id.nazwaText);
            imageImg = itemView.findViewById(R.id.pojazdObraz);
            vmaxTxt = itemView.findViewById(R.id.vmaxText);
            vmaxFmkTxt = itemView.findViewById(R.id.vmaxTuneText);
            taxTxt = itemView.findViewById(R.id.podatekText);
            resetTxt = itemView.findViewById(R.id.zerowanieText);
            priceTxt = itemView.findViewById(R.id.cenaText);
            visuTxt = itemView.findViewById(R.id.wizuText);
        }

        public void addVehicle(String name, String imageURL, String vmax, String vmaxFMK, String tax, String reset, String price) {
            nameTxt.setText(name);
            Glide
                    .with(mCtx)
                    .load(imageURL)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageImg);
            vmaxTxt.setText(vmax.concat("km/h"));
            vmaxFmkTxt.setText(vmaxFMK.concat("km/h"));
            taxTxt.setText(tax.concat("€"));
            resetTxt.setText(reset.concat("€"));
            priceTxt.setText(price.concat("€"));
        }
    }
}
