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
import android.widget.Toast;

import com.aardouin.cv.R;
import com.aardouin.cv.adapters.LeftDrawerAdapter;
import com.aardouin.cv.fragments.AbstractContentFragment;
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


    public static final String CURRENT_ITEM_KEY = "CURRENT_ITEM_KEY";
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView leftDrawer;
    private FrameLayout contentFrame;
    private LeftDrawerAdapter leftDrawerAdapter;
    private LeftDrawerAdapter.MenuItem currentItem;
    private long lastBackTimeStamp = -1 ;

    @Override
    protected void onStart() {
        super.onStart();


        if (currentItem == null) {
            setCurrentItem(LeftDrawerAdapter.MenuItem.Presentation);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CURRENT_ITEM_KEY, currentItem.name());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        bind();

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(CURRENT_ITEM_KEY)) {
                currentItem = LeftDrawerAdapter.MenuItem.valueOf(savedInstanceState.getString(CURRENT_ITEM_KEY));
            }
        }

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

        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
    }

    @Override
    public void onBackPressed() {
        AbstractContentFragment currentFragment = ((AbstractContentFragment) getSupportFragmentManager().findFragmentByTag(currentItem.name()));
        if(currentFragment ==  null || !currentFragment.doBack()){
            long timestampNow = System.currentTimeMillis() / 1000;

            if( timestampNow - lastBackTimeStamp > 3){
                lastBackTimeStamp = timestampNow;
                Toast.makeText(getBaseContext(),"Appuer de nouveau pour quitter",Toast.LENGTH_LONG).show();
            }else{
                super.onBackPressed();
            }
        }
    }

    private void setCurrentItem(LeftDrawerAdapter.MenuItem item) {

        if (!item.equals(currentItem)) {
            Fragment fragment = getFragmentForItem(item);

            if (fragment != null) {
                showFragment(fragment,item);
            }
            hideMenu();
            this.currentItem = item;
        }


    }

    private Fragment getFragmentForItem(LeftDrawerAdapter.MenuItem item) {
        Fragment fragment = null;

        fragment = getSupportFragmentManager().findFragmentByTag(item.name());
        if (fragment == null) {
            switch (item) {
                case Presentation:
                        fragment = new PresentationFragment();
                    break;
                case Formation:
                        fragment = new FormationFragment();
                    break;
                case Experiences:
                        fragment = new ExperiencesFragment();
                    break;
                case Competences:
                        fragment = new CompetencesFragment();
                    break;
                case Loisirs:
                        fragment = new InteretsFragments();
                    break;
                case Contacts:
                        fragment = new ContactsFragment();
                    break;
                case PDF:
                        fragment = new PDFFragments();
                    break;
                case Portfolio:
                        fragment = new PortfolioFragment();
                    break;
            }
        }
        return fragment;
    }

    private void showFragment(Fragment fragment, LeftDrawerAdapter.MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(contentFrame.getId(), fragment,item.name());

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
