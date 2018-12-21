package com.example.yoggy.myoggu_latihan_gabungan1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity extends AppCompatActivity {
    private FirebaseAuth mAuth; //firebase otentifikasi langkah 3
    String TAG="ini kelas main activity"; // firebase otentifikasi

    EditText email_reg,password_reg; //untuk xml
    Button masuk_reg; //dari xml


    String str_email,str_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mAuth = FirebaseAuth.getInstance();

        email_reg = findViewById(R.id.email_reg); //deklarasi untuk layout xml
        password_reg = findViewById(R.id.password_reg); //deklarasi untuk layout xml
        masuk_reg = findViewById(R.id.masuk_reg); //deklarasi untuk layout xml

        masuk_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_email = email_reg.getText().toString(); // menadapatkan value di xml edit text email
                str_password = password_reg.getText().toString(); // mendapatkan value di xml edit text password

                signUp(str_email,str_password); // method untuk sign in
            }
        });
    }
    @Override //on start langkah koneksi firebase pada langkah 3
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Intent i = new Intent(Main3Activity.this,MainActivity.class);
        startActivity(i);
    }

    private  void signUp(String str_email,String str_password) //langkah koneksi firebase pada langkah 4
    {
        mAuth.createUserWithEmailAndPassword(str_email, str_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Main3Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
