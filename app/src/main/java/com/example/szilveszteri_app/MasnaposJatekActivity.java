package com.example.szilveszteri_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MasnaposJatekActivity extends AppCompatActivity {


    private ImageView imagekepTe, imagekepGep;
    private ImageView gimageHp1, gimageHp2, gimageHp3;
    private ImageView eimageHp1, eimageHp2, eimageHp3;
    private TextView emberkiir, gepkiir, dontetlen;
    private Button btnKo, btnPapir, btnOllo ,btnVissza;
    private String gepValasztas, emberValasztas;
    private int gepSzamol,emberSzamol,dontetlenSzamol,eletEmber,eletGep;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masnapos_jatek);

        rnd = new Random();
        init();
        listeners();
        eletEmber = 3;
        eletGep= 3;
    }

    private void init() {

        imagekepGep = findViewById(R.id.image_kepGep);
        imagekepTe = findViewById(R.id.image_kepTe);
        btnKo = findViewById(R.id.btn_Ko);
        btnPapir = findViewById(R.id.btn_Papir);
        btnOllo = findViewById(R.id.btn_Ollo);
        btnVissza = findViewById(R.id.vissza);
        emberkiir = findViewById(R.id.ember);
        gepkiir = findViewById(R.id.gep);
        gimageHp1 = findViewById(R.id.image_ghp1);
        gimageHp2 = findViewById(R.id.image_ghp2);
        gimageHp3 = findViewById(R.id.image_ghp3);
        eimageHp1 = findViewById(R.id.image_ehp1);
        eimageHp2 = findViewById(R.id.image_ehp2);
        eimageHp3 = findViewById(R.id.image_ehp3);
        dontetlen = findViewById(R.id.dontetlen);
    }

    private void listeners(){

        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emberValasztas = "Kő";
                imagekepTe.setImageResource(R.drawable.rock);
                Jatek();
            }
        });

        btnPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emberValasztas = "Papir";
                imagekepTe.setImageResource(R.drawable.paper);
                Jatek();
            }
        });

        btnOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emberValasztas = "Olló";
                imagekepTe.setImageResource(R.drawable.scissors);
                Jatek();
            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(MasnaposJatekActivity.this,MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    public void Jatek(){
        int gep = rnd.nextInt(3);

        if (gep == 0){
            gepValasztas = "Kő";
            imagekepGep.setImageResource(R.drawable.rock);
        }else if (gep == 1){
            gepValasztas = "Papir";
            imagekepGep.setImageResource(R.drawable.paper);
        }else if (gep == 2){
            gepValasztas = "Olló";
            imagekepGep.setImageResource(R.drawable.scissors);
        }

        if (emberValasztas.equals("Kő") && gepValasztas.equals("Papir")){
            Toast.makeText(MasnaposJatekActivity.this, "Ön vesztett, a gép nyert", Toast.LENGTH_SHORT).show();
            gepSzamol++;
            gepkiir.setText(String.valueOf(gepSzamol));
            eletCsokkentesEmber();
        }else
        if (emberValasztas.equals("Kő") && gepValasztas.equals("Olló")){
            Toast.makeText(MasnaposJatekActivity.this, "Ön nyert, a gép vesztett", Toast.LENGTH_SHORT).show();
            emberSzamol++;
            emberkiir.setText(String.valueOf(emberSzamol));
            eletCsokkentesGep();
        }else
        if (emberValasztas.equals("Papir") && gepValasztas.equals("Kő")){
            Toast.makeText(MasnaposJatekActivity.this, "Ön nyert, a gép vesztett", Toast.LENGTH_SHORT).show();
            emberSzamol++;
            emberkiir.setText(String.valueOf(emberSzamol));
            eletCsokkentesGep();
        }else
        if (emberValasztas.equals("Papir") && gepValasztas.equals("Olló")){
            Toast.makeText(MasnaposJatekActivity.this, "Ön vesztett, a gép nyert", Toast.LENGTH_SHORT).show();
            gepSzamol++;
            gepkiir.setText(String.valueOf(gepSzamol));
            eletCsokkentesEmber();
        }else
        if (emberValasztas.equals("Olló") && gepValasztas.equals("Papir")){
            Toast.makeText(MasnaposJatekActivity.this, "Ön nyert, a gép vesztett", Toast.LENGTH_SHORT).show();
            emberSzamol++;
            emberkiir.setText(String.valueOf(emberSzamol));
            eletCsokkentesGep();
        }else
        if (emberValasztas.equals("Olló") && gepValasztas.equals("Kő")){
            Toast.makeText(MasnaposJatekActivity.this, "Ön vesztett, a gép nyert", Toast.LENGTH_SHORT).show();
            gepSzamol++;
            gepkiir.setText(String.valueOf(gepSzamol));
            eletCsokkentesEmber();
        }else
        if (emberValasztas.equals("Olló") && gepValasztas.equals("Olló")){
            Toast.makeText(MasnaposJatekActivity.this, "Ez döntetlen", Toast.LENGTH_SHORT).show();
            dontetlenSzamol++;
            dontetlen.setText(String.valueOf(dontetlenSzamol));
        }else
        if (emberValasztas.equals("Kő") && gepValasztas.equals("Kő")){
            Toast.makeText(MasnaposJatekActivity.this, "Ez döntetlen", Toast.LENGTH_SHORT).show();
            dontetlenSzamol++;
            dontetlen.setText(String.valueOf(dontetlenSzamol));
        }else
        if (emberValasztas.equals("Papir") && gepValasztas.equals("Papir")){
            Toast.makeText(MasnaposJatekActivity.this, "Ez döntetlen", Toast.LENGTH_SHORT).show();
            dontetlenSzamol++;
            dontetlen.setText(String.valueOf(dontetlenSzamol));
        }

    }

    public void Nyertvege(){

        AlertDialog.Builder build = new AlertDialog.Builder(MasnaposJatekActivity.this);
        build.setMessage("Be akarja zárni az alkalmazást vagy folytatja a játékot? ")
                .setCancelable(false)
                .setPositiveButton("Bezár", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Folytat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        onStop();
                        recreate();
                    }
                });
        AlertDialog alert = build.create();
        alert.setTitle("Gratulálnk ön nyert !!!");
        alert.show();
    }

    public void Vesztesvege(){

        AlertDialog.Builder build = new AlertDialog.Builder(MasnaposJatekActivity.this);
        build.setMessage("Be akarja zárni az alkalmazást vagy folytatja a játékot? ")
                .setCancelable(false)
                .setPositiveButton("Bezár", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Folytat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        onStop();
                        recreate();
                    }
                });
        AlertDialog alert = build.create();
        alert.setTitle("Sajnos ön kikapott :-(");
        alert.show();
    }

    private void eletCsokkentesGep() {
        switch (eletGep){
            case 3:
                gimageHp1.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gimageHp2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                gimageHp3.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
        eletGep--;
        if (eletGep < 1 || gepSzamol >= 3){
            Nyertvege();
        }
    }

    private void eletCsokkentesEmber() {
        switch (eletEmber){
            case 3:
                eimageHp1.setImageResource(R.drawable.heart1);
                break;
            case 2:
                eimageHp2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                eimageHp3.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
        eletEmber--;
        if (eletEmber < 1 || emberSzamol >= 3){
            Vesztesvege();
        }
    }
}