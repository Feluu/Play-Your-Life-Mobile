package com.feluu.pylife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.feluu.pylife.adapters.Adapter;
import com.feluu.pylife.adapters.CarsAdapter;

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
        List<Adapter> carsList;

        carsList = new ArrayList<>();
        carsList.add(new Adapter(R.string.admiral_name, R.string.admiral_vmax, R.string.admiral_vmaxfmk, R.string.admiral_tax, R.string.admiral_reset, R.drawable.admiral));
        carsList.add(new Adapter(R.string.alpha_name, R.string.alpha_vmax, R.string.alpha_vmaxfmk, R.string.alpha_tax, R.string.alpha_reset, R.drawable.alpha));
        carsList.add(new Adapter(R.string.bandito_name, R.string.bandito_vmax, R.string.bandito_vmaxfmk, R.string.bandito_tax, R.string.bandito_reset, R.drawable.bandito));
        carsList.add(new Adapter(R.string.banshee_name, R.string.banshee_vmax, R.string.banshee_vmaxfmk, R.string.banshee_tax, R.string.banshee_reset, R.drawable.banshee));
        carsList.add(new Adapter(R.string.bf_name, R.string.bf_vmax, R.string.bf_vmaxfmk, R.string.bf_tax, R.string.bf_reset, R.drawable.bf));
        carsList.add(new Adapter(R.string.bf400_name, R.string.bf400_vmax, R.string.bf400_vmaxfmk, R.string.bf400_tax, R.string.bf400_reset, R.drawable.bf400));
        carsList.add(new Adapter(R.string.blade_name, R.string.blade_vmax, R.string.blade_vmaxfmk, R.string.blade_tax, R.string.blade_reset, R.drawable.blade));
        carsList.add(new Adapter(R.string.blista_name, R.string.blista_vmax, R.string.blista_vmaxfmk, R.string.blista_tax, R.string.blista_reset, R.drawable.blista));
        carsList.add(new Adapter(R.string.bobcat_name, R.string.bobcat_vmax, R.string.bobcat_vmaxfmk, R.string.bobcat_tax, R.string.bobcat_reset, R.drawable.bobcat));
        carsList.add(new Adapter(R.string.bravura_name, R.string.bravura_vmax, R.string.bravura_vmaxfmk, R.string.bravura_tax, R.string.bravura_reset, R.drawable.bravura));
        carsList.add(new Adapter(R.string.broadway_name, R.string.broadway_vmax, R.string.broadway_vmaxfmk, R.string.broadway_tax, R.string.broadway_reset, R.drawable.broadway));
        carsList.add(new Adapter(R.string.bucaner_name, R.string.bucaner_vmax, R.string.bucaner_vmaxfmk, R.string.bucaner_tax, R.string.bucaner_reset, R.drawable.bucaner));
        carsList.add(new Adapter(R.string.buffalo_name, R.string.buffalo_vmax, R.string.buffalo_vmaxfmk, R.string.buffalo_tax, R.string.buffalo_reset, R.drawable.buffalo));
        carsList.add(new Adapter(R.string.bullet_name, R.string.bullet_vmax, R.string.bullet_vmaxfmk, R.string.bullet_tax, R.string.bullet_reset, R.drawable.bullet));
        carsList.add(new Adapter(R.string.burrito_name, R.string.burrito_vmax, R.string.burrito_vmaxfmk, R.string.burrito_tax, R.string.burrito_reset, R.drawable.burrito));
        carsList.add(new Adapter(R.string.cadrona_name, R.string.cadrona_vmax, R.string.cadrona_vmaxfmk, R.string.cadrona_tax, R.string.cadrona_reset, R.drawable.cadrona));
        carsList.add(new Adapter(R.string.camper_name, R.string.camper_vmax, R.string.camper_vmaxfmk, R.string.camper_tax, R.string.camper_reset, R.drawable.camper));
        carsList.add(new Adapter(R.string.cheetah_name, R.string.cheetah_vmax, R.string.cheetah_vmaxfmk, R.string.cheetah_tax, R.string.cheetah_reset, R.drawable.cheetah));
        carsList.add(new Adapter(R.string.clover_name, R.string.clover_vmax, R.string.clover_vmaxfmk, R.string.clover_tax, R.string.clover_reset, R.drawable.clover));
        carsList.add(new Adapter(R.string.club_name, R.string.club_vmax, R.string.club_vmaxfmk, R.string.club_tax, R.string.club_reset, R.drawable.club));
        carsList.add(new Adapter(R.string.comet_name, R.string.comet_vmax, R.string.comet_vmaxfmk, R.string.comet_tax, R.string.comet_reset, R.drawable.comet));
        carsList.add(new Adapter(R.string.elegant_name, R.string.elegant_vmax, R.string.elegant_vmaxfmk, R.string.elegant_tax, R.string.elegant_reset, R.drawable.elegant));
        carsList.add(new Adapter(R.string.elegy_name, R.string.elegy_vmax, R.string.elegy_vmaxfmk, R.string.elegy_tax, R.string.elegy_reset, R.drawable.elegy));
        carsList.add(new Adapter(R.string.emperor_name, R.string.emperor_vmax, R.string.emperor_vmaxfmk, R.string.emperor_tax, R.string.emperor_reset, R.drawable.emperor));
        carsList.add(new Adapter(R.string.esperanto_name, R.string.esperanto_vmax, R.string.esperanto_vmaxfmk, R.string.esperanto_tax, R.string.esperanto_reset, R.drawable.esperanto));
        carsList.add(new Adapter(R.string.euros_name, R.string.euros_vmax, R.string.euros_vmaxfmk, R.string.euros_tax, R.string.euros_reset, R.drawable.euros));
        carsList.add(new Adapter(R.string.faggio_name, R.string.faggio_vmax, R.string.faggio_vmaxfmk, R.string.faggio_tax, R.string.faggio_reset, R.drawable.faggio));
        carsList.add(new Adapter(R.string.fcr900_name, R.string.fcr900_vmax, R.string.fcr900_vmaxfmk, R.string.fcr900_tax, R.string.fcr900_reset, R.drawable.fcr900));
        carsList.add(new Adapter(R.string.feltzer_name, R.string.feltzer_vmax, R.string.feltzer_vmaxfmk, R.string.feltzer_tax, R.string.feltzer_reset, R.drawable.feltzer));
        carsList.add(new Adapter(R.string.flash_name, R.string.flash_vmax, R.string.flash_vmaxfmk, R.string.flash_tax, R.string.flash_reset, R.drawable.flash));
        carsList.add(new Adapter(R.string.fortune_name, R.string.fortune_vmax, R.string.fortune_vmaxfmk, R.string.fortune_tax, R.string.fortune_reset, R.drawable.fortune));
        carsList.add(new Adapter(R.string.freeway_name, R.string.freeway_vmax, R.string.freeway_vmaxfmk, R.string.freeway_tax, R.string.freeway_reset, R.drawable.freeway));
        carsList.add(new Adapter(R.string.glendale_name, R.string.glendale_vmax, R.string.glendale_vmaxfmk, R.string.glendale_tax, R.string.glendale_reset, R.drawable.glendale));
        carsList.add(new Adapter(R.string.greenwood_name, R.string.greenwood_vmax, R.string.greenwood_vmaxfmk, R.string.greenwood_tax, R.string.greenwood_reset, R.drawable.greenwood));
        carsList.add(new Adapter(R.string.hermes_name, R.string.hermes_vmax, R.string.hermes_vmaxfmk, R.string.hermes_tax, R.string.hermes_reset, R.drawable.hermes));
        carsList.add(new Adapter(R.string.hotknife_name, R.string.hotknife_vmax, R.string.hotknife_vmaxfmk, R.string.hotknife_tax, R.string.hotknife_reset, R.drawable.hotknife));
        carsList.add(new Adapter(R.string.huntley_name, R.string.huntley_vmax, R.string.huntley_vmaxfmk, R.string.huntley_tax, R.string.huntley_reset, R.drawable.huntley));
        carsList.add(new Adapter(R.string.hustler_name, R.string.hustler_vmax, R.string.hustler_vmaxfmk, R.string.hustler_tax, R.string.hustler_reset, R.drawable.hustler));
        carsList.add(new Adapter(R.string.infernus_name, R.string.infernus_vmax, R.string.infernus_vmaxfmk, R.string.infernus_tax, R.string.infernus_reset, R.drawable.infernus));
        carsList.add(new Adapter(R.string.intruder_name, R.string.intruder_vmax, R.string.intruder_vmaxfmk, R.string.intruder_tax, R.string.intruder_reset, R.drawable.intruder));
        carsList.add(new Adapter(R.string.jester_name, R.string.jester_vmax, R.string.jester_vmaxfmk, R.string.jester_tax, R.string.jester_reset, R.drawable.jester));
        carsList.add(new Adapter(R.string.journey_name, R.string.journey_vmax, R.string.journey_vmaxfmk, R.string.journey_tax, R.string.journey_reset, R.drawable.journey));
        carsList.add(new Adapter(R.string.landstalker_name, R.string.landstalker_vmax, R.string.landstalker_vmaxfmk, R.string.landstalker_tax, R.string.landstalker_reset, R.drawable.landstalker));
        carsList.add(new Adapter(R.string.majestic_name, R.string.majestic_vmax, R.string.majestic_vmaxfmk, R.string.majestic_tax, R.string.majestic_reset, R.drawable.majestic));
        carsList.add(new Adapter(R.string.manana_name, R.string.manana_vmax, R.string.manana_vmaxfmk, R.string.manana_tax, R.string.manana_reset, R.drawable.manana));
        carsList.add(new Adapter(R.string.merit_name, R.string.merit_vmax, R.string.merit_vmaxfmk, R.string.merit_tax, R.string.merit_reset, R.drawable.merit));
        carsList.add(new Adapter(R.string.mesa_name, R.string.mesa_vmax, R.string.mesa_vmaxfmk, R.string.mesa_tax, R.string.mesa_reset, R.drawable.mesa));
        carsList.add(new Adapter(R.string.moonbeam_name, R.string.moonbeam_vmax, R.string.moonbeam_vmaxfmk, R.string.moonbeam_tax, R.string.moonbeam_reset, R.drawable.moonbeam));
        carsList.add(new Adapter(R.string.nebula_name, R.string.nebula_vmax, R.string.nebula_vmaxfmk, R.string.nebula_tax, R.string.nebula_reset, R.drawable.nebula));
        carsList.add(new Adapter(R.string.nrg500_name, R.string.nrg500_vmax, R.string.nrg500_vmaxfmk, R.string.nrg500_tax, R.string.nrg500_reset, R.drawable.nrg500));
        carsList.add(new Adapter(R.string.oceanic_name, R.string.oceanic_vmax, R.string.oceanic_vmaxfmk, R.string.oceanic_tax, R.string.oceanic_reset, R.drawable.oceanic));
        carsList.add(new Adapter(R.string.patriot_name, R.string.patriot_vmax, R.string.patriot_vmaxfmk, R.string.patriot_tax, R.string.patriot_reset, R.drawable.patriot));
        carsList.add(new Adapter(R.string.pcj600_name, R.string.pcj600_vmax, R.string.pcj600_vmaxfmk, R.string.pcj600_tax, R.string.pcj600_reset, R.drawable.pcj600));
        carsList.add(new Adapter(R.string.perennial_name, R.string.perennial_vmax, R.string.perennial_vmaxfmk, R.string.perennial_tax, R.string.perennial_reset, R.drawable.perennial));
        carsList.add(new Adapter(R.string.phoenix_name, R.string.phoenix_vmax, R.string.phoenix_vmaxfmk, R.string.phoenix_tax, R.string.phoenix_reset, R.drawable.phoenix));
        carsList.add(new Adapter(R.string.picador_name, R.string.picador_vmax, R.string.picador_vmaxfmk, R.string.picador_tax, R.string.picador_reset, R.drawable.picador));
        carsList.add(new Adapter(R.string.pony_name, R.string.pony_vmax, R.string.pony_vmaxfmk, R.string.pony_tax, R.string.pony_reset, R.drawable.pony));
        carsList.add(new Adapter(R.string.premier_name, R.string.premier_vmax, R.string.premier_vmaxfmk, R.string.premier_tax, R.string.premier_reset, R.drawable.premier));
        carsList.add(new Adapter(R.string.previon_name, R.string.previon_vmax, R.string.previon_vmaxfmk, R.string.previon_tax, R.string.previon_reset, R.drawable.previon));
        carsList.add(new Adapter(R.string.primo_name, R.string.primo_vmax, R.string.primo_vmaxfmk, R.string.primo_tax, R.string.primo_reset, R.drawable.primo));
        carsList.add(new Adapter(R.string.quad_name, R.string.quad_vmax, R.string.quad_vmaxfmk, R.string.quad_tax, R.string.quad_reset, R.drawable.quad));
        carsList.add(new Adapter(R.string.rancher_name, R.string.rancher_vmax, R.string.rancher_vmaxfmk, R.string.rancher_tax, R.string.rancher_reset, R.drawable.rancher));
        carsList.add(new Adapter(R.string.regina_name, R.string.regina_vmax, R.string.regina_vmaxfmk, R.string.regina_tax, R.string.regina_reset, R.drawable.regina));
        carsList.add(new Adapter(R.string.remington_name, R.string.remington_vmax, R.string.remington_vmaxfmk, R.string.remington_tax, R.string.remington_reset, R.drawable.remington));
        carsList.add(new Adapter(R.string.sabre_name, R.string.sabre_vmax, R.string.sabre_vmaxfmk, R.string.sabre_tax, R.string.sabre_reset, R.drawable.sabre));
        carsList.add(new Adapter(R.string.sadler_name, R.string.sadler_vmax, R.string.sadler_vmaxfmk, R.string.sadler_tax, R.string.sadler_reset, R.drawable.sadler));
        carsList.add(new Adapter(R.string.sanchez_name, R.string.sanchez_vmax, R.string.sanchez_vmaxfmk, R.string.sanchez_tax, R.string.sanchez_reset, R.drawable.sanchez));
        carsList.add(new Adapter(R.string.sandking_name, R.string.sandking_vmax, R.string.sandking_vmaxfmk, R.string.sandking_tax, R.string.sandking_reset, R.drawable.sandking));
        carsList.add(new Adapter(R.string.savanna_name, R.string.savanna_vmax, R.string.savanna_vmaxfmk, R.string.savanna_tax, R.string.savanna_reset, R.drawable.savanna));
        carsList.add(new Adapter(R.string.sentinel_name, R.string.sentinel_vmax, R.string.sentinel_vmaxfmk, R.string.sentinel_tax, R.string.sentinel_reset, R.drawable.sentinel));
        carsList.add(new Adapter(R.string.slamvan_name, R.string.slamvan_vmax, R.string.slamvan_vmaxfmk, R.string.slamvan_tax, R.string.slamvan_reset, R.drawable.slamvan));
        carsList.add(new Adapter(R.string.solair_name, R.string.solair_vmax, R.string.solair_vmaxfmk, R.string.solair_tax, R.string.solair_reset, R.drawable.solair));
        carsList.add(new Adapter(R.string.stafford_name, R.string.stafford_vmax, R.string.stafford_vmaxfmk, R.string.stafford_tax, R.string.stafford_reset, R.drawable.stafford));
        carsList.add(new Adapter(R.string.stallion_name, R.string.stallion_vmax, R.string.stallion_vmaxfmk, R.string.stallion_tax, R.string.stallion_reset, R.drawable.stallion));
        carsList.add(new Adapter(R.string.stratum_name, R.string.stratum_vmax, R.string.stratum_vmaxfmk, R.string.stratum_tax, R.string.stratum_reset, R.drawable.stratum));
        carsList.add(new Adapter(R.string.stretch_name, R.string.stretch_vmax, R.string.stretch_vmaxfmk, R.string.stretch_tax, R.string.stretch_reset, R.drawable.stretch));
        carsList.add(new Adapter(R.string.sultan_name, R.string.sultan_vmax, R.string.sultan_vmaxfmk, R.string.sultan_tax, R.string.sultan_reset, R.drawable.sultan));
        carsList.add(new Adapter(R.string.sunrise_name, R.string.sunrise_vmax, R.string.sunrise_vmaxfmk, R.string.sunrise_tax, R.string.sunrise_reset, R.drawable.sunrise));
        carsList.add(new Adapter(R.string.supergt_name, R.string.supergt_vmax, R.string.supergt_vmaxfmk, R.string.supergt_tax, R.string.supergt_reset, R.drawable.supergt));
        carsList.add(new Adapter(R.string.tahoma_name, R.string.tahoma_vmax, R.string.tahoma_vmaxfmk, R.string.tahoma_tax, R.string.tahoma_reset, R.drawable.tahoma));
        carsList.add(new Adapter(R.string.tampa_name, R.string.tampa_vmax, R.string.tampa_vmaxfmk, R.string.tampa_tax, R.string.tampa_reset, R.drawable.tampa));
        carsList.add(new Adapter(R.string.tornado_name, R.string.tornado_vmax, R.string.tornado_vmaxfmk, R.string.tornado_tax, R.string.tornado_reset, R.drawable.tornado));
        carsList.add(new Adapter(R.string.turismo_name, R.string.turismo_vmax, R.string.turismo_vmaxfmk, R.string.turismo_tax, R.string.turismo_reset, R.drawable.turismo));
        carsList.add(new Adapter(R.string.uranus_name, R.string.uranus_vmax, R.string.uranus_vmaxfmk, R.string.uranus_tax, R.string.uranus_reset, R.drawable.uranus));
        carsList.add(new Adapter(R.string.vincent_name, R.string.vincent_vmax, R.string.vincent_vmaxfmk, R.string.vincent_tax, R.string.vincent_reset, R.drawable.vincent));
        carsList.add(new Adapter(R.string.virgo_name, R.string.virgo_vmax, R.string.virgo_vmaxfmk, R.string.virgo_tax, R.string.virgo_reset, R.drawable.virgo));
        carsList.add(new Adapter(R.string.voodoo_name, R.string.voodoo_vmax, R.string.voodoo_vmaxfmk, R.string.voodoo_tax, R.string.voodoo_reset, R.drawable.voodoo));
        carsList.add(new Adapter(R.string.walton_name, R.string.walton_vmax, R.string.walton_vmaxfmk, R.string.walton_tax, R.string.walton_reset, R.drawable.walton));
        carsList.add(new Adapter(R.string.washington_name, R.string.washington_vmax, R.string.washington_vmaxfmk, R.string.washingtona_tax, R.string.washington_reset, R.drawable.washington));
        carsList.add(new Adapter(R.string.wayfarer_name, R.string.wayfarer_vmax, R.string.wayfarer_vmaxfmk, R.string.wayfarer_tax, R.string.wayfarer_reset, R.drawable.wayfarer));
        carsList.add(new Adapter(R.string.willard_name, R.string.willard_vmax, R.string.willard_vmaxfmk, R.string.willard_tax, R.string.willard_reset, R.drawable.willard));
        carsList.add(new Adapter(R.string.windsor_name, R.string.windsor_vmax, R.string.windsor_vmaxfmk, R.string.windsor_tax, R.string.windsor_reset, R.drawable.windsor));
        carsList.add(new Adapter(R.string.yosemite_name, R.string.yosemite_vmax, R.string.yosemite_vmaxfmk, R.string.yosemite_tax, R.string.yosemite_reset, R.drawable.yosemite));
        carsList.add(new Adapter(R.string.zr350_name, R.string.zr350_vmax, R.string.zr350_vmaxfmk, R.string.zr350_tax, R.string.zr350_reset, R.drawable.zr350));

        CarsAdapter adapter = new CarsAdapter(this, carsList);
        recyclerView.setAdapter(adapter);
    }
}
