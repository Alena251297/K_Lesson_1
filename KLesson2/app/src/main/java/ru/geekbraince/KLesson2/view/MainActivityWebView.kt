package ru.geekbraince.KLesson2.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import ru.geekbraince.KLesson2.databinding.ActivityMainWebViewBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class MainActivityWebView : AppCompatActivity() {
     lateinit var binding: ActivityMainWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val str = "https://gb.ru"
//        binding.editText.setText(str)
        binding.btnOk.setOnClickListener{
            showURL(binding.editText.text.toString())
        }
    }
    fun showURL(urlString:String){
//в главном поток нельзя делать запросы в сеть, только в спомогательное. webview  не работает во вспомогательном потоке
        val url = URL(urlString)
        // 2 вариант val handler = Handler()// получаем указатель на текущий поток
      // 3 вариант  val handler = Handler(Looper.myLooper()!!)// получаем указатель на текущий поток

        //вспомогательный поток
             Thread{
                 //открыл urlConnecrion
            val urlConnection =url.openConnection() as HttpsURLConnection
            urlConnection.requestMethod="GET"
            urlConnection.readTimeout = 10000
                 //создаем поток
                 val reader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
                 val rezult =getLines(reader)
//                1 вариант  runOnUiThread{
//                     binding.webView.loadData(rezult,"text/html; charset=utf-8","utf-8")
//                 }
                     // 2 вариант  handler.post{ binding.webView.loadData(rezult,"text/html; charset=utf-8","utf-8")}
                 val handler = Handler(Looper.getMainLooper()) // получи ссылку на главный поток
                 handler.post { //binding.webView.loadData(rezult,"text/html; charset=utf-8","utf-8")//
                     binding.webView.loadDataWithBaseURL(null,rezult,"text/html; charset=utf-8","utf-8", null)
                      }//выполнить отображение webview
                 urlConnection.disconnect()
        }.start()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader:BufferedReader):String{
        return reader.lines().collect(Collectors.joining("\n"))
    }
}


//if(savedInstanceState==null)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_conteiner, MainFragment.newInstance()).commit()

//        val lesson = Lesson3()
//        lesson.mainSecondPart(this)
//        Log.d("mylogs1","${lesson.mainSecondPart(this)}")
//        LambdaKotlin().main()
//        MyExtension().main()
//        main()
