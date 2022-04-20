package net.heedapps.tibiatools.view;

import static com.android.billingclient.api.BillingClient.SkuType.SUBS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import net.heedapps.tibiatools.R;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView rashid_text_before;
    private TextView rashid_text_after;

    private PurchasesUpdatedListener purchasesUpdatedListener;
    private BillingClient billingClient;

    private Boolean savedSubscribe = false;
    private static final String PREF_FILE= "MyPref";
    private static final String SUBSCRIBE_KEY= "subscribe";
    private static final String ITEM_SKU_SUBSCRIBE_MONTHLY = "tibia_tools_remove_ads";

    private InterstitialAd interstitialAd_calc, interstitialAd_imbue, interstitialAd_quests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        startAdsBilling();

        AdView adViewMain = (AdView) findViewById(R.id.adViewMain);
        AdView adViewMainTwo = (AdView) findViewById(R.id.adViewMainTwo);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewMain.loadAd(adRequest);
        adViewMainTwo.loadAd(adRequest);
        if(getSubscribe()){
            adViewMain.setVisibility(View.GONE);
            adViewMainTwo.setVisibility(View.GONE);
        }

        InterstitialAd.load(this, "ca-app-pub-5981899111891359/1342268572", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        interstitialAd_calc = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        interstitialAd_calc = interstitialAd;
                    }
                });

        InterstitialAd.load(this, "ca-app-pub-5981899111891359/7716105232", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        interstitialAd_imbue = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        interstitialAd_imbue = interstitialAd;
                    }
                });

        InterstitialAd.load(this, "ca-app-pub-5981899111891359/4320619850", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        interstitialAd_quests = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        interstitialAd_quests = interstitialAd;
                    }
                });

        ImageView rashid_image = findViewById(R.id.rashid_image);
        rashid_text_before = findViewById(R.id.rashid_before_text);
        rashid_text_after = findViewById(R.id.rashid_after_text);

        Glide.with(this)
                .load(R.drawable.rashid)
                .into(rashid_image);
        rashidDay();

        Button calculators_btn = findViewById(R.id.calculators_btn);
        Button imbue_btn = findViewById(R.id.imbue_btn);
        Button essential_quests_btn = findViewById(R.id.quests_btn);
        Button btn_ads_removal = findViewById(R.id.btn_ads_removal);

        calculators_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(interstitialAd_calc != null && !getSubscribe()) {

                    interstitialAd_calc.show(MainActivity.this);
                }

                Intent hunt_intent = new Intent(MainActivity.this, CalculatorsActivity.class);
                startActivity(hunt_intent);
            }
        });

        imbue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(interstitialAd_imbue != null && !getSubscribe()) {

                    interstitialAd_imbue.show(MainActivity.this);
                }


                Intent imbue_intent = new Intent(MainActivity.this, ImbueActivity.class);
                startActivity(imbue_intent);
            }
        });

        essential_quests_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(interstitialAd_quests != null && !getSubscribe()) {

                    interstitialAd_quests.show(MainActivity.this);
                }


                Intent shared_intent = new Intent(MainActivity.this, EssentialQuestsActivity.class);
                startActivity(shared_intent);
            }
        });

        btn_ads_removal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ads_removal = new Intent(MainActivity.this, AdsRemovalActivity.class);
                startActivity(ads_removal);
            }
        });
    }

    private void startAdsBilling() {

        purchasesUpdatedListener = new PurchasesUpdatedListener() {
            @Override
            public void onPurchasesUpdated(@NonNull BillingResult billingResult, List<Purchase> purchases) {

                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK
                        && purchases != null) {
                    for (Purchase purchase : purchases) {
                        handlePurchase(purchase);
                    }
                } else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
                    Toast.makeText(MainActivity.this,
                            getString(R.string.cancelled_purchase), Toast.LENGTH_SHORT).show();
                } else {
                    // Handle any other error codes.
                    Toast.makeText(MainActivity.this,
                            "Error: " + billingResult.getDebugMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        };

        billingClient = BillingClient.newBuilder(getApplicationContext())
                .setListener(purchasesUpdatedListener)
                .enablePendingPurchases()
                .build();

        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingServiceDisconnected() {
                Toast.makeText(getApplicationContext(),"Service Disconnected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK){

                    Purchase.PurchasesResult queryPurchase = billingClient.queryPurchases(SUBS);
                    List<Purchase> queryPurchases = queryPurchase.getPurchasesList();
                    if(queryPurchases!=null && queryPurchases.size()>0){
                        handlePurchases(queryPurchases);
                    }else{
                        saveSubscribe(false);
                    }

                }

            }
        });

    }

    private void handlePurchase(Purchase purchase) {

        AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener = new AcknowledgePurchaseResponseListener() {
            @Override
            public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {

                if(billingResult.getResponseCode()==BillingClient.BillingResponseCode.OK){
                    //if purchase is acknowledged
                    // Grant entitlement to the user. and restart activity
                    saveSubscribe(true);
                }

            }
        };

        if(purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED){
            if(!purchase.isAcknowledged()){
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
            }
        }

        ConsumeParams consumeParams =
                ConsumeParams.newBuilder()
                        .setPurchaseToken(purchase.getPurchaseToken())
                        .build();

        ConsumeResponseListener listener = new ConsumeResponseListener() {
            @Override
            public void onConsumeResponse(BillingResult billingResult, String purchaseToken) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // Handle the success of the consume operation.
                    saveSubscribe(true);
                }
            }
        };

        billingClient.consumeAsync(consumeParams, listener);

    }

    void handlePurchases(List<Purchase>  purchases) {
        for(Purchase purchase:purchases) {
            purchase = null;
            //if item is purchased
            if(ITEM_SKU_SUBSCRIBE_MONTHLY.equals(purchase.getSkus()) && purchase.getPurchaseState() == Purchase.PurchaseState.UNSPECIFIED_STATE)
            {
                saveSubscribe(false);
            }else{
                saveSubscribe(true);
            }
        }
    }

    private void saveSubscribe(Boolean save){

        SharedPreferences saveSubscribe = getApplicationContext().getSharedPreferences(PREF_FILE, 0);

        SharedPreferences.Editor subscribe = saveSubscribe.edit();

        subscribe.putBoolean(SUBSCRIBE_KEY, save);

        subscribe.apply();

        Toast.makeText(getApplicationContext(), save.toString(), Toast.LENGTH_SHORT).show();

    }

    private Boolean getSubscribe(){

        SharedPreferences getSubscribeStatus = this.getSharedPreferences(PREF_FILE, 0);

        savedSubscribe = getSubscribeStatus.getBoolean(SUBSCRIBE_KEY, false);

        return savedSubscribe;

    }

    private void rashidDay(){

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String rashid_bef;
        String rashid_aft;

        switch (day) {
            case Calendar.SUNDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Edron";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Carlin";
                rashid_text_after.setText(rashid_aft);
                break;
            case Calendar.MONDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Carlin";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Svargrond";
                rashid_text_after.setText(rashid_aft);
                break;
            case Calendar.TUESDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Svargrond";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Liberty Bay";
                rashid_text_after.setText(rashid_aft);
                break;
            case Calendar.WEDNESDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Liberty Bay";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Port Hope";
                rashid_text_after.setText(rashid_aft);
                break;
            case Calendar.THURSDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Port Hope";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Ankrahmun";
                rashid_text_after.setText(rashid_aft);
                break;
            case Calendar.FRIDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Ankrahmun";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Darashia";
                rashid_text_after.setText(rashid_aft);
                break;
            case Calendar.SATURDAY:
                rashid_bef = getString(R.string.rashid_before) + " " + "Darashia";
                rashid_text_before.setText(rashid_bef);
                rashid_aft = getString(R.string.rashid_after) + " " + "Edron";
                rashid_text_after.setText(rashid_aft);
                break;
        }

    }

    public void InstaClick(View view) {

        try {
            Uri uri = Uri.parse("http://instagram.com/_u/henrique_sinhori/");
            Intent insta = new Intent(Intent.ACTION_VIEW, uri);
            insta.setPackage("com.instagram.android");

            if (isIntentAvailable(this, insta)) {
                startActivity(insta);
            } else {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/henrique_sinhori/")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isIntentAvailable(Context ctx, Intent intent) {
        final PackageManager packageManager = ctx.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}