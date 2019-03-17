package com.witaless.epamtraininghomework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class RestoreStateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restore_state);

        if (savedInstanceState == null) {
            Fragment newFragment = new RestoreStateFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.restore_state_container, newFragment);
            transaction.commit();
        }
    }
}
