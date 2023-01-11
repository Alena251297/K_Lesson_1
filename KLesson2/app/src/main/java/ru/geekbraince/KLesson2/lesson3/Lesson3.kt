package ru.geekbraince.KLesson2.lesson3

import android.app.Application
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

    fun mainSecondPart(){
        //массивы

    }


    class Test{
val stringTest:String="test"
    }
}