package net.heedapps.tibiatools.funcs.attr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.heedapps.tibiatools.R;

public class VoidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_void);

        Button btn_calc_void = findViewById(R.id.btn_calc_void);
        EditText gold_token = findViewById(R.id.gold_token_price_void);
        EditText basic_price = findViewById(R.id.rope_price);
        EditText intricate_price = findViewById(R.id.silencer_price);
        EditText powerfull_price = findViewById(R.id.grimeleech_price);
        TextView gold_imbui = findViewById(R.id.gold_imbui_void);
        TextView low_imbui = findViewById(R.id.low_imbui_void);
        TextView full_imbui = findViewById(R.id.full_imbui_void);

        btn_calc_void.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    int int_gold_token = 0;
                    int int_total_itens = 0;
                    int int_basic = 0;
                    int int_intri = 0;
                    int int_power = 0;
                    int result_low = 0;
                    int result_full = 0;
                    int type_low = 20;
                    int type_intri = 25;
                    int type_power = 5;
                    int type = 0;
                    String[] type_string= {
                            getString(R.string.costlowbasic),
                            getString(R.string.costlowintricate),
                            getString(R.string.costlowpowerfull)
                    };

                    if(!gold_token.getText().toString().isEmpty()){
                        int_gold_token = Integer.parseInt(gold_token.getText().toString());
                    }
                    if(!basic_price.getText().toString().isEmpty()){
                        int_basic = Integer.parseInt(basic_price.getText().toString());
                        int_total_itens = int_basic * type_low;
                    }
                    if(!intricate_price.getText().toString().isEmpty()){
                        int_intri = Integer.parseInt(intricate_price.getText().toString());
                        int_total_itens = int_total_itens + int_intri * type_intri;
                    }
                    if(!powerfull_price.getText().toString().isEmpty()){
                        int_power = Integer.parseInt(powerfull_price.getText().toString());
                        int_total_itens = int_total_itens + int_power * type_power;
                    }

                    if(int_basic > 0){
                        result_low = type_low*int_basic + 5000;
                        result_full = result_low + 10000;
                        int_gold_token = int_gold_token * 2;
                        if(int_intri > 0){
                            result_low = result_low + type_intri*int_intri + 20000;
                            result_full = result_low + 30000;
                            int_gold_token = int_gold_token / 2 * 4;
                            type = 1;
                            if(int_power > 0){
                                result_low = result_low + type_power*int_power + 75000;
                                result_full = result_low + 50000;
                                int_gold_token = int_gold_token / 4 * 6;
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
                        String gold_or_itens = "";
                        if(int_gold_token > int_total_itens){
                            int total = int_gold_token - int_total_itens;
                            gold_or_itens = getString(R.string.market_cheaper)
                                    + " " + total
                                    + " gold pieces.";
                        }else{
                            int total = int_total_itens - int_gold_token;
                            gold_or_itens = getString(R.string.gold_cheaper)
                                    + " " + total
                                    + " gold pieces.";
                        }
                        low_imbui.setText(low_msg);
                        full_imbui.setText(full_msg);
                        gold_imbui.setText(gold_or_itens);

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}