package com.example.group13_f2019_mad3125_fp;

import android.content.Context;
import android.content.SharedPreferences;

public class preference {

    private SharedPreferences preferences;

    public Preference(Context context){
        preferences = context.getSharedPreferences("myPreference", Context.MODE_PRIVATE);
    }

}
