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
import ru.geekbraince.KLesson2.databinding.FragmentMainBinding
import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.view.OnItemViewClickListener
import ru.geekbraince.KLesson2.view.details.DetailsFragment
import ru.geekbraince.KLesson2.viewmodel.AppState
import ru.geekbraince.KLesson2.viewmodel.MainViewModel

class MainFragment: Fragment(), OnItemViewClickListener {

    //промежуточный _binding который может быть null
private  var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
    //при создании свойства переопределяется геттер и сеттер
    get(){return _binding!!}
    //реализуем view model
    //Во View получили ссылку на ViewModal, повесили observe на ViewModal, если у нас что-то обновится, т.е в LiveData
    //прописываем ссылку на ViewModel
    private  val viewModel: MainViewModel by lazy{
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private var isDataSetRus:Boolean =true
private val adapter = MainFragmentAdapter()

    companion object
    {
        //обе записи идентичны, создает экземпляр класса, фабричный метод
//        fun newInstance():Fragment{
//            return MainFragment()}
        //возыращает новый фрагмент
        fun newInstance()= MainFragment()
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //генерирует xml файлы, вместо findViewById
        //  в промежуточный  _binding инфлейтим на фрагмент
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
//        binding.textview.text="test"
//        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            mainFragmentRecyclerView.adapter =adapter
            adapter.setOnItemViewClickListener(this@MainFragment) //FIXME
            //он клилк листнер через лямбда
            mainFragmentFAB.setOnClickListener {
                isDataSetRus = !isDataSetRus
                if (isDataSetRus) {
                    viewModel.getWeatherFromLocalSourceRus()
                   mainFragmentFAB.setImageResource(R.drawable.ic_russian)
                } else {
                    viewModel.getWeatherFromLocalSourceWorld()
                    mainFragmentFAB.setImageResource(R.drawable.ic_eart)
                }
            }
        }

        //создали viewModel, viewLifecycleOwner - следит за жизненным циклом activity


            //Получаем LiveData, вешаем observe. Если LiveData обновтся - то вызови observer Observer<Any> и в него передаем результат
        viewModel.getLivaData()
            .observe(viewLifecycleOwner,Observer<AppState>{appState:AppState->
                           renderData(appState)
        })
        //делаем запрос во viewModal для эмуляции запроса на сервер
        viewModel.getWeatherFromLocalSourceRus()
    }

    fun renderData(appState: AppState){
        //аналог swich case, для каждого состояния прописываем действия
        with(binding){
            when(appState){
                is AppState.Error -> {
                    mainFragmentLoadingLayout.visibility = View.GONE
                    val throwable = appState.error
                    Snackbar.make(binding.root, "Ошибка $throwable", Snackbar.LENGTH_LONG).show()
                }
                AppState.Loading -> {
                    //делаем наш loading видимым
                    mainFragmentLoadingLayout.visibility = View.VISIBLE
                }
                is AppState.Success ->
                {  //делаем наш loading невидимым
                    mainFragmentLoadingLayout.visibility = View.GONE
                    val weather= appState.weatherData
                    //вывод сообщения после загрузки
                    adapter.setWeather(weather)
                    //  Snackbar.make(binding.root, "Готово!", Snackbar.LENGTH_LONG).show()
                }
            }
        }

    }

//    private fun setData(weather: List<Weather>) {
//        binding.cityName.text = weather.city.name
//        binding.cityCoordinates.text = "lat ${weather.city.lat}\n lon ${weather.city.lon}"
//        binding.feelsLikeValue.text = weather.fieldsLike.toString()
//        binding.temperatureValue.text = "${weather.temperatura}"
//
//    }


    //когда конец работы приложения, обнуляем _binding
    override fun onDestroy() {
        super.onDestroy()
        //чтобы не было утечки памяти
        _binding = null
    }

    override fun onItemClick(weather: Weather) {
        val bundle = Bundle()
        bundle.putParcelable(DetailsFragment.BUNDELE_WEATHER_KEY,weather)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_conteiner, DetailsFragment.newInstance(bundle)) // или add. c add не работает
            .addToBackStack("")
            .commit()
    }

}
