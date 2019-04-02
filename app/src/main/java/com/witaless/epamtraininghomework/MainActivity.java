package com.witaless.epamtraininghomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(RestoreStateActivity.class);
            }
        });
        findViewById(R.id.start_service_broadcast_example_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ServiceBroadcastExampleActivity.class);
            }
        });
    }

    private void openActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

}
