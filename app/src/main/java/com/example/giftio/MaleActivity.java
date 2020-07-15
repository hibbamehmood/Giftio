package com.example.giftio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MaleActivity extends AppCompatActivity {

    Timer timer;
    private Button ready;
    ImageView imageView;
    Random r;
    Integer [] maleimg={

            R.drawable.shirt,
            R.drawable.perfumeboy,
            R.drawable.stud1,
            R.drawable.t,
            R.drawable.headphone,
            R.drawable.boyphonecover,
            R.drawable.boywactch,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MaleActivity.this,ThankyouActivity.class);
                startActivity(intent);
                finish();
            }
        } ,3000);

        ready=(Button)  findViewById(R.id.ready);
        imageView=(ImageView) findViewById(R.id.image) ;

        r=new Random();


        ready.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Animation animation= AnimationUtils.loadAnimation(MaleActivity.this,R.anim.mixed_anim);
                                         ready.startAnimation(animation);

                                         imageView.setImageResource(maleimg[r.nextInt(maleimg.length)]);

                                         //  Intent intent = new Intent(MaleActivity.this, ThankyouActivity.class);
                                         // startActivity(intent);
                                     }
                                 }
        );


    }
}
