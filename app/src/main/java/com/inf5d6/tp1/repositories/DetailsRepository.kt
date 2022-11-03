package com.inf5d6.tp1.repositories

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest

import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.inf5d6.tp1.MainActivity
import com.inf5d6.tp1.models.DetailsTvShow

class DetailsRepository(private val app: Application) {
    fun showsDetail(tvShow: MutableLiveData<DetailsTvShow>, id: Int) {
        val queue = Volley.newRequestQueue(app)
        val url = "${MainActivity.SRVURL}/tvshow?tvshowId=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val gson = Gson()
                val details = gson.fromJson(response, DetailsTvShow::class.java)
                tvShow.value = details
            },
            { error ->
                println(error)
            })
        queue.add(stringRequest)
    }
}