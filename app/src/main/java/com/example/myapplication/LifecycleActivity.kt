package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LifecycleActivity : AppCompatActivity() {

    val TAG_NAME = LifecycleActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        Log.d(TAG_NAME, "OnCreate: Start of Activity")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG_NAME, "OnStart: Creates resource allocation")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG_NAME, "OnResume: Let's User Interact!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG_NAME, "OnPause: Stop user engagement and prepare for removal of resources")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG_NAME, "OnStop: Remove the resources/content used")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG_NAME, "OnDestroy: Remove the reference of activity and clear every resource")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG_NAME, "OnRestart: Notify for the reactivation of activity")
    }
}