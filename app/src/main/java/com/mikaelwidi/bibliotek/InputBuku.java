package com.mikaelwidi.bibliotek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputBuku extends AppCompatActivity {

    EditText kodeB, judulB, author, kodeR;
    Button simpan;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_buku);

        kodeB = (EditText) findViewById(R.id.kodebuku);
        judulB = (EditText) findViewById(R.id.judulbuku);
        author = (EditText) findViewById(R.id.pengarang);
        kodeR = (EditText) findViewById(R.id.koderak);
        simpan = (Button) findViewById(R.id.simpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("buku");

                String kd_buku = kodeB.getText().toString();
                String jdl_buku = judulB.getText().toString();
                String pengar = author.getText().toString();
                String kd_rak = kodeR.getText().toString();

                BukuHelper helper = new BukuHelper(kd_buku, jdl_buku, pengar, kd_rak);
                reference.child(kd_buku).setValue(helper);
            }
        });
    }
}