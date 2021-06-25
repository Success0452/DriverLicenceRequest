package com.famous.driverlicenceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.famous.driverlicenceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.about.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        binding.check.setOnClickListener {
            startActivity(Intent(this, CheckActivity::class.java))
        }

    }
}