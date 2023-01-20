package ru.geekbraince.KLesson2.lesson4

import android.util.Log
val word by lazy{ //lazy работает по пнципе делегата, оболочка
    Log.d("mylogs","word by lazy")
    "word1"
}
fun main(){
    val baseImpl = BaseImpl()
    val delegate = Deligate(baseImpl, baseImpl)
    delegate.funBase1()
    delegate.funBase2()
    Log.d("mylogs",delegate.nameBase1)
    Log.d("mylogs",delegate.nameBase2)
    Log.d("mylogs",word)
}

class Deligate(base1:Base1, base2:Base2):Base1 by base1, Base2 by base2 {
    override fun funBase1() {
        Log.d("mylogs","funBase1_d")
    }

    override val nameBase1 = "nameBase1_d"


    override fun funBase2() {
        Log.d("mylogs","funBase2_d")
    }

    override val nameBase2 = "nameBase2_d"
}
class BaseImpl:Base1,Base2{
    override fun funBase1() {
        Log.d("mylogs","funBase1")
    }

    override val nameBase1 = "nameBase1"


    override fun funBase2() {
        Log.d("mylogs","funBase2")
    }

    override val nameBase2 = "nameBase2"


}
//поведение
interface Base1{
    fun funBase1()
    val nameBase1:String
}
interface Base2{
    fun funBase2()
    val nameBase2:String
}