package ru.lesson.lesson_5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText editText1;
public static final String KEY_MESSAGE = "message";
//идентификатор запроса
public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* button1=findViewById(R.id.button1);
        editText1 = findViewById(R.id.edittext1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //создаем намерение, явный интент, создаем намерение  в другую активити
                Intent i = new Intent(MainActivity.this,SeondActivity.class);
                //строка с сообщение.
                String strMessage = "My message: "+ editText1.getText();
                Message messageObj = new Message();
                messageObj.setMessage(strMessage);
                //передали строку с сообщением, ключ чтобы опознать какое сообщение передавать
                i.putExtra(KEY_MESSAGE,messageObj);
                 //запустить цель, создает новый активити
                //startActivity(i);
               startActivityForResult(i,REQUEST_CODE);
            }
        });

        Intent i = getIntent();
        Bundle exstras = i.getExtras();
        if(exstras!=null)
        {
            String message = exstras.getString(KEY_MESSAGE);
            editText1.setText(message);
        }*/

        Log.d("mylogs", MimeTypeMap.getSingleton().getMimeTypeFromExtension("png"));

//неявный интент
        button1=findViewById(R.id.button1);
        editText1 = findViewById(R.id.edittext1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправить кому-то
                //смотрим внутрь телефона - кто может отправить данное сообщение
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "subject");
                i.putExtra(Intent.EXTRA_TEXT, "text");

                startActivity(i);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode==REQUEST_CODE)
        {
            String message = data.getExtras().getString(MainActivity.KEY_MESSAGE);
            editText1.setText("onActivityResult Work" + message);
        }
    }
}