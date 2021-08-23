package com.github.ulyanovskk.kittycodes.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.github.ulyanovskk.kittycodes.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}