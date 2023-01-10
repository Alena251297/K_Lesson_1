package ru.geekbraince.KLesson2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.geekbraince.KLesson2.R
import ru.geekbraince.KLesson2.databinding.FragmentMainBinding
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
        viewModel.getLivaData().observe(viewLifecycleOwner,Observer<Any>{
            Toast.makeText(context,"it", Toast.LENGTH_LONG).show()
        })
        //делаем запрос во viewModal для эмуляции запроса на сервер
        viewModel.getDataFromRemoteSource()
    }

    //когда конец работы приложения, обнуляем _binding
    override fun onDestroy() {
        super.onDestroy()
        //чтобы не было утечки памяти
        _binding = null
    }

    }
