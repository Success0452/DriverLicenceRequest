package com.famous.driverlicenceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import java.lang.StringBuilder

class FormActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

         database = FirebaseDatabase.getInstance().reference
// GetData
        var getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder()
                for (i in snapshot.children){
                    var fullNG = i.child("").getValue()
                    var addressG = i .child("").getValue()
                    var cityG = i .child("").getValue()
                    var phoneNumberG = i .child("").getValue()
                    var state = i .child("").getValue()
                    var date = i .child("").getValue()
                    var height = i .child("").getValue()
                    var maleFemale = i .child("").getValue()

                    sb.append("${i.key} $fullNG $addressG $cityG $phoneNumberG $state $date $height $maleFemale")



                }
            }


            override fun onCancelled(error: DatabaseError) {

            }

        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
    }

}