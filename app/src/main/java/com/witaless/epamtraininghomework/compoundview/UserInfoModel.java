package com.witaless.epamtraininghomework.compoundview;

import android.support.annotation.DrawableRes;

public class UserInfoModel {

    private String name;
    private String email;
    @DrawableRes
    private int icon;

    public UserInfoModel() {
    }

    public UserInfoModel(String name, String email, @DrawableRes int icon) {
        this.name = name;
        this.email = email;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon = icon;
    }
}
