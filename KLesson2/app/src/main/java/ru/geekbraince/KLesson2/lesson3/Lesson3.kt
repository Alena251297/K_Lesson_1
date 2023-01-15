package ru.geekbraince.KLesson2.lesson3

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Lesson3 {


    fun mainFirstPart()
    {

      var bar= AppCompatActivity().supportActionBar
        var menu= AppCompatActivity().menuInflater
      var application:Application= AppCompatActivity().application

        var notNullble:String=" "
        //присваиваем занчение null, String? - тип Nullble
        var Nullble:String?=""
        Nullble = null
        //Test без ? не принимает значение null, Test? - принимает значение null
        var testObject:Test?= Test()
//        testObject=null
        // если testObject?.stringTest не  null то вернется testObject?.stringTest, но если  null то вернется "void"
        //?: - оператор "Элвис"
        notNullble = testObject?.stringTest?:"void"
        // аналог оператора "Элвис"
        notNullble =if(testObject?.stringTest!=null)
        {testObject.stringTest}
        else{" "}
        val testObj=Test()
    }

    fun mainSecondPart() {
        //массивы
        //создали массив
        val phrase: Array<String> = arrayOf("firds", "second")

        //или так
        val phrase1 = arrayOf("firds", "second")
        //получаем данные из массива по индексу
        val word = phrase[1]
        //задаем значение
//        phrase[0] = "secondNew"
//        phrase[1] = "secondNew1"
        phrase.size
        //создаем список, новый тип
        class Person(val name: String, var Age: Int)
        //задаем список людей
        val people: List<Person> = listOf(Person("Maksim", 25), Person("Nikol", 20))
        people.get(0).Age = 26
        val peapleHack: MutableList<Person> = people.toMutableList()
        peapleHack.add(Person("новый человек", 0))
        var myInt: Int = 2
        Log.d("mylogs", "${myInt.mySquare()}")
    }
    //наша экстеншен функция
fun Int.mySquare():Int{
    return this*this
}

    class Test{
val stringTest:String="test"
    }
}