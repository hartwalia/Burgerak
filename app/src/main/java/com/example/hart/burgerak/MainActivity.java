package com.example.hart.burgerak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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
    private SharedPreferences mSharedPreferences;
    private String mUserToken;

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

        mSharedPreferences = getSharedPreferences(getString(R.string.pref_file_key), MODE_PRIVATE);
        mUserToken = mSharedPreferences.getString("USER_TOKEN", null);

        if (mUserToken == null) {
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

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//
//        mToolbar.getMenu().clear();
//
//        mSharedPreferences = getSharedPreferences(getString(R.string.pref_file_key), MODE_PRIVATE);
//        mUserToken = mSharedPreferences.getString("USER_TOKEN", null);
//
//        if (mUserToken == null) {
//            mNavigationView.inflateMenu(R.menu.navigation_drawer_menu_logged_out);
//        }
//        else {
//            mNavigationView.inflateMenu(R.menu.navigation_drawer_menu_logged_in);
//        }
//    }

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

            case R.id.login:
                launchIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(launchIntent);
                break;
            case R.id.logout:
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString("USER_TOKEN", null);
                editor.apply();

//                launchIntent = new Intent(getApplicationContext(), MainActivity.class);
//                launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(launchIntent);

                finish();
                break;
            case R.id.profile:
                launchIntent = new Intent(getApplicationContext(), UserActivity.class);
                launchIntent.putExtra("fragment_to_load", "user_profile");
                startActivity(launchIntent);
                finish();
                break;
            case R.id.stall:
                launchIntent = new Intent(getApplicationContext(), UserActivity.class);
                launchIntent.putExtra("fragment_to_load", "user_stall");
                startActivity(launchIntent);
                finish();
                break;
        }
        return false;
    }
}
