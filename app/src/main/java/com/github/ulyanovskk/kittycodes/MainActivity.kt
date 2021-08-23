package com.github.ulyanovskk.kittycodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.preference.Preference
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    private lateinit var exitBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exitBtn = findViewById<Button>(R.id.exitBtn)
        setClickListeners()
        restoreData()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,InternetCodesFragment.newInstance())
            .commitNow()
    }

    private fun setClickListeners() {
        findViewById<Button>(R.id.settingsBtn).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,SettingsFragment())
                .commitNow()
        }
        findViewById<Button>(R.id.searchBtn).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, InternetCodesFragment.newInstance())
                .commitNow()
            restoreData()
        }
        exitBtn.setOnClickListener {
            finish()
        }
    }
    private fun restoreData() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        exitBtn.isVisible = sharedPreferences.getBoolean("exitVisibility", true)
    }
}