package com.example.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var  emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var sumbitButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        emailInput = findViewById(R.id.signInEmail)
        passwordInput = findViewById(R.id.signInPassword)
        sumbitButton = findViewById(R.id.submitBatton)

        sumbitButton.setOnClickListener {

            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText( this, "Empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Congrats", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                    }

                }
        }

    }
}