package com.example.okesampah.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.okesampah.R
import com.example.okesampah.app.ApiConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var btnDaftar: Button
    lateinit var btnGoogleLogin: Button
    lateinit var editNama: Button
    lateinit var editEmail: Button
    lateinit var editPassword: Button
    lateinit var editNohp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initiasialisasi()
        btnDaftar.setOnClickListener {
            register()
        }
    }

    fun initiasialisasi(){
        btnDaftar = findViewById(R.id.btn_daftar)
        btnGoogleLogin = findViewById(R.id.btn_logingoogle)
        editNama = findViewById(R.id.edit_nama)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        editNohp = findViewById(R.id.edit_nohp)
    }
    fun register(){
        if(editNama.text.isEmpty()){
            editNama.error =  "Kolom Nama tidak boleh kosong"
            editNama.requestFocus()
            return
        }else if(editEmail.text.isEmpty()){
            editEmail.error =  "Kolom Email tidak boleh kosong"
            editEmail.requestFocus()
            return
        }else if(editPassword.text.isEmpty()){
            editPassword.error =  "Kolom Password tidak boleh kosong"
            editPassword.requestFocus()
            return
        }else if(editNohp.text.isEmpty()){
            editNohp.error =  "Kolom No.HP tidak boleh kosong"
            editNohp.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(editNama.text.toString(),editEmail.text.toString(),editPassword.text.toString(),editNohp.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}