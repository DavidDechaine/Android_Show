package com.inf5d6.tp1.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.inf5d6.tp1.repositories.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(val app: Application) : AndroidViewModel(app) {
    var username = ""
    var password = ""
    private val loginRepository = LoginRepository(app)

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            loginRepository.login(username, password)
        }

    }
}
