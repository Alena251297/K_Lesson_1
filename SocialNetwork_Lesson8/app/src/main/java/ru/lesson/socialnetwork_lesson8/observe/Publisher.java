package ru.lesson.socialnetwork_lesson8.observe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.lesson.socialnetwork_lesson8.CardDate;

public class Publisher {
    //список слушателей
    private List<Observer> observers;

// инициализация слушателей
    public Publisher() {
        this.observers = new ArrayList<Observer>();
    }

    //наполнение списка
        public void subscribe(Observer observer)
    {
        // возможность слушателя подписаться
        observers.add(observer);
    }
    public void unsubscribe(Observer observer)
    {
        // возможность слушателя отписаться
        observers.remove(observer);
    }

    //поступила задача
    public void notifyTask(CardDate cardDate)
    {
        for(Observer observer:observers)
        {
            observer.updateState(cardDate);
        }
    }
}
