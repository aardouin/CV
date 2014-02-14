package com.aardouin.cv.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.aardouin.cv.R;
import com.aardouin.cv.adapters.LeftDrawerAdapter;
import com.aardouin.cv.fragments.CompetencesFragment;
import com.aardouin.cv.fragments.ContactsFragment;
import com.aardouin.cv.fragments.ExperiencesFragment;
import com.aardouin.cv.fragments.FormationFragment;
import com.aardouin.cv.fragments.InteretsFragments;
import com.aardouin.cv.fragments.PDFFragments;
import com.aardouin.cv.fragments.PortfolioFragment;
import com.aardouin.cv.fragments.PresentationFragment;
import com.aardouin.cv.views.ActionBar;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class MainActivity extends FragmentActivity implements ActionBar.ActionBarListener {


    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView leftDrawer;
    private FrameLayout contentFrame;
    private LeftDrawerAdapter leftDrawerAdapter;
    private LeftDrawerAdapter.MenuItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        bind();


        leftDrawer.setItemChecked(0, true);
    }

    private void bind() {
        actionBar = (ActionBar) findViewById(R.id.action_bar);
        actionBar.setListener(this);
        actionBar.bringToFront();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        leftDrawer = (ListView) findViewById(R.id.left_drawer);

        leftDrawerAdapter = new LeftDrawerAdapter(this);
        leftDrawer.setAdapter(leftDrawerAdapter);

        leftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setCurrentItem((LeftDrawerAdapter.MenuItem) adapterView.getAdapter().getItem(i));
            }
        });

        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
    }

    private void setCurrentItem(LeftDrawerAdapter.MenuItem item) {

        if (!item.equals(currentItem)) {
            Fragment fragment = getFragmentForItem(item);

            if (fragment != null) {
                showFragment(fragment);
            }
            hideMenu();
            this.currentItem = item;
        }


    }

    private Fragment getFragmentForItem(LeftDrawerAdapter.MenuItem item) {
        Fragment fragment = null;
        switch (item) {
            case Presentation:
                fragment = getSupportFragmentManager().findFragmentByTag(PresentationFragment.TAG);
                if (fragment == null) {
                    fragment = new PresentationFragment();
                }
                break;
            case Formation:
                fragment = getSupportFragmentManager().findFragmentByTag(FormationFragment.TAG);
                if (fragment == null) {
                    fragment = new FormationFragment();
                }
                break;
            case Experiences:
                fragment = getSupportFragmentManager().findFragmentByTag(ExperiencesFragment.TAG);
                if (fragment == null) {
                    fragment = new ExperiencesFragment();
                }
                break;
            case Competences:
                fragment = getSupportFragmentManager().findFragmentByTag(CompetencesFragment.TAG);
                if (fragment == null) {
                    fragment = new CompetencesFragment();
                }
                break;
            case Loisirs:
                fragment = getSupportFragmentManager().findFragmentByTag(InteretsFragments.TAG);
                if (fragment == null) {
                    fragment = new InteretsFragments();
                }
                break;
            case Contacts:
                fragment = getSupportFragmentManager().findFragmentByTag(ContactsFragment.TAG);
                if (fragment == null) {
                    fragment = new ContactsFragment();
                }
                break;
            case PDF:

                fragment = getSupportFragmentManager().findFragmentByTag(PDFFragments.TAG);
                if (fragment == null) {
                    fragment = new PDFFragments();
                }
                break;
            case Portfolio:
                fragment = getSupportFragmentManager().findFragmentByTag(PortfolioFragment.TAG);
                if (fragment == null) {
                    fragment = new PortfolioFragment();
                }
                break;
        }
        return fragment;
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(contentFrame.getId(), fragment);

        transaction.commit();
    }

    @Override
    public void onMenuButtonClicked() {
        this.toggleMenu();
    }

    private void toggleMenu() {
        if (drawerLayout.isDrawerOpen(leftDrawer))
            hideMenu();
        else
            showMenu();
    }

    private void showMenu() {
        drawerLayout.openDrawer(leftDrawer);
    }

    private void hideMenu() {
        drawerLayout.closeDrawer(leftDrawer);
    }

}
