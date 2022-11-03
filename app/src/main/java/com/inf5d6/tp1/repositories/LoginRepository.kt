package com.inf5d6.tp1.repositories

import android.app.Application
import android.content.Intent
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.inf5d6.tp1.MainActivity
import com.inf5d6.tp1.MainActivity.Companion.SRVURL
import com.inf5d6.tp1.MainActivity.Companion.TOKEN
import org.json.JSONObject

class LoginRepository(private val app: Application) {
    fun login(username: String, password: String) {
        val queue = Volley.newRequestQueue(app)
        val url = "$SRVURL/auth/token"
        val body = JSONObject()
        body.put("username", username)
        body.put("password", password)
        val jsonObject = JsonObjectRequest(
            Request.Method.POST,
            url,
            body,
            { response ->
                if(response.has("token")) {
                    TOKEN = response.getString("token")

                    val intent = Intent(app, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    app.startActivity(intent)
                }else {
                    Toast.makeText(app, response.getString("message"), Toast.LENGTH_SHORT).show()
                }
            },
            {
               Toast.makeText(app, "Error: invalid credentials ", Toast.LENGTH_LONG).show()
            }
        )
        queue.add(jsonObject)
    }
}