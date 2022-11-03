package com.inf5d6.tp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.inf5d6.tp1.viewModels.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)


        val userInput = findViewById<EditText>(R.id.userInput)
        val passwordInput = findViewById<EditText>(R.id.passInput)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            loginViewModel.username = userInput.text.toString()
            loginViewModel.password = passwordInput.text.toString()
            loginViewModel.login()
        }

        
    }
}