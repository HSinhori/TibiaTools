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

public class LevelCalculatorActivity extends AppCompatActivity {

    EditText current_level;
    EditText desired_level;
    TextView exp_required;

    TextView current_life_knight;
    TextView desired_life_knight;
    TextView current_mana_knight;
    TextView desired_mana_knight;
    TextView current_cap_knight;
    TextView desired_cap_knight;
    TextView current_speed_knight;
    TextView desired_speed_knight;

    TextView current_life_mage;
    TextView desired_life_mage;
    TextView current_mana_mage;
    TextView desired_mana_mage;
    TextView current_cap_mage;
    TextView desired_cap_mage;
    TextView current_speed_mage;
    TextView desired_speed_mage;

    TextView current_life_paladin;
    TextView desired_life_paladin;
    TextView current_mana_paladin;
    TextView desired_mana_paladin;
    TextView current_cap_paladin;
    TextView desired_cap_paladin;
    TextView current_speed_paladin;
    TextView desired_speed_paladin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_calculator);

        ImageView knight_male = findViewById(R.id.img_knight_male);
        ImageView knight_female = findViewById(R.id.img_knight_female);
        ImageView mage_male = findViewById(R.id.img_mage_male);
        ImageView mage_female = findViewById(R.id.img_mage_female);
        ImageView hunter_male = findViewById(R.id.img_paladin_male);
        ImageView hunter_female = findViewById(R.id.img_paladin_female);

        Button btn_level = findViewById(R.id.btn_level);
        current_level = findViewById(R.id.current_level);
        desired_level = findViewById(R.id.desired_level);
        exp_required = findViewById(R.id.exp_required);

        current_life_knight = findViewById(R.id.current_life_knight);
        desired_life_knight = findViewById(R.id.desired_life_knight);
        current_mana_knight = findViewById(R.id.current_mana_knight);
        desired_mana_knight = findViewById(R.id.desired_mana_knight);
        current_cap_knight = findViewById(R.id.current_cap_knight);
        desired_cap_knight = findViewById(R.id.desired_cap_knight);
        current_speed_knight = findViewById(R.id.current_speed_knight);
        desired_speed_knight = findViewById(R.id.desired_speed_knight);

        current_life_mage = findViewById(R.id.current_life_mage);
        desired_life_mage = findViewById(R.id.desired_life_mage);
        current_mana_mage = findViewById(R.id.current_mana_mage);
        desired_mana_mage = findViewById(R.id.desired_mana_mage);
        current_cap_mage = findViewById(R.id.current_cap_mage);
        desired_cap_mage = findViewById(R.id.desired_cap_mage);
        current_speed_mage = findViewById(R.id.current_speed_mage);
        desired_speed_mage = findViewById(R.id.desired_speed_mage);

        current_life_paladin = findViewById(R.id.current_life_paladin);
        desired_life_paladin = findViewById(R.id.desired_life_paladin);
        current_mana_paladin = findViewById(R.id.current_mana_paladin);
        desired_mana_paladin = findViewById(R.id.desired_mana_paladin);
        current_cap_paladin = findViewById(R.id.current_cap_paladin);
        desired_cap_paladin = findViewById(R.id.desired_cap_paladin);
        current_speed_paladin = findViewById(R.id.current_speed_paladin);
        desired_speed_paladin = findViewById(R.id.desired_speed_paladin);

        Glide.with(this)
                .load(R.drawable.knight_male)
                .into(knight_male);
        Glide.with(this)
                .load(R.drawable.knight_female)
                .into(knight_female);
        Glide.with(this)
                .load(R.drawable.mage_male)
                .into(mage_male);
        Glide.with(this)
                .load(R.drawable.mage_female)
                .into(mage_female);
        Glide.with(this)
                .load(R.drawable.hunter_male)
                .into(hunter_male);
        Glide.with(this)
                .load(R.drawable.hunter_female)
                .into(hunter_female);

        btn_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    if(!current_level.getText().toString().isEmpty()){
                        if(!desired_level.getText().toString().isEmpty()){
                            calcExp();
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    private void calcExp() {

        try {
            int current_level_int = Integer.parseInt(current_level.getText().toString());
            int desired_level_int = Integer.parseInt(desired_level.getText().toString());
            long cur_lvl_int;
            long des_lvl_int;
            long result;
            cur_lvl_int = (((50L * current_level_int * current_level_int * current_level_int) / 3)
                    - (100L * current_level_int * current_level_int)
                    + ((850L * current_level_int) / 3)) - 200;
            des_lvl_int = (((50L * desired_level_int * desired_level_int * desired_level_int) / 3)
                    - (100L * desired_level_int * desired_level_int)
                    + ((850L * desired_level_int) / 3)) - 200;
            result = des_lvl_int - cur_lvl_int;
            String exp_required_string = result + " "
                    + getString(R.string.exp_required_str)
                    + " " + desired_level_int;
            exp_required.setText(exp_required_string);
            lifeCalc();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void lifeCalc() {

        try{

            int current_level_int = Integer.parseInt(current_level.getText().toString());
            int desired_level_int = Integer.parseInt(desired_level.getText().toString());
            int cur_knight_life = (current_level_int - 8) * 15 + 185;
            int des_knight_life = (desired_level_int - 8) * 15 + 185;
            int cur_mage_life = current_level_int * 5 + 145;
            int des_mage_life = desired_level_int * 5 + 145;
            int cur_paladin_life = (current_level_int - 8) * 10 + 185;
            int des_paladin_life = (desired_level_int - 8) * 10 + 185;

            current_life_knight.setText(String.valueOf(cur_knight_life));
            desired_life_knight.setText(String.valueOf(des_knight_life));
            current_life_mage.setText(String.valueOf(cur_mage_life));
            desired_life_mage.setText(String.valueOf(des_mage_life));
            current_life_paladin.setText(String.valueOf(cur_paladin_life));
            desired_life_paladin.setText(String.valueOf(des_paladin_life));

            manaCalc();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void manaCalc() {

        try{

            int current_level_int = Integer.parseInt(current_level.getText().toString());
            int desired_level_int = Integer.parseInt(desired_level.getText().toString());
            int cur_knight = current_level_int * 5 + 50;
            int des_knight = desired_level_int * 5 + 50;
            int cur_mage = (current_level_int - 8) * 30 + 90;
            int des_mage = (desired_level_int - 8) * 30 + 90;
            int cur_paladin = (current_level_int - 8) * 15 + 90;
            int des_paladin = (desired_level_int - 8) * 15 + 90;

            current_mana_knight.setText(String.valueOf(cur_knight));
            desired_mana_knight.setText(String.valueOf(des_knight));
            current_mana_mage.setText(String.valueOf(cur_mage));
            desired_mana_mage.setText(String.valueOf(des_mage));
            current_mana_paladin.setText(String.valueOf(cur_paladin));
            desired_mana_paladin.setText(String.valueOf(des_paladin));

            capCalc();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void capCalc() {

        try{

            int current_level_int = Integer.parseInt(current_level.getText().toString());
            int desired_level_int = Integer.parseInt(desired_level.getText().toString());
            int cur_knight = (current_level_int - 8) * 25 + 470;
            int des_knight = (desired_level_int - 8) * 25 + 470;
            int cur_mage = current_level_int * 10 + 400;
            int des_mage = desired_level_int * 10 + 400;
            int cur_paladin = (current_level_int - 8) * 20 + 470;
            int des_paladin = (desired_level_int - 8) * 20 + 470;

            current_cap_knight.setText(String.valueOf(cur_knight));
            desired_cap_knight.setText(String.valueOf(des_knight));
            current_cap_mage.setText(String.valueOf(cur_mage));
            desired_cap_mage.setText(String.valueOf(des_mage));
            current_cap_paladin.setText(String.valueOf(cur_paladin));
            desired_cap_paladin.setText(String.valueOf(des_paladin));

            speedCalc();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void speedCalc() {

        try{

            int current_level_int = Integer.parseInt(current_level.getText().toString());
            int desired_level_int = Integer.parseInt(desired_level.getText().toString());
            int cur_speed = 220 + (2 * (current_level_int - 1));
            int des_speed = 220 + (2 * (desired_level_int - 1));

            current_speed_knight.setText(String.valueOf(cur_speed));
            desired_speed_knight.setText(String.valueOf(des_speed));
            current_speed_mage.setText(String.valueOf(cur_speed));
            desired_speed_mage.setText(String.valueOf(des_speed));
            current_speed_paladin.setText(String.valueOf(cur_speed));
            desired_speed_paladin.setText(String.valueOf(des_speed));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}