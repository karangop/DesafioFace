package com.desafiolatam.desafioface.network.fcm;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;

/**
 * Created by karan_000 on 05-04-2017.
 */

public interface ServerToken {

    @FormUrlEncoded
    @PUT("users/fcm_token")
    Call<String> putToken(@Field("users[fcm_token]") String fcmToken);
}
