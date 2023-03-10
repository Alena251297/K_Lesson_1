package ru.lesson.socialnetwork_lesson8;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Navigation {
    private final FragmentManager fragmentManager;

    public Navigation(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void addFrqgment(Fragment fragment, boolean useBackStack)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_conteiner,fragment);
        if (useBackStack)
        {
            fragmentTransaction.addToBackStack(" ");
        }
        fragmentTransaction.commit();
    }
}
