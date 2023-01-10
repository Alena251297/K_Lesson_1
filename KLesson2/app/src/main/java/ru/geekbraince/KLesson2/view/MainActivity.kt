package ru.geekbraince.KLesson2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbraince.KLesson2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if(savedInstanceState==null)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_conteiner, MainFragment.newInstance()).commit()
    }
}