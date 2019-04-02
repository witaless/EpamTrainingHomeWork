package com.witaless.epamtraininghomework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.witaless.epamtraininghomework.compoundview.UserInfoModel;
import com.witaless.epamtraininghomework.compoundview.UserInfoView;
import com.witaless.epamtraininghomework.fragments.FavoritesFragment;
import com.witaless.epamtraininghomework.fragments.InboxFragment;
import com.witaless.epamtraininghomework.fragments.OutboxFragment;
import com.witaless.epamtraininghomework.fragments.TrashFragment;


public class MainActivity extends AppCompatActivity {

    private static final int NAV_HEADER_INDEX = 0;
    private static final String TEST_USER_NAME = "Vitaly Kulikovski";
    private static final String TEST_USER_EMAIL = "witaless99@gmail.com";

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        setupActionBar();
        setupNavigationView();
    }

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(myOnNavigationItemSelectedListener);
        navigationView.setCheckedItem(R.id.nav_inbox);

        setTitle(navigationView.getCheckedItem().getTitle());
        setDisplayedFragment(new InboxFragment());

        UserInfoView userInfoView = (UserInfoView) navigationView.getHeaderView(NAV_HEADER_INDEX);
        userInfoView.setUserInfo(new UserInfoModel(TEST_USER_NAME, TEST_USER_EMAIL, R.drawable.ic_account));
    }

    private void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void setDisplayedFragment(final Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, newFragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    NavigationView.OnNavigationItemSelectedListener myOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_inbox:
                    setDisplayedFragment(new InboxFragment());

                    break;
                case R.id.nav_outbox:
                    setDisplayedFragment(new OutboxFragment());

                    break;
                case R.id.nav_favorites:
                    setDisplayedFragment(new FavoritesFragment());

                    break;
                case R.id.nav_trash:
                    setDisplayedFragment(new TrashFragment());

                    break;
            }

            setTitle(menuItem.getTitle());
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();

            return true;
        }
    };
}
