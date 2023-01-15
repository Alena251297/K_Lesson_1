package ru.geekbraince.KLesson2.view

import ru.geekbraince.KLesson2.domain.Weather

interface OnItemViewClickListener {
    fun onItemClick(weather: Weather)
}