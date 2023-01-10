package ru.lessonlesson_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewLabel = findViewById(R.id.TextLanguaLabel);
        TextView textView = findViewById(R.id.TextLangua);
        //получить и вывести ресур внутри java кода
        textViewLabel.setText(getString(R.string.languageLabel_java));
        textView.setText(getString(R.string.language_java));

        //Считали шрифт
        Typeface tf = Typeface.createFromAsset(getAssets(),"font/Methodiy-Regular.ttf");
        //применяем шрифт
        textView.setTypeface(tf);
        textViewLabel.setTypeface(tf);

        //загружаем картинку

        AppCompatImageView appCompatImageView = findViewById(R.id.imageView);
        try {
            //поток чтения
            InputStream inputStream = getAssets().open("notebook.jpg");
             // создаем картинку, по байтово считываем картинку и байты переопределяем
            Drawable d = Drawable.createFromStream(inputStream,"notebook.jpg");
            //загружаем
             appCompatImageView.setImageDrawable(d);
        } catch (IOException e)
        {
            e.getStackTrace();
        }
//получаем LinearLayot
        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        //считываем массив строк
        String[] version = getResources().getStringArray(R.array.version_names);
        //считываем массив картинок
        TypedArray typedArray = getResources().obtainTypedArray(R.array.version_icons);
        //вывод картинок
        for (int i=0; i<typedArray.length(); i++)
        {
            //создаем картинку
            //getLayoutInflater().inflate вставить наш item в linearLayout
            View view = getLayoutInflater().inflate(R.layout.item,linearLayout, false);
            TextView textVesionName = view.findViewById(R.id.textVesionName);
            textVesionName.setText(version[i]);


            AppCompatImageView imageVeiwVersion = view.findViewById(R.id.imageVeiwVersion);
            imageVeiwVersion.setImageResource(typedArray.getResourceId(i,0));

            //зафиксировать изменения
            linearLayout.addView(view);
        }




    }
}