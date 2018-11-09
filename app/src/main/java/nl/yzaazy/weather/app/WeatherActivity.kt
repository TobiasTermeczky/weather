package nl.yzaazy.weather.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import nl.yzaazy.weather.R

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val textView = findViewById<TextView>(R.id.text)


    }

}
