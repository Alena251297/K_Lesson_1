package ru.geekbraince.KLesson2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

//создаем liveData
class MainViewModel(private val liveDataToObserve:MutableLiveData<Any> = MutableLiveData()):
ViewModel() {
    //ссылка на livedata
    //liveDataToObserve - подписываем наш Observer
fun  getLivaData()=liveDataToObserve
    //эмулируем запрос на сервер. в потоке
    fun getDataFromRemoteSource(){
        //старт потока
Thread{
    sleep(2000)
        //загружаем в поток что-то
    liveDataToObserve.postValue(Any())
}.start()
    }
}