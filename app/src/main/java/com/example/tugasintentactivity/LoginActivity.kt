package com.example.tugasintentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tugasintentactivity.databinding.ActivityHomepageBinding
import com.example.tugasintentactivity.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    companion object{
        const val EXTRA_USERNAME = "username"
        const val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnLogin.setOnClickListener {
                val intentToHome = Intent(this@LoginActivity, HomeActivity::class.java)

                val username = inputUsername.text.toString()
                val password = inputPassword.text.toString()

                intentToHome.putExtra(RegisterActivity.EXTRA_USERNAME, username)
                intentToHome.putExtra(RegisterActivity.EXTRA_PASSWORD, password)

                startActivity(intentToHome)
            }
        }

        val btnForgotPassword = findViewById<TextView>(R.id.btn_forgot_password)

        btnForgotPassword.setOnClickListener {
            val intentToForgotPassword = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intentToForgotPassword)
        }
        val btnToRegister = findViewById<TextView>(R.id.btn_to_register)
        btnToRegister.setOnClickListener{
            val intentToRegister = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intentToRegister)
        }
    }
}