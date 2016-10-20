package com.example.hart.burgerak;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.hart.burgerak.ui.HomeFragment;
import com.example.hart.burgerak.ui.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_login_toolbar);
        setSupportActionBar(toolbar);
        //setTitle(R.string.activity_login_title);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_login_vg_container, new LoginFragment())
                .commit();

    }
}
