package pk.wirless.seanet.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import pk.wirless.seanet.Login;
import pk.wirless.seanet.R;

public class Splash extends AppCompatActivity {

    private static int splash_time_out = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash.this, Login.class);
                startActivity(homeIntent);
                finish();
            }
        },splash_time_out);
    }
}