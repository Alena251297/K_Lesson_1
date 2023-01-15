package ru.geekbraince.KLesson2.repository

import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.domain.getRussianCities
import ru.geekbraince.KLesson2.domain.getWorldCities

class RepositoryImplementation: Repository {
    override fun getWeatherFromRemoteSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalSource(): Weather {
       return Weather()
    }
//имплиментировала наши методы со списками
    override fun getWeatherFromLocalStorageRus(): List<Weather> {
        return  getRussianCities()
    }

    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
       return getWorldCities()
    }

}