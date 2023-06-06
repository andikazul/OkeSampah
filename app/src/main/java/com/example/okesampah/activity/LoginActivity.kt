package com.example.okesampah.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.okesampah.R
import com.example.okesampah.helper.SharedPref

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}