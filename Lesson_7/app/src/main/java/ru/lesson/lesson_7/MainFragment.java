package ru.lesson.lesson_7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    public static MainFragment newInstance()
    {
        return new MainFragment();
    }

    //внедрение фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //создать view через inflater
        //attachToRoor - View внедрятся без наследства
        // container - сюда передается контейнер в который мы поместим фрагмент
        View v = inflater.inflate(R.layout.fragment_main,container,false);
        ((TextView) v.findViewById(R.id.text_view)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // клики по менюшке popup
                PopupMenu popupMenu = new PopupMenu(requireActivity(), v);
                requireActivity().getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.action_main:
                                ((MainActivity)getActivity()).showFragment(MainFragment.newInstance());
                                break;
                            case R.id.action_favorite:
                                ((MainActivity)getActivity()).showFragment(FavoriteFragment.newInstance());
                                break;
                            case R.id.action_settings:
                                ((MainActivity)getActivity()).showFragment(SettingsFragment.newInstance());
                                break;
                        }
                        return false;
                    }
                });
                //показывает меню
                popupMenu.show();
            }
        });

        return v;
    }
}
