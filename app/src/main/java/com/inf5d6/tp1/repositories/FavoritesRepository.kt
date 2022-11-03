package com.inf5d6.tp1.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.inf5d6.tp1.MainActivity
import com.inf5d6.tp1.MainActivity.Companion.TOKEN
import com.inf5d6.tp1.models.DetailsTvShow
import com.inf5d6.tp1.models.IsFav

class FavoritesRepository(private val app: Application) {
    fun getFavs(tvShowList: MutableLiveData<MutableList<DetailsTvShow>>) {
        val queue = Volley.newRequestQueue(app)
        val url = "${MainActivity.SRVURL}/favorites"
        val request = object : JsonArrayRequest(
            Method.GET,
            url,
            null,
            { response->
                val favorites =
                    Gson().fromJson(response.toString(), Array<DetailsTvShow>::class.java)
                tvShowList.value = favorites.toMutableList()
                Log.println(Log.INFO, "REFRESH", response.toString())
            },
            { error->
                println(error)

            },
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headerMap = mutableMapOf<String, String>()
                headerMap.put("Content-Type", "application/json")
                headerMap.put("Authorization", "Bearer $TOKEN")
                return headerMap
            }
        }
        queue.add(request)
    }

    fun checkFav(isFav : MutableLiveData<IsFav> ,id : Int){
        val queue = Volley.newRequestQueue(app)
        val url = "${MainActivity.SRVURL}/favorite?tvshowId=$id"
        val stringRequest = object: StringRequest(
            Method.GET,
            url,
            { response ->
                val gson = Gson()
                val details = gson.fromJson(response, IsFav::class.java)
                isFav.value = details
            },
            { error ->
                println(error)
            },
        ){
            override fun getHeaders(): MutableMap<String, String> {
                val headerMap = mutableMapOf<String, String>()
                headerMap.put("Content-Type", "application/json")
                headerMap.put("Authorization", "Bearer $TOKEN")
                return headerMap
            }
        }
        queue.add(stringRequest)
    }
    fun deleteFav(id: Int){
        val queue = Volley.newRequestQueue(app)
        val url = "${MainActivity.SRVURL}/favorite?tvshowId=$id"
        val request = object : StringRequest(
            Method.DELETE,
            url,
            { response->
                Log.println(Log.INFO, "DELETE", response)
            },
            { error->
                Log.println(Log.INFO, "Error", error.toString())

            },
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headerMap = mutableMapOf<String, String>()
                headerMap.put("Content-Type", "application/json")
                headerMap.put("Authorization", "Bearer $TOKEN")
                return headerMap
            }
        }
        queue.add(request)
    }

    fun addFav(id: Int){
        val queue = Volley.newRequestQueue(app)
        val url = "${MainActivity.SRVURL}/favorite?tvshowId=$id"
        val request = object : StringRequest(
            Method.POST,
            url,
            { response->
                Log.println(Log.INFO, "DELETE", response)
            },
            { error->
                Log.println(Log.INFO, "Error", error.toString())

            },
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headerMap = mutableMapOf<String, String>()
                headerMap.put("Content-Type", "application/json")
                headerMap.put("Authorization", "Bearer $TOKEN")
                return headerMap
            }
        }
        queue.add(request)
    }
}