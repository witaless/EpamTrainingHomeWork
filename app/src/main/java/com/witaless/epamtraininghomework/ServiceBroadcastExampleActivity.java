package com.witaless.epamtraininghomework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceBroadcastExampleActivity extends AppCompatActivity {

    public static final String SERVICE_PARAM_STATUS = "paramStatus";
    public static final String SERVICE_PARAM_TIME = "time";
    public static final String SERVICE_STATUS_CODE_START = "start";
    public static final String SERVICE_STATUS_CODE_FINISH = "finish";
    public static final String BROADCAST_ACTION = ServiceBroadcastExampleActivity.class.getSimpleName() + ".BROADCAST_ACTION";
    private static final String MESSAGE_SERVICE_STARTED = "Service Started";
    private static final String MESSAGE_SERVICE_FINISHED = "Service Finished Work";

    private TextView startTimeView;
    private TextView finishTimeView;
    private Button startServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_broadcast_example);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startTimeView = findViewById(R.id.start_time_textview);
        finishTimeView = findViewById(R.id.finish_time_textview);
        startServiceButton = findViewById(R.id.start_service_button);

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(ServiceBroadcastExampleActivity.this, MyService.class));
                startServiceButton.setEnabled(false);
                finishTimeView.setText(R.string.service_broadcast_example_finish_time_text);
                Toast.makeText(ServiceBroadcastExampleActivity.this, MESSAGE_SERVICE_STARTED, Toast.LENGTH_SHORT).show();
            }
        });

        registerReceiver(broadcastReceiver, new IntentFilter(BROADCAST_ACTION));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String status = intent.getStringExtra(SERVICE_PARAM_STATUS);
            String time = intent.getStringExtra(SERVICE_PARAM_TIME);

            switch (status) {
                case SERVICE_STATUS_CODE_START:
                    startTimeView.setText(time);
                    break;
                case SERVICE_STATUS_CODE_FINISH:
                    finishTimeView.setText(time);
                    startServiceButton.setEnabled(true);
                    Toast.makeText(ServiceBroadcastExampleActivity.this, MESSAGE_SERVICE_FINISHED, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
