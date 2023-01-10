package ru.lesson.lesson_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        readSettings();
        initToolBar();
        initDrawer(initToolBar());

    }

    private Toolbar initToolBar() {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        //указываем этот тулбар в качестве основого в приложении
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void initDrawer(Toolbar toolbar) {
        //связываем тулбар с drawerLayout
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        //делаем бургер кнопку
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.add, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //включаем бургер кнопку
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        //слушаем нажатие
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_main:
                        showFragment(MainFragment.newInstance());
                        break;
                    case R.id.action_favorite:
                        showFragment(FavoriteFragment.newInstance());
                        break;
                    case R.id.action_settings:
                        showFragment(SettingsFragment.newInstance());
                        break;
                }
                // по нажатию на пукт меню боковое меню закрывается
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    //добавляем наше меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//обрабатываем клики, по клику показываем соотвествующие фрагменты
        switch (item.getItemId())
        {
            case R.id.action_main:
                showFragment(MainFragment.newInstance());
                break;
            case R.id.action_favorite:
                showFragment(FavoriteFragment.newInstance());
                break;
            case R.id.action_settings:
                showFragment(SettingsFragment.newInstance());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // впихиваем наш макет
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }




    private void readSettings() {
        //сохранение состояния настроек
        //открыли файл
        SharedPreferences sharedPreferences = getSharedPreferences(Settings.SHARED_PREFERENS_NAME, Context.MODE_PRIVATE);
        //получаем из файла
        //если в файле ничего не записано то вернется дефолтное значение
        Settings.isDeleteFragment = sharedPreferences.getBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD, false);
        Settings.isIsBackIsRemove = sharedPreferences.getBoolean(Settings.IS_BACK_REMOVE, false);
        Settings.isReplaceFragment = sharedPreferences.getBoolean(Settings.IS_REPLACE_FRAGMENT_USED, false);
        Settings.isBackStack = sharedPreferences.getBoolean(Settings.IS_BACK_STACK_USE, false);
        Settings.isAddFragment = sharedPreferences.getBoolean(Settings.IS_ADD_FRAGMENT_USED, false);
    }

    private void initView() {
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonMain = findViewById(R.id.buttonMain);
        Button buttonFavorite = findViewById(R.id.buttonFavorite);
        Button buttonSetings = findViewById(R.id.buttonSettings);
        buttonBack.setOnClickListener(this);
        buttonMain.setOnClickListener(this);
        buttonFavorite.setOnClickListener(this);
        buttonSetings.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
switch (v.getId())
{
    case R.id.buttonBack:
       FragmentManager fragmentManager = getSupportFragmentManager();
       //неудаляет последний фрагмент
        if(fragmentManager.getFragments().size()<=1)
            break;
       if (Settings.isIsBackIsRemove)
       {
          Fragment fragmentForDelete = getVisibleFragment(fragmentManager);
          if(fragmentForDelete!=null)
          {
              fragmentManager.beginTransaction().remove(fragmentForDelete).commit();
          }
       }else {
           //вернуться на шаг назад
           fragmentManager.popBackStack();
       }
        break;
    case R.id.buttonMain:
        showFragment(MainFragment.newInstance());
        break;
    case R.id.buttonFavorite:
        showFragment(FavoriteFragment.newInstance());
        break;
    case R.id.buttonSettings:
        showFragment(SettingsFragment.newInstance());
        break;
}
    }

    Fragment getVisibleFragment(FragmentManager fragmentManager )
    {
        //получить список фрагментов, getFragments() - вернуть фрагменты
        List<Fragment> flist = fragmentManager.getFragments();
        for (int i=0; i<flist.size(); i++)
        {
            Fragment fragment = flist.get(i);
            //если фрагмент виден
            if(fragment.isVisible())
            {
                return fragment;
            }
        }
        return  null;
    }

    public void showFragment(Fragment fragment) {
        //задаем явно фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        // задаем транзакцию
         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //перед удаление проверить есть ли фрагменты
         if(Settings.isDeleteFragment)
         {
             Fragment fragmentFroDelete = getVisibleFragment(fragmentManager);
             if(fragmentFroDelete!=null)
             {
               fragmentTransaction.remove(fragmentFroDelete);
             }
         }

         if(Settings.isAddFragment)
         {
             fragmentTransaction.add(R.id.fragment_conteiner,fragment);
         }else if (Settings.isReplaceFragment)
             fragmentTransaction.replace(R.id.fragment_conteiner,fragment);
        if(Settings.isBackStack)
        {
            fragmentTransaction.addToBackStack("");
        }
        fragmentTransaction.commit();
    }


}