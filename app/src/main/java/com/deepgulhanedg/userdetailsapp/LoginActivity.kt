package com.deepgulhanedg.userdetailsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var login = findViewById<Button>(R.id.login) as Button
        var email = findViewById<TextInputLayout>(R.id.email) as TextInputLayout
        var pass = findViewById<TextInputLayout>(R.id.pass) as TextInputLayout

        login.setOnClickListener{

                callApi(
                    setText(email) ,
                    pass.text.toString().trim()
                )

        }
    }

    private fun callApi(username: String, password: String) {

    }
}