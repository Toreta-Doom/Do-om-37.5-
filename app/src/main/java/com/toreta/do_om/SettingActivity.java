package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.toreta.do_om.activity.MainActivity;
import com.toreta.do_om.adapter.RankingAdapter;
import com.toreta.do_om.adapter.WishAdapter;

public class SettingActivity extends AppCompatActivity {

    TextView settingWishText;
    ImageView settingWishIc;

    private TextView textView;
    private ImageButton imageButton;
    private DrawerLayout mDrawerLayout;
    private TextView headTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        settingWishText = findViewById(R.id.setting_wish_text);
        settingWishIc = findViewById(R.id.setting_wish_ic);

        settingWishText.setOnClickListener(m_crBtnClick);
        settingWishIc.setOnClickListener(m_crBtnClick);

        init();
        drawer();



//        headTwo.setOnClickListener(view -> {
//            startActivity(new Intent(this, MainActivity.class));
//        });

    }


    Button.OnClickListener m_crBtnClick = v -> {
        Intent intent = new Intent(SettingActivity.this, WishlistActivity.class);
        startActivity(intent);
    };


    private void drawer() {

        mDrawerLayout = findViewById(R.id.drawer_layout_setting);

        NavigationView navigationView = findViewById(R.id.nav_view_setting);
        navigationView.setNavigationItemSelectedListener(menuItem -> {

            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();

            int id = menuItem.getItemId();

            if (id == R.id.ranking) {
                startActivity(new Intent(this, RankingActivity.class));
            } else if (id == R.id.wish) {
                startActivity(new Intent(this, WishlistActivity.class));

            } else if (id == R.id.setting) {
                startActivity(new Intent(this, SettingActivity.class));
            }

            return true;
        });
    }

    private void init() {
        mDrawerLayout = findViewById(R.id.drawer_layout_setting);
        imageButton = findViewById(R.id.show_navigation);
        textView = findViewById(R.id.appbar_title);
        headTwo = findViewById(R.id.headTwo);
    }

}
