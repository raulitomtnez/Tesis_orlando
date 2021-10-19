package com.example.raul.myapplication_tesis_2.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPreferences {
    // Constants
    private static final String KEY_LOGIN_STATUS = "LOGIN_STATUS";
    private static final String KEY_USER_NAME = "USER_NAME";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_PASSWORD = "PASSWORD";

    public AppPreferences() {
    }

    /**
     * To save login status
     *
     * @param status  Login status
     * @param context App context
     */
    public static void saveLoginStatus(boolean status, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_LOGIN_STATUS, status);
        editor.apply();
    }

    /**
     * To now login status
     *
     * @param context App context
     * @return preferences.getBoolean()
     */
    public static boolean getLoginStatus(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(KEY_LOGIN_STATUS, false);
    }

    /**
     * To save user name
     *
     * @param user_name User name
     * @param context   App context
     * @return
     */
    public static boolean saveUserName(String user_name, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_USER_NAME, user_name);
        editor.apply();
        return true;
    }

    /**
     * To get user name
     *
     * @param context App context
     * @return preferences.getString()
     */
    public static String getUserName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(KEY_USER_NAME, "");
    }

    /**
     * To save user name
     *
     * @param password User password
     * @param context  App context
     * @return
     */
    public static boolean saveRole(String password, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
        return true;
    }

    /**
     * To get user name
     *
     * @param context App context
     * @return preferences.getString()
     */
    public static String getRole(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(KEY_PASSWORD, "");
    }

    /**
     * To save name
     *
     * @param name    Name
     * @param context App context
     * @return
     */
    public static boolean saveName(String name, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAME, name);
        editor.apply();
        return true;
    }

    /**
     * To get name
     *
     * @param context App context
     * @return preferences.getString()
     */
    public static String getName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(KEY_NAME, "");
    }

}
