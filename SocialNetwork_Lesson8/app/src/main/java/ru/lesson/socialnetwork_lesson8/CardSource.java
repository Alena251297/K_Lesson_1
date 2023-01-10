package ru.lesson.socialnetwork_lesson8;

//определяем поведение карточки
public interface CardSource {
    int size();// размер
    CardDate getCardDate(int position); // возврат карточки по значению

    // поведение, что наш источник данных должен так же иметь:
    void deleteCardData (int position);// удаляет по позиции
    void updateCardData (int position, CardDate newCardDate);//обновляет карточку по позиции
    void addCardData (CardDate newCardDate); //добавляет новую карточку
    void cleardData(); // удалить все
}
