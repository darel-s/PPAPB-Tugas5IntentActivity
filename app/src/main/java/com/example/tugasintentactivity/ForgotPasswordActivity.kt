package com.example.tugasintentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var inputemailforget : EditText
    private lateinit var btnNext : Button
    private lateinit var btnBack : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        inputemailforget = findViewById(R.id.input_email_forget)
        btnNext = findViewById(R.id.btn_next)
        btnBack = findViewById(R.id.btn_back)

        btnNext.setOnClickListener {
            val email = inputemailforget.text.toString()
        }

        btnBack.setOnClickListener {
            val intentToLogin = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
            startActivity(intentToLogin)
            finish()
        }
    }
}