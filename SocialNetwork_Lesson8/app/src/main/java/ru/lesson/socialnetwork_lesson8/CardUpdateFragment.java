package ru.lesson.socialnetwork_lesson8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.lesson.socialnetwork_lesson8.observe.Publisher;

public class CardUpdateFragment extends Fragment {
    private CardDate cardDate;
private Publisher publisher;
    private static final String ARG_CARD_DATA = "Param_CardDate";
//передаем паблишер в наш фрагмент
    //присоединили паблишер
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        publisher =  ((MainActivity)context).getPublisher();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publisher=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_card, container,false);
        return view;
    }

    //для редактирования карточки
    public static CardUpdateFragment newInstance(CardDate cardDate)
    {
        CardUpdateFragment fragment = new CardUpdateFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CARD_DATA, cardDate);
        fragment.setArguments(args);
        return fragment;
    }

    //для новых карточек, если на вход ничего не приходит создается пустой фрагмент
    public static CardUpdateFragment newInstance()
    {
        CardUpdateFragment fragment = new CardUpdateFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
        {
            //по ключу достаем нашу карточку
            cardDate = getArguments().getParcelable(ARG_CARD_DATA);
        }
    }
}
