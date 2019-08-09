package com.iqbalseptyan.uasakb.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 08-08-2019
*/
public class Preferences {
    static final String KEY_NAMA_TEREGISTER ="nama", KEY_EMAIL_TEREGISTER ="email",
            KEY_USER_TEREGISTER ="user", KEY_PASS_TEREGISTER ="pass";
    static final String KEY_USERNAME_SEDANG_LOGIN = "Username_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setRegisteredNama(Context context, String nama){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NAMA_TEREGISTER, nama);
        editor.apply();
    }

    public static String getRegisteredNama(Context context){
        return getSharedPreference(context).getString(KEY_NAMA_TEREGISTER,"");
    }

    public static void setRegisteredEmail(Context context, String email){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_EMAIL_TEREGISTER, email);
        editor.apply();
    }

    public static String getRegisteredEmail(Context context){
        return getSharedPreference(context).getString(KEY_EMAIL_TEREGISTER,"");
    }

    public static void setRegisteredUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USER_TEREGISTER, username);
        editor.apply();
    }

    public static String getRegisteredUser(Context context){
        return getSharedPreference(context).getString(KEY_USER_TEREGISTER,"");
    }

    public static void setRegisteredPass(Context context, String password){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_PASS_TEREGISTER, password);
        editor.apply();
    }

    public static String getRegisteredPass(Context context){
        return getSharedPreference(context).getString(KEY_PASS_TEREGISTER,"");
    }

    public static void setLoggedInUser(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USERNAME_SEDANG_LOGIN, username);
        editor.apply();
    }

    public static String getLoggedInUser(Context context){
        return getSharedPreference(context).getString(KEY_USERNAME_SEDANG_LOGIN,"");
    }

    public static void setLoggedInStatus(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN,status);
        editor.apply();
    }

    public static boolean getLoggedInStatus(Context context){
        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN,false);
    }

    public static void clearLoggedInUser (Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_USERNAME_SEDANG_LOGIN);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();

    }
}
