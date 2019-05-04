package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.feluu.pylife.adapters.CarsAdapter;
import com.feluu.pylife.models.ListModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView leaveActivity;
        TextView activityTitle;

        leaveActivity = findViewById(R.id.exitActivity);
        activityTitle = findViewById(R.id.textView1);
        recyclerView = findViewById(R.id.recyclerView);
        activityTitle.setText(R.string.cars_list_activity);

        leaveActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addCarsToRecycler();
    }

    private void addCarsToRecycler() {
        List<ListModel> carsList;

        carsList = new ArrayList<>();
        carsList.add(new ListModel(intToString(R.string.admiral_name), intToString(R.string.admiral_vmax), intToString(R.string.admiral_vmaxfmk), intToString(R.string.admiral_tax), intToString(R.string.admiral_reset), R.drawable.admiral));
        carsList.add(new ListModel(intToString(R.string.alpha_name), intToString(R.string.alpha_vmax), intToString(R.string.alpha_vmaxfmk), intToString(R.string.alpha_tax), intToString(R.string.alpha_reset), R.drawable.alpha));
        carsList.add(new ListModel(intToString(R.string.bandito_name), intToString(R.string.bandito_vmax), intToString(R.string.bandito_vmaxfmk), intToString(R.string.bandito_tax), intToString(R.string.bandito_reset), R.drawable.bandito));
        carsList.add(new ListModel(intToString(R.string.banshee_name), intToString(R.string.banshee_vmax), intToString(R.string.banshee_vmaxfmk), intToString(R.string.banshee_tax), intToString(R.string.banshee_reset), R.drawable.banshee));
        carsList.add(new ListModel(intToString(R.string.bf_name), intToString(R.string.bf_vmax), intToString(R.string.bf_vmaxfmk), intToString(R.string.bf_tax), intToString(R.string.bf_reset), R.drawable.bf));
        carsList.add(new ListModel(intToString(R.string.bf400_name), intToString(R.string.bf400_vmax), intToString(R.string.bf400_vmaxfmk), intToString(R.string.bf400_tax), intToString(R.string.bf400_reset), R.drawable.bf400));
        carsList.add(new ListModel(intToString(R.string.blade_name), intToString(R.string.blade_vmax), intToString(R.string.blade_vmaxfmk), intToString(R.string.blade_tax), intToString(R.string.blade_reset), R.drawable.blade));
        carsList.add(new ListModel(intToString(R.string.blista_name), intToString(R.string.blista_vmax), intToString(R.string.blista_vmaxfmk), intToString(R.string.blista_tax), intToString(R.string.blista_reset), R.drawable.blista));
        carsList.add(new ListModel(intToString(R.string.bobcat_name), intToString(R.string.bobcat_vmax), intToString(R.string.bobcat_vmaxfmk), intToString(R.string.bobcat_tax), intToString(R.string.bobcat_reset), R.drawable.bobcat));
        carsList.add(new ListModel(intToString(R.string.bravura_name), intToString(R.string.bravura_vmax), intToString(R.string.bravura_vmaxfmk), intToString(R.string.bravura_tax), intToString(R.string.bravura_reset), R.drawable.bravura));
        carsList.add(new ListModel(intToString(R.string.broadway_name), intToString(R.string.broadway_vmax), intToString(R.string.broadway_vmaxfmk), intToString(R.string.broadway_tax), intToString(R.string.broadway_reset), R.drawable.broadway));
        carsList.add(new ListModel(intToString(R.string.bucaner_name), intToString(R.string.bucaner_vmax), intToString(R.string.bucaner_vmaxfmk), intToString(R.string.bucaner_tax), intToString(R.string.bucaner_reset), R.drawable.bucaner));
        carsList.add(new ListModel(intToString(R.string.buffalo_name), intToString(R.string.buffalo_vmax), intToString(R.string.buffalo_vmaxfmk), intToString(R.string.buffalo_tax), intToString(R.string.buffalo_reset), R.drawable.buffalo));
        carsList.add(new ListModel(intToString(R.string.bullet_name), intToString(R.string.bullet_vmax), intToString(R.string.bullet_vmaxfmk), intToString(R.string.bullet_tax), intToString(R.string.bullet_reset), R.drawable.bullet));
        carsList.add(new ListModel(intToString(R.string.burrito_name), intToString(R.string.burrito_vmax), intToString(R.string.burrito_vmaxfmk), intToString(R.string.burrito_tax), intToString(R.string.burrito_reset), R.drawable.burrito));
        carsList.add(new ListModel(intToString(R.string.cadrona_name), intToString(R.string.cadrona_vmax), intToString(R.string.cadrona_vmaxfmk), intToString(R.string.cadrona_tax), intToString(R.string.cadrona_reset), R.drawable.cadrona));
        carsList.add(new ListModel(intToString(R.string.camper_name), intToString(R.string.camper_vmax), intToString(R.string.camper_vmaxfmk), intToString(R.string.camper_tax), intToString(R.string.camper_reset), R.drawable.camper));
        carsList.add(new ListModel(intToString(R.string.cheetah_name), intToString(R.string.cheetah_vmax), intToString(R.string.cheetah_vmaxfmk), intToString(R.string.cheetah_tax), intToString(R.string.cheetah_reset), R.drawable.cheetah));
        carsList.add(new ListModel(intToString(R.string.clover_name), intToString(R.string.clover_vmax), intToString(R.string.clover_vmaxfmk), intToString(R.string.clover_tax), intToString(R.string.clover_reset), R.drawable.clover));
        carsList.add(new ListModel(intToString(R.string.club_name), intToString(R.string.club_vmax), intToString(R.string.club_vmaxfmk), intToString(R.string.club_tax), intToString(R.string.club_reset), R.drawable.club));
        carsList.add(new ListModel(intToString(R.string.comet_name), intToString(R.string.comet_vmax), intToString(R.string.comet_vmaxfmk), intToString(R.string.comet_tax), intToString(R.string.comet_reset), R.drawable.comet));
        carsList.add(new ListModel(intToString(R.string.elegant_name), intToString(R.string.elegant_vmax), intToString(R.string.elegant_vmaxfmk), intToString(R.string.elegant_tax), intToString(R.string.elegant_reset), R.drawable.elegant));
        carsList.add(new ListModel(intToString(R.string.elegy_name), intToString(R.string.elegy_vmax), intToString(R.string.elegy_vmaxfmk), intToString(R.string.elegy_tax), intToString(R.string.elegy_reset), R.drawable.elegy));
        carsList.add(new ListModel(intToString(R.string.emperor_name), intToString(R.string.emperor_vmax), intToString(R.string.emperor_vmaxfmk), intToString(R.string.emperor_tax), intToString(R.string.emperor_reset), R.drawable.emperor));
        carsList.add(new ListModel(intToString(R.string.esperanto_name), intToString(R.string.esperanto_vmax), intToString(R.string.esperanto_vmaxfmk), intToString(R.string.esperanto_tax), intToString(R.string.esperanto_reset), R.drawable.esperanto));
        carsList.add(new ListModel(intToString(R.string.euros_name), intToString(R.string.euros_vmax), intToString(R.string.euros_vmaxfmk), intToString(R.string.euros_tax), intToString(R.string.euros_reset), R.drawable.euros));
        carsList.add(new ListModel(intToString(R.string.faggio_name), intToString(R.string.faggio_vmax), intToString(R.string.faggio_vmaxfmk), intToString(R.string.faggio_tax), intToString(R.string.faggio_reset), R.drawable.faggio));
        carsList.add(new ListModel(intToString(R.string.fcr900_name), intToString(R.string.fcr900_vmax), intToString(R.string.fcr900_vmaxfmk), intToString(R.string.fcr900_tax), intToString(R.string.fcr900_reset), R.drawable.fcr900));
        carsList.add(new ListModel(intToString(R.string.feltzer_name), intToString(R.string.feltzer_vmax), intToString(R.string.feltzer_vmaxfmk), intToString(R.string.feltzer_tax), intToString(R.string.feltzer_reset), R.drawable.feltzer));
        carsList.add(new ListModel(intToString(R.string.flash_name), intToString(R.string.flash_vmax), intToString(R.string.flash_vmaxfmk), intToString(R.string.flash_tax), intToString(R.string.flash_reset), R.drawable.flash));
        carsList.add(new ListModel(intToString(R.string.fortune_name), intToString(R.string.fortune_vmax), intToString(R.string.fortune_vmaxfmk), intToString(R.string.fortune_tax), intToString(R.string.fortune_reset), R.drawable.fortune));
        carsList.add(new ListModel(intToString(R.string.freeway_name), intToString(R.string.freeway_vmax), intToString(R.string.freeway_vmaxfmk), intToString(R.string.freeway_tax), intToString(R.string.freeway_reset), R.drawable.freeway));
        carsList.add(new ListModel(intToString(R.string.glendale_name), intToString(R.string.glendale_vmax), intToString(R.string.glendale_vmaxfmk), intToString(R.string.glendale_tax), intToString(R.string.glendale_reset), R.drawable.glendale));
        carsList.add(new ListModel(intToString(R.string.greenwood_name), intToString(R.string.greenwood_vmax), intToString(R.string.greenwood_vmaxfmk), intToString(R.string.greenwood_tax), intToString(R.string.greenwood_reset), R.drawable.greenwood));
        carsList.add(new ListModel(intToString(R.string.hermes_name), intToString(R.string.hermes_vmax), intToString(R.string.hermes_vmaxfmk), intToString(R.string.hermes_tax), intToString(R.string.hermes_reset), R.drawable.hermes));
        carsList.add(new ListModel(intToString(R.string.hotknife_name), intToString(R.string.hotknife_vmax), intToString(R.string.hotknife_vmaxfmk), intToString(R.string.hotknife_tax), intToString(R.string.hotknife_reset), R.drawable.hotknife));
        carsList.add(new ListModel(intToString(R.string.huntley_name), intToString(R.string.huntley_vmax), intToString(R.string.huntley_vmaxfmk), intToString(R.string.huntley_tax), intToString(R.string.huntley_reset), R.drawable.huntley));
        carsList.add(new ListModel(intToString(R.string.hustler_name), intToString(R.string.hustler_vmax), intToString(R.string.hustler_vmaxfmk), intToString(R.string.hustler_tax), intToString(R.string.hustler_reset), R.drawable.hustler));
        carsList.add(new ListModel(intToString(R.string.infernus_name), intToString(R.string.infernus_vmax), intToString(R.string.infernus_vmaxfmk), intToString(R.string.infernus_tax), intToString(R.string.infernus_reset), R.drawable.infernus));
        carsList.add(new ListModel(intToString(R.string.intruder_name), intToString(R.string.intruder_vmax), intToString(R.string.intruder_vmaxfmk), intToString(R.string.intruder_tax), intToString(R.string.intruder_reset), R.drawable.intruder));
        carsList.add(new ListModel(intToString(R.string.jester_name), intToString(R.string.jester_vmax), intToString(R.string.jester_vmaxfmk), intToString(R.string.jester_tax), intToString(R.string.jester_reset), R.drawable.jester));
        carsList.add(new ListModel(intToString(R.string.journey_name), intToString(R.string.journey_vmax), intToString(R.string.journey_vmaxfmk), intToString(R.string.journey_tax), intToString(R.string.journey_reset), R.drawable.journey));
        carsList.add(new ListModel(intToString(R.string.landstalker_name), intToString(R.string.landstalker_vmax), intToString(R.string.landstalker_vmaxfmk), intToString(R.string.landstalker_tax), intToString(R.string.landstalker_reset), R.drawable.landstalker));
        carsList.add(new ListModel(intToString(R.string.majestic_name), intToString(R.string.majestic_vmax), intToString(R.string.majestic_vmaxfmk), intToString(R.string.majestic_tax), intToString(R.string.majestic_reset), R.drawable.majestic));
        carsList.add(new ListModel(intToString(R.string.manana_name), intToString(R.string.manana_vmax), intToString(R.string.manana_vmaxfmk), intToString(R.string.manana_tax), intToString(R.string.manana_reset), R.drawable.manana));
        carsList.add(new ListModel(intToString(R.string.merit_name), intToString(R.string.merit_vmax), intToString(R.string.merit_vmaxfmk), intToString(R.string.merit_tax), intToString(R.string.merit_reset), R.drawable.merit));
        carsList.add(new ListModel(intToString(R.string.mesa_name), intToString(R.string.mesa_vmax), intToString(R.string.mesa_vmaxfmk), intToString(R.string.mesa_tax), intToString(R.string.mesa_reset), R.drawable.mesa));
        carsList.add(new ListModel(intToString(R.string.moonbeam_name), intToString(R.string.moonbeam_vmax), intToString(R.string.moonbeam_vmaxfmk), intToString(R.string.moonbeam_tax), intToString(R.string.moonbeam_reset), R.drawable.moonbeam));
        carsList.add(new ListModel(intToString(R.string.nebula_name), intToString(R.string.nebula_vmax), intToString(R.string.nebula_vmaxfmk), intToString(R.string.nebula_tax), intToString(R.string.nebula_reset), R.drawable.nebula));
        carsList.add(new ListModel(intToString(R.string.nrg500_name), intToString(R.string.nrg500_vmax), intToString(R.string.nrg500_vmaxfmk), intToString(R.string.nrg500_tax), intToString(R.string.nrg500_reset), R.drawable.nrg500));
        carsList.add(new ListModel(intToString(R.string.oceanic_name), intToString(R.string.oceanic_vmax), intToString(R.string.oceanic_vmaxfmk), intToString(R.string.oceanic_tax), intToString(R.string.oceanic_reset), R.drawable.oceanic));
        carsList.add(new ListModel(intToString(R.string.patriot_name), intToString(R.string.patriot_vmax), intToString(R.string.patriot_vmaxfmk), intToString(R.string.patriot_tax), intToString(R.string.patriot_reset), R.drawable.patriot));
        carsList.add(new ListModel(intToString(R.string.pcj600_name), intToString(R.string.pcj600_vmax), intToString(R.string.pcj600_vmaxfmk), intToString(R.string.pcj600_tax), intToString(R.string.pcj600_reset), R.drawable.pcj600));
        carsList.add(new ListModel(intToString(R.string.perennial_name), intToString(R.string.perennial_vmax), intToString(R.string.perennial_vmaxfmk), intToString(R.string.perennial_tax), intToString(R.string.perennial_reset), R.drawable.perennial));
        carsList.add(new ListModel(intToString(R.string.phoenix_name), intToString(R.string.phoenix_vmax), intToString(R.string.phoenix_vmaxfmk), intToString(R.string.phoenix_tax), intToString(R.string.phoenix_reset), R.drawable.phoenix));
        carsList.add(new ListModel(intToString(R.string.picador_name), intToString(R.string.picador_vmax), intToString(R.string.picador_vmaxfmk), intToString(R.string.picador_tax), intToString(R.string.picador_reset), R.drawable.picador));
        carsList.add(new ListModel(intToString(R.string.pony_name), intToString(R.string.pony_vmax), intToString(R.string.pony_vmaxfmk), intToString(R.string.pony_tax), intToString(R.string.pony_reset), R.drawable.pony));
        carsList.add(new ListModel(intToString(R.string.premier_name), intToString(R.string.premier_vmax), intToString(R.string.premier_vmaxfmk), intToString(R.string.premier_tax), intToString(R.string.premier_reset), R.drawable.premier));
        carsList.add(new ListModel(intToString(R.string.previon_name), intToString(R.string.previon_vmax), intToString(R.string.previon_vmaxfmk), intToString(R.string.previon_tax), intToString(R.string.previon_reset), R.drawable.previon));
        carsList.add(new ListModel(intToString(R.string.primo_name), intToString(R.string.primo_vmax), intToString(R.string.primo_vmaxfmk), intToString(R.string.primo_tax), intToString(R.string.primo_reset), R.drawable.primo));
        carsList.add(new ListModel(intToString(R.string.quad_name), intToString(R.string.quad_vmax), intToString(R.string.quad_vmaxfmk), intToString(R.string.quad_tax), intToString(R.string.quad_reset), R.drawable.quad));
        carsList.add(new ListModel(intToString(R.string.rancher_name), intToString(R.string.rancher_vmax), intToString(R.string.rancher_vmaxfmk), intToString(R.string.rancher_tax), intToString(R.string.rancher_reset), R.drawable.rancher));
        carsList.add(new ListModel(intToString(R.string.regina_name), intToString(R.string.regina_vmax), intToString(R.string.regina_vmaxfmk), intToString(R.string.regina_tax), intToString(R.string.regina_reset), R.drawable.regina));
        carsList.add(new ListModel(intToString(R.string.remington_name), intToString(R.string.remington_vmax), intToString(R.string.remington_vmaxfmk), intToString(R.string.remington_tax), intToString(R.string.remington_reset), R.drawable.remington));
        carsList.add(new ListModel(intToString(R.string.sabre_name), intToString(R.string.sabre_vmax), intToString(R.string.sabre_vmaxfmk), intToString(R.string.sabre_tax), intToString(R.string.sabre_reset), R.drawable.sabre));
        carsList.add(new ListModel(intToString(R.string.sadler_name), intToString(R.string.sadler_vmax), intToString(R.string.sadler_vmaxfmk), intToString(R.string.sadler_tax), intToString(R.string.sadler_reset), R.drawable.sadler));
        carsList.add(new ListModel(intToString(R.string.sanchez_name), intToString(R.string.sanchez_vmax), intToString(R.string.sanchez_vmaxfmk), intToString(R.string.sanchez_tax), intToString(R.string.sanchez_reset), R.drawable.sanchez));
        carsList.add(new ListModel(intToString(R.string.sandking_name), intToString(R.string.sandking_vmax), intToString(R.string.sandking_vmaxfmk), intToString(R.string.sandking_tax), intToString(R.string.sandking_reset), R.drawable.sandking));
        carsList.add(new ListModel(intToString(R.string.savanna_name), intToString(R.string.savanna_vmax), intToString(R.string.savanna_vmaxfmk), intToString(R.string.savanna_tax), intToString(R.string.savanna_reset), R.drawable.savanna));
        carsList.add(new ListModel(intToString(R.string.sentinel_name), intToString(R.string.sentinel_vmax), intToString(R.string.sentinel_vmaxfmk), intToString(R.string.sentinel_tax), intToString(R.string.sentinel_reset), R.drawable.sentinel));
        carsList.add(new ListModel(intToString(R.string.slamvan_name), intToString(R.string.slamvan_vmax), intToString(R.string.slamvan_vmaxfmk), intToString(R.string.slamvan_tax), intToString(R.string.slamvan_reset), R.drawable.slamvan));
        carsList.add(new ListModel(intToString(R.string.solair_name), intToString(R.string.solair_vmax), intToString(R.string.solair_vmaxfmk), intToString(R.string.solair_tax), intToString(R.string.solair_reset), R.drawable.solair));
        carsList.add(new ListModel(intToString(R.string.stafford_name), intToString(R.string.stafford_vmax), intToString(R.string.stafford_vmaxfmk), intToString(R.string.stafford_tax), intToString(R.string.stafford_reset), R.drawable.stafford));
        carsList.add(new ListModel(intToString(R.string.stallion_name), intToString(R.string.stallion_vmax), intToString(R.string.stallion_vmaxfmk), intToString(R.string.stallion_tax), intToString(R.string.stallion_reset), R.drawable.stallion));
        carsList.add(new ListModel(intToString(R.string.stratum_name), intToString(R.string.stratum_vmax), intToString(R.string.stratum_vmaxfmk), intToString(R.string.stratum_tax), intToString(R.string.stratum_reset), R.drawable.stratum));
        carsList.add(new ListModel(intToString(R.string.stretch_name), intToString(R.string.stretch_vmax), intToString(R.string.stretch_vmaxfmk), intToString(R.string.stretch_tax), intToString(R.string.stretch_reset), R.drawable.stretch));
        carsList.add(new ListModel(intToString(R.string.sultan_name), intToString(R.string.sultan_vmax), intToString(R.string.sultan_vmaxfmk), intToString(R.string.sultan_tax), intToString(R.string.sultan_reset), R.drawable.sultan));
        carsList.add(new ListModel(intToString(R.string.sunrise_name), intToString(R.string.sunrise_vmax), intToString(R.string.sunrise_vmaxfmk), intToString(R.string.sunrise_tax), intToString(R.string.sunrise_reset), R.drawable.sunrise));
        carsList.add(new ListModel(intToString(R.string.supergt_name), intToString(R.string.supergt_vmax), intToString(R.string.supergt_vmaxfmk), intToString(R.string.supergt_tax), intToString(R.string.supergt_reset), R.drawable.supergt));
        carsList.add(new ListModel(intToString(R.string.tahoma_name), intToString(R.string.tahoma_vmax), intToString(R.string.tahoma_vmaxfmk), intToString(R.string.tahoma_tax), intToString(R.string.tahoma_reset), R.drawable.tahoma));
        carsList.add(new ListModel(intToString(R.string.tampa_name), intToString(R.string.tampa_vmax), intToString(R.string.tampa_vmaxfmk), intToString(R.string.tampa_tax), intToString(R.string.tampa_reset), R.drawable.tampa));
        carsList.add(new ListModel(intToString(R.string.tornado_name), intToString(R.string.tornado_vmax), intToString(R.string.tornado_vmaxfmk), intToString(R.string.tornado_tax), intToString(R.string.tornado_reset), R.drawable.tornado));
        carsList.add(new ListModel(intToString(R.string.turismo_name), intToString(R.string.turismo_vmax), intToString(R.string.turismo_vmaxfmk), intToString(R.string.turismo_tax), intToString(R.string.turismo_reset), R.drawable.turismo));
        carsList.add(new ListModel(intToString(R.string.uranus_name), intToString(R.string.uranus_vmax), intToString(R.string.uranus_vmaxfmk), intToString(R.string.uranus_tax), intToString(R.string.uranus_reset), R.drawable.uranus));
        carsList.add(new ListModel(intToString(R.string.vincent_name), intToString(R.string.vincent_vmax), intToString(R.string.vincent_vmaxfmk), intToString(R.string.vincent_tax), intToString(R.string.vincent_reset), R.drawable.vincent));
        carsList.add(new ListModel(intToString(R.string.virgo_name), intToString(R.string.virgo_vmax), intToString(R.string.virgo_vmaxfmk), intToString(R.string.virgo_tax), intToString(R.string.virgo_reset), R.drawable.virgo));
        carsList.add(new ListModel(intToString(R.string.voodoo_name), intToString(R.string.voodoo_vmax), intToString(R.string.voodoo_vmaxfmk), intToString(R.string.voodoo_tax), intToString(R.string.voodoo_reset), R.drawable.voodoo));
        carsList.add(new ListModel(intToString(R.string.walton_name), intToString(R.string.walton_vmax), intToString(R.string.walton_vmaxfmk), intToString(R.string.walton_tax), intToString(R.string.walton_reset), R.drawable.walton));
        carsList.add(new ListModel(intToString(R.string.washington_name), intToString(R.string.washington_vmax), intToString(R.string.washington_vmaxfmk), intToString(R.string.washingtona_tax), intToString(R.string.washington_reset), R.drawable.washington));
        carsList.add(new ListModel(intToString(R.string.wayfarer_name), intToString(R.string.wayfarer_vmax), intToString(R.string.wayfarer_vmaxfmk), intToString(R.string.wayfarer_tax), intToString(R.string.wayfarer_reset), R.drawable.wayfarer));
        carsList.add(new ListModel(intToString(R.string.willard_name), intToString(R.string.willard_vmax), intToString(R.string.willard_vmaxfmk), intToString(R.string.willard_tax), intToString(R.string.willard_reset), R.drawable.willard));
        carsList.add(new ListModel(intToString(R.string.windsor_name), intToString(R.string.windsor_vmax), intToString(R.string.windsor_vmaxfmk), intToString(R.string.windsor_tax), intToString(R.string.windsor_reset), R.drawable.windsor));
        carsList.add(new ListModel(intToString(R.string.yosemite_name), intToString(R.string.yosemite_vmax), intToString(R.string.yosemite_vmaxfmk), intToString(R.string.yosemite_tax), intToString(R.string.yosemite_reset), R.drawable.yosemite));
        carsList.add(new ListModel(intToString(R.string.zr350_name), intToString(R.string.zr350_vmax), intToString(R.string.zr350_vmaxfmk), intToString(R.string.zr350_tax), intToString(R.string.zr350_reset), R.drawable.zr350));
        CarsAdapter adapter = new CarsAdapter(this, carsList);
        recyclerView.setAdapter(adapter);
    }

    public String intToString(int Res) {
        return getResources().getString(Res);
    }
}
