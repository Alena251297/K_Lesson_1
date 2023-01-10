package ru.lesson.lesson_6;

import static ru.lesson.lesson_6.CityFragment.KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null)
        {
            //обращаемся к фрагмент менеджеру, открываем, добавляем наш фрагмент во frame и закрываем
            getSupportFragmentManager().beginTransaction().replace(R.id.city_conteiner,CityFragment.newInstance()).commit();

        }
//            //  ищем фрагмент который сиди в контейнере R.id.city_conteiner
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            Fragment currentFragment = (Fragment)fragmentManager.findFragmentById(R.id.city_conteiner);
//            // если такой есть и он является CoatOfArmsFragment
//            if (currentFragment!=null && currentFragment instanceof CoatOfArmsFragment)
//            {
//                //TODO: исправить научившись закрывать фрагменты
//                onBackPressed();
//            } else { }
        }
        //CityFragment cityFragment = CityFragment.newInstance();

        //определить горизонтальное положение
       /* if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.coat_of_arms_conteiner, CoatOfArmsFragment.newInstance(new City(0,"Москва"))).commit();
        }*/

    //сохранение при повороте экрана
    @Override
    protected void onResume() {
        super.onResume();
        //ищем фрагмент который сидит в конетейнере R.id.city_conteiner
        Fragment backStackFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.city_conteiner);
        //если такой есть и он является CoarOfArmsFragment
        if (backStackFragment!=null && backStackFragment instanceof CoatOfArmsFragment)
        {
            //то симмулируем нажатие кнопки Назад
            onBackPressed();
        }
    }
}


