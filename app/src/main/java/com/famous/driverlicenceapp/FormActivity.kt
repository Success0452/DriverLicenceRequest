package com.famous.driverlicenceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.famous.driverlicenceapp.databinding.ActivityFormBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.lang.StringBuilder

class FormActivity : AppCompatActivity() {


    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    private lateinit var binding: ActivityFormBinding

    private lateinit var mUser : DatabaseModel
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readData()
    }

    private fun readData() {

        reference = FirebaseDatabase.getInstance().getReference("USers")
        reference.child("Users").get().addOnSuccessListener {
            if (it.exists()){
                val fullName = it.child("fullName").value
                val address = it.child("address").value
                val city = it.child("city").value
                val date = it.child("date").value
                val height = it.child("height").value
                val maleFemale = it.child("maleFemale").value
                val phoneNumber = it.child("phoneNumber").value
                val state = it.child("state").value

                Toast.makeText(this, "Succefully Read", Toast.LENGTH_LONG).show()
                binding.fullNameTxt.text = fullName.toString()
                binding.cityTxt.text = city.toString()
                binding.addressTxt.text = address.toString()
                binding.heightTxt.text = height.toString()
                binding.phoneNumberTxt.text = phoneNumber.toString()
                binding.stateTxt.text = state.toString()
                binding.maleFemaleTxt.text = maleFemale.toString()
                binding.dateTxt.text = date.toString()

            }else
            {
                Toast.makeText(this, "Info not Avaliable", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }
}
