package com.example.sevenwindsstudiotesttask.network

import com.example.sevenwindsstudiotesttask.model.AuthResponse
import com.example.sevenwindsstudiotesttask.model.ModelRegister
import com.example.sevenwindsstudiotesttask.model.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface loginInterface {
    @POST("auth/registration")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<AuthResponse>
}
