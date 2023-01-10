package ru.geekbraince.KLesson2.repository

import ru.geekbraince.KLesson2.domain.Weather

class RepositoryImplementation: Repository {
    override fun getWeatherFromRemoteSource(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalSource(): Weather {
       return Weather()
    }

}