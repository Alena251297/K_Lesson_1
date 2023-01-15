package ru.geekbraince.KLesson2.lesson3

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
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

    fun mainSecondPart(context: Context) {
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

        //задаем список людей
        val people: List<Person> = listOf(Person("Maksim", 25), Person("Nikol", 20))
        people.get(0).Age = 26
        val peapleHack: MutableList<Person> = people.toMutableList()
        peapleHack.add(Person("новый человек", 0))
        var myInt: Int = 2
        Log.d("mylogs", "${myInt.mySquare()}")
        writeAll(1)
        writeAll(1.0)
        writeAll("")
        writeAll(1f)
        writeAll(people[0])

        //btn - нельзя передать в Generic2 так как обрезан - ViewGroup
        val btn = Button(context)
        val layot = LinearLayout(context)
        val  view1 =Generic2(layot)

    }
    data class Person(val name: String, var Age: Int)
    //первый вариант записи
    private fun writeInt(input:Int){ Log.d("mylogs", input.toString())}
    private fun writeDouble(input:Double){ Log.d("mylogs", input.toString())}
    private  fun writeFloat(input:Float){ Log.d("mylogs", input.toString())}
    private fun writeString(input:String){ Log.d("mylogs", input.toString())}
    private fun writePerson(input:Person){ Log.d("mylogs", input.toString())}
//второй вариант с помощью дженерик, дженерик - любой тип
    fun <T> writeAll(input: T) =  Log.d("mylogs", input.toString())
    fun <T,G,J> writeAll(input: T, input2:G, input3:J) =  Log.d("mylogs", input.toString())

    //наша экстеншен функция
fun Int.mySquare():Int{
    return this*this
}
    interface Test2 {
    val string:String
    }

    class Generic<T>(val field1:T)
    //T -  может быть любой тип. В данном примере мы ограничиваем наш T ViewGroup.
    class Generic2<G:ViewGroup>(val field1:G)

    class Test{
val stringTest:String="test"
    }
}