package ru.lesson.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class InterceptActivity extends AppCompatActivity {
Button button3;
EditText editText3;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept);
        imageView = findViewById(R.id.imageview);
        button3 = findViewById(R.id.button3);
        editText3 = findViewById(R.id.edittext3);

        Intent i = getIntent();
        String action = i.getAction();
        String type = i.getType();

        Bundle extras = i.getExtras();

        if(action.equals(Intent.ACTION_SEND))
        {

            if (type.startsWith("image/"))
            {
                imageView.setImageURI(extras.getParcelable(Intent.EXTRA_STREAM));
            }else if (type.startsWith("text/"))
            {
                String subject = extras.getString(Intent.EXTRA_SUBJECT);
                String text = extras.getString(Intent.EXTRA_TEXT);
                editText3.setText(String.format("%s %s",subject, text));
            }
        }


    }
}