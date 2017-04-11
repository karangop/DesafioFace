package com.desafiolatam.desafioface.network.fcm;

import android.util.Log;

import com.desafiolatam.desafioface.background.PutToken;
import com.desafiolatam.desafioface.models.CurrentUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.List;

/**
 * Created by karan_000 on 05-04-2017.
 */

public class DeviceService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
//        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("token", token);
        new Token(this).saveToken(token);
        validation(token);
    }

    private void validation(String token){
        List<CurrentUser> currentUsers = CurrentUser.listAll(CurrentUser.class);
        if (currentUsers != null & currentUsers.size() > 0){
            new PutToken().execute(token);

        }

    }
}
