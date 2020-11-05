package com.giogen.interfazconfig;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

public class Preferencia extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefer);
        Load_Data();
    }

    public void Load_Data(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean ch_Oscuro = sp.getBoolean("oscuro",false);
        if (ch_Oscuro){
            getListView().setBackgroundColor(Color.parseColor("#222222"));
        }else {
            getListView().setBackgroundColor(Color.parseColor("#ffffff"));
        }
        CheckBoxPreference chk_oscuro= (CheckBoxPreference) findPreference("oscuro");
        chk_oscuro.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean encendido = (Boolean)o;
                if (encendido){
                    getListView().setBackgroundColor(Color.parseColor("#222222"));
                }else {
                    getListView().setBackgroundColor(Color.parseColor("#ffffff"));
                }

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        Load_Data();
        super.onResume();
    }
}
