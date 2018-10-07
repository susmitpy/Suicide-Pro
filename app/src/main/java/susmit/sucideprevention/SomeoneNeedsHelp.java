package susmit.sucideprevention;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;

public class SomeoneNeedsHelp extends AppCompatActivity {
    Button willCall, callMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_someone_needs_help);
        willCall = findViewById(R.id.willCall);
        callMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelephonyManager phoneMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                @SuppressLint("MissingPermission") String numberToCall = phoneMgr.getLine1Number();
                // Send number to call to server
            }
        });
        willCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent1 = new Intent(Intent.ACTION_CALL);
                phoneIntent1.setData(Uri.parse("tel:" + "8767042470"));  //02227546669
                try {
                    phoneIntent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(phoneIntent1);
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
