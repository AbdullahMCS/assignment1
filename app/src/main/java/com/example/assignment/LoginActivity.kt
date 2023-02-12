package com.example.assignment

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val batteryChangeReceiver = BatteryChangeReceiver()
        applicationContext.registerReceiver(
            batteryChangeReceiver,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )

        binding.btnLogin.setOnClickListener {
            val email = binding.edEmail.text
            val password = binding.edPassword.text
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }
}