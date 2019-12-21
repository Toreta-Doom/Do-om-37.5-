package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    TextView settingWishText;
    ImageView settingWishIc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        settingWishText = findViewById(R.id.setting_wish_text);
        settingWishIc = findViewById(R.id.setting_wish_ic);

        settingWishText.setOnClickListener(m_crBtnClick);
        settingWishIc.setOnClickListener(m_crBtnClick);
    }

    Button.OnClickListener m_crBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SettingActivity.this, WishlistActivity.class);
            startActivity(intent);
        }
    };

}