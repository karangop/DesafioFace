package com.desafiolatam.desafioface.network.session;

import com.desafiolatam.desafioface.models.CurrentUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by karan_000 on 27-03-2017.
 */

public interface Session {

    @FormUrlEncoded /*Acepta parametros*/
    @POST("mobile_sessions")
    Call<CurrentUser> loggin(@Field("session[email]") String email, @Field("session[password]") String password);
}
