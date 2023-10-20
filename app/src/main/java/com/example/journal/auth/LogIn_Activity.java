package com.example.journal.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.journal.MainActivity;
import com.example.journal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn_Activity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText Login_Email,Login_Password;
    Button Login_btn;
    String Email,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Login_btn = (Button) findViewById(R.id.Login_Button);
        Login_Email = (EditText) findViewById(R.id.Login_email);
        Login_Password = (EditText) findViewById(R.id.Login_password);

        auth = FirebaseAuth.getInstance();
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = Login_Email.getText().toString();
                Password = Login_Password.getText().toString();
                auth.signInWithEmailAndPassword(Email,Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LogIn_Activity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}