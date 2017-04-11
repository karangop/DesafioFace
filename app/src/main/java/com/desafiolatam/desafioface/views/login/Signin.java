package com.desafiolatam.desafioface.views.login;

import android.util.Log;

import com.desafiolatam.desafioface.models.CurrentUser;
import com.desafiolatam.desafioface.network.session.LoginInterceptor;
import com.desafiolatam.desafioface.network.session.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by karan_000 on 27-03-2017.
 */

public class Signin {

    private SessionCallback callback;

    public Signin(SessionCallback callback) {
        this.callback = callback;
    }

    public void toServer(String email, String password){

        if (email.trim().length() == 0 || password.trim().length() == 0){
            callback.requieredField();
        }else{
            if (!email.contains("@")){
                callback.mailFormat();
            }else{
                Session session = new LoginInterceptor().get();
                Call<CurrentUser> call = session.loggin(email,password);
                call.enqueue(new Callback<CurrentUser>() {
                    @Override
                    public void onResponse(Call<CurrentUser> call, Response<CurrentUser> response) {
                        if(200 == response.code() && response.isSuccessful()){
                            CurrentUser user = response.body();
//                    Toast.makeText(LoginActivity.this, user.getAuth_token(), Toast.LENGTH_SHORT).show();
                            user.create();
                            callback.success();
                            Log.d("SERVER_ID",String.valueOf(user.getServer_id()));
                        }
                        else{
                            callback.failed();
//                    Toast.makeText(LoginActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentUser> call, Throwable t) {
                        callback.failed();
//                Toast.makeText(LoginActivity.this, "on failure", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }



    }
}
