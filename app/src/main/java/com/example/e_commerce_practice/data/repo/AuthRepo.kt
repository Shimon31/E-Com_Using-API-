package com.example.e_commerce_practice.data.repo

import com.example.e_commerce_practice.data.model.login.RequestLogin
import com.example.e_commerce_practice.data.model.login.ResponseLogin
import com.example.e_commerce_practice.data.model.registration.RequestRegistration
import com.example.e_commerce_practice.data.model.registration.ResponseRegistration
import com.example.e_commerce_practice.services.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(private var service: AuthService) {


    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin> {

        return service.login(requestLogin)
    }


    suspend fun register(requestRegister: RequestRegistration): Response<ResponseRegistration> {

        return service.register(requestRegister)
    }
}