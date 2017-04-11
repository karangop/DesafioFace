package com.desafiolatam.desafioface.views.splash;

import com.desafiolatam.desafioface.models.CurrentUser;

import java.util.List;

/**
 * Created by karan_000 on 27-03-2017.
 */

public class LoginValidation {

    private LoginCallback callback;

    public LoginValidation(LoginCallback callback) {
        this.callback = callback;
    }

    public void init() {
        List<CurrentUser> currentUsers = CurrentUser.listAll(CurrentUser.class);
        if(currentUsers != null && currentUsers.size() > 0){
            callback.signed();
        }else{
            callback.signIn();
        }
    }
}
