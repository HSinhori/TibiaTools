package net.heedapps.tibiatools.calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import net.heedapps.tibiatools.R;

public class SharedExpActivity extends AppCompatActivity {

    EditText main_level;
    TextView min_level, max_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_exp);

        main_level = findViewById(R.id.main_level);
        min_level = findViewById(R.id.text_min_level);
        max_level = findViewById(R.id.text_max_level);

        main_level.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedCalc();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void sharedCalc(){
        try{

            if(main_level.getText().toString().equals("")){
                min_level.setText(getString(R.string.min_level));
                max_level.setText(getString(R.string.max_level));
            }

            float main_lv = Float.parseFloat(main_level.getText().toString());
            float min_lv = main_lv / 3 * 2;
            int min_lv_int = Integer.parseInt(main_level.getText().toString()) / 3 * 2;
            float max_lv = main_lv / 2 * 3;
            int max_lv_int = Integer.parseInt(main_level.getText().toString()) / 2 * 3;
            float result_min = min_lv - min_lv_int;
            float result_max = max_lv - max_lv_int;

            if(result_min > 0){
                min_lv_int = min_lv_int + 1;
            }
            if(result_max > 0){
                max_lv_int = max_lv_int + 1;
            }

            String text_min_lv = "";
            String text_max_lv = "";

            if(main_lv > 0){
                text_min_lv = getString(R.string.min_level) + " " + min_lv_int;
                min_level.setText(text_min_lv);
                text_max_lv = getString(R.string.max_level) + " " + max_lv_int;
                max_level.setText(text_max_lv);
            }else{
                min_level.setText(getString(R.string.min_level));
                max_level.setText(getString(R.string.max_level));
            }

        }catch (Exception e){
            Toast.makeText(SharedExpActivity.this, getString(R.string.verify_fields), Toast.LENGTH_SHORT).show();
        }
    }

}