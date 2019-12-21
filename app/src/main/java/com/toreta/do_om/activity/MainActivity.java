package com.toreta.do_om.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.toreta.do_om.R;
import com.toreta.do_om.RankingActivity;
import com.toreta.do_om.WishlistActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Context context = this;
    private ImageButton imageButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        drawer();

        textView.setText("도옴");


        imageButton.setOnClickListener(view -> {
            mDrawerLayout.openDrawer(GravityCompat.START);
        });
    }

    private void drawer() {

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {

            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();

            int id = menuItem.getItemId();

            if (id == R.id.ranking) {
                startActivity(new Intent(MainActivity.this, RankingActivity.class));
            } else if (id == R.id.wish) {
                startActivity(new Intent(MainActivity.this, WishlistActivity.class));

            } else if (id == R.id.setting) {
            }

            return true;
        });
    }

    private void init() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        imageButton = findViewById(R.id.show_navigation);

        textView = findViewById(R.id.appbar_title);
    }

}
