package com.example.szilveszteri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UjevActivity extends AppCompatActivity {

    Button btnvissza,btnnyomdmeg;
    ImageView kep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ujev);

        btnvissza = findViewById(R.id.vissza);
        btnnyomdmeg = findViewById(R.id.nyomdmeg);
        kep = findViewById(R.id.kep);


        btnvissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(UjevActivity.this,MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });

        btnnyomdmeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                kep.startAnimation(animation);
            }
        });
    }
}