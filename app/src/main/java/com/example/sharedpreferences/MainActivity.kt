package com.example.sharedpreferences

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
        Log.d("SavedValues", "$appName , $titleFromPrefs")

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
    }
}
