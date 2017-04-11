package com.desafiolatam.desafioface.network.fcm;

import android.util.Log;

import com.desafiolatam.desafioface.views.notifications.FavoriteNotification;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by karan_000 on 05-04-2017.
 */

public class MessageService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
        Log.d("fcm", "onMessageReceived: message");
        String email = remoteMessage.getData().get("email");
        FavoriteNotification.notify(this, email);

    }

}
