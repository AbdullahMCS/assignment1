package com.example.myapplication

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class BatteryReceiver : BroadcastReceiver() {

    /*
    * Broadcast Receiver: A broadcast receiver is a component that listens for broadcast messages from other apps or from the system.
    * Broadcast receivers are used to receive notifications about events such as incoming SMS messages, battery low, or network connectivity changes.
    * You can create a broadcast receiver by creating a class that extends the BroadcastReceiver class.
    * */
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BATTERY_LOW) {
            // show notification when battery level is low
            val notificationBuilder = NotificationCompat.Builder(context, "battery_channel")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Battery Low")
                .setContentText("Battery level is low, please charge your device.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, notificationBuilder.build())
        }
    }


}

