package com.example.hart.burgerak.model;

import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

/**
 * Created by 3SHEN on 1/10/2016.
 */

public class User {
    private String mName;
    private String mEmail;
    private String mId;
    private String mUserToken;

    public User(String ownerId, String email, String name, String userToken) {
        mId = ownerId;
        mEmail = email;
        mName = name;
        mUserToken = userToken;
    }

    public User(@NonNull JSONObject jsonObject) {
        mId = jsonObject.optString("ownerId");
        mEmail = jsonObject.optString("email");
        mName = jsonObject.optString("name");
        mUserToken = jsonObject.optString("user-token");
    }

    public String getId() {
        return mId;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getName() {
        return mName;
    }

    public String getUserToken() {
        return mUserToken;
    }


}
