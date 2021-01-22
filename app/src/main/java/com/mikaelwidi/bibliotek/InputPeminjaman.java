package com.mikaelwidi.bibliotek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputPeminjaman extends AppCompatActivity {

    EditText kodeP, idA, kodeB;
    Button simpan;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_peminjaman);

        kodeB = (EditText) findViewById(R.id.kodebuku);
        kodeP = (EditText) findViewById(R.id.kodepinjam);
        idA = (EditText) findViewById(R.id.idanggota);
        simpan = (Button) findViewById(R.id.simpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("pinjam");

                String kd_pinjam = kodeP.getText().toString();
                String id_anggota = idA.getText().toString();
                String kd_buku = kodeB.getText().toString();

                PeminjamanHelper helper = new PeminjamanHelper(kd_pinjam, id_anggota, kd_buku);
                reference.child(kd_pinjam).setValue(helper);
            }
        });
    }
}