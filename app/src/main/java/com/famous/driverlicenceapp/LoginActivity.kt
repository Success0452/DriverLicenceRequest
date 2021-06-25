package com.famous.driverlicenceapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.famous.driverlicenceapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    //ActionBar
    private lateinit var actionBar: ActionBar

    //ProgressDialog
    private lateinit var progressDialog : ProgressDialog

    //FirebaseAuth
    private lateinit var firebaseAuth : FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configure ActionBar
        actionBar = supportActionBar!!
        actionBar.title = "Login"

        //configure ProgressDialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Logging in")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, open sign up
        binding.loginBtn.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //handle click, begin login
        binding.signB.setOnClickListener{
            //before login, validate data
            validateData()
        }


    }

    private fun validateData() {
        //get data
        email = binding.emailLogin.text.toString().trim()
        password = binding.passwordLogin.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.emailLogin.error = "Invalid Email Format"
        }else if (TextUtils.isEmpty(password)){
            binding.passwordLogin.error = "Please Enter Password"
        } else {
            //data is validated, begin login
            firebaseLogin()
        }


    }

    private fun firebaseLogin() {
        //show progress
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //login success
                progressDialog.dismiss()
                //get User info
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Login as $email", Toast.LENGTH_LONG).show()
                //open main activity
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            }
            .addOnFailureListener{ e->
                //login failure
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun checkUser() {
        //if user is logged in go to profile activity
        //get Current User

        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            //user is already logged in
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}