package com.example.assignment

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.myapplication.R

class BatteryChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BATTERY_CHANGED) {
            Toast.makeText(context, "Battery Level Changed", Toast.LENGTH_LONG).show()
        }
    }
}