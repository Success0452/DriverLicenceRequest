package com.famous.driverlicenceapp

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.famous.driverlicenceapp.databinding.ActivityProcessBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*


class ProcessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProcessBinding
    lateinit var ImageUri : Uri

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

        binding.applyBtn.setOnClickListener {
            var database = FirebaseDatabase.getInstance().reference
            database.child(fullname).setValue(Save(fullname,address,city,phoneNumber,state,date, height, maleFemale))

            startActivity(Intent(this, DoneActivity::class.java))
        }
    }
}