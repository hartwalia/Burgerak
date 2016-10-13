package com.example.hart.burgerak.controller;

import com.example.hart.burgerak.model.User;

/**
 * Created by 3SHEN on 13/10/2016.
 */

public class UserController {

    private static UserController sUserController;

    private User mLoggedInUser;

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
    }

}
