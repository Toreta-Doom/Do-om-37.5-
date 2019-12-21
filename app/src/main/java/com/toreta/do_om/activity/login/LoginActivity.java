package com.toreta.do_om.activity.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.toreta.do_om.R;

public class LoginActivity extends AppCompatActivity {

    private Button sign_in_btn;
    private TextView register_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        buttonListener();
    }

    private void init() {

        sign_in_btn = findViewById(R.id.sign_in_btn);
        register_Text = findViewById(R.id.register_Text);

    }

    private void buttonListener() {
        register_Text.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
