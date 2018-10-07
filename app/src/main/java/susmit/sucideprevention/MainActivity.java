package susmit.sucideprevention;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton iWantHelp, someoneNeedsHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iWantHelp = findViewById(R.id.btnIWantHelp);
        someoneNeedsHelp = findViewById(R.id.btnSomeoneNeedsHelp);

        iWantHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IWantHelp.class));
            }
        });

        someoneNeedsHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SomeoneNeedsHelp.class));
            }
        });
    }
}
