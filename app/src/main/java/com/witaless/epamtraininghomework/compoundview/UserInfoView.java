package com.witaless.epamtraininghomework.compoundview;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.witaless.epamtraininghomework.R;

import java.util.Random;

public class UserInfoView extends LinearLayout {

    private static final int MAX_COLOR_CHANNEL = 256;

    private ImageView userIconImageView;
    private TextView userNameTextView;
    private TextView userEmailTextView;

    private UserInfoModel userInfo = null;

    public UserInfoView(Context context) {
        super(context);
        initializeViews(context);
    }

    public UserInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public UserInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public UserInfoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.user_info_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        setOrientation(VERTICAL);

        userIconImageView = findViewById(R.id.user_icon);
        userNameTextView = findViewById(R.id.user_name);
        userEmailTextView = findViewById(R.id.user_email);

        userIconImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int randomRed = random.nextInt(MAX_COLOR_CHANNEL);
                int randomGreen = random.nextInt(MAX_COLOR_CHANNEL);
                int randomBlue = random.nextInt(MAX_COLOR_CHANNEL);
                userIconImageView.setColorFilter(Color.rgb(randomRed, randomGreen, randomBlue));
            }
        });
    }

    public void setUserInfo(final UserInfoModel userInfo) {
        userIconImageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), userInfo.getIcon()));
        userNameTextView.setText(userInfo.getName());
        userEmailTextView.setText(userInfo.getEmail());
        this.userInfo = userInfo;
    }

    public UserInfoModel getUserInfo() {
        return userInfo;
    }


}
