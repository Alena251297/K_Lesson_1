package com.example.cities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Активити";
    private static final String FRAGMENT_TAG = "CitiesFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new CitiesFragment()).commit();

        CitiesFragment citiesFragment = (CitiesFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (citiesFragment == null) {
            citiesFragment = new CitiesFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, citiesFragment, FRAGMENT_TAG).commit();
    }

//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        //Toast.makeText(getApplicationContext(), " - onStart", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onStart");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Toast.makeText(getApplicationContext(), " - Поворный запуск - onRestoreInstanceState ", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onRestoreInstanceState");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(getApplicationContext(), " - onResume", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(getApplicationContext(), " - onPause", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onPause");
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        Toast.makeText(getApplicationContext(), " - onSaveInstanceState", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onSaveInstanceState");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(getApplicationContext(), " - onStop", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onStop");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(getApplicationContext(), " - onRestart", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onRestart");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(getApplicationContext(), " - onDestroy", Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onDestroy");
//
//    }
}