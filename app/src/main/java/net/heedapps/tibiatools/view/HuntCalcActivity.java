package net.heedapps.tibiatools.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import net.heedapps.tibiatools.R;

public class HuntCalcActivity extends AppCompatActivity {

    private EditText general_balance, number_players, player_one_name, player_one_balance
            , player_two_name, player_two_balance, player_three_name, player_three_balance
            , player_four_name, player_four_balance, player_five_name, player_five_balance
            , player_six_name, player_six_balance, player_seven_name, player_seven_balance
            , player_eight_name, player_eight_balance, player_nine_name, player_nine_balance
            , player_ten_name, player_ten_balance;
    private TextView text_general_balance, text_player_one_balance, text_player_two_balance
            , text_player_three_balance, text_player_four_balance, text_player_five_balance
            , text_player_six_balance , text_player_seven_balance, text_player_eight_balance
            , text_player_nine_balance, text_player_ten_balance;
    private Button btn_calc;
    private int balance_players = 0, balance_general = 0, result = 0;
    private ImageButton add_btn, sub_btn;
    private AdView adViewHunt, adViewHuntTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunt_calc);

        //MobileAds.initialize(HuntCalcActivity.this, "ca-app-pub-5981899111891359~4261585507");
        //adViewHunt = (AdView) findViewById(R.id.adViewHunt);
        //adViewHuntTwo = (AdView) findViewById(R.id.adViewHuntTwo);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //adViewHunt.loadAd(adRequest);
        //adViewHuntTwo.loadAd(adRequest);

        general_balance = findViewById(R.id.general_balance);
        number_players = findViewById(R.id.number_players);
        player_one_name = findViewById(R.id.player_one_name);
        player_one_balance = findViewById(R.id.player_one_balance);
        player_two_name = findViewById(R.id.player_two_name);
        player_two_balance = findViewById(R.id.player_two_balance);
        player_three_name = findViewById(R.id.player_three_name);
        player_three_balance = findViewById(R.id.player_three_balance);
        player_four_name = findViewById(R.id.player_four_name);
        player_four_balance = findViewById(R.id.player_four_balance);
        player_five_name = findViewById(R.id.player_five_name);
        player_five_balance = findViewById(R.id.player_five_balance);
        player_six_name = findViewById(R.id.player_six_name);
        player_six_balance = findViewById(R.id.player_six_balance);
        player_seven_name = findViewById(R.id.player_seven_name);
        player_seven_balance = findViewById(R.id.player_seven_balance);
        player_eight_name = findViewById(R.id.player_eight_name);
        player_eight_balance = findViewById(R.id.player_eight_balance);
        player_nine_name = findViewById(R.id.player_nine_name);
        player_nine_balance = findViewById(R.id.player_nine_balance);
        player_ten_name = findViewById(R.id.player_ten_name);
        player_ten_balance = findViewById(R.id.player_ten_balance);

        text_general_balance = findViewById(R.id.text_general_balance);
        text_player_one_balance = findViewById(R.id.text_player_one_balance);
        text_player_two_balance = findViewById(R.id.text_player_two_balance);
        text_player_three_balance = findViewById(R.id.text_player_three_balance);
        text_player_four_balance = findViewById(R.id.text_player_four_balance);
        text_player_five_balance = findViewById(R.id.text_player_five_balance);
        text_player_six_balance = findViewById(R.id.text_player_six_balance);
        text_player_seven_balance = findViewById(R.id.text_player_seven_balance);
        text_player_eight_balance = findViewById(R.id.text_player_eight_balance);
        text_player_nine_balance = findViewById(R.id.text_player_nine_balance);
        text_player_ten_balance = findViewById(R.id.text_player_ten_balance);

        add_btn = findViewById(R.id.add_btn);
        sub_btn = findViewById(R.id.sub_btn);

        btn_calc = findViewById(R.id.btn_calc);

        number_players.setText("2");

        number_players.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    int numb_players = Integer.parseInt(number_players.getText().toString());
                    if (numb_players < 2 || numb_players > 10 || number_players.getText().toString() == "") {
                        text_general_balance.setText(getString(R.string.invalid_number));

                    } else if (numb_players == 2) {

                        player_three_name.setVisibility(View.GONE);
                        player_three_balance.setVisibility(View.GONE);
                        text_player_three_balance.setVisibility(View.GONE);

                        player_four_name.setVisibility(View.GONE);
                        player_four_balance.setVisibility(View.GONE);
                        text_player_four_balance.setVisibility(View.GONE);

                        player_five_name.setVisibility(View.GONE);
                        player_five_balance.setVisibility(View.GONE);
                        text_player_five_balance.setVisibility(View.GONE);

                        player_six_name.setVisibility(View.GONE);
                        player_six_balance.setVisibility(View.GONE);
                        text_player_six_balance.setVisibility(View.GONE);

                        player_seven_name.setVisibility(View.GONE);
                        player_seven_balance.setVisibility(View.GONE);
                        text_player_seven_balance.setVisibility(View.GONE);

                        player_eight_name.setVisibility(View.GONE);
                        player_eight_balance.setVisibility(View.GONE);
                        text_player_eight_balance.setVisibility(View.GONE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 3) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.GONE);
                        player_four_balance.setVisibility(View.GONE);
                        text_player_four_balance.setVisibility(View.GONE);

                        player_five_name.setVisibility(View.GONE);
                        player_five_balance.setVisibility(View.GONE);
                        text_player_five_balance.setVisibility(View.GONE);

                        player_six_name.setVisibility(View.GONE);
                        player_six_balance.setVisibility(View.GONE);
                        text_player_six_balance.setVisibility(View.GONE);

                        player_seven_name.setVisibility(View.GONE);
                        player_seven_balance.setVisibility(View.GONE);
                        text_player_seven_balance.setVisibility(View.GONE);

                        player_eight_name.setVisibility(View.GONE);
                        player_eight_balance.setVisibility(View.GONE);
                        text_player_eight_balance.setVisibility(View.GONE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 4) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.GONE);
                        player_five_balance.setVisibility(View.GONE);
                        text_player_five_balance.setVisibility(View.GONE);

                        player_six_name.setVisibility(View.GONE);
                        player_six_balance.setVisibility(View.GONE);
                        text_player_six_balance.setVisibility(View.GONE);

                        player_seven_name.setVisibility(View.GONE);
                        player_seven_balance.setVisibility(View.GONE);
                        text_player_seven_balance.setVisibility(View.GONE);

                        player_eight_name.setVisibility(View.GONE);
                        player_eight_balance.setVisibility(View.GONE);
                        text_player_eight_balance.setVisibility(View.GONE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 5) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.VISIBLE);
                        player_five_balance.setVisibility(View.VISIBLE);
                        text_player_five_balance.setVisibility(View.VISIBLE);

                        player_six_name.setVisibility(View.GONE);
                        player_six_balance.setVisibility(View.GONE);
                        text_player_six_balance.setVisibility(View.GONE);

                        player_seven_name.setVisibility(View.GONE);
                        player_seven_balance.setVisibility(View.GONE);
                        text_player_seven_balance.setVisibility(View.GONE);

                        player_eight_name.setVisibility(View.GONE);
                        player_eight_balance.setVisibility(View.GONE);
                        text_player_eight_balance.setVisibility(View.GONE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 6) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.VISIBLE);
                        player_five_balance.setVisibility(View.VISIBLE);
                        text_player_five_balance.setVisibility(View.VISIBLE);

                        player_six_name.setVisibility(View.VISIBLE);
                        player_six_balance.setVisibility(View.VISIBLE);
                        text_player_six_balance.setVisibility(View.VISIBLE);

                        player_seven_name.setVisibility(View.GONE);
                        player_seven_balance.setVisibility(View.GONE);
                        text_player_seven_balance.setVisibility(View.GONE);

                        player_eight_name.setVisibility(View.GONE);
                        player_eight_balance.setVisibility(View.GONE);
                        text_player_eight_balance.setVisibility(View.GONE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 7) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.VISIBLE);
                        player_five_balance.setVisibility(View.VISIBLE);
                        text_player_five_balance.setVisibility(View.VISIBLE);

                        player_six_name.setVisibility(View.VISIBLE);
                        player_six_balance.setVisibility(View.VISIBLE);
                        text_player_six_balance.setVisibility(View.VISIBLE);

                        player_seven_name.setVisibility(View.VISIBLE);
                        player_seven_balance.setVisibility(View.VISIBLE);
                        text_player_seven_balance.setVisibility(View.VISIBLE);

                        player_eight_name.setVisibility(View.GONE);
                        player_eight_balance.setVisibility(View.GONE);
                        text_player_eight_balance.setVisibility(View.GONE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 8) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.VISIBLE);
                        player_five_balance.setVisibility(View.VISIBLE);
                        text_player_five_balance.setVisibility(View.VISIBLE);

                        player_six_name.setVisibility(View.VISIBLE);
                        player_six_balance.setVisibility(View.VISIBLE);
                        text_player_six_balance.setVisibility(View.VISIBLE);

                        player_seven_name.setVisibility(View.VISIBLE);
                        player_seven_balance.setVisibility(View.VISIBLE);
                        text_player_seven_balance.setVisibility(View.VISIBLE);

                        player_eight_name.setVisibility(View.VISIBLE);
                        player_eight_balance.setVisibility(View.VISIBLE);
                        text_player_eight_balance.setVisibility(View.VISIBLE);

                        player_nine_name.setVisibility(View.GONE);
                        player_nine_balance.setVisibility(View.GONE);
                        text_player_nine_balance.setVisibility(View.GONE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 9) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.VISIBLE);
                        player_five_balance.setVisibility(View.VISIBLE);
                        text_player_five_balance.setVisibility(View.VISIBLE);

                        player_six_name.setVisibility(View.VISIBLE);
                        player_six_balance.setVisibility(View.VISIBLE);
                        text_player_six_balance.setVisibility(View.VISIBLE);

                        player_seven_name.setVisibility(View.VISIBLE);
                        player_seven_balance.setVisibility(View.VISIBLE);
                        text_player_seven_balance.setVisibility(View.VISIBLE);

                        player_eight_name.setVisibility(View.VISIBLE);
                        player_eight_balance.setVisibility(View.VISIBLE);
                        text_player_eight_balance.setVisibility(View.VISIBLE);

                        player_nine_name.setVisibility(View.VISIBLE);
                        player_nine_balance.setVisibility(View.VISIBLE);
                        text_player_nine_balance.setVisibility(View.VISIBLE);

                        player_ten_name.setVisibility(View.GONE);
                        player_ten_balance.setVisibility(View.GONE);
                        text_player_ten_balance.setVisibility(View.GONE);

                    } else if (numb_players == 10) {

                        player_three_name.setVisibility(View.VISIBLE);
                        player_three_balance.setVisibility(View.VISIBLE);
                        text_player_three_balance.setVisibility(View.VISIBLE);

                        player_four_name.setVisibility(View.VISIBLE);
                        player_four_balance.setVisibility(View.VISIBLE);
                        text_player_four_balance.setVisibility(View.VISIBLE);

                        player_five_name.setVisibility(View.VISIBLE);
                        player_five_balance.setVisibility(View.VISIBLE);
                        text_player_five_balance.setVisibility(View.VISIBLE);

                        player_six_name.setVisibility(View.VISIBLE);
                        player_six_balance.setVisibility(View.VISIBLE);
                        text_player_six_balance.setVisibility(View.VISIBLE);

                        player_seven_name.setVisibility(View.VISIBLE);
                        player_seven_balance.setVisibility(View.VISIBLE);
                        text_player_seven_balance.setVisibility(View.VISIBLE);

                        player_eight_name.setVisibility(View.VISIBLE);
                        player_eight_balance.setVisibility(View.VISIBLE);
                        text_player_eight_balance.setVisibility(View.VISIBLE);

                        player_nine_name.setVisibility(View.VISIBLE);
                        player_nine_balance.setVisibility(View.VISIBLE);
                        text_player_nine_balance.setVisibility(View.VISIBLE);

                        player_ten_name.setVisibility(View.VISIBLE);
                        player_ten_balance.setVisibility(View.VISIBLE);
                        text_player_ten_balance.setVisibility(View.VISIBLE);

                    }

                    calculateGeneralBalance();

                }catch (Exception e){

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        general_balance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateGeneralBalance();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub_string = number_players.getText().toString();
                int sub_int = Integer.parseInt(sub_string);
                if(sub_int == 2){
                    text_general_balance.setText(getString(R.string.invalid_number));
                }else{
                    sub_int = sub_int - 1;
                    number_players.setText(String.valueOf(sub_int));
                }
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add_string = number_players.getText().toString();
                int add_int = Integer.parseInt(add_string);
                if(add_int == 10){
                    text_general_balance.setText(getString(R.string.invalid_number));
                }else{
                    add_int = add_int + 1;
                    number_players.setText(String.valueOf(add_int));
                }
            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    int numb_players = Integer.parseInt(number_players.getText().toString());
                    String message = "";

                    if(numb_players == 2){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());

                        player_two_result = result - player_two_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                    }else if(numb_players == 3){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                    }else if(numb_players == 4){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                    }else if(numb_players == 5){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());
                        int player_five_result = Integer.parseInt(player_five_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;
                        player_five_result = result - player_five_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                        if(player_five_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_five_result < 0){
                            player_five_result = player_five_result * -1;
                        }

                        message = player_five_name.getText().toString() + " " + message + " " + player_five_result;

                        if(player_five_result == 0){
                            message = player_five_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_five_balance.setText(message);

                        message = "";

                    }else if(numb_players == 6){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());
                        int player_five_result = Integer.parseInt(player_five_balance.getText().toString());
                        int player_six_result = Integer.parseInt(player_six_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;
                        player_five_result = result - player_five_result;
                        player_six_result = result - player_six_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                        if(player_five_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_five_result < 0){
                            player_five_result = player_five_result * -1;
                        }

                        message = player_five_name.getText().toString() + " " + message + " " + player_five_result;

                        if(player_five_result == 0){
                            message = player_five_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_five_balance.setText(message);

                        message = "";

                        if(player_six_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_six_result < 0){
                            player_six_result = player_six_result * -1;
                        }

                        message = player_six_name.getText().toString() + " " + message + " " + player_six_result;

                        if(player_six_result == 0){
                            message = player_six_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_six_balance.setText(message);

                        message = "";

                    }else if(numb_players == 7){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());
                        int player_five_result = Integer.parseInt(player_five_balance.getText().toString());
                        int player_six_result = Integer.parseInt(player_six_balance.getText().toString());
                        int player_seven_result = Integer.parseInt(player_seven_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;
                        player_five_result = result - player_five_result;
                        player_six_result = result - player_six_result;
                        player_seven_result = result - player_seven_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                        if(player_five_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_five_result < 0){
                            player_five_result = player_five_result * -1;
                        }

                        message = player_five_name.getText().toString() + " " + message + " " + player_five_result;

                        if(player_five_result == 0){
                            message = player_five_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_five_balance.setText(message);

                        message = "";

                        if(player_six_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_six_result < 0){
                            player_six_result = player_six_result * -1;
                        }

                        message = player_six_name.getText().toString() + " " + message + " " + player_six_result;

                        if(player_six_result == 0){
                            message = player_six_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_six_balance.setText(message);

                        message = "";

                        if(player_seven_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_seven_result < 0){
                            player_seven_result = player_seven_result * -1;
                        }

                        message = player_seven_name.getText().toString() + " " + message + " " + player_seven_result;

                        if(player_seven_result == 0){
                            message = player_seven_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_seven_balance.setText(message);

                        message = "";

                    }else if(numb_players == 8){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());
                        int player_five_result = Integer.parseInt(player_five_balance.getText().toString());
                        int player_six_result = Integer.parseInt(player_six_balance.getText().toString());
                        int player_seven_result = Integer.parseInt(player_seven_balance.getText().toString());
                        int player_eight_result = Integer.parseInt(player_eight_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;
                        player_five_result = result - player_five_result;
                        player_six_result = result - player_six_result;
                        player_seven_result = result - player_seven_result;
                        player_eight_result = result - player_eight_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                        if(player_five_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_five_result < 0){
                            player_five_result = player_five_result * -1;
                        }

                        message = player_five_name.getText().toString() + " " + message + " " + player_five_result;

                        if(player_five_result == 0){
                            message = player_five_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_five_balance.setText(message);

                        message = "";

                        if(player_six_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_six_result < 0){
                            player_six_result = player_six_result * -1;
                        }

                        message = player_six_name.getText().toString() + " " + message + " " + player_six_result;

                        if(player_six_result == 0){
                            message = player_six_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_six_balance.setText(message);

                        message = "";

                        if(player_seven_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_seven_result < 0){
                            player_seven_result = player_seven_result * -1;
                        }

                        message = player_seven_name.getText().toString() + " " + message + " " + player_seven_result;

                        if(player_seven_result == 0){
                            message = player_seven_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_seven_balance.setText(message);

                        message = "";

                        if(player_eight_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_eight_result < 0){
                            player_eight_result = player_eight_result * -1;
                        }

                        message = player_eight_name.getText().toString() + " " + message + " " + player_eight_result;

                        if(player_eight_result == 0){
                            message = player_eight_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_eight_balance.setText(message);

                        message = "";

                    }else if(numb_players == 9){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());
                        int player_five_result = Integer.parseInt(player_five_balance.getText().toString());
                        int player_six_result = Integer.parseInt(player_six_balance.getText().toString());
                        int player_seven_result = Integer.parseInt(player_seven_balance.getText().toString());
                        int player_eight_result = Integer.parseInt(player_eight_balance.getText().toString());
                        int player_nine_result = Integer.parseInt(player_nine_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;
                        player_five_result = result - player_five_result;
                        player_six_result = result - player_six_result;
                        player_seven_result = result - player_seven_result;
                        player_eight_result = result - player_eight_result;
                        player_nine_result = result - player_nine_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                        if(player_five_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_five_result < 0){
                            player_five_result = player_five_result * -1;
                        }

                        message = player_five_name.getText().toString() + " " + message + " " + player_five_result;

                        if(player_five_result == 0){
                            message = player_five_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_five_balance.setText(message);

                        message = "";

                        if(player_six_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_six_result < 0){
                            player_six_result = player_six_result * -1;
                        }

                        message = player_six_name.getText().toString() + " " + message + " " + player_six_result;

                        if(player_six_result == 0){
                            message = player_six_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_six_balance.setText(message);

                        message = "";

                        if(player_seven_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_seven_result < 0){
                            player_seven_result = player_seven_result * -1;
                        }

                        message = player_seven_name.getText().toString() + " " + message + " " + player_seven_result;

                        if(player_seven_result == 0){
                            message = player_seven_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_seven_balance.setText(message);

                        message = "";

                        if(player_eight_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_eight_result < 0){
                            player_eight_result = player_eight_result * -1;
                        }

                        message = player_eight_name.getText().toString() + " " + message + " " + player_eight_result;

                        if(player_eight_result == 0){
                            message = player_eight_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_eight_balance.setText(message);

                        message = "";

                        if(player_nine_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_nine_result < 0){
                            player_nine_result = player_nine_result * -1;
                        }

                        message = player_nine_name.getText().toString() + " " + message + " " + player_nine_result;

                        if(player_nine_result == 0){
                            message = player_nine_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_nine_balance.setText(message);

                        message = "";

                    }else if(numb_players == 10){

                        int player_two_result = Integer.parseInt(player_two_balance.getText().toString());
                        int player_three_result = Integer.parseInt(player_three_balance.getText().toString());
                        int player_four_result = Integer.parseInt(player_four_balance.getText().toString());
                        int player_five_result = Integer.parseInt(player_five_balance.getText().toString());
                        int player_six_result = Integer.parseInt(player_six_balance.getText().toString());
                        int player_seven_result = Integer.parseInt(player_seven_balance.getText().toString());
                        int player_eight_result = Integer.parseInt(player_eight_balance.getText().toString());
                        int player_nine_result = Integer.parseInt(player_nine_balance.getText().toString());
                        int player_ten_result = Integer.parseInt(player_ten_balance.getText().toString());

                        player_two_result = result - player_two_result;
                        player_three_result = result - player_three_result;
                        player_four_result = result - player_four_result;
                        player_five_result = result - player_five_result;
                        player_six_result = result - player_six_result;
                        player_seven_result = result - player_seven_result;
                        player_eight_result = result - player_eight_result;
                        player_nine_result = result - player_nine_result;
                        player_ten_result = result - player_ten_result;

                        if(player_two_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_two_result < 0){
                            player_two_result = player_two_result * -1;
                        }

                        message = player_two_name.getText().toString() + " " + message + " " + player_two_result;

                        if(player_two_result == 0){
                            message = player_two_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_two_balance.setText(message);

                        message = "";

                        if(player_three_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_three_result < 0){
                            player_three_result = player_three_result * -1;
                        }

                        message = player_three_name.getText().toString() + " " + message + " " + player_three_result;

                        if(player_three_result == 0){
                            message = player_three_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_three_balance.setText(message);

                        message = "";

                        if(player_four_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_four_result < 0){
                            player_four_result = player_four_result * -1;
                        }

                        message = player_four_name.getText().toString() + " " + message + " " + player_four_result;

                        if(player_four_result == 0){
                            message = player_four_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_four_balance.setText(message);

                        message = "";

                        if(player_five_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_five_result < 0){
                            player_five_result = player_five_result * -1;
                        }

                        message = player_five_name.getText().toString() + " " + message + " " + player_five_result;

                        if(player_five_result == 0){
                            message = player_five_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_five_balance.setText(message);

                        message = "";

                        if(player_six_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_six_result < 0){
                            player_six_result = player_six_result * -1;
                        }

                        message = player_six_name.getText().toString() + " " + message + " " + player_six_result;

                        if(player_six_result == 0){
                            message = player_six_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_six_balance.setText(message);

                        message = "";

                        if(player_seven_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_seven_result < 0){
                            player_seven_result = player_seven_result * -1;
                        }

                        message = player_seven_name.getText().toString() + " " + message + " " + player_seven_result;

                        if(player_seven_result == 0){
                            message = player_seven_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_seven_balance.setText(message);

                        message = "";

                        if(player_eight_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_eight_result < 0){
                            player_eight_result = player_eight_result * -1;
                        }

                        message = player_eight_name.getText().toString() + " " + message
                                + " " + player_eight_result;

                        if(player_eight_result == 0){
                            message = player_eight_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_eight_balance.setText(message);

                        message = "";

                        if(player_nine_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_nine_result < 0){
                            player_nine_result = player_nine_result * -1;
                        }

                        message = player_nine_name.getText().toString() + " " + message
                                + " " + player_nine_result;

                        if(player_nine_result == 0){
                            message = player_nine_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_nine_balance.setText(message);

                        message = "";

                        if(player_ten_result > 0){
                            message = getString(R.string.must_receive);
                        }else{
                            message = getString(R.string.must_pay);
                        }

                        if(player_ten_result < 0){
                            player_ten_result = player_ten_result * -1;
                        }

                        message = player_ten_name.getText().toString() + " " + message
                                + " " + player_ten_result;

                        if(player_ten_result == 0){
                            message = player_ten_name.getText().toString() + " "
                                    + getString(R.string.not_pay_receive);
                        }

                        text_player_ten_balance.setText(message);

                        message = "";

                    }

                }catch (Exception e){
                    Toast.makeText(HuntCalcActivity.this, getString(R.string.verify_fields), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void calculateGeneralBalance(){

        text_general_balance.setText("");
        try{

            int numb_players = Integer.parseInt(number_players.getText().toString());
            if (numb_players < 2 || numb_players > 10
                    || number_players.getText().toString().equals("")) {

                text_general_balance.setText(getString(R.string.invalid_number));

            }else {

                balance_general = Integer.parseInt(general_balance.getText().toString());
                balance_players = Integer.parseInt(number_players.getText().toString());
                result = balance_general / balance_players;
                String result_final = String.valueOf(result);
                result_final = getString(R.string.final_balance) + " " + result_final;
                text_general_balance.setText(result_final);

            }

        }catch (Exception e){
            text_general_balance.setText(getString(R.string.empty_fields));
        }

    }
}