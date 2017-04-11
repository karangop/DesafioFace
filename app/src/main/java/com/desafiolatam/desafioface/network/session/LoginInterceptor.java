package com.desafiolatam.desafioface.network.session;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karan_000 on 27-03-2017.
 */

public class LoginInterceptor {

    public  static final String BASE_URL = "https://empieza.desafiolatam.com/";

    public Session get(){
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
            /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Session session = interceptor.create(Session.class);
        return session;
    }
}
