package com.mikaelwidi.bibliotek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputAnggota extends AppCompatActivity {

    EditText idA, namaA, noHP;
    Button simpan;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_anggota);

        idA = (EditText) findViewById(R.id.idanggota);
        namaA = (EditText) findViewById(R.id.nama);
        noHP = (EditText) findViewById(R.id.nohp);
        simpan = (Button) findViewById(R.id.simpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("anggota");

                String id_anggota = idA.getText().toString();
                String nama = namaA.getText().toString();
                String no_hp = noHP.getText().toString();

                AnggotaHelper helper = new AnggotaHelper(id_anggota, nama, no_hp);
                reference.child(id_anggota).setValue(helper);
            }
        });
    }

}