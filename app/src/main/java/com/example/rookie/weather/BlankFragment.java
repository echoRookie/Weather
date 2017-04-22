package com.example.rookie.weather;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.widget.Toast;


public class BlankFragment extends PreferenceFragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pre);
        SwitchPreference switchPreference = (SwitchPreference) findPreference("switch_preference_1");
        switchPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(),"11",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        }

    @Override
    public Preference findPreference(CharSequence key) {
        return super.findPreference(key);
    }
}
