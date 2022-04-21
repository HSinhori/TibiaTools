package net.heedapps.tibiatools.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import net.heedapps.tibiatools.R;
import net.heedapps.tibiatools.calculators.DistTrainingActivity;
import net.heedapps.tibiatools.calculators.HuntCalcActivity;
import net.heedapps.tibiatools.calculators.LevelCalculatorActivity;
import net.heedapps.tibiatools.calculators.SharedExpActivity;
import net.heedapps.tibiatools.calculators.MeleeTrainingActivity;

public class CalculatorsActivity extends AppCompatActivity {

    private Boolean savedSubscribe = false;
    private static final String PREF_FILE= "MyPref";
    private static final String SUBSCRIBE_KEY= "subscribe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        AdView adViewCalc = (AdView) findViewById(R.id.adViewCalc);
        AdView adViewCalcTwo = (AdView) findViewById(R.id.adViewCalcTwo);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewCalc.loadAd(adRequest);
        adViewCalcTwo.loadAd(adRequest);
        if(getSubscribe()){
            adViewCalc.setVisibility(View.GONE);
            adViewCalcTwo.setVisibility(View.GONE);
        }

        Button melee_skill_training = findViewById(R.id.melee_skill_training);
        Button dist_skill_training = findViewById(R.id.dist_skill_training);
        Button shared_btn = findViewById(R.id.shared_btn);
        Button hunt_btn = findViewById(R.id.hunt_btn);
        Button level_btn = findViewById(R.id.level_btn);

        melee_skill_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hunt_intent = new Intent(CalculatorsActivity.this, MeleeTrainingActivity.class);
                startActivity(hunt_intent);
            }
        });

        dist_skill_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hunt_intent = new Intent(CalculatorsActivity.this, DistTrainingActivity.class);
                startActivity(hunt_intent);
            }
        });

        shared_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hunt_intent = new Intent(CalculatorsActivity.this, SharedExpActivity.class);
                startActivity(hunt_intent);
            }
        });

        hunt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imbue_intent = new Intent(CalculatorsActivity.this, HuntCalcActivity.class);
                startActivity(imbue_intent);
            }
        });

        level_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imbue_intent = new Intent(CalculatorsActivity.this, LevelCalculatorActivity.class);
                startActivity(imbue_intent);
            }
        });
    }

    private Boolean getSubscribe(){

        SharedPreferences getSubscribeStatus = this.getSharedPreferences(PREF_FILE, 0);

        savedSubscribe = getSubscribeStatus.getBoolean(SUBSCRIBE_KEY, false);

        return savedSubscribe;

    }
}