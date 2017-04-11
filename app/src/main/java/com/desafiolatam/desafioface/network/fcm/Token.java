package com.desafiolatam.desafioface.network.fcm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by karan_000 on 05-04-2017.
 */

public class Token {

    private static final String TOKEN_GROUP = "com.desafiolatam.desafioface.network.fcm.shared_preference_group.TOKEN_GROUP";
    private static final String TOKEN_KEY = "com.desafiolatam.desafioface.network.fcm.shared_preference_key.TOKEN_KEY";

    private Context context;

    public Token(Context context) {
        this.context = context;
    }

    void saveToken(String token) {
        SharedPreferences saveToken = context.getSharedPreferences(TOKEN_GROUP, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = saveToken.edit();
        prefEditor.putString(TOKEN_KEY, token);
        prefEditor.apply();
    }

    public String getToken() {
        SharedPreferences getToken = context.getSharedPreferences(TOKEN_GROUP, Context.MODE_PRIVATE);
        return getToken.getString(TOKEN_KEY, null);
    }
}
