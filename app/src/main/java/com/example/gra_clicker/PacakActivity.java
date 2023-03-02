package com.example.gra_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PacakActivity extends AppCompatActivity {

    private ArrayList<ImageView> imageViews = new ArrayList<>();
    //dodawanie do listy

    private int czas=10;
    private TextView textViewCzas;
    private TextView textViewPunkty;
    private int punkty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacak);
        textViewCzas = findViewById(R.id.textView);
        textViewPunkty = findViewById(R.id.textView3);
        ImageView imageView = findViewById(R.id.imageView);
        imageViews.add(imageView);
        imageViews.add((ImageView) findViewById(R.id.imageView));
        imageViews.add(findViewById(R.id.imageView2));
        imageViews.add(findViewById(R.id.imageView3));
        imageViews.add(findViewById(R.id.imageView4));
        pokazJedenObraz();
        Zliczaj();
    }
    private void Zliczaj(){
        final Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if (czas > 0) {
                            czas--;
                            textViewCzas.setText("Czas" + Integer.toString(czas));
                            pokazJedenObraz();
                        }
                        else{
                            for(ImageView obraz:imageViews){
                                obraz.setVisibility(View.INVISIBLE);
                            }
                        }
                        handler.postDelayed(this, 1000);
                    }
                }
        );
    }

    private void pokazJedenObraz(){
        for(ImageView obraz:imageViews){
            obraz.setVisibility(View.INVISIBLE);
        }
        //int zaokrągla do 0
        //pomnożone jako imageVIew.size
        int wylosowana = (int) (Math.random()*imageViews.size());
        imageViews.get(wylosowana).setVisibility(View.VISIBLE);
        imageViews.get(wylosowana).setVisibility(View.VISIBLE);


        if(czas>0){
        imageViews.get(wylosowana).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        punkty++;
                        textViewPunkty.setText("Punkty" + Integer.toString(punkty));
                        pokazJedenObraz();
                    }
                }
        );
    }
    }


}