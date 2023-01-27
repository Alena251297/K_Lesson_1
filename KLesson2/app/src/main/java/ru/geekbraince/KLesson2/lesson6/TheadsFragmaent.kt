package ru.geekbraince.KLesson2.lesson6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.geekbraince.KLesson2.databinding.FragmentTheaderBinding
import java.util.*
import java.util.concurrent.TimeUnit

class TheadsFragmaent:Fragment() {
    companion object{
        fun newInstance()=TheadsFragmaent()
    }

    private var _binding:FragmentTheaderBinding?=null
    private val binding:FragmentTheaderBinding
    get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =FragmentTheaderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) //Danger!!!
        binding.button.setOnClickListener {
            val timer = binding.editText.text.toString().toInt()
            startCalculations(timer)
        }
        val myHandler1991 = Handler(Looper.myLooper()!!) //ссылка на текущий поток(главный)
        binding.calculationTheadsBtn.setOnClickListener {
                      Thread {
//                val myHandler1992 = Handler(Looper.myLooper()!!)//ссылка на главный
                val myHandler1993 =
                    Handler(Looper.getMainLooper()!!)//ссылка на текущий поток(Thead вспомогательный)
                val timer = binding.editText.text.toString().toInt()
                startCalculations(timer)
                myHandler1991.post(Runnable {//работа с view
                    binding.mainContainer.addView(TextView(it.context).apply {
                        text = "Thead1991"
                        textSize = 30f
                    })
                })
                myHandler1993.post(Runnable {//работа с view
                    binding.mainContainer.addView(TextView(it.context).apply {
                        text = "Thead1993"
                        textSize = 30f
                    })
                })

            }.start()
        }

        val handlerTheard = MyThread() //вечный поток
        handlerTheard.start()

        binding.calcTheadsHandlerBtn.setOnClickListener {
            val handler = handlerTheard.mHandler
            handler?.post{//задачи
                val timer = binding.editText.text.toString().toInt()
                startCalculations(timer)
                myHandler1991.post(Runnable {//работа с view
                    binding.mainContainer.addView(TextView(it.context).apply {
                        text = "Handler Theads"
                        textSize = 30f
                    })
                })
            }
        }
        handlerTheard.mHandler?.looper?.quitSafely()//ожидает завершения всех задач
        handlerTheard.mHandler?.looper?.quit() //выходим незамедлительно
    }
    private fun startCalculations(timer: Int){
        val currentTime = Date().time // Date().time - возвращает текущее время в милисекундах на устройстве
        while ((currentTime+timer*1000)>Date().time){}
    }
}

//создаем свой поток
class MyThread:Thread(){
    var mHandler:Handler?=null
    override fun run() {
        //бесконечный луп, зацикленный поток
        Looper.prepare()
        mHandler = Handler(Looper.myLooper()!!)
        Looper.loop()
    }
}


