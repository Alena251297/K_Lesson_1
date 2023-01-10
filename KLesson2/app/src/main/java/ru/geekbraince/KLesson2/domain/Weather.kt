package ru.geekbraince.KLesson2.domain

data class Weather(val city:City= getDefaultCity(),
                   val temperatura:Int = -1,
                   val fieldsLike:Int=-5
)

private fun getDefaultCity() = City("Москва", 55.0, 37.0)
