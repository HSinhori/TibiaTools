package net.heedapps.tibiatools.calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.heedapps.tibiatools.R;

public class DistTrainingActivity extends AppCompatActivity {

    private EditText melee_dist_training_current_skill;
    private EditText melee_dist_training_desired_skill;
    private EditText dist_training_current_skill;
    private EditText dist_training_desired_skill;
    private EditText shield_dist_training_current_skill;
    private EditText shield_dist_training_desired_skill;

    private TextView dist_estimated_time;
    private TextView melee_dist_estimated_time;
    private TextView shield_dist_estimated_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dist_training);

        ImageView img_hunter_male_dist_training = findViewById(R.id.img_paladin_male_dist_training);
        ImageView img_hunter_female_dist_training = findViewById(R.id.img_paladin_female_dist_training);

        melee_dist_training_current_skill = findViewById(R.id.melee_dist_training_current_skill);
        melee_dist_training_desired_skill = findViewById(R.id.melee_dist_training_desired_skill);
        dist_training_current_skill = findViewById(R.id.dist_training_current_skill);
        dist_training_desired_skill = findViewById(R.id.dist_training_desired_skill);
        shield_dist_training_current_skill = findViewById(R.id.shield_dist_training_current_skill);
        shield_dist_training_desired_skill = findViewById(R.id.shield_dist_training_desired_skill);

        Button btn_calc_melee_training = findViewById(R.id.btn_calc_dist_training);

        dist_estimated_time = findViewById(R.id.dist_estimated_time);
        melee_dist_estimated_time = findViewById(R.id.melee_dist_estimated_time);
        shield_dist_estimated_time = findViewById(R.id.shield_dist_estimated_time);

        Glide.with(this).load(R.drawable.hunter_male).into(img_hunter_male_dist_training);
        Glide.with(this).load(R.drawable.hunter_female).into(img_hunter_female_dist_training);

        btn_calc_melee_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {

            int cur_melee = Integer.parseInt(melee_dist_training_current_skill.getText().toString());
            int des_melee = Integer.parseInt(melee_dist_training_desired_skill.getText().toString());
            int cur_dist = Integer.parseInt(dist_training_current_skill.getText().toString());
            int des_dist = Integer.parseInt(dist_training_desired_skill.getText().toString());
            int cur_shield = Integer.parseInt(shield_dist_training_current_skill.getText().toString());
            int des_shield = Integer.parseInt(shield_dist_training_desired_skill.getText().toString());

            if (!String.valueOf(cur_dist).isEmpty() &&
                    !String.valueOf(des_dist).isEmpty() &&
                    !String.valueOf(cur_shield).isEmpty() &&
                    !String.valueOf(des_shield).isEmpty()) {

                if (cur_melee >= 10 && des_melee >= 10 &&
                        cur_dist >= 10 && des_dist >= 10 &&
                        cur_shield >= 10 && des_shield >= 10) {

                    if (des_melee > cur_melee &&
                            des_dist > cur_dist &&
                            des_shield > cur_shield) {

                        int dist_time = 0;

                        for (int i_dist = cur_dist; i_dist < des_dist; i_dist++) {

                            dist_time += (60 * (Math.pow(1.1, (i_dist - 9))));

                        }

                        int shield_time = 0;

                        for (int i_shield = cur_shield; i_shield < des_shield; i_shield++) {

                            shield_time += (120 * (Math.pow(1.1, (i_shield - 9))));

                        }

                        int melee_time = 0;

                        for (int i_melee = cur_melee; i_melee < des_melee; i_melee++) {

                            melee_time += (120 * (Math.pow(1.2, (i_melee - 9))));

                        }

                        convert(dist_time, shield_time, melee_time);

                    }

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void convert(int dist_time, int shield_time, int melee_time) {

        if (dist_time < 60) {

            String time = getString(R.string.estimated_time) + " distance: " +
                    dist_time + " " + getString(R.string.seconds);

            dist_estimated_time.setText(time);

        } else if (dist_time < 3600) {

            int min_time = (int) Math.floor(dist_time / 60.0);
            int sec_time = (int) Math.floor(dist_time - (min_time * 60.0));

            String time = getString(R.string.estimated_time) + " distance: " +
                    min_time + " " +
                    getString(R.string.minutes) + " " +
                    getString(R.string.and) + " " +
                    sec_time + " " + getString(R.string.seconds);

            dist_estimated_time.setText(time);

        } else {

            int hour_time = (int) Math.floor(dist_time / 3600.0);
            int min_time = (int) Math.floor((dist_time - (hour_time * 3600.0)) / 60);

            String time = getString(R.string.estimated_time) + " distance: " +
                    hour_time + " " +
                    getString(R.string.hours) + " " +
                    getString(R.string.and) + " " +
                    min_time + " " + getString(R.string.minutes);

            dist_estimated_time.setText(time);

        }

        if(melee_time < 60){

            String time = getString(R.string.estimated_time) + " melee: " +
                    melee_time + " " + getString(R.string.seconds);

            melee_dist_estimated_time.setText(time);

        }else if(melee_time < 3600){

            int min_time = (int) Math.floor(melee_time/60.0);
            int sec_time = (int) Math.floor(melee_time - (min_time * 60.0));

            String time = getString(R.string.estimated_time) + " melee: " +
                    min_time + " " +
                    getString(R.string.minutes) + " " +
                    getString(R.string.and) + " " +
                    sec_time + " " + getString(R.string.seconds);

            melee_dist_estimated_time.setText(time);

        }else{

            int hour_time = (int) Math.floor(melee_time/3600.0);
            int min_time = (int) Math.floor((melee_time - (hour_time * 3600.0))/60);

            String time = getString(R.string.estimated_time) + " melee: " +
                    hour_time + " " +
                    getString(R.string.hours) + " " +
                    getString(R.string.and) + " " +
                    min_time + " " + getString(R.string.minutes);

            melee_dist_estimated_time.setText(time);

        }

        if (shield_time < 60) {

            String time = getString(R.string.estimated_time) + " shielding: " +
                    shield_time + " " + getString(R.string.seconds);

            shield_dist_estimated_time.setText(time);

        } else if (shield_time < 3600) {

            int min_time = (int) Math.floor(shield_time / 60.0);
            int sec_time = (int) Math.floor(shield_time - (min_time * 60.0));

            String time = getString(R.string.estimated_time) + " shielding: " +
                    min_time + " " +
                    getString(R.string.minutes) + " " +
                    getString(R.string.and) + " " +
                    sec_time + " " + getString(R.string.seconds);

            shield_dist_estimated_time.setText(time);

        } else {

            int hour_time = (int) Math.floor(shield_time / 3600.0);
            int min_time = (int) Math.floor((shield_time - (hour_time * 3600.0)) / 60);

            String time = getString(R.string.estimated_time) + " shielding: " +
                    hour_time + " " +
                    getString(R.string.hours) + " " +
                    getString(R.string.and) + " " +
                    min_time + " " + getString(R.string.minutes);

            shield_dist_estimated_time.setText(time);

        }

    }
}