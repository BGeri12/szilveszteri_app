package com.example.szilveszteri_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnJatek,btnUjev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listeners();
    }

    private void init() {

            btnJatek = findViewById(R.id.btn_jatek);
            btnUjev = findViewById(R.id.btn_BU);
    }

    private void listeners(){

        btnJatek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent jatek = new Intent(MainActivity.this,MasnaposJatekActivity.class);
                 startActivity(jatek);
                 finish();
            }
        });

        btnUjev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ujev = new Intent(MainActivity.this,UjevActivity.class);
                startActivity(ujev);
                finish();
            }
        });

    }

}