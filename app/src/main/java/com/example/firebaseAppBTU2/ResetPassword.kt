package com.example.firebaseAppBTU2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class  ResetPassword : AppCompatActivity() {
    lateinit var EmailText: EditText;
    lateinit var RecoverButton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        init()


        RecoverButton.setOnClickListener{

            if (EmailText.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Input is Empty",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (EmailText.text.contains(".") && EmailText.text.contains("@")){

                FirebaseAuth.getInstance().sendPasswordResetEmail(EmailText.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(this,"Recovery was sent on your Email",Toast.LENGTH_LONG).show()
                    }

                    else {
                        Toast.makeText(this, "Error occured", Toast.LENGTH_LONG).show()
                    }
                }

            }
            else{
                Toast.makeText(this,"Enter existing Email",Toast.LENGTH_LONG).show()
            }

        }

    }

    fun init() {
        EmailText=findViewById(R.id.input_email_text)
        RecoverButton=findViewById(R.id.recover_button)
    }
}

