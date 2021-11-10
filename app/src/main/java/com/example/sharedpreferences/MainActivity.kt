package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleFromPrefs = resources.getString(R.string.title_text)
        val appName = resources.getString(R.string.app_name)
        val highscore = resources.getInteger(R.integer.saved_high_score_key)
        Log.d("SavedValues", "$appName , $titleFromPrefs")
        Log.d("SavedValues", "initial high score $highscore")

        val textvi = findViewById<TextView>(R.id.tv1)
        textvi.setText(titleFromPrefs)

        val switch1 = findViewById<Switch>(R.id.Stw1)
        val switch2 = findViewById<Switch>(R.id.Stw2)
        val switch3 = findViewById<Switch>(R.id.Stw3)
        val switch4 = findViewById<Switch>(R.id.Stw4)
        switch1.isChecked = resources.getBoolean(R.bool.boolean_key1)
        switch2.isChecked = resources.getBoolean(R.bool.boolean_key2)
        switch3.isChecked = resources.getBoolean(R.bool.boolean_key3)
        switch4.isChecked = resources.getBoolean(R.bool.boolean_key4)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        if(sharedPref != null){
            val success = sharedPref.edit().putInt(getString(R.integer.saved_high_score_key),60).commit()
            if(success){
                val newHighScore = sharedPref.getInt(getString(R.integer.saved_high_score_key),5)
                Log.d("SavedValues", "after being commited $newHighScore")
            }
        sharedPref.edit().putString(getString(R.string.title_text), "Sobreescrito").commit()
        Log.d("SavedValues", "new title ${sharedPref.getString(getString(R.string.title_text), "")}")

        sharedPref.edit().putString("algun_string_asi_nomas", "a ver si se guarda").commit()
        Log.d("SavedValues", "Experimento ${sharedPref.getString("algun_string_asi_nomas", "")}")
        }
    }
}
