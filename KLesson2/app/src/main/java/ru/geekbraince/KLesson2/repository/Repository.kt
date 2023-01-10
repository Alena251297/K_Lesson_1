package ru.geekbraince.KLesson2.repository

import ru.geekbraince.KLesson2.domain.Weather

interface Repository {
    //возвращают погоду
  fun  getWeatherFromRemoteSource():Weather
  fun  getWeatherFromLocalSource():Weather
}