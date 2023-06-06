package com.example.okesampah.app

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register") //"http://127.0.0.1:8000/api/register"
    fun register(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("nohp") nohp:String,
    ):Call<ResponseBody>

    @POST("login") //"http://127.0.0.1:8000/api/login"
    fun login(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("nohp") nohp:String,
    ):Call<ResponseBody>
}