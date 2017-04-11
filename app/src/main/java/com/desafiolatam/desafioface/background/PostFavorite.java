package com.desafiolatam.desafioface.background;

import android.os.AsyncTask;

import com.desafiolatam.desafioface.models.Developer;
import com.desafiolatam.desafioface.network.favorite.DeveloperFavorite;
import com.desafiolatam.desafioface.network.favorite.FavoriteInterceptor;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by karan_000 on 07-04-2017.
 */

public class PostFavorite extends AsyncTask<Long, Integer, Integer> {
    @Override
    protected Integer doInBackground(Long... params) {
        DeveloperFavorite request = FavoriteInterceptor.get();
        Call<Developer> call = request.post(params[0]);

        try {
            Response<Developer> response = call.execute();
            return response.code();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
