package ru.lesson.socialnetwork_lesson8;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import ru.lesson.socialnetwork_lesson8.observe.Publisher;

public class MainActivity extends AppCompatActivity {
    private Publisher publisher;

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        if (savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conteiner,SocialNetworkFragment.newInstance()).commit();
        }
    }
//меню активити, общее меню
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.fragment_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private Toolbar initToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

}
