package net.heedapps.tibiatools.funcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.heedapps.tibiatools.R;
import net.heedapps.tibiatools.funcs.skills.BashActivity;
import net.heedapps.tibiatools.funcs.skills.BlockadeActivity;
import net.heedapps.tibiatools.funcs.skills.ChopActivity;
import net.heedapps.tibiatools.funcs.skills.EpiphanyActivity;
import net.heedapps.tibiatools.funcs.skills.PrecisionActivity;
import net.heedapps.tibiatools.funcs.skills.SlashActivity;

public class SkillsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        ImageView img_chop = findViewById(R.id.img_chop);

        Glide.with(this)
                .load(R.drawable.chop)
                .into(img_chop);
    }

    public void bashClick(View view) {
        Intent i = new Intent(SkillsActivity.this, BashActivity.class);
        startActivity(i);
    }

    public void blockadeClick(View view) {
        Intent i = new Intent(SkillsActivity.this, BlockadeActivity.class);
        startActivity(i);
    }

    public void chopClick(View view) {
        Intent i = new Intent(SkillsActivity.this, ChopActivity.class);
        startActivity(i);
    }

    public void epiphanyClick(View view) {
        Intent i = new Intent(SkillsActivity.this, EpiphanyActivity.class);
        startActivity(i);
    }

    public void slashClick(View view) {
        Intent i = new Intent(SkillsActivity.this, SlashActivity.class);
        startActivity(i);
    }

    public void precisionClick(View view) {
        Intent i = new Intent(SkillsActivity.this, PrecisionActivity.class);
        startActivity(i);
    }
}