package com.example.hart.burgerak.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.hart.burgerak.R;
import com.example.hart.burgerak.UserActivity;
import com.example.hart.burgerak.api.RestAPIClient;
import com.example.hart.burgerak.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private EditText mEmailInputEditText;
    private EditText mPasswordInputEditText;
    private EditText mNameInputEditText;
    private TextView mLoginButton;
    private Button mSignUpButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        mNameInputEditText = (EditText) view.findViewById(R.id.fragment_sign_up_name_input);
        mEmailInputEditText = (EditText) view.findViewById(R.id.fragment_sign_up_email_input);
        mPasswordInputEditText = (EditText) view.findViewById(R.id.fragment_sign_up_password_input);
        mSignUpButton = (Button) view.findViewById(R.id.fragment_sign_up_btn_sign_up);
        mLoginButton = (TextView) view.findViewById(R.id.fragment_sign_up_btn_login);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestAPIClient restAPIClient = RestAPIClient.getInstance(getActivity().getApplicationContext());
                restAPIClient.signUp(mEmailInputEditText.getText().toString(), mPasswordInputEditText.getText().toString(),
                                     mNameInputEditText.getText().toString(), new RestAPIClient.OnUserAuthenticationCompleteListener() {
                    @Override
                    public void onComplete(User user, VolleyError error) {
                        Toast.makeText(getContext(), "Welcome " + user.getName() + " !", Toast.LENGTH_SHORT).show();

                        Intent launchIntent = new Intent (getContext(), UserActivity.class);
                        launchIntent.putExtra("fragment_to_load", "user_profile");
                        startActivity(launchIntent);
                    }
                });
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_login_vg_container, new LoginFragment())
                        .addToBackStack("LoginFragment")
                        .commit();
            }
        });
    }

}
