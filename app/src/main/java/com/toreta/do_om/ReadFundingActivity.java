package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.toreta.do_om.activity.MainActivity;

public class ReadFundingActivity extends AppCompatActivity {

    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_funding);

        ok = findViewById(R.id.funding_Read_OK);

        ok.setOnClickListener(view -> {
            Toast.makeText(this, "참여 완료", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
