package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlayer.setOnClickListener {
            startService(Intent(this@MainActivity, MediaPlayerService::class.java))
        }

        binding.btnContact.setOnClickListener {
            startActivity(Intent(this@MainActivity, ContactListActivity::class.java))
        }
    }
}