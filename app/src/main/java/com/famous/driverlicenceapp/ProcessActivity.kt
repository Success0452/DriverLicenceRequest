package com.famous.driverlicenceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.famous.driverlicenceapp.databinding.ActivityProcessBinding

class ProcessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProcessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}