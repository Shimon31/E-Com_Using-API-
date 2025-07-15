package com.example.e_commerce_practice.di

import com.example.e_commerce_practice.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {

        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit.Builder) : AuthService{

        return retrofit.build().create(AuthService::class.java)
    }

}