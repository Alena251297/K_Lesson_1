package ru.geekbraince.KLesson2.repository

data class FactDTO (
    val temp:Int,
    val feels_like:Int,
    val condition:String,
)

//    val obs_time:Int,
//    val icon:String,
//    val wind_speed:Double,
//    val win_dir:String,
//    val pressure_mm:Int,
//    val pressure_pa:Int,
//    val humidity:Int,
//    val daytime:String,
//    val polar:Boolean,
//    val season:String,
//    val wind_gust:Double