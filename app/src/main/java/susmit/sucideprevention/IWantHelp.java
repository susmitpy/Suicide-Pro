package susmit.sucideprevention;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class IWantHelp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iwant_help);



        Intent phoneIntent1 = new Intent(Intent.ACTION_CALL);
        phoneIntent1.setData(Uri.parse("tel:" + "9892021890"));
        try {
          //  phoneIntent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(phoneIntent1);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
