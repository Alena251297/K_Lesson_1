package ru.geekbraince.KLesson2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.repository.RepositoryImplementation
import java.lang.Thread.sleep
import kotlin.random.Random

//создаем liveData
class MainViewModel(
    private val liveDataToObserve:MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImplementation:RepositoryImplementation = RepositoryImplementation()):
ViewModel() {
    //ссылка на livedata
    //liveDataToObserve - подписываем наш Observer
fun  getLivaData()=liveDataToObserve

    fun getWeatherFromLocalSourceWorld(){
        getDataFromLocalSource(false)
    }
    fun getWeatherFromLocalSourceRus(){
        getDataFromLocalSource(true)
    }

    //эмулируем запрос на сервер. в потоке
    fun getDataFromLocalSource(isRussian:Boolean){
        //пока состояние загрузки
        liveDataToObserve.postValue(AppState.Loading)
        //старт потока
Thread{
    sleep(500)
    //загрузка или русских городов или города мира
    if(isRussian)
    {
        liveDataToObserve.postValue(AppState.Success(repositoryImplementation.getWeatherFromLocalStorageRus()))
    } else{ liveDataToObserve.postValue(AppState.Success(repositoryImplementation.getWeatherFromLocalStorageWorld()))}

//    val r = Random(10).nextInt()
//    if (r>5){
//
//    } else {liveDataToObserve.postValue(AppState.Error(IllegalStateException()))}

        //после загрузки, состояние удача
    //получаем результат сервера

}.start()
    }
}