package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class RankingActivity extends AppCompatActivity {

    private TextView textView;
    private ImageButton imageButton;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        textView = findViewById(R.id.appbar_title);
        imageButton = findViewById(R.id.show_navigation);


        textView.setText("순위 보기");

        imageButton.setOnClickListener(view -> {
            mDrawerLayout.openDrawer(GravityCompat.START);
        });

        drawer();
    }

    private void drawer() {

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {

            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();

            int id = menuItem.getItemId();

            if (id == R.id.ranking) {
                startActivity(new Intent(RankingActivity.this, RankingActivity.class));
            } else if (id == R.id.wish) {
                startActivity(new Intent(RankingActivity.this, WishlistActivity.class));

            } else if (id == R.id.setting) {
                startActivity(new Intent(RankingActivity.this, SettingActivity.class));
            }

            return true;
        });
    }
}
