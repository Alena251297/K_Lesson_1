package ru.activity.activity;

import android.nfc.Tag;
import android.util.Log;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Активити";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null)
        {
            instanceState = "Первый запуск";
        }
        else {
            instanceState = "Второй запуск";
        }
        Toast.makeText(getApplicationContext(), " - onCreate", Toast.LENGTH_SHORT).show();

       Log.i(TAG,"onCreate");

    }



    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(getApplicationContext(), " - onStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onStart");
    }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState )
  {
      super.onRestoreInstanceState(savedInstanceState);
      Toast.makeText(getApplicationContext(), " - Поворный запуск - onRestoreInstanceState ", Toast.LENGTH_SHORT).show();
      Log.i(TAG,"onRestoreInstanceState");
  }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(), " - onResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), " - onPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onPause");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), " - onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onSaveInstanceState");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), " - onStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onStop");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(getApplicationContext(), " - onRestart", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onRestart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), " - onDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"onDestroy");
    }
}