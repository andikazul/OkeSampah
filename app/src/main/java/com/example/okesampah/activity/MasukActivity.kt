package com.example.okesampah.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.okesampah.R
import com.example.okesampah.helper.SharedPref

class MasukActivity : AppCompatActivity() {
    lateinit var s:SharedPref
    private lateinit var btnLogin : Button
    private lateinit var btnDaftar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)

       mainButton()
    }

    fun mainButton(){
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
        btnDaftar = findViewById(R.id.btnDaftar)
        btnDaftar.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}