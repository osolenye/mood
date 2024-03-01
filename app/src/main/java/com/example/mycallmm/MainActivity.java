package com.example.mycallmm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_generate;
    TextView txt_otvet, txt_main;
    int otvetInt, getOtvetInt;
    LottieAnimationView lottie_sun, lottie_one, lottie_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_generate = findViewById(R.id.btn_generate);
        txt_otvet = findViewById(R.id.txt_procent);
        txt_main = findViewById(R.id.txt_main);

        lottie_sun = findViewById(R.id.lottie_sun);
        lottie_one = findViewById(R.id.lottie_one);
        lottie_two = findViewById(R.id.lottie_two);

        lottie_sun.setAnimation(R.raw.sunshine);
        lottie_one.setAnimation(R.raw.animation_fire);
        lottie_two.setAnimation(R.raw.fun_time);

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                getOtvetInt = random.nextInt(100);
                otvetInt = getOtvetInt;

                if (( otvetInt !=0 )) {
                    txt_otvet.setText(String.valueOf(otvetInt)+ " %");
                    printAnswer();
                    btn_generate.setVisibility(View.VISIBLE);

                }else {
                    Toast.makeText(MainActivity.this, "Нажмите ещё один раз", Toast.LENGTH_SHORT).show();
                    btn_generate.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void printAnswer() {
        if(otvetInt >= 1 && otvetInt <= 48){
            txt_main.setText("Не печалься(((");
            lottie_two.setVisibility(View.GONE);
            lottie_one.setVisibility(View.VISIBLE);

        }else {
            if(otvetInt >= 48 && otvetInt <= 65){
                txt_main.setText("Хехей все круто!!");
                lottie_two.setVisibility(View.GONE);
                lottie_one.setVisibility(View.VISIBLE);



            } else{
                if(otvetInt >= 65 && otvetInt <= 100){
                    txt_main.setText("Супер кайф");
                    lottie_one.setVisibility(View.GONE);
                    lottie_two.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}