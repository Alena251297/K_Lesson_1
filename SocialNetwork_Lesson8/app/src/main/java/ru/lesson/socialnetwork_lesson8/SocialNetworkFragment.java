package ru.lesson.socialnetwork_lesson8;


import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

public class SocialNetworkFragment extends Fragment  implements MyOnclickListener{
    private CardSource data;
    private  SocialNetworkAdapter adapter;
    private RecyclerView recyclerView;

    public static SocialNetworkFragment newInstance()
    {
        return new SocialNetworkFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network,container,false);
        //указываем явно, что фрагмент имеет свое OptionsMenu
        setHasOptionsMenu(true);
        //String[] data = getResources().getStringArray(R.array.test_title);

       data = new CardSourceImplementation(getResources()).init();

         recyclerView = view.findViewById(R.id.recyclerView);
        //все элементы внутри одинакоговогго размера
        recyclerView.setHasFixedSize(true);
        //отвечает за размещение элементов
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //анимация, создем анимации
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        //анимции удаления, добавления, обновления
        defaultItemAnimator.setAddDuration(2000);
        defaultItemAnimator.setChangeDuration(2000);
        defaultItemAnimator.setRemoveDuration(2000);
        //для элементов этого списка задаем анимции
        recyclerView.setItemAnimator(defaultItemAnimator);
        //установка адаптера
         adapter = new SocialNetworkAdapter(data, this);



        adapter.setOnMyOnclickListener(this);


        recyclerView.setAdapter(adapter);
        return view;
    }
    //меню фрагмента
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    //кнопки очистить и добавить
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                //добавить новую карточку
                // создать полностью новый элемент
        data.addCardData(new CardDate("New" + data.size(),
        "new"+data.size(),R.drawable.natural1,false, Calendar.getInstance().getTime()));
                // начинается с 0
               //обновляем
        adapter.notifyItemInserted(data.size()-1);
//обновление всего списка
//                adapter.notifyDataSetChanged();
                //recyclerView.scrollToPosition(data.size()-1);
                //плавно добавляется переезжает вниз
                recyclerView.smoothScrollToPosition(data.size()-1);
                return true;
            case R.id.action_clear:
                data.cleardData();
                //обнуляет весь список
                adapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMyclick(View view, int position) {
        //Toast.makeText(getContext(), "тяжелая обработка для " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu( ContextMenu menu,  View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.card_menu, menu);

    }
//контекстное меню при нажатии на картинку
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = adapter.getMenuContextClickPosition();
          switch (item.getItemId())
        {
            case R.id.action_update:
              //  CardDate cardDate = data.getCardDate(position);
                data.getCardDate(position).setTitle("обновили" + position);
                //data.updateCardData(position,data.getCardDate(position));
                adapter.notifyItemChanged(position);
           //     Log.d("mylog","log");
                return true;
            case R.id.action_delete:
                //удаление элемента
                data.deleteCardData(position);
                adapter.notifyItemRemoved(position);
             //   Log.d("mylog","log");
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
