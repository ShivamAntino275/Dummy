package com.indigo.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var customView:ExtraView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customView = findViewById<ExtraView>(R.id.layoutExtraView)
        customView.setValue(this)
    }
}