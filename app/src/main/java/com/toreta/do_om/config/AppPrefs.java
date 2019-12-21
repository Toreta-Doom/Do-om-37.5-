package com.toreta.do_om.config;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefs {

    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;

    private static int PRIVATE_MODE = 0;
    private static String PREF_NAME = "app-prefs";
    private static String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";


    public AppPrefs(Context context){
        prefs = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        prefsEditor = prefs.edit();
    }

    void setFirstTimeLaunch(Boolean isFirstTime){
        prefsEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        prefsEditor.commit();
    }

    Boolean isFirstTimeLaunch(){
        return prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


}
