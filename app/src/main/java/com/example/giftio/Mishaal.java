package com.example.giftio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mishaal extends AppCompatActivity {

    private Button female, male;
    private TextView gender, username;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mishaal); male = (Button) findViewById(R.id.b1);
        female = (Button) findViewById(R.id.b2);
        username = (TextView) findViewById(R.id.t1);
        name = (EditText) findViewById(R.id.t2);
        gender = (TextView) findViewById(R.id.t3);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Mishaal.this, MaleActivity.class);
                startActivity(intent);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(Mishaal.this, FemaleActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );


    }
}
