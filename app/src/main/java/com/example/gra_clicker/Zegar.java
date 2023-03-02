package com.example.gra_clicker;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Zegar {

    private boolean running;
    private int sekundy = 180;
    private TextView timeView;
    private CountDownTimer timer;

    public Zegar(boolean running, TextView timeView) {
        this.running = running;
        this.timeView = timeView;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void startTimer(){
        timer = new CountDownTimer(sekundy * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sekundy = (int) millisUntilFinished/1000;//Pokazuje ile sekund zostało. Zamieniamy na minisekundy, dlatego dzielimy na 1000
                pokazCzas(sekundy);//pokazuje sekundy
            }

            @Override
            public void onFinish() {
                timeView.setText("Koniec");
            }
        };
        timer.start();//Startujemy zegar
        setRunning(true);//Zmieniamy zegar na idący
    }

    public void stopTimer(){
        timer.cancel();//Wstrzymujemy czas
        setRunning(false);//stop
    }

    private void pokazCzas(int s){
        int minuty = (s%60);
        int sek = s - minuty*60;
        timeView.setText(String.format("%02d; %02d", minuty, sek));//pokaż czas
    }

}
