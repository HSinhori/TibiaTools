package net.heedapps.tibiatools.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import net.heedapps.tibiatools.funcs.AttrActivity;
import net.heedapps.tibiatools.funcs.DamageActivity;
import net.heedapps.tibiatools.funcs.ProtectionActivity;
import net.heedapps.tibiatools.R;
import net.heedapps.tibiatools.funcs.SkillsActivity;

public class ImbueActivity extends AppCompatActivity {

    private Boolean savedSubscribe = false;
    private static final String PREF_FILE= "MyPref";
    private static final String SUBSCRIBE_KEY= "subscribe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imbue);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        AdView adViewImbue = (AdView) findViewById(R.id.adViewImbue);
        AdView adViewImbueTwo = (AdView) findViewById(R.id.adViewImbueTwo);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewImbue.loadAd(adRequest);
        adViewImbueTwo.loadAd(adRequest);
        if(getSubscribe()){
            adViewImbue.setVisibility(View.GONE);
            adViewImbueTwo.setVisibility(View.GONE);
        }

    }

    public void attrClick(View view) {
        Intent i = new Intent(ImbueActivity.this, AttrActivity.class);
        startActivity(i);
    }

    public void skillClick(View view) {
        Intent i = new Intent(ImbueActivity.this, SkillsActivity.class);
        startActivity(i);
    }

    public void damageClick(View view) {
        Intent i = new Intent(ImbueActivity.this, DamageActivity.class);
        startActivity(i);
    }

    public void protectionClick(View view) {
        Intent i = new Intent(ImbueActivity.this, ProtectionActivity.class);
        startActivity(i);
    }

    private Boolean getSubscribe(){

        SharedPreferences getSubscribeStatus = this.getSharedPreferences(PREF_FILE, 0);

        savedSubscribe = getSubscribeStatus.getBoolean(SUBSCRIBE_KEY, false);

        return savedSubscribe;

    }
}