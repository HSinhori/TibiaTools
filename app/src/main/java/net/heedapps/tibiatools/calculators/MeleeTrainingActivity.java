package net.heedapps.tibiatools.calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import net.heedapps.tibiatools.R;

public class MeleeTrainingActivity extends AppCompatActivity {

    private EditText melee_training_current_skill;
    private EditText melee_training_desired_skill;
    private EditText shield_melee_training_current_skill;
    private EditText shield_melee_training_desired_skill;

    private TextView melee_estimated_time;
    private TextView shield_melee_estimated_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melee_training);

        ImageView img_knight_male_melee_training = findViewById(R.id.img_knight_male_melee_training);
        ImageView img_knight_female_melee_training = findViewById(R.id.img_knight_female_melee_training);

        melee_training_current_skill = findViewById(R.id.melee_training_current_skill);
        melee_training_desired_skill = findViewById(R.id.melee_training_desired_skill);
        shield_melee_training_current_skill = findViewById(R.id.shield_melee_training_current_skill);
        shield_melee_training_desired_skill = findViewById(R.id.shield_melee_training_desired_skill);

        Button btn_calc_melee_training = findViewById(R.id.btn_calc_melee_training);

        melee_estimated_time = findViewById(R.id.melee_estimated_time);
        shield_melee_estimated_time = findViewById(R.id.shield_melee_estimated_time);

        Glide.with(this).load(R.drawable.knight_male).into(img_knight_male_melee_training);
        Glide.with(this).load(R.drawable.knight_female).into(img_knight_female_melee_training);

        btn_calc_melee_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

    }

    private void calculate() {

        try {

            int cur_melee = Integer.parseInt(melee_training_current_skill.getText().toString());
            int des_melee = Integer.parseInt(melee_training_desired_skill.getText().toString());
            int cur_shield = Integer.parseInt(shield_melee_training_current_skill.getText().toString());
            int des_shield = Integer.parseInt(shield_melee_training_desired_skill.getText().toString());

            if (!String.valueOf(cur_melee).isEmpty() &&
                    !String.valueOf(des_melee).isEmpty() &&
                    !String.valueOf(cur_shield).isEmpty() &&
                    !String.valueOf(des_shield).isEmpty()) {

                if (cur_melee >= 10 && des_melee >= 10 && cur_shield >= 10 && des_shield >= 10) {

                    if(des_melee > cur_melee && des_shield > cur_shield){

                        int melee_time = 0;

                        for (int i_melee = cur_melee; i_melee < des_melee; i_melee++){

                            melee_time += (120 * (Math.pow(1.1, (i_melee - 9))));

                        }

                        int shield_time = 0;

                        for (int i_shield = cur_shield; i_shield < des_shield; i_shield++){

                            shield_time += (120 * (Math.pow(1.1, (i_shield - 9))));

                        }

                        convert(melee_time, shield_time);

                    }else{
                        Toast.makeText(
                                this, getString(R.string.required_less_current),
                                Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(
                            this, getString(R.string.less_than_10),
                            Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(
                        this, getString(R.string.empty_skill_value),
                        Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void convert(int melee_time, int shield_time) {

        if(melee_time < 60){

            String time = getString(R.string.estimated_time) + " melee: " +
                    melee_time + " " + getString(R.string.seconds);

            melee_estimated_time.setText(time);

        }else if(melee_time < 3600){

            int min_time = (int) Math.floor(melee_time/60.0);
            int sec_time = (int) Math.floor(melee_time - (min_time * 60.0));

            String time = getString(R.string.estimated_time) + " melee: " +
                    min_time + " " +
                    getString(R.string.minutes) + " " +
                    getString(R.string.and) + " " +
                    sec_time + " " + getString(R.string.seconds);

            melee_estimated_time.setText(time);

        }else{

            int hour_time = (int) Math.floor(melee_time/3600.0);
            int min_time = (int) Math.floor((melee_time - (hour_time * 3600.0))/60);

            String time = getString(R.string.estimated_time) + " melee: " +
                    hour_time + " " +
                    getString(R.string.hours) + " " +
                    getString(R.string.and) + " " +
                    min_time + " " + getString(R.string.minutes);

            melee_estimated_time.setText(time);

        }

        if(shield_time < 60){

            String time = getString(R.string.estimated_time) + " shielding: " +
                    shield_time + " " + getString(R.string.seconds);

            shield_melee_estimated_time.setText(time);

        }else if(shield_time < 3600){

            int min_time = (int) Math.floor(shield_time/60.0);
            int sec_time = (int) Math.floor(shield_time - (min_time * 60.0));

            String time = getString(R.string.estimated_time) + " shielding: " +
                    min_time + " " +
                    getString(R.string.minutes) + " " +
                    getString(R.string.and) + " " +
                    sec_time + " " + getString(R.string.seconds);

            shield_melee_estimated_time.setText(time);

        }else{

            int hour_time = (int) Math.floor(shield_time/3600.0);
            int min_time = (int) Math.floor((shield_time - (hour_time * 3600.0))/60);

            String time = getString(R.string.estimated_time) + " shielding: " +
                    hour_time + " " +
                    getString(R.string.hours) + " " +
                    getString(R.string.and) + " " +
                    min_time + " " + getString(R.string.minutes);

            shield_melee_estimated_time.setText(time);

        }

    }
}