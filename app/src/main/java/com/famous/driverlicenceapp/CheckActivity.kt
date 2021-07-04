package com.famous.driverlicenceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.famous.driverlicenceapp.databinding.ActivityCheckBinding

class CheckActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}