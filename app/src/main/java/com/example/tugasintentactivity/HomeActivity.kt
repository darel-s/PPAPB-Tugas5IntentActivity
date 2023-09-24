package com.example.tugasintentactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasintentactivity.RegisterActivity.Companion.EXTRA_EMAIL
import com.example.tugasintentactivity.RegisterActivity.Companion.EXTRA_PHONE
import com.example.tugasintentactivity.RegisterActivity.Companion.EXTRA_USERNAME
import com.example.tugasintentactivity.databinding.ActivityHomepageBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data

                val username = data?.getStringExtra(EXTRA_USERNAME)
                val email = data?.getStringExtra(EXTRA_EMAIL)
                val phone = data?.getStringExtra(EXTRA_PHONE)

                if (!username.isNullOrEmpty() && !email.isNullOrEmpty() && !phone.isNullOrEmpty()) {
                    binding.txtUsername.text = username
                    binding.txtEmail.text = email
                    binding.txtPhone.text = phone
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        with(binding) {
            txtUsername.text = "$username"
            txtEmail.text = "$email"
            txtPhone.text = "$phone"

            val btnLogout = findViewById<Button>(R.id.btn_logout)
            btnLogout.setOnClickListener {
                val intentToRegisterActivity = Intent(this@HomeActivity, RegisterActivity::class.java)
                intentToRegisterActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intentToRegisterActivity)
                finish()
            }
        }
    }
}