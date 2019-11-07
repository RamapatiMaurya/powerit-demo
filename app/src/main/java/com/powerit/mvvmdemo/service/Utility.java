package com.powerit.mvvmdemo.service;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Utility {
    private static final String MY_PREFS_NAME = "MyPrefsFile";

    public static void saveStringPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringPreference(Context context, String key) {
        return context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).getString(key, null);
    }

}
