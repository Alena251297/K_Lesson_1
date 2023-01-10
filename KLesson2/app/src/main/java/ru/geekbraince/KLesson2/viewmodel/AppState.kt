package ru.geekbraince.KLesson2.viewmodel

import ru.geekbraince.KLesson2.domain.Weather

sealed class AppState{
    //3 состояния - загрузка, удачно, ошибка
    //Loading ничего в себя не принимает, это просто состояние, Loading может быть только один
    object Loading:AppState()
    data class Success(val weatherData:Weather):AppState()
    data class Error(val error:Throwable):AppState()
}
