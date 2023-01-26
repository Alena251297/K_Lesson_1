package ru.geekbraince.KLesson2.repository

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class WeatherLoader(val listener: WeatherLoaderListener,val lat:Double, val lon:Double) {
    fun loadWeather(){
        val url = URL("https://api.weather.yandex.ru/v2/informers?lat${lat}&lon${lon}")
             Thread{
            val urlConnection =url.openConnection() as HttpsURLConnection
            urlConnection.requestMethod="GET"
                 //передаем ключ
                 urlConnection.addRequestProperty("X-Yandex-API-Key","ed158824-2853-4399-a44f-0b4cdff51ccc")
            urlConnection.readTimeout = 10000
                 //получаем данные
             val reader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
                 // переводим их из gson
             val wethearDTO = Gson().fromJson(reader,WeatherDTO::class.java)
           //  val rest = getLines(reader)
             val handler = Handler(Looper.getMainLooper())
                 handler.post {  listener.onLoader(wethearDTO) }


            urlConnection.disconnect()
        }.start()
    }
}