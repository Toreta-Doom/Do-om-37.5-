package com.toreta.do_om.activity.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.toreta.do_om.R;
import com.toreta.do_om.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private Button sign_in_btn;
    private TextView register_Text;
    private EditText sign_in_id;
    private EditText sign_in_pw;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        buttonListener();

        firebaseAuth = FirebaseAuth.getInstance();

        sign_in_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String email = sign_in_id.getText().toString().trim();
                String pw = sign_in_pw.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email, pw)
                        .addOnCompleteListener(LoginActivity.this, task -> {

                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                            }

                        });
            }

        });
    }

    private void init() {

        sign_in_btn = findViewById(R.id.sign_in_btn);
        register_Text = findViewById(R.id.register_Text);
        sign_in_id = findViewById(R.id.sign_in_id);
        sign_in_pw = findViewById(R.id.sign_in_pw);

    }

    private void buttonListener() {
        register_Text.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
