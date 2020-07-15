package com.example.giftio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ThankyouActivity extends AppCompatActivity {
    private Button thankyou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thankyou);
        thankyou=(Button)  findViewById(R.id.thank);
        thankyou.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Animation animation= AnimationUtils.loadAnimation(ThankyouActivity.this,R.anim.mixed_anim);
                                            thankyou.startAnimation(animation);


                                        }
                                    }
        );


    }
}
