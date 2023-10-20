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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration_Activity extends AppCompatActivity {

    Button Reg_Signup;
    EditText Reg_Email,Reg_Password,Reg_Confirm_Password;
    private FirebaseAuth auth;
    String  Email,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regstration);
        Reg_Email = (EditText) findViewById(R.id.Registration_email);
        Reg_Password = (EditText) findViewById(R.id.Registration_password);
        Reg_Confirm_Password = (EditText) findViewById(R.id.Registration_conform_password);
        Reg_Signup = (Button) findViewById(R.id.Registration_Signup);

        auth = FirebaseAuth.getInstance();

        Reg_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = Reg_Email.getText().toString();
                Password = Reg_Password.getText().toString();
                auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(Registration_Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful()){
                             Toast.makeText(Registration_Activity.this,"Done",Toast.LENGTH_SHORT).show();
                             Intent  intent  = new Intent(Registration_Activity.this, MainActivity.class);
                             startActivity(intent);
                         }else {
                             Toast.makeText(Registration_Activity.this,"Not done",Toast.LENGTH_SHORT).show();
                         }
                    }
                });
            }
        });

    }
}