package ru.geekbraince.KLesson2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbraince.KLesson2.R
import ru.geekbraince.KLesson2.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if(savedInstanceState==null)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_conteiner, MainFragment.newInstance()).commit()

//        val lesson = Lesson3()
//        lesson.mainSecondPart(this)
//        Log.d("mylogs1","${lesson.mainSecondPart(this)}")


    }
}