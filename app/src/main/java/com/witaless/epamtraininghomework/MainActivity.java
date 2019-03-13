package com.witaless.epamtraininghomework;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_activity_button_open_vk_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(VKPageActivity.class);
            }
        });
        findViewById(R.id.main_activity_button_open_podcasts_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(GooglePodcastsActivity.class);
            }
        });
    }
    private void openActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
