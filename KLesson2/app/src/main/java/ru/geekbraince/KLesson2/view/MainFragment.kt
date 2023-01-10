package ru.geekbraince.KLesson2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.geekbraince.KLesson2.R
import ru.geekbraince.KLesson2.databinding.FragmentMainBinding
import ru.geekbraince.KLesson2.domain.Weather
import ru.geekbraince.KLesson2.viewmodel.AppState
import ru.geekbraince.KLesson2.viewmodel.MainViewModel

class MainFragment: Fragment() {

    //промежуточный _binding который может быть null
private  var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
    //при создании свойства переопределяется геттер и сеттер
    get(){return _binding!!}
    //реализуем view model

    //прописываем ссылку на ViewModel
    private lateinit var viewModel:MainViewModel



    companion object
    {
        //обе записи идентичны, создает экземпляр класса, фабричный метод
//        fun newInstance():Fragment{
//            return MainFragment()}
        //возыращает новый фрагмент
        fun newInstance()=MainFragment()
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
        //создали viewModel, viewLifecycleOwner - следит за жизненным циклом activity

        //Во View получили ссылку на ViewModal, повесили observe на ViewModal, если у нас что-то обновится, т.е в LiveData
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            //Получаем LiveData, вешаем observe. Если LiveData обновтся - то вызови observer Observer<Any> и в него передаем результат
        viewModel.getLivaData().observe(viewLifecycleOwner,Observer<AppState>{
            renderData(it)
        })
        //делаем запрос во viewModal для эмуляции запроса на сервер
        viewModel.getDataFromRemoteSource()
    }

    fun renderData(appState: AppState){
        //аналог swich case, для каждого состояния прописываем действия
        when(appState){
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                val throwable = appState.error
                Snackbar.make(binding.mainView, "Ошибка $throwable", Snackbar.LENGTH_LONG).show()
            }
            AppState.Loading -> {
                //делаем наш loading видимым
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Success ->
            {  //делаем наш loading невидимым
                binding.loadingLayout.visibility = View.GONE
                val weather= appState.weatherData
                //вывод сообщения после загрузки
                setData(weather)
                Snackbar.make(binding.mainView, "Готово!", Snackbar.LENGTH_LONG).show()
            }
        }
    }

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
