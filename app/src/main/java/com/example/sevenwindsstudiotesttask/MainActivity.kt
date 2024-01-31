package com.example.sevenwindsstudiotesttask

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.sevenwindsstudiotesttask.databinding.ActivityMainBinding
import com.example.sevenwindsstudiotesttask.model.RegisterRequest
import com.example.sevenwindsstudiotesttask.register_ViewModel.RegisterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // Observe LiveData from ViewModel
        viewModel.getRegister().observe(this, { userList ->
            // Update UI with the result from ViewModel
            if (userList != null) {
                // Handle the list of users as needed
                binding.textViewResult.text = userList.toString()
                Toast.makeText(this, "Posted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed to fetch data", Toast.LENGTH_LONG).show()
            }
        })


        binding.button.setOnClickListener {
            PerformRegistration()
        }
    }

    private fun PerformRegistration() {
       val email = binding.Email.text.toString()
        val password = binding.Password.text.toString()
        val repeatPassword = binding.RepeatPAssword.text.toString()

        viewModel.RegistrationLogic(email,password,repeatPassword)
    }




    }
