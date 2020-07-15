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

public class FemaleActivity extends AppCompatActivity {

    Timer timer;

    private Button ready1;
    ImageView imageView;
    Random r;
    Integer [] femaleimg={

            R.drawable.bangles,
            R.drawable.ring,
            R.drawable.perfumegirl,
            R.drawable.makeup,
            R.drawable.earing,
            R.drawable.bg,
            R.drawable.braclt,
            R.drawable.diary,
            R.drawable.girlphonecover,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(FemaleActivity.this,ThankyouActivity.class);
                startActivity(intent);
                finish();
            }
        } ,3000);

        ready1=(Button)  findViewById(R.id.ready1);

        imageView=(ImageView) findViewById(R.id.image1) ;

        r=new Random();

        ready1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Animation animation= AnimationUtils.loadAnimation(FemaleActivity.this,R.anim.mixed_anim);
                                          ready1.startAnimation(animation);


                                          imageView.setImageResource(femaleimg[r.nextInt(femaleimg.length)]);

                                          // Intent intent = new Intent(FemaleActivity.this, ThankyouActivity.class);
                                          // startActivity(intent);
                                      }
                                  }
        );


    }
}
