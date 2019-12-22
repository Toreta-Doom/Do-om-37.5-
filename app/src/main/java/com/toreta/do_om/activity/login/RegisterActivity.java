package com.toreta.do_om.activity.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.toreta.do_om.R;
import com.toreta.do_om.activity.MainActivity;

public class RegisterActivity extends AppCompatActivity {


    private ImageView logo;
    private Button sign_up_btn;
    private EditText name;
    private EditText sign_up_id;
    private EditText sign_up_pw;
    private ImageView tick;
    private ImageView not_tick;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        firebaseAuth = FirebaseAuth.getInstance();

        buttonListener();


    }

    private void buttonListener() {

        sign_up_btn.setOnClickListener(view -> {
            String email = sign_up_id.getText().toString();
            String pw = sign_up_pw.getText().toString();

            Toast.makeText(RegisterActivity.this, "회원 가입 성공 !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);

//            firebaseAuth.createUserWithEmailAndPassword(email, pw)
//                    .addOnCompleteListener(RegisterActivity.this, task -> {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(RegisterActivity.this, "회원 가입 성공 !", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                            finish();
//                        } else {
//                            Toast.makeText(RegisterActivity.this, "등록 에러", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                    });
        });
    }

    private void init() {
        logo = findViewById(R.id.logo);
        sign_up_btn = findViewById(R.id.sign_up_btn);
        name = findViewById(R.id.name);
        sign_up_id = findViewById(R.id.sign_up_id);
        sign_up_pw = findViewById(R.id.sign_up_pw);
        tick = findViewById(R.id.tick);
        not_tick = findViewById(R.id.not_tick);
    }


}
