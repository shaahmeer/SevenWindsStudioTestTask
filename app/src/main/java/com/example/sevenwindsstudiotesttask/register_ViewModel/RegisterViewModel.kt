package com.example.sevenwindsstudiotesttask.register_ViewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sevenwindsstudiotesttask.model.AuthResponse
import com.example.sevenwindsstudiotesttask.model.RegisterRequest
import com.example.sevenwindsstudiotesttask.network.loginInterface
import com.example.sevenwindsstudiotesttask.network.retroInstance
import retrofit2.Call
import retrofit2.Response // Correct import statement

class RegisterViewModel : ViewModel() {
    var liveData: MutableLiveData<AuthResponse> = MutableLiveData()

    fun getRegister(): MutableLiveData<AuthResponse> {
        return liveData
    }

    fun RegistrationLogic(email: String, password: String, repeatPassword: String) {
        if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            liveData.postValue(null)
        } else if (password != repeatPassword) {
            liveData.postValue(null)
        } else if (password.length < 6) {
            liveData.postValue(null)


        } else {
            Toast.makeText(this@RegisterViewModel, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()

        }

        val registerRequest = RegisterRequest(email, password)
        val retroInstance = retroInstance().getRetroInstance()
        val retroService = retroInstance.create(loginInterface::class.java)
        val call = retroService.registerUser(registerRequest)
        call.enqueue(object : retrofit2.Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }


    }


