package com.binimoi.shofiqanytimehospital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {

    //Storage File
    public static final String SHARED_PREF_NAME = "larntech";

    //Username
    public static final String USER_NAME = "username";

    public static SharedPrefManager mInstance;

    public static Context mCtx;


    public SharedPrefManager(Context context) {
        mCtx = context;
    }

    public SharedPrefManager() {

    }


    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    //method to store user data
    public void storeUserName(String names) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, names);
        editor.commit();
    }

    //check if user is logged in
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, null) != null;
    }


    //find logged in user
    public String LoggedInUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, null);

    }


    //Logout user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        mCtx.startActivity(new Intent(mCtx, PatientLoginRegActivity.class));
    }

}
