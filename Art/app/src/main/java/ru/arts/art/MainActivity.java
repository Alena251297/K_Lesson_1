package ru.arts.art;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int MyThema1 = 1;
    static final int MyThema2 = 2;
    static final int MyThema3 = 3;
    static final int MyThema4 = 4;

    static final String KEY_SP ="sp";
    //ключ текущей темы
    static final String KEY_CURRENT_THEME ="current_theme";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //задаем тему, пишеьмя перед макетом. Задаем тему с сохраненным значением, сохраненное назнавание
        // значение 1,2,3,4. Для когда 1 - My  и так далее
        setTheme(getRealId(getCurrentTheme()));
        //изменить тему
        setContentView(R.layout.activity_main);
        InitView();
        Log.d("mylogs",getRealId(getCurrentTheme()) + " ");
        Log.d("mylogs",(getCurrentTheme()) + " ");
        Log.d("mylogs",R.style.My1 + " ");

    }

    @Override
    public void recreate() {
        super.recreate();
    }
    //улавливаем нажатия, и сохраняем соотвествующу тему для кнопки
        @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.myThem1:
                setCurrentTheme(MyThema1);
                break;
            case R.id.myThem2:
                setCurrentTheme(MyThema2);
                break;
            case R.id.myThem3:
                setCurrentTheme(MyThema3);
                break;
            case R.id.myThem4:
                setCurrentTheme(MyThema4);
                break;
        }
        //перезагружка, применить новую тему после перезагрузки
        recreate();
    }
private void InitView()
{
    (findViewById(R.id.myThem1)).setOnClickListener(this);
    (findViewById(R.id.myThem2)).setOnClickListener(this);
    (findViewById(R.id.myThem3)).setOnClickListener(this);
    (findViewById(R.id.myThem4)).setOnClickListener(this);
    // когда перезапускается приожение, вывделен определенный чек
    switch (getCurrentTheme())
    {
        case 1:
            ((RadioButton)findViewById(R.id.myThem1)).setChecked(true);
            break;
        case 2:
            ((RadioButton)findViewById(R.id.myThem2)).setChecked(true);
            break;
        case 3:
            ((RadioButton)findViewById(R.id.myThem3)).setChecked(true);
            break;
        case 4:
            ((RadioButton)findViewById(R.id.myThem4)).setChecked(true);
            break;
    }
}
//записать, запомнить тему. Записали настройки приложения, темы, сохраняем нажатую кнопку
    private void setCurrentTheme(int currentTheme)
    {
        //эти настройки не расшариваются другим приложением. Только наше приложение читает эти настройки
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        //сессия записи настроек
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt(KEY_CURRENT_THEME,currentTheme);
        // закрываем сессию
        editor.apply();
    }
    //вставить тему
    private int getCurrentTheme()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
      return (sharedPreferences.getInt(KEY_CURRENT_THEME, -1));
    }
    //прочитать id
    private int getRealId(int currentTheme) {
        switch (currentTheme)
        {
            case MyThema1:
               return R.style.My1;
             case MyThema2:
                return R.style.My2;
            case MyThema3:
                return  R.style.My3;
            case MyThema4:
                return  R.style.My4;
         default: return 0;
        }
    }

}