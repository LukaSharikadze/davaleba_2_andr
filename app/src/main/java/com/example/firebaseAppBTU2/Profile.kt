package com.example.firebaseAppBTU2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {
    lateinit var signout_butto:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        signout_butto.setOnClickListener{


            val FirebaseAuth = FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
    }

    fun init(){
        signout_butto=findViewById(R.id.sign_out_button)
    }
}