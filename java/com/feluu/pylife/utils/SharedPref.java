package com.feluu.pylife.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    
    private SharedPreferences mySharedPref;

    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("NightMode", state);
        editor.commit();
    }

    public void setAvailableWheels(String wheels) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putString("Wheels", wheels);
        editor.commit();
    }

    public Boolean loadNightModeState() {
        Boolean state = mySharedPref.getBoolean("NightMode", false);
        return state;
    }

    public String loadAvailableWheels() {
        String wheels = mySharedPref.getString("Wheels", null);
        return wheels;
    }
}
