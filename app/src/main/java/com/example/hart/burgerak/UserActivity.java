package com.example.hart.burgerak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.hart.burgerak.ui.HomeFragment;
import com.example.hart.burgerak.ui.UserProfileFragment;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ViewGroup mContentViewGroup;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private SharedPreferences mSharedPreferences;
    private String intentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_user_drawer_layout);
        mContentViewGroup = (ViewGroup) findViewById(R.id.activity_user_vg_container);
        mNavigationView = (NavigationView) findViewById(R.id.activity_user_navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.activity_user_toolbar);

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        mNavigationView.inflateMenu(R.menu.navigation_drawer_menu_logged_in);
        mNavigationView.setNavigationItemSelectedListener(this);

        intentFragment = getIntent().getExtras().getString("fragment_to_load");

        switch (intentFragment) {
            case "user_profile":
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.activity_user_vg_container, new UserProfileFragment())
                        .commit();
                break;
            case "user_stall":
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawers();

        Intent launchIntent;
        int id = item.getItemId();

        switch (id) {

            case R.id.logout:
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString("USER_TOKEN", null);
                editor.apply();
                finish();
                break;
            case R.id.profile:
                break;
            case R.id.stall:
                break;
        }
        return false;
    }

}
