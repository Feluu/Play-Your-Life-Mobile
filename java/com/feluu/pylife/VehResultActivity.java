package com.feluu.pylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.feluu.pylife.models.Visual;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Objects;

public class VehResultActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerAdapter<?, ?> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veh_result);

        ImageView vehImage = findViewById(R.id.vehImage);
        ImageView leaveImage = findViewById(R.id.leaveImage);
        TextView titleText = findViewById(R.id.title);
        recyclerView = findViewById(R.id.recyclerView);

        leaveImage.setOnClickListener((View v) -> finish());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        String vehicle_image_url = getIntent().getStringExtra("URL_OBRAZU");
        String vehicle_name = getIntent().getStringExtra("NAZWA_POJAZDU");
        String vehicle_id = getIntent().getStringExtra("ID_POJAZDU");

        titleText.setText(vehicle_name);
        Glide
                .with(this)
                .load(vehicle_image_url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(vehImage);

        fetch(vehicle_id);
    }

    private void fetch(String pojazd) {
        Query query = FirebaseDatabase.getInstance()
                .getReference("Pojazdy/".concat(pojazd))
                .child("tune-wizu");

        FirebaseRecyclerOptions<Visual> options =
                new FirebaseRecyclerOptions.Builder<Visual>()
                        .setQuery(query, (@NonNull DataSnapshot snapshot) ->
                                new Visual(Objects.requireNonNull(snapshot.child("nazwa").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("cena").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("demont").getValue()).toString(),
                                        Objects.requireNonNull(snapshot.child("obraz").getValue()).toString())
                        )
                        .build();

        adapter = new FirebaseRecyclerAdapter<Visual, ViewHolder>(options) {
            @Override
            @NonNull
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visual_tune, parent, false);

                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, final int position, @NonNull Visual model) {
                holder.addVisualTune(model.getName(), model.getPrice(), model.getDemont(), model.getImageURL());

                holder.rootView.setOnClickListener((View view) -> createDialog(model.getImageURL()));
            }
        };

        recyclerView.setAdapter(adapter);
    }

    private void createDialog(String imageUrl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(VehResultActivity.this);

        builder.setNegativeButton("Zamknij", (DialogInterface dialog, int which)  -> dialog.dismiss());

        final AlertDialog dialog = builder.create();

        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.dialog_image, null);
        ImageView img = dialogLayout.findViewById(R.id.dialogImage);

        Glide
                .with(VehResultActivity.this)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(img);

        dialog.setView(dialogLayout);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTxt, priceTxt, demontTxt;
        public ImageView imageImg;
        public RelativeLayout rootView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.nazwaText);
            priceTxt = itemView.findViewById(R.id.cenaText);
            demontTxt = itemView.findViewById(R.id.demontText);
            imageImg = itemView.findViewById(R.id.pojazdObraz);
            rootView = itemView.findViewById(R.id.root);
        }

        public void addVisualTune(String name, String price, String demont, String imageURL) {
            nameTxt.setText(name);
            priceTxt.setText(price);
            demontTxt.setText(demont);
            Glide
                    .with(VehResultActivity.this)
                    .load(imageURL)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageImg);
        }
    }
}