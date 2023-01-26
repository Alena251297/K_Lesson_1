package ru.geekbraince.KLesson2.repository
//описываем поведение класс который должен уметь случать ответ
interface WeatherLoaderListener {
    //может загрузить данные либо не загрузить
    fun onLoader(weatherDTO: WeatherDTO)
    fun onFailed(throwable: Throwable)
}