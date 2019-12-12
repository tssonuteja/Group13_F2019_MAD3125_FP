package com.example.group13_f2019_mad3125_fp;



import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private SharedPreferences preferences;

    public Preference(Context context){
        preferences = context.getSharedPreferences("myPreference", Context.MODE_PRIVATE);
    }

    public void put(String key, String value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void put(String key, boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key){
        return preferences.getBoolean(key, false);
    }

    public String getString(String key){
        return preferences.getString(key, "");
    }

    public void clearData(String key){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }
}
