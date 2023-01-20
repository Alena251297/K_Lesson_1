package ru.geekbraince.KLesson2.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.geekbraince.KLesson2.R
import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.view.OnItemViewClickListener

class MainFragmentAdapter:RecyclerView.Adapter<MainFragmentAdapter.MainFragmentViewHolder>(){
    private var weatherData:List<Weather> = listOf()
    private lateinit var listener:OnItemViewClickListener

    fun setWeather(data:List<Weather>)
    {
        weatherData = data  //указывает сейчас на data
        //все данные обновятся
        notifyDataSetChanged()
    }
    fun setOnItemViewClickListener(onItemViewClickListener:OnItemViewClickListener)
    {
      listener = onItemViewClickListener

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentViewHolder {
        val holder = MainFragmentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_main_recycler_item,parent, false))
        return holder
    }

    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) =  holder.render(weatherData.get(position))


    override fun getItemCount()= weatherData.size

   inner class MainFragmentViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun render(weather: Weather){
            //записываем во view имя города
            itemView.findViewById<TextView>(R.id.mainFragmentRecyclerItemTextView).text = weather.city.name
            itemView.setOnClickListener { //  Toast.makeText(itemView.context,"work", Toast.LENGTH_LONG).show()
                listener.onItemClick(weather)
            }
        }
    }

}