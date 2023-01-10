package ru.calculator.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button_lastic;
    Button button_plus;
    Button button_minus;
    Button button_iquls;
    Button button_delit;
    Button button_multip;
    Button button_point;
    EditText resolt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint);
        inView();
        onList();

        //как поймать элемент  по id
       //TextView textView = findViewById( R.id.TextView);

    }

    private void inView()
    {
        resolt = findViewById(R.id.result);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button_lastic = findViewById(R.id.lastic);
        button_plus = findViewById(R.id.plus);
        button_minus = findViewById(R.id.minus);
        button_delit = findViewById(R.id.delit);
        button_multip = findViewById(R.id.mult);
        button_iquls = findViewById(R.id.ravno);
        button_point = findViewById(R.id.point);
    }
private void onList()
{
    button0.setOnClickListener(this);
    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);
    button5.setOnClickListener(this);
    button6.setOnClickListener(this);
    button7.setOnClickListener(this);
    button8.setOnClickListener(this);
    button9.setOnClickListener(this);
    button_lastic.setOnClickListener(this);
    button_plus.setOnClickListener(this);
    /*button_lastic.setOnClickListener(this);
    button_plus.setOnClickListener(this);*/
}

    @Override
    public void onClick(View view) {
        String number = resolt.getText().toString();
        String operation = "";
       /* int a,b,res;

        String num1 = resolt.getText().toString();
        String num2 = resolt.getText().toString();
        a=Integer.parseInt(num1);
        b=Integer.parseInt(num2);*/
        switch (view.getId())
{

    case R.id.button_0:
        number = number + "0";
        resolt.setText(number);
        break;

    case R.id.button_1:
        number = number + "1";
        resolt.setText(number);
        break;
    case R.id.button_2:
        number = number + "2";
        resolt.setText(number);
        break;
    case R.id.button_3:
        number = number + "3";
        resolt.setText(number);
        break;
    case R.id.button_4:
        number = number + "4";
        resolt.setText(number);
        break;
    case R.id.button_5:
        number = number + "5";
        resolt.setText(number);
        break;
    case R.id.button_6:
        number = number + "6";
        resolt.setText(number);
        break;
    case R.id.button_7:
        number = number + "7";
        resolt.setText(number);
        break;
    case R.id.button_8:
        number = number + "8";
        resolt.setText(number);
        break;
    case R.id.button_9:
        number = number + "9";
        resolt.setText(number);
        break;
    case R.id.lastic:
        number=number.substring(0,number.length()-1);
        resolt.setText(number);
        break;
    case R.id.plus:
        number = number + "+";

       /* res=a+b;
        String s = Double.toString(res);*/
        resolt.setText(number);
        //resolt.setText("+");
        break;
  /*  case R.id.minus:
        break;
    case R.id.mult:
        break;
    case R.id.delit:
    case R.id.ravno:

        break;*/
    default:break;
}
    }
}