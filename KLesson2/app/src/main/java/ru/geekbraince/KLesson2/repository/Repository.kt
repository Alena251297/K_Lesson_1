package ru.geekbraince.KLesson2.repository

import ru.geekbraince.KLesson2.domain.Weather

interface Repository {
    //возвращают погоду
  fun  getWeatherFromRemoteSource():Weather
  fun  getWeatherFromLocalSource():Weather

  //добавляем в репозиторий 2 метода, получение списка наших городов
  fun getWeatherFromLocalStorageRus(): List<Weather>
  fun getWeatherFromLocalStorageWorld(): List<Weather>
}