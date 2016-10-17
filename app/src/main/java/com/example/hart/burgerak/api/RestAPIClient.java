package com.example.hart.burgerak.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.hart.burgerak.R;
import com.example.hart.burgerak.controller.UserController;
import com.example.hart.burgerak.model.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 3SHEN on 13/10/2016.
 */

public class RestAPIClient {
    private static RestAPIClient sSharedInstance;

    private RequestQueue mRequestQueue;
    private String mUserToken;
    private String mId;
    private SharedPreferences mSharedPreferences;

    // Private constructor for Singleton pattern
    private RestAPIClient(@NonNull Context context) {
        // We'll use this RequestQueue to dispatch our requests
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());

        mSharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file_key), Context.MODE_PRIVATE);
        mUserToken = loadUserToken();
    }

    // Get singleton instance using this static method
    public static synchronized RestAPIClient getInstance(@NonNull Context context) {
        if (sSharedInstance == null) {
            sSharedInstance = new RestAPIClient(context);
        }

        return sSharedInstance;
    }

    private Request newRequest(int method, String url, JSONObject parameters, Response.Listener successListener, Response.ErrorListener errorListener) {
        BackendlessJsonObjectRequest request = new BackendlessJsonObjectRequest(method, url, parameters, successListener, errorListener);

        if (mUserToken != null) {
            request.putHeader("user-token", mUserToken);
        }

        return request;
    }

    public interface OnUserAuthenticationCompleteListener {
        void onComplete(User user, VolleyError error);
    }

    public void login(String email, String password, final OnUserAuthenticationCompleteListener completionListener) {
        String url = "https://api.backendless.com/v1/users/login";

        JSONObject parameters = new JSONObject();
        try {
            parameters.put("login", email);
            parameters.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Request request = newRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                User user = new User(response);
                saveUserToken(user.getUserToken());
                saveUserId(user.getId());
                UserController.getInstance().setLoggedInUser(user);

                completionListener.onComplete(user, null);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                completionListener.onComplete(null, error);
            }
        });

        mRequestQueue.add(request);
    }

    public interface OnUserTokenValidationCompleteListener {
        void onComplete(Boolean response, VolleyError error);
    }

//    public void validateUserToken(final OnUserTokenValidationCompleteListener completionListener) {
//        String url = "https://api.backendless.com/v1/users/isvalidusertoken/";
//
//        url += loadUserToken();
//
//        Request request = newRequest(Request.Method.GET, url, new Response.Listener<Boolean>() {
//            @Override
//            public void onResponse(Boolean response) {
//                completionListener.onComplete(PROBLEM, null);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                completionListener.onComplete(null, error);
//            }
//        });
//
//        mRequestQueue.add(request);
//
//    }

    private void saveUserToken(String token) {
        mUserToken = token;

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("USER_TOKEN", token);
        editor.apply();
    }

    private String loadUserToken() {
        String token = mSharedPreferences.getString("USER_TOKEN", null);
        return token;
    }

    private void saveUserId(String id) {
        mId = id;

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("USER_ID", mId);
        editor.apply();
    }

    private String loadUserId () {
        String id = mSharedPreferences.getString("USER_ID", null);
        return id;
    }
}
