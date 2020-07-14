package com.example.aatmnirbhar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeScreen extends AppCompatActivity {

    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bottomNav = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.fragment_container);

        if (savedInstanceState==null){
            bottomNav.setItemSelected(R.id.Home,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment abc = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,abc).commit();
        }

        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){

                    case R.id.auction:
                        fragment = new AuctionFragment();
                        break;
                    case R.id.bag:
                        fragment = new BagFragment();
                        break;
                    case R.id.Home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.wishlist:
                        fragment = new Wishlist();



                }

                if (fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
                }
            }
        });

    }
}