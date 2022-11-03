package com.inf5d6.tp1.ui.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailsTvShowModelFactory (val application: Application, private val idTvShow: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsTvShowViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailsTvShowViewModel(this.application, this.idTvShow) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}