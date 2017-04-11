package com.desafiolatam.desafioface.background;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RecentUsersService extends IntentService {

    private static final String ACTION_RECENT_USERS = "com.desafiolatam.desafioface.background.action.ACTION_RECENT_USERS";
    public static final String USERS_FINISHED = "com.desafiolatam.desafioface.background.broadcast.USERS_FINISHED";

    public RecentUsersService() {
        super("RecentUsersService");
    }

    public static void startActionRecentUsers(Context context) {
        Intent intent = new Intent(context, RecentUsersService.class);
        intent.setAction(ACTION_RECENT_USERS);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_RECENT_USERS.equals(action)) {
                fetchUsers();
            }
        }
    }

    private void fetchUsers() {
        Log.d("INTENT SERVICE", "fetch users");

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("page","1");
        queryMap.put("name","karina");
        new fectUsers(-1).execute(queryMap);
    }

    private class fectUsers extends GetUsers{

        public fectUsers(int additionalPages) {
            super(additionalPages);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("RESULT", String.valueOf(integer));
            Intent intent = new Intent();
            intent.setAction(USERS_FINISHED);
            LocalBroadcastManager.getInstance(RecentUsersService.this).sendBroadcast(intent);
        }
    }

}
