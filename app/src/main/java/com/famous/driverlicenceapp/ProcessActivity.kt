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

        val fullname = binding.fullnameEdit.text.toString()
        val address = binding.addressEdit.text.toString()
        val city = binding.cityEdit.text.toString()
        val phoneNumber = binding.phoneEdit.text.toString()
        val state = binding.stateEdit.text.toString()
        val date = binding.dateEdit.text.toString()
        val height = binding.heightBtn.text.toString()
        val maleFemale = binding.mfEdit.text.toString()



    }
}