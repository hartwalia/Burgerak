package com.example.hart.burgerak.api;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 3SHEN on 13/10/2016.
 */

public class BackendlessJsonObjectRequest extends JsonObjectRequest {

    private final Map<String, String> mAdditionalHeaders = new HashMap<>();

    public BackendlessJsonObjectRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public void putHeader(String key, String value) {
        mAdditionalHeaders.put(key, value);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        // Set up required headers
        Map<String, String> headers = new HashMap<>(super.getHeaders());
        headers.put("application-id", "0F6CF728-5CB0-35BC-FFD5-31B377237600");
        headers.put("secret-key", "5BF403A8-A957-0FB9-FF1C-8F40E19DE800");
        headers.put("application-type", "REST");

        headers.putAll(mAdditionalHeaders);

        return headers;
    }
}
