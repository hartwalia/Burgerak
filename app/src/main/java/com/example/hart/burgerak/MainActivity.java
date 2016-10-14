package com.example.hart.burgerak;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.hart.burgerak.api.RestAPIClient;
import com.example.hart.burgerak.controller.UserController;
import com.example.hart.burgerak.model.User;
import com.example.hart.burgerak.ui.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ViewGroup mContentViewGroup;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        mContentViewGroup = (ViewGroup) findViewById(R.id.activity_main_vg_container);
        mNavigationView = (NavigationView) findViewById(R.id.activity_main_navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        if (true) {
            mNavigationView.inflateMenu(R.menu.navigation_drawer_menu_logged_out);
        }
        else {
            mNavigationView.inflateMenu(R.menu.navigation_drawer_menu_logged_in);
        }

        mNavigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_vg_container, new HomeFragment())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawers();
        //ask about getApplicationContext
        Intent launchIntent = new Intent (getApplicationContext(), LoginActivity.class);
        startActivity(launchIntent);
        return false;
    }
}
