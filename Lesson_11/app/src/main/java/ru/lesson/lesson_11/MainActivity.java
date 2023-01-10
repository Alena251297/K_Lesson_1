package ru.lesson.lesson_11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button alertdialog = findViewById(R.id.alert_dialog);
        alertdialog.setOnClickListener(clickListenerDialog1);
        Button alertdialog_3 = findViewById(R.id.alert_dialog_3);
        alertdialog_3.setOnClickListener(clickListenerDialog2);
        Button alert_dialog_list = findViewById(R.id.allert_dialog_list);
        alert_dialog_list.setOnClickListener(clickListenerListDialog);
        Button alert_dialog_list_singl = findViewById(R.id.allert_dialog_list_singl);
        alert_dialog_list_singl.setOnClickListener(clickListenerListDialogSingl);
        Button alert_dialog_list_multi = findViewById(R.id.allert_dialog_mult);
        alert_dialog_list_multi.setOnClickListener(clickListenerListDialogMulti);
    }

//AlertDialog
    private View.OnClickListener clickListenerDialog2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            //наполняем на диалог, задаем значение, строим диалог
            builder.setTitle(R.string.exclamation)
                    .setMessage(R.string.message)
                    .setPositiveButton(R.string.yes, dialogListner)
                    .setNeutralButton(R.string.dunno, dialogListner)
                    .setNegativeButton(R.string.no, dialogListner);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private View.OnClickListener clickListenerDialog1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            //наполняем на диалог, задаем значение, строим диалог
            builder.setTitle(R.string.exclamation)
                    .setMessage(R.string.message)
                    .setPositiveButton(R.string.yes, dialogListner);
           //экземпляр AlertDialog, класса создаем диалог
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private View.OnClickListener clickListenerListDialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //получаем массив с вариантами
            String[] variant = getResources().getStringArray(R.array.variant);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                      builder.setTitle(R.string.exclamation)
                              .setItems(variant,dialogListner);
            //экземпляр AlertDialog, класса создаем диалог
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };
    private int chosenSingle =-1;
    private boolean[] chosenMulti ={false, false, false};
    private View.OnClickListener clickListenerListDialogSingl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //получаем массив с вариантами
            String[] variant = getResources().getStringArray(R.array.variant);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                      builder.setTitle(R.string.exclamation)
                              .setSingleChoiceItems(variant, chosenSingle,new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialogInterface, int i) {
                                      chosenSingle=i;
                                      Log.d("mylogs","chosen " + variant[i]);
                                  }
                              })
                              .setPositiveButton(R.string.yes, dialogListner);;

            //экземпляр AlertDialog, класса создаем диалог

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };
    private View.OnClickListener clickListenerListDialogMulti = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] variant = getResources().getStringArray(R.array.variant);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setMultiChoiceItems(variant, chosenMulti,new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            //запоминаем варианты ответов
                            chosenMulti[i]=b;
                            Log.d("mylogs","chosen " + variant[i]);
                        }
                    })
                    .setPositiveButton(R.string.yes, dialogListner);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private DialogInterface.OnClickListener dialogListner = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            Log.d("mylogs","что то пришло" + i);
        }
    };

}

