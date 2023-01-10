package ru.lesson.socialnetwork_lesson8;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

//класс для элемента RecyclerView
public class SocialNetworkAdapter  extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {
    // данные которые поступают в этот класс
    private CardSource dataSourse;
    private  MyOnclickListener listener;
    private final Fragment fragment;
    private int menuContextClickPosition;

    public int getMenuContextClickPosition() {
        return menuContextClickPosition;
    }

    public void setOnMyOnclickListener(MyOnclickListener listener)
{
    this.listener = listener;
}
    public SocialNetworkAdapter(CardSource dataSourse, Fragment fragment) {
        this.dataSourse = dataSourse;
        this.fragment = fragment;
    }

    //список можно как добавлять данные так и обновлять, менять данные на ходу
    public void setData(CardSource dataSourse) {
        this.dataSourse = dataSourse;
    }

    //создаются элементы. parent - родительский контейнер
    //MyViewHolder - оболочка для работы с view, получаем доступ к его полям
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new MyViewHolder(view);
    }

    //запись данных. В уже созданные View записывает данные.
    // holder -  при прокрутке появится элементы который был скрыт
    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        //записываем значение
        holder.title.setText(dataSourse.getCardDate(position).getTitle());
        holder.description.setText(dataSourse.getCardDate(position).getDescription());
        holder.imageView.setImageResource(dataSourse.getCardDate(position).getPicture());
        holder.like.setChecked(dataSourse.getCardDate(position).isLike());
    }

    //возвращает размер
    @Override
    public int getItemCount() {
        return dataSourse.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView description;
        ImageView imageView;
        ToggleButton like;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            like = itemView.findViewById(R.id.like);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
            //привязываем контекстное меню к картинке
            fragment.registerForContextMenu(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     //getAdapterPosition - получить в holder позицию
                    listener.onMyclick(v,getAdapterPosition());
                    //запонминаем меню для которого обрабатываем клик
                    menuContextClickPosition = getAdapterPosition();
                    imageView.showContextMenu();
                }
            });
            //длинное нажатие на картинку
            //LongClick не работает

            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //показать при клике меню

                    return true;
                }
            });
        }
    }
}
