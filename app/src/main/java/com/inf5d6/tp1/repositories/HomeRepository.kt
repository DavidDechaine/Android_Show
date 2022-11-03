package com.inf5d6.tp1.repositories

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.inf5d6.tp1.MainActivity.Companion.SRVURL
import com.inf5d6.tp1.models.DetailsTvShow

class HomeRepository (private val app: Application){
    fun loadTvshows(tvShowList: MutableLiveData<MutableList<DetailsTvShow>>) {
        val queue = Volley.newRequestQueue(app)
        val url = "${SRVURL}/tvshows"

        val request = StringRequest(
            Request.Method.GET,
            url,
            {
                val arrayTvShows = Gson().fromJson(it, Array<DetailsTvShow>::class.java)
                tvShowList.value = arrayTvShows.toMutableList()
            },
            {error->
                println("ERREUR: $error")
            })
        queue.add(request)
    }
}