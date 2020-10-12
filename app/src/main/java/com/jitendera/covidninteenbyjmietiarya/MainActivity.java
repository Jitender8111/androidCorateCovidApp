package com.jitendera.covidninteenbyjmietiarya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 5000;
    CardView cardviewforimagesplash;
    ImageView img;
    TextView tvTracker;
    Animation topAnim,bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animator);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.top_animator);

        cardviewforimagesplash = findViewById(R.id.cardviewforimagesplash);
        img = findViewById(R.id.imageviewforsplash);
        tvTracker = findViewById(R.id.tvtrackersplash);

        cardviewforimagesplash.setAnimation(topAnim);
        img.setAnimation(topAnim);
        tvTracker.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,IndiaCovidTracking.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}