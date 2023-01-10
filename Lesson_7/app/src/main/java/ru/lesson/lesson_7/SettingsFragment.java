package ru.lesson.lesson_7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;


public class SettingsFragment extends Fragment {

    public static SettingsFragment newInstance() {
          return new SettingsFragment();
    }

    RadioButton radionButtonAdd;
    RadioButton radionButtonReplace;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        initView(v);
             return v;
    }

    private void initView(View v) {
        radionButtonReplace = v.findViewById(R.id.radionButtonReplace);
        radionButtonAdd = v.findViewById(R.id.radionButtonAdd);
        //определили переключатели
        SwitchCompat switchBackStack = v.findViewById(R.id.switchForBackStack) ;
        SwitchCompat switchDeleteBeforeAdd = v.findViewById(R.id.switchDeleteBeforeAdd);
        SwitchCompat switchBackAsRemove = v.findViewById(R.id.switchBackAsRemove);
        //считываем значения
        switchDeleteBeforeAdd.setChecked(Settings.isDeleteFragment);
        switchBackStack.setChecked(Settings.isBackStack);
        switchBackAsRemove.setChecked(Settings.isIsBackIsRemove);


        radionButtonAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // клик
                Settings.isAddFragment = isChecked;
                writeSettings();
            }
        });
        //вешаем слушатели на переключатели
        radionButtonReplace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isReplaceFragment = isChecked;
                writeSettings();
            }
        });

        switchBackStack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isBackStack = isChecked;
                writeSettings();
            }
        });
        switchDeleteBeforeAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isDeleteFragment = isChecked;
                writeSettings();
            }
        });

        switchBackAsRemove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isIsBackIsRemove = isChecked;
                writeSettings();
            }
        });






    }

    private void writeSettings() {
        //вызвали настройки, указали какие именно настройки, и что эти настройки только для нашего приложения.
        // SHARED_PREFERENS_NAME - как имя файла
        //sharedPreferences = requireActivity() - вызывается в контекте Activity
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(Settings.SHARED_PREFERENS_NAME, Context.MODE_PRIVATE);
        //открываем запись
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //записываем, сохраняем настройки
        editor.putBoolean(Settings.IS_ADD_FRAGMENT_USED, Settings.isAddFragment);
        editor.putBoolean(Settings.IS_REPLACE_FRAGMENT_USED, Settings.isReplaceFragment);
        editor.putBoolean(Settings.IS_BACK_STACK_USE, Settings.isBackStack);
        editor.putBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD, Settings.isDeleteFragment);
        editor.putBoolean(Settings.IS_BACK_REMOVE, Settings.isIsBackIsRemove);
        //применить настройки
        editor.apply();
    }
}