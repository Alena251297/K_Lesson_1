package ru.geekbraince.KLesson2.repository

import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.domain.getRussianCities
import ru.geekbraince.KLesson2.domain.getWorldCities

class RepositoryImplementation: Repository {
    override fun getWeatherFromRemoteSource() = Weather()

    override fun getWeatherFromLocalSource()=Weather()
//имплиментировала наши методы со списками
    override fun getWeatherFromLocalStorageRus() = getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = getWorldCities()

}