package com.ikelistiani.menubuttton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ikelistiani.menubuttton.fragment.DashboardFragment;
import com.ikelistiani.menubuttton.fragment.HomeFragment;
import com.ikelistiani.menubuttton.fragment.NotificationFragment;
import com.ikelistiani.menubuttton.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment = new HomeFragment();
    Fragment dashboardFragment = new DashboardFragment();
    Fragment notificationFragment = new NotificationFragment();
    Fragment userFragment = new UserFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragmentActive = homeFragment;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fragmentManager.beginTransaction().hide(fragmentActive).show(homeFragment).commit();
                    fragmentActive = homeFragment;

                    return true;

                case R.id.navigation_dashboard:
                    fragmentManager.beginTransaction().hide(fragmentActive).show(dashboardFragment).commit();
                    fragmentActive = dashboardFragment;

                    return true;

                case R.id.navigation_notifications:
                    fragmentManager.beginTransaction().hide(fragmentActive).show(notificationFragment).commit();
                    fragmentActive = notificationFragment;

                    return true;

                case R.id.navigation_user:
                    fragmentManager.beginTransaction().hide(fragmentActive).show(userFragment).commit();
                    fragmentActive = userFragment;

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager.beginTransaction().add(R.id.frameLayout, userFragment).hide(userFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout, dashboardFragment).hide(dashboardFragment).commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout, homeFragment). commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout, notificationFragment).hide(notificationFragment).commit();
    }

}
