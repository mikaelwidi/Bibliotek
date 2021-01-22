package com.mikaelwidi.bibliotek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mAuth.getCurrentUser();

                if (mFirebaseUser != null){
                    Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }else{
                    Toast.makeText(MainActivity.this, "Login Please", Toast.LENGTH_SHORT).show();
                }
            }

        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (uname.isEmpty()){
                    username.setError("Email is required!");
                    username.requestFocus();
                }else if (pass.isEmpty()){
                    password.setError("Password is required!");
                    password.requestFocus();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(uname).matches()){
                    username.setError("Enter a valid email!");
                    username.requestFocus();
                }else if(!(uname.isEmpty() && pass.isEmpty())){
                    mAuth.signInWithEmailAndPassword(uname, pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            }else {
                                Toast.makeText(MainActivity.this, "Failed to Login, please check your credentials", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });

                }

            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}