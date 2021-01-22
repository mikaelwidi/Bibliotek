package com.mikaelwidi.bibliotek;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListBuku extends AppCompatActivity {

    ListView listB;
    SearchView searchView;
    ArrayList<String> myArrayList = new ArrayList<>();
    ArrayAdapter<String> myArrayAdapter;
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    BukuHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buku);
        myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArrayList);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("buku");
        helper = new BukuHelper();

        searchView = (SearchView) findViewById(R.id.search_bar);
        listB = (ListView) findViewById(R.id.listBuku);

        listB.setAdapter(myArrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ListBuku.this.myArrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListBuku.this.myArrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value = snapshot.getValue(BukuHelper.class).toString();
                myArrayList.add(value);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}