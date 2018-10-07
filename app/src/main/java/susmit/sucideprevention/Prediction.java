package susmit.sucideprevention;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static susmit.sucideprevention.ForBind.CHANNEL_ID;


public class Prediction extends Service {

    public static final String DEBUG_TAG = "FINAL";
    static boolean toggle = false;

    Notification notification;
    String[] words;


    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(DEBUG_TAG, "Started Service and running");
        // Notifications
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("RemoteAccess")
                .setContentText("Listening For Messages")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
        return START_STICKY;
    }

    private static String CHROME_BOOKMARKS_URI =
            "content://com.android.chrome.browser/bookmarks";

    @Override
    public void onDestroy() {
        sendBroadcast(new Intent("android.intent.action.ACTION_RESTART_SERVICE"));
        super.onDestroy();
        Log.e(DEBUG_TAG, "Stopped Service");

    }

    @Override

    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return null;
        // throw new UnsupportedOperationException("Not yet implemented");
    }



}
