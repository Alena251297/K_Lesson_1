package ru.geekbraince.KLesson2.lesson4

import android.util.Log

class MyExtension {
    fun main(){
        val people :List<LambdaKotlin.Person> = listOf(
            LambdaKotlin.Person("name1", 10),
            LambdaKotlin.Person("name2", 20)
        )
        people.indexOf(people[0])
        people.indexOf(people[1])
        people.indexOf(people[0])
        people[0].name
        people[0].age

        val withRest =with(people){ //extension-функция, ничего не возвращает
            get(0).name ="withname"
            get(1).name ="withname"
        }
        people.forEach{(it.print3())}
       val applyRest= people.apply {//возвращает
           get(0).name ="applyname2"
           get(1).name ="applyname1"
          }
        applyRest.forEach{(it.print3())}
        var x =20
        var y= 30
        x=y.also { y=x }
        Log.d("mylogs","${x} ${y}")

        var person:LambdaKotlin.Person? = null
        person?.let{
            it.print3()
        }
    }
    fun LambdaKotlin.Person.print3():String{
        Log.d("mylogs","${this.name} ${this.age}")
        return " return "
    }
}