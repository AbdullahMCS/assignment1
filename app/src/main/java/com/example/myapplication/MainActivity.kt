package com.example.myapplication

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Broadcast Receiver
        val batteryReceiver = BatteryReceiver()
        applicationContext.registerReceiver(
            batteryReceiver,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )


        // Service
        val intent = Intent(this, MusicService::class.java)
        startService(intent)
    }
}