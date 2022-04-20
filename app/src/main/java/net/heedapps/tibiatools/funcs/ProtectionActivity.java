package net.heedapps.tibiatools.funcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.heedapps.tibiatools.R;
import net.heedapps.tibiatools.funcs.protection.CloudFabricActivity;
import net.heedapps.tibiatools.funcs.protection.DemonPresenceActivity;
import net.heedapps.tibiatools.funcs.protection.DragonHideActivity;
import net.heedapps.tibiatools.funcs.protection.LichShroudActivity;
import net.heedapps.tibiatools.funcs.protection.QuaraScaleActivity;
import net.heedapps.tibiatools.funcs.protection.SnakeSkinActivity;

public class ProtectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);

        ImageView img_cloud = findViewById(R.id.img_cloud);
        ImageView img_quara = findViewById(R.id.img_quara);
        ImageView img_lich = findViewById(R.id.img_lich);
        ImageView img_dragon = findViewById(R.id.img_dragon_hide);
        ImageView img_snake = findViewById(R.id.img_snake);
        ImageView img_demon = findViewById(R.id.img_demon);

        Glide.with(this)
                .load(R.drawable.electrify)
                .into(img_cloud);
        Glide.with(this)
                .load(R.drawable.frost)
                .into(img_quara);
        Glide.with(this)
                .load(R.drawable.reap)
                .into(img_lich);
        Glide.with(this)
                .load(R.drawable.scorch)
                .into(img_dragon);
        Glide.with(this)
                .load(R.drawable.venom)
                .into(img_snake);
        Glide.with(this)
                .load(R.drawable.holy)
                .into(img_demon);
    }

    public void cloudClick(View view) {
        Intent i = new Intent(ProtectionActivity.this, CloudFabricActivity.class);
        startActivity(i);
    }

    public void demonClick(View view) {
        Intent i = new Intent(ProtectionActivity.this, DemonPresenceActivity.class);
        startActivity(i);
    }

    public void dragonClick(View view) {
        Intent i = new Intent(ProtectionActivity.this, DragonHideActivity.class);
        startActivity(i);
    }

    public void lichClick(View view) {
        Intent i = new Intent(ProtectionActivity.this, LichShroudActivity.class);
        startActivity(i);
    }

    public void quaraClick(View view) {
        Intent i = new Intent(ProtectionActivity.this, QuaraScaleActivity.class);
        startActivity(i);
    }

    public void snakeClick(View view) {
        Intent i = new Intent(ProtectionActivity.this, SnakeSkinActivity.class);
        startActivity(i);
    }
}