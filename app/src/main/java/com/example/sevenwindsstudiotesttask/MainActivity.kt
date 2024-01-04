package com.example.sevenwindsstudiotesttask

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.sevenwindsstudiotesttask.model.RegisterRequest
import com.example.sevenwindsstudiotesttask.register_ViewModel.RegisterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RegisterViewModel
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var repeatPasswordEditText: EditText
    private lateinit var registrationButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // Initialize UI components
        emailEditText = findViewById(R.id.editTextText)
        passwordEditText = findViewById(R.id.editTextText2)
        repeatPasswordEditText = findViewById(R.id.editTextText3)
        registrationButton = findViewById(R.id.button)
        resultTextView = findViewById(R.id.textViewResult)

        // Observe LiveData from ViewModel
        viewModel.getRegister().observe(this, { userList ->
            // Update UI with the result from ViewModel
            if (userList != null) {
                // Handle the list of users as needed
                resultTextView.text = userList.toString()
                Toast.makeText(this, "Posted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed to fetch data", Toast.LENGTH_LONG).show()
            }
        })

        // Set onClickListener for the registration button
        registrationButton.setOnClickListener {
            // Retrieve values from EditText fields
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val repeatPassword = repeatPasswordEditText.text.toString()

            // Validate input
            if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != repeatPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Call the ViewModel method to make the API call
                val registerRequest = RegisterRequest(email, password)
                viewModel.makeApiCall(registerRequest)
            }
        }
    }
}