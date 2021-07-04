package com.famous.driverlicenceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.famous.driverlicenceapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val input1 = binding.oldEdit.text.toString()
        var input2 = binding.regNum.text.toString()

        binding.processBtn.setOnClickListener {

                startActivity(Intent(this, ProcessActivity::class.java))

        }

    }
}