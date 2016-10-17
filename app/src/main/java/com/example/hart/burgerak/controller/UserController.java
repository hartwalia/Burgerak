package com.example.hart.burgerak.controller;

import android.content.SharedPreferences;

import com.example.hart.burgerak.model.User;

/**
 * Created by 3SHEN on 13/10/2016.
 */

public class UserController {

    private static UserController sUserController;

    private User mLoggedInUser;
    private String mId;
    private SharedPreferences mSharedPreferences;

    private UserController() {

    }

    public static synchronized UserController getInstance() {
        if (sUserController == null) {
            sUserController = new UserController();
        }

        return sUserController;
    }

    public User getLoggedInUser() {
        return mLoggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {

        mLoggedInUser = loggedInUser;
        saveUserId(mLoggedInUser.getId());
    }

    public void saveUserId(String id) {
        mId = id;

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("USER_ID", mId);
        editor.apply();
    }

    public String loadUserId () {
        String id = mSharedPreferences.getString("USER_ID", null);
        return id;
    }

}
