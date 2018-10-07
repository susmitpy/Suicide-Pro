package e.susmit.remoteaccess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.provider.Telephony;
import android.util.Log;

public class onBoot extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.e("FINAL", "Boot Completed Message Received");
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {

            Intent intent1 = new Intent();
            intent1.setClass(context, ForBind.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
            Log.e("FINAL", "Service Started");

        }
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
