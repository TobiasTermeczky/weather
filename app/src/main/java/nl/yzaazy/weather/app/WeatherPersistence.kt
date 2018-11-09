package nl.yzaazy.weather.app

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.gson.Gson
import nl.yzaazy.weather.model.WeatherData

class WeatherPersistence {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    fun getData(context: Context, callback: DataCallback) {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            val queue = Volley.newRequestQueue(context)
            val url = "https://api.darksky.net/forecast/8ef96cce5504d6208fc3af2fdb7aa627/"+ location?.latitude+","+location?.longitude+"?exclude=hourly,daily,alerts,flags&lang=nl&units=auto"
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    callback.dataCallback(parseJSon(response))
                },
                Response.ErrorListener {  })
            queue.add(stringRequest)
        }
    }


    private fun parseJSon(jsonString: String): WeatherData {
        return Gson().fromJson(jsonString, WeatherData::class.java)
    }
}