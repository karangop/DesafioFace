package com.desafiolatam.desafioface.views.login;

import android.content.Context;

import com.desafiolatam.desafioface.background.PutToken;
import com.desafiolatam.desafioface.network.fcm.Token;

/**
 * Created by karan_000 on 05-04-2017.
 */

public class TokenValidation {


    public void init(Context context){
        String token = new Token(context).getToken();
        if (token != null){

            new PutToken().execute(token);

        }
    }
}
