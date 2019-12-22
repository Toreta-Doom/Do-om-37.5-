package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.toreta.do_om.adapter.FundingAdapter;
import com.toreta.do_om.adapter.RankingAdapter;

public class RankingActivity extends AppCompatActivity {

    private TextView textView;
    private ImageButton imageButton;
    private DrawerLayout mDrawerLayout;

    private RankingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        textView = findViewById(R.id.appbar_title);
        imageButton = findViewById(R.id.show_navigation);

        init();

        recyclerView();

        textView.setText("순위 보기");

        imageButton.setOnClickListener(view -> {
            mDrawerLayout.openDrawer(GravityCompat.START);
        });

        drawer();
    }

    private void recyclerView() {

        RecyclerView recyclerView = findViewById(R.id.ranking_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RankingAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void drawer() {

        mDrawerLayout = findViewById(R.id.drawer_layout_ranking);

        NavigationView navigationView = findViewById(R.id.nav_view_ranking);
            navigationView.setNavigationItemSelectedListener(menuItem -> {

            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();

            int id = menuItem.getItemId();

            if (id == R.id.ranking) {
            } else if (id == R.id.wish) {
                startActivity(new Intent(this, WishlistActivity.class));

            } else if (id == R.id.setting) {
                startActivity(new Intent(this, SettingActivity.class));
            }

            return true;
        });
    }

    private void init() {
        mDrawerLayout = findViewById(R.id.drawer_layout_ranking);
        imageButton = findViewById(R.id.show_navigation);
        textView = findViewById(R.id.appbar_title);
    }
}
