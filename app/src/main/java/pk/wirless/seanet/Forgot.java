package pk.wirless.seanet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Forgot extends AppCompatActivity {
    private TextView i_changed_my_mind;
    private Button change_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        i_changed_my_mind = (TextView) findViewById(R.id.mind_changed);
        change_password = (Button) findViewById(R.id.change_password_btn);
        i_changed_my_mind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forgot.this,Login.class));
                finish();
            }
        });
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forgot.this,Login.class));
                finish();
            }
        });
    }
}