package com.example.hart.burgerak.ui;


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

import com.example.hart.burgerak.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText mEmailInputEditText;
    private EditText mPasswordInputEditText;
    private Button mLoginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mEmailInputEditText = (EditText) view.findViewById(R.id.fragment_login_email_input);
        mPasswordInputEditText = (EditText) view.findViewById(R.id.fragment_login_password_input);
        mLoginButton = (Button) view.findViewById(R.id.fragment_login_btn_login);

        ViewCompat.setElevation(mEmailInputEditText, 8);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, mEmailInputEditText.getText().toString());
                Log.d(TAG, mPasswordInputEditText.getText().toString());
            }
        });
    }
}
