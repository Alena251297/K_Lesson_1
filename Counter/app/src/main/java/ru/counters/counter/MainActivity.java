package ru.counters.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//сама активити становится сушателем на кнопки
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static String TAG = "counters";
    Counter counter;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // найти элемент по id записать в переменную
        intView();
        setContent();
        counter = new Counter();
        intListner();
    }

    @Override
    protected void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(TAG,counter);
        setContent();
    }

    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getParcelable(TAG);
    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.button_1:
        //setContentView(R.layout.linear_une);
        counter.incCounter1();
        textView1.setText(String.valueOf(counter.getCounter_1()));
        break;
    case R.id.button_2:
        counter.incCounter2();
        textView2.setText(String.valueOf(counter.getCounter_2()));
        break;
    case R.id.button_3:
        counter.incCounter3();
        textView3.setText(String.valueOf(counter.getCounter_3()));
        break;
    case R.id.button_4:
        counter.incCounter4();
        textView4.setText(String.valueOf(counter.getCounter_4()));
        break;
    default: break;
}
    }


//проверка нажатия на кнопку, поймали клик
 /*   public void badClick(View view) {
        if (view.getId()==R.id.button_1)
        {
            onToast("button1");
            counter.incCounter1();
            //setText установить текст
            textView1.setText(String.valueOf(counter_1));

        }
        else {
          //  counter_2++;
            //textView2.setText(String.valueOf(counter_2));
            onToast("button2");
        }

    }*/
    public void onToast (String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d("my log",message);
    }

    private void intView()
    {
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        button1=findViewById(R.id.button_1);
        button2=findViewById(R.id.button_2);
        button3=findViewById(R.id.button_3);
        button4=findViewById(R.id.button_4);
    }
    private void setContent()
    {
         int counter_1 =0;
         int counter_2 =0;
         int counter_3 =0;
         int counter_4 =0;
        textView1.setText(String.valueOf(counter_1));
        textView2.setText(String.valueOf(counter_2));
        textView3.setText(String.valueOf(counter_3));
        textView4.setText(String.valueOf(counter_4));
    }
    private void intListner()
    {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.incCounter1();
                textView1.setText(String.valueOf(counter));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.incCounter2();
                textView2.setText(String.valueOf(counter));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.incCounter2();
                textView2.setText(String.valueOf(counter));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.incCounter3();;
                textView3.setText(String.valueOf(counter));
            }
        });
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

}