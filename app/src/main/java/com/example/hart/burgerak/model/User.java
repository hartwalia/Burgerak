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

    public User(@NonNull JSONObject jsonObject) {
        /*
        {
        	"userStatus": "ENABLED",
	        "created": 1475211805000,
	        "name": null,
	        "ownerId": "CC06DDDF-4E42-3B3A-FF73-55EA7886D900",
	        "updated": null,
	        "email": "demo1@apptivitylab.com",
	        "objectId": "CC06DDDF-4E42-3B3A-FF73-55EA7886D900",
	        "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"password\",\"created\",\"___saved\",\"___class\",\"name\",\"ownerId\",\"updated\",\"email\",\"objectId\"],\"relatedObjects\":{}}"
        }
         */

        mId = jsonObject.optString("ownerId");
        mEmail = jsonObject.optString("email");
        mName = jsonObject.optString("name");
        mUserToken = jsonObject.optString("user-token");

        Log.d(TAG, mName.toString());
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
