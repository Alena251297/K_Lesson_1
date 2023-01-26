package ru.geekbraince.KLesson2.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import ru.geekbraince.KLesson2.R
import ru.geekbraince.KLesson2.databinding.ActivityMainBinding
import ru.geekbraince.KLesson2.databinding.ActivityMainWebViewBinding
import ru.geekbraince.KLesson2.view.main.MainFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

     lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_conteiner, MainFragment.newInstance()).commit()


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
