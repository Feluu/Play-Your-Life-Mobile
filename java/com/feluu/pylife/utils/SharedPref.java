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
        editor.apply();
    }

    public void setAvailableWheels(String wheels) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putString("Wheels", wheels);
        editor.apply();
    }

    public Boolean loadNightModeState() {
        return mySharedPref.getBoolean("NightMode", false);
    }

    public String loadAvailableWheels() {
        return mySharedPref.getString("Wheels", null);
    }
}
