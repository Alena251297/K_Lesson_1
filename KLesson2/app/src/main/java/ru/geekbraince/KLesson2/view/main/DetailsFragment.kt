package ru.geekbraince.KLesson2.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.geekbraince.KLesson2.R
import ru.geekbraince.KLesson2.databinding.FragmentDetailsBinding
import ru.geekbraince.KLesson2.databinding.FragmentMainBinding
import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.viewmodel.AppState
import ru.geekbraince.KLesson2.viewmodel.MainViewModel

class DetailsFragment: Fragment() {


private  var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
      get(){return _binding!!}




    companion object
    {
        //обе записи идентичны, создает экземпляр класса, фабричный метод
//        fun newInstance():Fragment{
//            return MainFragment()}
        //возыращает новый фрагмент

        fun newInstance(bundle: Bundle):DetailsFragment{
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
        const val BUNDELE_WEATHER_KEY = "KEY"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
//        binding.textview.text="test"
//        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weather = (arguments?.getParcelable<Weather>(BUNDELE_WEATHER_KEY))?:Weather()
        setData(weather)
   }

//    fun renderData(appState: AppState){
//
//        when(appState){
//            is AppState.Error -> {
//                binding.loadingLayout.visibility = View.GONE
//                val throwable = appState.error
//                Snackbar.make(binding.root, "Ошибка $throwable", Snackbar.LENGTH_LONG).show()
//            }
//            AppState.Loading -> {
//                //делаем наш loading видимым
//                binding.loadingLayout.visibility = View.VISIBLE
//            }
//            is AppState.Success ->
//            {  //делаем наш loading невидимым
//                binding.loadingLayout.visibility = View.GONE
//                val weather= appState.weatherData
//                //вывод сообщения после загрузки
//                 setData(weather)
//                Snackbar.make(binding.root, "Готово!", Snackbar.LENGTH_LONG).show()
//            }
//        }
//    }

    private fun setData(weather: Weather) {
        binding.cityName.text = weather.city.name
        binding.cityCoordinates.text = "lat ${weather.city.lat}\n lon ${weather.city.lon}"
        binding.feelsLikeValue.text = weather.fieldsLike.toString()
        binding.temperatureValue.text = "${weather.temperatura}"

    }


    //когда конец работы приложения, обнуляем _binding
    override fun onDestroy() {
        super.onDestroy()
        //чтобы не было утечки памяти
        _binding = null
    }

    }
