package com.famous.driverlicenceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.famous.driverlicenceapp.databinding.ActivityDoneBinding

class DoneActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.chckFormBtn.setOnClickListener {
            startActivity(Intent(this, CheckActivity::class.java))
        }

    }
}