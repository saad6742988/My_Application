package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    public TextView email;
    public TextView pass;
    public Button reg;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        reg = findViewById(R.id.reg);

        mAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(view ->{
            createUser();
        });
    }

    private void createUser() {
        String e = email.getText().toString();
        String p = pass.getText().toString();
        mAuth.createUserWithEmailAndPassword("saad@gmail.com","ok123456ok").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(register.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (TextUtils.isEmpty(e)){
            email.setError("Email cannot be empty");
            email.requestFocus();
        }else if (TextUtils.isEmpty(p)){
            pass.setError("Password cannot be empty");
            pass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(register.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}