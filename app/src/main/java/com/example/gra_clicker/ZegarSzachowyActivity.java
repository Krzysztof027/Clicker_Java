package com.example.gra_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZegarSzachowyActivity extends AppCompatActivity {


    Button button;
    TextView textView1;
    TextView TextView2;
    Zegar zegar1;
    Zegar zegar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zegar_szachowy);

        button = findViewById(R.id.button3);

        textView1 = findViewById(R.id.textView5);
        TextView2 = findViewById(R.id.textView6);

        zegar1 = new Zegar(true, textView1);
        zegar2 = new Zegar(false, TextView2);
        zegar1.startTimer();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zegar1.isRunning()){
                    zegar1.stopTimer();
                    zegar2.startTimer();
                }
                else{
                    zegar1.startTimer();
                    zegar2.stopTimer();
                }
            }
        });
    }
}