package ru.geekbraince.KLesson2.lesson4

import android.util.Log

class LambdaKotlin {
    fun main(){
     /*   val l1={ Log.d("mylogs", "run1") //переменная функционального типа,ссылка на функцию
        "run2"}
        val l2 =run { Log.d("mylogs", "run3")//результат выполнения, run - эксеншен фнкция
            "run4"} //то что выполнится
    val field1="str1"
        run{ //икапсилирует от внешнего кода, код внутри закрывает от наружного кода
            val field1="str2"
        }
        Log.d("mylogs", field1)
        Log.d("mylogs", l1())
        Log.d("mylogs", l2)*/
       // printMy(valAnonim)
      //  printMy(valLambda)

    }
    val valAnonim = fun (int1:Int,int2:Int):String{ //анонимная функция
        Log.d("mylogs", " Зашли valAnonim")
        return "valAnonim"
    }
    val valLambda = {int1:Int,int2:Int -> //лямбда, не работает с return, нельзя лябда указывать строгий тип
        Log.d("mylogs", " Зашли valLambda")
         "valLambda" //возвращаем
    }
    fun printMy(fun1:(int1:Int,int2:Int)->String){//функция которая принимает в себя другую функцию, fun1 - ссылка на функцию
        Log.d("mylogs", " Зашли printMy")
        Log.d("mylogs", fun1(1,2))
    }
}