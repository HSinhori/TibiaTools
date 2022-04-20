package net.heedapps.tibiatools.funcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.heedapps.tibiatools.R;
import net.heedapps.tibiatools.funcs.damage.ElectrifyActivity;
import net.heedapps.tibiatools.funcs.damage.FrostActivity;
import net.heedapps.tibiatools.funcs.damage.ReapActivity;
import net.heedapps.tibiatools.funcs.damage.ScorchActivity;
import net.heedapps.tibiatools.funcs.damage.VenomActivity;

public class DamageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage);

        ImageView img_electrify = findViewById(R.id.img_electrify);
        ImageView img_frost = findViewById(R.id.img_frost);
        ImageView img_reap = findViewById(R.id.img_reap);
        ImageView img_scorch = findViewById(R.id.img_scorch);
        ImageView img_venom = findViewById(R.id.img_venom);

        Glide.with(this)
                .load(R.drawable.electrify)
                .into(img_electrify);
        Glide.with(this)
                .load(R.drawable.frost)
                .into(img_frost);
        Glide.with(this)
                .load(R.drawable.reap)
                .into(img_reap);
        Glide.with(this)
                .load(R.drawable.scorch)
                .into(img_scorch);
        Glide.with(this)
                .load(R.drawable.venom)
                .into(img_venom);
    }

    public void electrifyClick(View view) {
        Intent i = new Intent(DamageActivity.this, ElectrifyActivity.class);
        startActivity(i);
    }

    public void frostClick(View view) {
        Intent i = new Intent(DamageActivity.this, FrostActivity.class);
        startActivity(i);
    }

    public void reapClick(View view) {
        Intent i = new Intent(DamageActivity.this, ReapActivity.class);
        startActivity(i);
    }

    public void scorchClick(View view) {
        Intent i = new Intent(DamageActivity.this, ScorchActivity.class);
        startActivity(i);
    }

    public void venomClick(View view) {
        Intent i = new Intent(DamageActivity.this, VenomActivity.class);
        startActivity(i);
    }
}