package ru.lesson.lesson_7;

public class Settings {
    //настройки
    //по какому имени настройки, уникальная настройка
    public static final String SHARED_PREFERENS_NAME = "SHARED_PREFERENS_NAME";

    //какие реимы используются
    public static final String IS_BACK_STACK_USE = "IS_BACK_STACK_USE";
    //для наслоение фрагментов
    public static final String IS_ADD_FRAGMENT_USED = "IS_ADD_FRAGMENT_USED";
    public static final String IS_REPLACE_FRAGMENT_USED = "IS_REPLACE_FRAGMENT_USED";
    //кнопка назад
    public static final String IS_BACK_REMOVE = "IS_BACK_REMOVE";
    // удаление фрагментов. удаляем предыдущий фрагмент перед тем как добавить новый
    public static final String IS_DELETE_FRAGMENT_BEFORE_ADD = "IS_DELETE_FRAGMENT_BEFORE_ADD";


    public static boolean isBackStack;
    public static boolean isAddFragment;
    public static boolean isReplaceFragment;
    public static boolean isIsBackIsRemove;
    public static boolean isDeleteFragment;


}
