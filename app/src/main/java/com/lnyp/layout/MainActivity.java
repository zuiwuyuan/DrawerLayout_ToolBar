package com.lnyp.layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private LinearLayout drawerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerContent = (LinearLayout) findViewById(R.id.drawerContent);
        // 设置Toolbar
        toolbar.setTitle("掌阅宝");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        // 设置toolbar支持actionbar
        setSupportActionBar(toolbar);

        // 使用ActionBarDrawerToggle，配合DrawerLayout和ActionBar,以实现推荐的抽屉功能。
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);


        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);

        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 关闭DrawerLayout
        drawerLayout.closeDrawer(drawerContent);
        switch (v.getId()) {

            case R.id.text1:

                Toast.makeText(MainActivity.this, "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text2:
                Toast.makeText(MainActivity.this, "我的关注", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
