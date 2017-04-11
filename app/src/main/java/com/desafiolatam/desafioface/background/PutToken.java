package com.desafiolatam.desafioface.background;

import android.os.AsyncTask;

import com.desafiolatam.desafioface.network.fcm.FcmInterceptor;
import com.desafiolatam.desafioface.network.fcm.ServerToken;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by karan_000 on 07-04-2017.
 */

public class PutToken extends AsyncTask<String, Integer, Boolean>{

    @Override
    protected Boolean doInBackground(String... params) {
        ServerToken request = FcmInterceptor.get();
        Call<String> call = request.putToken(params[0]);

        try {
            call.execute();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
