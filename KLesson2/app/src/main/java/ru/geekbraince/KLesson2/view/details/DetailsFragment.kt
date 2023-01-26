package ru.geekbraince.KLesson2.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.geekbraince.KLesson2.databinding.FragmentDetailsBinding
import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.repository.WeatherDTO
import ru.geekbraince.KLesson2.repository.WeatherLoader
import ru.geekbraince.KLesson2.repository.WeatherLoaderListener

class DetailsFragment: Fragment(),WeatherLoaderListener {


//    val listener = object: WeatherLoaderListener{
//        override fun onLoader(weatherDTO: WeatherDTO) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onFailed(throwable: Throwable) {
//            TODO("Not yet implemented")
//        }
//
//    }

private  var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
      get(){return _binding!!}
    companion object
    {
        //обе записи идентичны, создает экземпляр класса, фабричный метод
//        fun newInstance():Fragment{
//            return MainFragment()}
        //возыращает новый фрагмент
        fun newInstance(bundle: Bundle): DetailsFragment {
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

    val localWeather:Weather by lazy{
        (arguments?.getParcelable(BUNDELE_WEATHER_KEY))?: Weather()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WeatherLoader(this,localWeather.city.lat,localWeather.city.lon).loadWeather()
        }

   private fun showWeather(weatherDTO: WeatherDTO) {

               with(binding) {
                with(weatherDTO){
                cityName.text = localWeather.city.name
                cityCoordinates.text = "lat ${localWeather.city.lat}\n lon ${localWeather.city.lon}"
                feelsLikeValue.text = weatherDTO.fact.feels_like.toString()
                temperatureValue.text = "${fact.temp}"
                weatherCondition.text = "${fact.condition}"
            }
        }
    }
    //когда конец работы приложения, обнуляем _binding
    override fun onDestroy() {
        super.onDestroy()
        //чтобы не было утечки памяти
        _binding = null
    }


    override fun onLoader(weatherDTO: WeatherDTO) {
        showWeather(weatherDTO)
    }

    override fun onFailed(throwable: Throwable) {
        //вывести в случае неудачи
        TODO("Not yet implemented")
    }


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