package ru.lesson.lesson_5;

import static ru.lesson.lesson_5.MainActivity.KEY_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SeondActivity extends AppCompatActivity {
    Button button2;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button2=findViewById(R.id.button2);
        editText2 = findViewById(R.id.edittext2);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SeondActivity.this, MainActivity.class);
                String message = "You message: "+ editText2.getText();
                i.putExtra(MainActivity.KEY_MESSAGE,message);
                //startActivity(i);
                setResult(MainActivity.REQUEST_CODE,i);
                //закрыть предыдущую активити
                finish();
            }
        });

        Intent i = getIntent();
        Bundle exstras = i.getExtras();
        if(exstras!=null)
        {
            Message messageObj = exstras.getParcelable(KEY_MESSAGE);
            //передали объект
            String message = messageObj.getMessage();
            editText2.setText(message);
        }



    }
}