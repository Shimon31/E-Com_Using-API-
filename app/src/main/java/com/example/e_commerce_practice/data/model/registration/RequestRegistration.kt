package com.example.e_commerce_practice.data.model.registration


import com.google.gson.annotations.SerializedName

data class RequestRegistration(
    @SerializedName("avatar")
    var avatar: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("password")
    var password: String?
)