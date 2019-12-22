package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.toreta.do_om.adapter.NotificationAdapter;
import com.toreta.do_om.adapter.RankingAdapter;

public class NotificationActivity extends AppCompatActivity {

    private NotificationAdapter adapter;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mDrawerLayout = findViewById(R.id.drawer_layout_setting);
        recyclerView();
    }

    private void recyclerView() {

        RecyclerView recyclerView = findViewById(R.id.notificationView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new NotificationAdapter();
        recyclerView.setAdapter(adapter);

    }
}
