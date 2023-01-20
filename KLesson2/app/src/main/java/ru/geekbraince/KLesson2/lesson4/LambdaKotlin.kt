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
       // printMy(valAnonim) valAnonim передаем функцию в качестве аргумента
      //  printMy(valLambda)
        //3я часть
    val l3={int1:Int,int2:Int -> //слева - параметры которые передаются, справа - выполнение,  //последняя строка - то что возвращается
    Log.d("mylogs", " 1")
   }
      val l4=l3(1,2) //передам значения в лямбду
        //4я часть
            val people :List<Person> = listOf(Person("name1",10),Person("name2",20))
            people.forEach({person:Person -> Log.d("mylogs","${person.name}")})
            people.forEach({person:Person -> print(person)} )
            people.forEach({person -> Log.d("mylogs","${person.name}")})
            people.forEach{(Log.d("mylogs","${it.name}"))}
            people.forEach{it.print1()}
            people.forEach{print(it)}
    }
    data class Person(val name:String, val age:Int)
    fun print(person:Person){
        Log.d("mylogs","${person.name} ${person.age}")
    }
    fun Person.print1(){
        Log.d("mylogs","${this.name} ${this.age}")
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