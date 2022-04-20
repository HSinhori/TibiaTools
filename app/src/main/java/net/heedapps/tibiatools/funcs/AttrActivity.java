package net.heedapps.tibiatools.funcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.heedapps.tibiatools.R;
import net.heedapps.tibiatools.funcs.attr.FeatherActivity;
import net.heedapps.tibiatools.funcs.attr.StrikeActivity;
import net.heedapps.tibiatools.funcs.attr.SwiftnessActivity;
import net.heedapps.tibiatools.funcs.attr.VampActivity;
import net.heedapps.tibiatools.funcs.attr.VibrancyActivity;
import net.heedapps.tibiatools.funcs.attr.VoidActivity;

public class AttrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attr);

        ImageView img_strike = findViewById(R.id.img_strike);
        Glide.with(this)
                .load(R.drawable.strike)
                .into(img_strike);
    }

    public void strikeClick(View view) {
        Intent i = new Intent(AttrActivity.this, StrikeActivity.class);
        startActivity(i);
    }

    public void vampClick(View view) {
        Intent i = new Intent(AttrActivity.this, VampActivity.class);
        startActivity(i);
    }

    public void voidClick(View view) {
        Intent i = new Intent(AttrActivity.this, VoidActivity.class);
        startActivity(i);
    }

    public void vibrancyClick(View view) {
        Intent i = new Intent(AttrActivity.this, VibrancyActivity.class);
        startActivity(i);
    }

    public void swiftnessClick(View view) {
        Intent i = new Intent(AttrActivity.this, SwiftnessActivity.class);
        startActivity(i);
    }

    public void featherClick(View view) {
        Intent i = new Intent(AttrActivity.this, FeatherActivity.class);
        startActivity(i);
    }
}