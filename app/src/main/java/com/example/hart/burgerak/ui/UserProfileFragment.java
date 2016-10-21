package com.example.hart.burgerak.ui;


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

import com.example.hart.burgerak.R;
import com.example.hart.burgerak.controller.UserController;
import com.example.hart.burgerak.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {

    private TextView mEmailInputEditText;
    private TextView mContactInputEditText;
    private TextView mNameInputEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        User user = UserController.getInstance().getLoggedInUser();

        mNameInputEditText = (TextView) view.findViewById(R.id.fragment_user_profile_name_input);
        mEmailInputEditText = (TextView) view.findViewById(R.id.fragment_user_profile_email_input);
        mContactInputEditText = (TextView) view.findViewById(R.id.fragment_user_profile_contact_input);

        mNameInputEditText.setText(user.getName());
        mEmailInputEditText.setText(user.getEmail());

        return view;
    }



}
