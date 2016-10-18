package com.example.hart.burgerak.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.hart.burgerak.R;
import com.example.hart.burgerak.UserActivity;
import com.example.hart.burgerak.api.RestAPIClient;
import com.example.hart.burgerak.model.User;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText mEmailInputEditText;
    private EditText mPasswordInputEditText;
    private Button mLoginButton;
    private TextView mSignUpButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mEmailInputEditText = (EditText) view.findViewById(R.id.fragment_login_email_input);
        mPasswordInputEditText = (EditText) view.findViewById(R.id.fragment_login_password_input);
        mLoginButton = (Button) view.findViewById(R.id.fragment_login_btn_login);
        mSignUpButton = (TextView) view.findViewById(R.id.fragment_login_btn_sign_up);

        ViewCompat.setElevation(mEmailInputEditText, 8);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestAPIClient restAPIClient = RestAPIClient.getInstance(getActivity().getApplicationContext());
                restAPIClient.login(mEmailInputEditText.getText().toString(), mPasswordInputEditText.getText().toString(), new RestAPIClient.OnUserAuthenticationCompleteListener() {
                    @Override
                    public void onComplete(User user, VolleyError error) {
                        Toast.makeText(getContext(), "You're logged in " + user.getName() + " !", Toast.LENGTH_SHORT).show();

                        Intent launchIntent = new Intent (getContext(), UserActivity.class);
                        startActivity(launchIntent);
                    }
                });
            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                             .beginTransaction()
                             .replace(R.id.activity_login_vg_container, new SignUpFragment())
                             .addToBackStack("SignUpFragment")
                             .commit();
            }
        });
    }
}
