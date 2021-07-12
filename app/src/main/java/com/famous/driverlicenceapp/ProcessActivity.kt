package com.famous.driverlicenceapp

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.famous.driverlicenceapp.databinding.ActivityProcessBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*


class ProcessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProcessBinding
    lateinit var ImageUri : Uri

    private lateinit var database: FirebaseDatabase
    private lateinit var reference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users")

        binding.applyBtn.setOnClickListener {
            sendData()
        }
    }

    private fun sendData() {
        val fullname = binding.fullnameEdit.text.toString().trim()
        val address = binding.addressEdit.text.toString().trim()
        val city = binding.cityEdit.text.toString().trim()
        val phoneNumber = binding.phoneEdit.text.toString().trim()
        val state = binding.stateEdit.text.toString().trim()
        val date = binding.dateEdit.text.toString().trim()
        val height = binding.heightBtn.text.toString().trim()
        val maleFemale = binding.mfEdit.text.toString().trim()

        if (fullname.isNotEmpty() && address.isNotEmpty() && city.isNotEmpty() && phoneNumber.isNotEmpty() && state.isNotEmpty() && date.isNotEmpty() && height.isNotEmpty() && maleFemale.isNotEmpty())
        {

            var model = DatabaseModel(fullname, address, city, phoneNumber, state, date, height, maleFemale)
            var id = reference.push().key

            //Here we send the data to Firebase
            reference.child(id!!).setValue(model)

            startActivity(Intent(this, DoneActivity::class.java))
            finish()
        }else
        {
            Toast.makeText(this, "All Field Required", Toast.LENGTH_LONG).show()
        }
    }
}