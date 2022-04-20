package net.heedapps.tibiatools.funcs.damage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.heedapps.tibiatools.R;

public class FrostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frost);

        Button btn_calc_strike = findViewById(R.id.btn_calc_frost);
        EditText basic_price = findViewById(R.id.frosty_heart_price);
        EditText intricate_price = findViewById(R.id.seacrest_hair_price);
        EditText powerfull_price = findViewById(R.id.polar_bear_paw_price);
        TextView low_imbui = findViewById(R.id.low_imbui_frost);
        TextView full_imbui = findViewById(R.id.full_imbui_frost);

        btn_calc_strike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    int int_basic = 0;
                    int int_intri = 0;
                    int int_power = 0;
                    int result_low = 0;
                    int result_full = 0;
                    int type_low = 25;
                    int type_intri = 10;
                    int type_power = 5;
                    int type = 0;
                    String[] type_string= {
                            getString(R.string.costlowbasic),
                            getString(R.string.costlowintricate),
                            getString(R.string.costlowpowerfull)
                    };

                    if(!basic_price.getText().toString().isEmpty()){
                        int_basic = Integer.parseInt(basic_price.getText().toString());
                    }
                    if(!intricate_price.getText().toString().isEmpty()){
                        int_intri = Integer.parseInt(intricate_price.getText().toString());
                    }
                    if(!powerfull_price.getText().toString().isEmpty()){
                        int_power = Integer.parseInt(powerfull_price.getText().toString());
                    }

                    if(int_basic > 0){
                        result_low = type_low*int_basic + 5000;
                        result_full = result_low + 10000;
                        if(int_intri > 0){
                            result_low = result_low + type_intri*int_intri + 20000;
                            result_full = result_low + 30000;
                            type = 1;
                            if(int_power > 0){
                                result_low = result_low + type_power*int_power + 75000;
                                result_full = result_low + 50000;
                                type = 2;
                            }
                        }
                        String low_msg = type_string[type]
                                + " " + result_low
                                + " " + getString(R.string.must_profit)
                                + " " + result_low/20 + " "
                                + getString(R.string.per_hour);
                        String full_msg = getString(R.string.costfull)
                                + " " + result_full
                                + " " + getString(R.string.must_profit)
                                + " " + result_full/20 + " "
                                +getString(R.string.per_hour);
                        low_imbui.setText(low_msg);
                        full_imbui.setText(full_msg);

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}