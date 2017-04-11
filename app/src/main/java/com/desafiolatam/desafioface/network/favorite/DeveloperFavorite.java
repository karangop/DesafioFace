package com.desafiolatam.desafioface.network.favorite;

import com.desafiolatam.desafioface.models.Developer;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by karan_000 on 07-04-2017.
 */

public interface DeveloperFavorite {

    @POST("users/{user_id}/favorite")
    Call<Developer> post(@Path("user_id") long serverId);
}
