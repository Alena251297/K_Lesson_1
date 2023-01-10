package ru.home.k_lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    //свойства(поля)
    companion object Res{
        @JvmStatic
        val field1 = "STATIC_STRING"
    }

    enum class WeatherType {
        SUNNY,
        RAINY,
        CLOUDY,
        MISTY,
        SNOWY,
        HAILY
    }


    val  listener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }


    var i:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val objTest = Test("name")
        Log.d("mylog", "${objTest.name}")

        //анонимний класс - класс которого не существует, нет имени. Экземпляр анонимного класса. Можем обратиться его экземпляру, к самому анниму
        //обратиться нельзя
        val test3 = object {
            var i:Int=0
            val field1 = "STATIC_STRING"
        }
        Log.d("mylog", "${test3.i}")
        Log.d("mylog", "${test3.field1}")

        val weatherType:WeatherType = WeatherType.CLOUDY
        this.i=when(weatherType){
            WeatherType.CLOUDY-> 1
            WeatherType.HAILY-> 2
            WeatherType.MISTY-> 3
            WeatherType.RAINY-> 4
            WeatherType.SNOWY-> 5
            WeatherType.SUNNY-> 6
        }

        this.i=1
        val str= when(this.i){
           1->"1"
            2->{val int1:Int=12
            int1}
            else->1
        }

        Log.d("mylog", "$str")


//        this.i=if(objTest.i==3) 2 else 3





        val getI=objTest.i
        objTest.i =2
        this.i=2
        this.i=try {
            throw IllegalStateException()
        }catch (e:IllegalStateException)
        {3}
            Log.d("mylog", "$i")

    }
}
class Test(var name:String=" ")
{
        var i:Int=0
}
fun test():Int{
    var i:Int =0
    return i
}