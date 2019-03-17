package com.witaless.epamtraininghomework;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final String TAG = MyService.class.getSimpleName();
    private final String DATE_FORMAT = "kk:mm:ss:SS";
    private final long FINISH_DELAY = 3000;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        sendTimeBroadcast(ServiceBroadcastExampleActivity.SERVICE_STATUS_CODE_START);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sendTimeBroadcast(ServiceBroadcastExampleActivity.SERVICE_STATUS_CODE_FINISH);
                stopSelf();
            }
        }, FINISH_DELAY);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void sendTimeBroadcast(String status) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ROOT);
        String formattedTime = simpleDateFormat.format(new Date());

        Intent intent = new Intent(ServiceBroadcastExampleActivity.BROADCAST_ACTION);
        intent.putExtra(ServiceBroadcastExampleActivity.SERVICE_PARAM_STATUS, status);
        intent.putExtra(ServiceBroadcastExampleActivity.SERVICE_PARAM_TIME, formattedTime);
        sendBroadcast(intent);
    }

}
