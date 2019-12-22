package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.toreta.do_om.activity.MainActivity;
import com.toreta.do_om.adapter.RankingAdapter;
import com.toreta.do_om.adapter.WishAdapter;

public class WishlistActivity extends AppCompatActivity {

    private TextView textView;
    private ImageButton imageButton;
    private DrawerLayout mDrawerLayout;

    private WishAdapter adapter;
    private ImageView notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        textView = findViewById(R.id.appbar_title);
        imageButton = findViewById(R.id.show_navigation);

        init();

        textView.setText("위시 리스트");

        imageButton.setOnClickListener(view -> {
            mDrawerLayout.openDrawer(GravityCompat.START);
        });

        drawer();

        recyclerView();

        notification = findViewById(R.id.notification_image);

        notification.setOnClickListener(view -> {
            startActivity(new Intent(this, NotificationActivity.class));
        });

    }

    private void recyclerView() {

        RecyclerView recyclerView = findViewById(R.id.wish_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new WishAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void drawer() {

        mDrawerLayout = findViewById(R.id.drawer_layout_wish);

        NavigationView navigationView = findViewById(R.id.nav_view_wish);
        navigationView.setNavigationItemSelectedListener(menuItem -> {

            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();

            int id = menuItem.getItemId();

            if (id == R.id.ranking) {
                startActivity(new Intent(WishlistActivity.this, RankingActivity.class));
            } else if (id == R.id.wish) {
                startActivity(new Intent(WishlistActivity.this, WishlistActivity.class));

            } else if (id == R.id.setting) {
                startActivity(new Intent(WishlistActivity.this, SettingActivity.class));
            }

            return true;
        });
    }

    private void init() {
        mDrawerLayout = findViewById(R.id.drawer_layout_wish);
        imageButton = findViewById(R.id.show_navigation);
        textView = findViewById(R.id.appbar_title);
    }
}
