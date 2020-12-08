package com.example.shiva.android_tutorial;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
 Toolbar toolbar;
 DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Android tutorial");
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation);
        drawerLayout=(DrawerLayout)findViewById(R.id.mydraw);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        String itemname=(String)item.getTitle();
        Toast.makeText(getApplicationContext(),itemname+"clicked",Toast.LENGTH_SHORT).show();
        closeDrawer();
        switch (item.getItemId())
        {
            case R.id.like:
                break;
            case R.id.lock:
                break;
        }
        return false;
    }
    private void closeDrawer()
    {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    private void showDrawer()
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            closeDrawer();
        }else {
            super.onBackPressed();
        }
    }
}
