package com.example.e_commerce_practice.services

import com.example.e_commerce_practice.data.model.login.RequestLogin
import com.example.e_commerce_practice.data.model.login.ResponseLogin
import com.example.e_commerce_practice.data.model.registration.RequestRegistration
import com.example.e_commerce_practice.data.model.registration.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {


    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin) : Response<ResponseLogin>

    @POST("users/")
    suspend fun register(@Body requestRegister: RequestRegistration) : Response<ResponseRegistration>

}