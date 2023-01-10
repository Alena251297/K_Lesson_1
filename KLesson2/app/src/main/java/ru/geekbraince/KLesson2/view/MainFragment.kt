package ru.geekbraince.KLesson2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment: Fragment() {
    companion object
    {
        //обе записи идентичны, создает экземпляр класса, фабричный метод
//        fun newInstance():Fragment{
//            return MainFragment()}
        //возыращает новый фрагмент
        fun newInstance()=MainFragment()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    }
