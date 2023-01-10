package ru.lesson.socialnetwork_lesson8.observe;

import ru.lesson.socialnetwork_lesson8.CardDate;
//слушатель
public interface Observer {
    void updateState(CardDate cardDate); //обновляет состоятение

}
