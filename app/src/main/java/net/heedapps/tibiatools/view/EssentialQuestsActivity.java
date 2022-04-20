package net.heedapps.tibiatools.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import net.heedapps.tibiatools.R;

public class EssentialQuestsActivity extends AppCompatActivity {

    private Boolean savedSubscribe = false;
    private static final String PREF_FILE= "MyPref";
    private static final String SUBSCRIBE_KEY= "subscribe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essential_quests);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        AdView adViewQuests = (AdView) findViewById(R.id.adViewQuests);
        AdView adViewQuestsTwo = (AdView) findViewById(R.id.adViewQuestsTwo);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewQuests.loadAd(adRequest);
        adViewQuestsTwo.loadAd(adRequest);
        if(getSubscribe()){
            adViewQuests.setVisibility(View.GONE);
            adViewQuestsTwo.setVisibility(View.GONE);
        }

        TextView shattered_isles = findViewById(R.id.shattered_isles);
        shattered_isles.setMovementMethod(LinkMovementMethod.getInstance());

        TextView oramond_quest = findViewById(R.id.oramond_quest);
        oramond_quest.setMovementMethod(LinkMovementMethod.getInstance());

        TextView feaster_of_souls = findViewById(R.id.feaster_of_souls);
        feaster_of_souls.setMovementMethod(LinkMovementMethod.getInstance());

        TextView grave_danger = findViewById(R.id.grave_danger);
        grave_danger.setMovementMethod(LinkMovementMethod.getInstance());

        TextView secret_library = findViewById(R.id.secret_library);
        secret_library.setMovementMethod(LinkMovementMethod.getInstance());

        TextView dream_courts = findViewById(R.id.dream_courts);
        dream_courts.setMovementMethod(LinkMovementMethod.getInstance());

        TextView service_yalahar = findViewById(R.id.service_yalahar);
        service_yalahar.setMovementMethod(LinkMovementMethod.getInstance());

        TextView shadows_yalahar = findViewById(R.id.shadows_yalahar);
        shadows_yalahar.setMovementMethod(LinkMovementMethod.getInstance());

        TextView inquisition_quest = findViewById(R.id.inquisition_quest);
        inquisition_quest.setMovementMethod(LinkMovementMethod.getInstance());

        TextView pits_inferno = findViewById(R.id.pits_inferno);
        pits_inferno.setMovementMethod(LinkMovementMethod.getInstance());

        TextView threatened_dreams = findViewById(R.id.threatened_dreams);
        threatened_dreams.setMovementMethod(LinkMovementMethod.getInstance());

        TextView postman_mission = findViewById(R.id.postman_mission);
        postman_mission.setMovementMethod(LinkMovementMethod.getInstance());

        TextView explorer_society = findViewById(R.id.explorer_society);
        explorer_society.setMovementMethod(LinkMovementMethod.getInstance());

        TextView forgotten_knowledge = findViewById(R.id.forgotten_knowledge);
        forgotten_knowledge.setMovementMethod(LinkMovementMethod.getInstance());

        TextView liquid_black = findViewById(R.id.liquid_black);
        liquid_black.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ice_island = findViewById(R.id.ice_island);
        ice_island.setMovementMethod(LinkMovementMethod.getInstance());

        TextView new_frontier = findViewById(R.id.new_frontier);
        new_frontier.setMovementMethod(LinkMovementMethod.getInstance());

        TextView white_raven = findViewById(R.id.white_raven);
        white_raven.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ape_city = findViewById(R.id.ape_city);
        ape_city.setMovementMethod(LinkMovementMethod.getInstance());

        TextView children_revolution = findViewById(R.id.children_revolution);
        children_revolution.setMovementMethod(LinkMovementMethod.getInstance());

        TextView wrath_emperor = findViewById(R.id.wrath_emperor);
        wrath_emperor.setMovementMethod(LinkMovementMethod.getInstance());

        TextView kilmaresh_quest = findViewById(R.id.kilmaresh_quest);
        kilmaresh_quest.setMovementMethod(LinkMovementMethod.getInstance());

        TextView bigfoot_burden = findViewById(R.id.bigfoot_burden);
        bigfoot_burden.setMovementMethod(LinkMovementMethod.getInstance());

        TextView grimvale_quest = findViewById(R.id.grimvale_quest);
        grimvale_quest.setMovementMethod(LinkMovementMethod.getInstance());

        TextView pirates_tail = findViewById(R.id.pirates_tail);
        pirates_tail.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cults_tibia = findViewById(R.id.cults_tibia);
        cults_tibia.setMovementMethod(LinkMovementMethod.getInstance());

        TextView thieves_guild = findViewById(R.id.thieves_guild);
        thieves_guild.setMovementMethod(LinkMovementMethod.getInstance());

        TextView order_cobra = findViewById(R.id.order_cobra);
        order_cobra.setMovementMethod(LinkMovementMethod.getInstance());

        TextView order_falcon = findViewById(R.id.order_falcon);
        order_falcon.setMovementMethod(LinkMovementMethod.getInstance());

        TextView heart_destruction = findViewById(R.id.heart_destruction);
        heart_destruction.setMovementMethod(LinkMovementMethod.getInstance());

        TextView order_lion = findViewById(R.id.order_lion);
        order_lion.setMovementMethod(LinkMovementMethod.getInstance());

        TextView dangerous_depths = findViewById(R.id.dangerous_depths);
        dangerous_depths.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ferumbras_ascendant = findViewById(R.id.ferumbras_ascendant);
        ferumbras_ascendant.setMovementMethod(LinkMovementMethod.getInstance());

        TextView soul_war = findViewById(R.id.soul_war);
        soul_war.setMovementMethod(LinkMovementMethod.getInstance());

        TextView hero_rathleton = findViewById(R.id.hero_rathleton);
        hero_rathleton.setMovementMethod(LinkMovementMethod.getInstance());

        TextView paw_fur = findViewById(R.id.paw_fur);
        paw_fur.setMovementMethod(LinkMovementMethod.getInstance());

        TextView tomes_knowledge = findViewById(R.id.tomes_knowledge);
        tomes_knowledge.setMovementMethod(LinkMovementMethod.getInstance());

        TextView travelling_trader = findViewById(R.id.travelling_trader);
        travelling_trader.setMovementMethod(LinkMovementMethod.getInstance());

        TextView blood_brothers = findViewById(R.id.blood_brothers);
        blood_brothers.setMovementMethod(LinkMovementMethod.getInstance());

        TextView djinn_efreet = findViewById(R.id.djinn_efreet);
        djinn_efreet.setMovementMethod(LinkMovementMethod.getInstance());

        TextView djinn_marid = findViewById(R.id.djinn_marid);
        djinn_marid.setMovementMethod(LinkMovementMethod.getInstance());

        TextView secret_service = findViewById(R.id.secret_service);
        secret_service.setMovementMethod(LinkMovementMethod.getInstance());

        TextView sea_serpent = findViewById(R.id.sea_serpent);
        sea_serpent.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private Boolean getSubscribe(){

        SharedPreferences getSubscribeStatus = this.getSharedPreferences(PREF_FILE, 0);

        savedSubscribe = getSubscribeStatus.getBoolean(SUBSCRIBE_KEY, false);

        return savedSubscribe;

    }
}