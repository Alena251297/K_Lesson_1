package ru.lesson.lesson_6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CityFragment extends Fragment {

    City currentCity;
    //положение экрана, оиентация портретная или альбомная
    boolean isLandScape;
    //Ключ
    public static final String KEY = "cities";

    //фабричный метод
    public static CityFragment newInstance()
    {
      return new CityFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        //сохранение состояния
        if (savedInstanceState!=null)
        {
            currentCity = savedInstanceState.getParcelable(KEY);
        }
        if (isLandScape)
        if(currentCity!=null)
        {
            showCoatOfArms(currentCity.getImageIndex());
        } else {
            showCoatOfArms(0);
        }


    }

//сохраняем состояние
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(KEY,currentCity);
        super.onSaveInstanceState(outState);

    }

    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
       //впихиваем некторый фрагмент, макет, view хранит ссылку на LinearLayout
        View view = inflater.inflate(R.layout.fragment_city,container,false);
        //наш linearLayout. Создаем новый объект приводим view явно к LinearLayout
        LinearLayout linearLayout = (LinearLayout) view;

        createTextViewList(linearLayout);

        return view;
    }
    //получаем наш массив городов
    private void createTextViewList(LinearLayout linearLayout) {
        String[] city = getResources().getStringArray(R.array.cities);
        //оживляет макет, версия версия макета в виде кода
        LayoutInflater layoutInflater = getLayoutInflater();
        //выводим наш массив городов в textView
        for (int i=0; i<city.length; i++)
         {

             String name = city[i];
             //добавить R.layout.item в контейнер linearLayout
             TextView textView = (TextView)layoutInflater.inflate(R.layout.item, linearLayout, false);
             //добавляем textView
             //TextView textView = new TextView(getContext());
             textView.setText(name);
             //размер текста
             //textView.setTextSize(30);
             //добавляем наш textView
             linearLayout.addView(textView);
             int finalI = i;
             //для элемента генерируем текущий город по нажатию
             textView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     //currentCity = new City(finalI, (getResources().getStringArray(R.array.cities)[finalI]));
                     showCoatOfArms(finalI);
                 }
             });
         }
    }

    private void showCoatOfArms(int index) {
        currentCity = new City(index,
                (getResources().getStringArray(R.array.cities)[index]));
        if (isLandScape) {
            showCoatOfArmsLand();
        }  else { // портрет addToBackStack вкючили стек фрагментов, включили очередь для фрагментов
            showCoatOfArmsPort();
        }
    }

    private void showCoatOfArmsPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.city_conteiner, CoatOfArmsFragment.newInstance(currentCity))
                .addToBackStack("")
                .commit();
    }

    private void showCoatOfArmsLand() {
        //создаем новый фрагмент
        //родительная активити обращается к фрагмент менеджеру, далее фрагмент менеджер открывает транзакцию,
        // передачу,
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.coat_of_arms_conteiner, CoatOfArmsFragment.newInstance(currentCity))
                .commit();
    }
}
