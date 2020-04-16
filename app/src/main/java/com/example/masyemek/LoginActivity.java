package com.example.masyemek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPassword;
    private Button loginButton;
    private TextView loginRegister;
    private ProgressDialog loginProgress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPassword = (EditText) findViewById(R.id.login_password);
        loginEmail = (EditText) findViewById(R.id.login_email);
        loginButton = (Button) findViewById(R.id.login_button);
        loginRegister = (TextView) findViewById(R.id.login_need_account);
        loginProgress= new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();

        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=loginEmail.getText().toString();
                String password= loginPassword.getText().toString();
                if (!TextUtils.isEmpty(email)|| !TextUtils.isEmpty(password))
                {
                   loginProgress.setTitle("OTURUM AÇILIYOR");
                   loginProgress.setMessage("HESABINIZA GİRİLİYOR,LÜTFEN BEKLEYİNİZ");
                   loginProgress.setCanceledOnTouchOutside(false);
                   loginProgress.show();
                   loginUser(email,password);
                }
            }
        });
    }

    private void loginUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful())
               {
                   loginProgress.dismiss();
                   Toast.makeText(getApplicationContext(),"GİRİŞ BAŞARILI",Toast.LENGTH_SHORT).show();
                   Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                   startActivity(mainIntent);
               }
               else
               {
                   loginProgress.dismiss();
                   Toast.makeText(getApplicationContext(),"GİRİŞ YAPILAMADI:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}
