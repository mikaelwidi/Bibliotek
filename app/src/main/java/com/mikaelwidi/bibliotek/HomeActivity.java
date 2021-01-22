package com.mikaelwidi.bibliotek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView inputA, inputB, inputP, dataA, dataB, dataP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inputA = (CardView) findViewById(R.id.inputA);
        inputB = (CardView) findViewById(R.id.inputB);
        inputP = (CardView) findViewById(R.id.inputP);
        dataA = (CardView) findViewById(R.id.dataA);
        dataB = (CardView) findViewById(R.id.dataB);
        dataP = (CardView) findViewById(R.id.dataP);

        inputA.setOnClickListener(this);
        inputB.setOnClickListener(this);
        inputP.setOnClickListener(this);
        dataA.setOnClickListener(this);
        dataB.setOnClickListener(this);
        dataP.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.inputA :
                i = new Intent(this, InputAnggota.class);
                startActivity(i);
                break;

            case R.id.inputB :
                i = new Intent(this, InputBuku.class);
                startActivity(i);
                break;

            case R.id.inputP :
                i = new Intent(this, InputPeminjaman.class);
                startActivity(i);
                break;

            case R.id.dataA :
                i = new Intent(this, ListAnggota.class);
                startActivity(i);
                break;

            case R.id.dataB :
                i = new Intent(this, ListBuku.class);
                startActivity(i);
                break;

            case R.id.dataP :
                i = new Intent(this, ListPeminjaman.class);
                startActivity(i);
                break;
        }
    }
}