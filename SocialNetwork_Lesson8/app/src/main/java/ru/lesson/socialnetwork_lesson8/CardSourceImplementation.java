package ru.lesson.socialnetwork_lesson8;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//реализация интерфейса
public class CardSourceImplementation implements CardSource{
    //список
    public  List<CardDate> dataSource;
    private Resources resources;
    @Override
    public int size() {
        return dataSource.size(); // возвращаем размер даных которые нам пришли
    }

    @Override
    public CardDate getCardDate(int position) {
        return dataSource.get(position); // возвращаем по позиции
    }

    @Override
    public void deleteCardData(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateCardData(int position, CardDate newCardDate) {
        dataSource.set(position, newCardDate);
    }

    @Override
    public void addCardData(CardDate newCardDate) {
        dataSource.add(1,newCardDate);

    }

    @Override
    public void cleardData() {
        dataSource.clear();
    }

    public CardSourceImplementation(Resources resources) {
        dataSource = new ArrayList<>();
        this.resources = resources;
    }
    public CardSourceImplementation init()
    {
        String[] title = resources.getStringArray(R.array.title);
        String[] description = resources.getStringArray(R.array.description);
        //получам картинки
        TypedArray typedArray = resources.obtainTypedArray(R.array.pictures);
        int[] picture = new int[typedArray.length()];
        for (int i=0; i<typedArray.length(); i++)
        {
            picture[i]=typedArray.getResourceId(i,-1);
        }
        for (int i=0; i<title.length; i++)
        {
            dataSource.add(new CardDate(title[i],description[i],picture[i], false, Calendar.getInstance().getTime()));
        }
        return this; // возвращает реализацию интерфейся, getCardDate и size


    }




    //инициализируем объект
    //получить из ресурсов наши массивы с описанием, title и картинками



}
