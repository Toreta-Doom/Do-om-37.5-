package com.toreta.do_om.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.toreta.do_om.FundingActivity;
import com.toreta.do_om.R;
import com.toreta.do_om.RankingActivity;
import com.toreta.do_om.ReadFundingActivity;
import com.toreta.do_om.SettingActivity;
import com.toreta.do_om.WishlistActivity;
import com.toreta.do_om.adapter.FundingAdapter;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Context context = this;
    private ImageButton imageButton;
    private TextView textView;
    private FloatingActionButton fab;
    private ImageView imageView2;

    private FundingAdapter adapter;

    private ImageView close;
    private TextView headOne;
    private TextView headTwo;
    private TextView headThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        drawer();

        textView.setText("봉사");

        fab.setOnClickListener(view -> {
            startActivity(new Intent(this, FundingActivity.class));
        });

        imageButton.setOnClickListener(view -> {
            mDrawerLayout.openDrawer(GravityCompat.START);
        });



        recyclerView();


    }

    private void recyclerView() {

        RecyclerView recyclerView = findViewById(R.id.main_recyclerciew);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FundingAdapter();
        recyclerView.setAdapter(adapter);



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
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }

            return true;
        });
    }

    private void init() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        imageButton = findViewById(R.id.show_navigation);
        fab = findViewById(R.id.fab);
        textView = findViewById(R.id.appbar_title);

        close = findViewById(R.id.close);
        headOne = findViewById(R.id.headOne);
        headTwo = findViewById(R.id.headTwo);
        headThree = findViewById(R.id.headThree);
    }

}
