package com.example.workshoprecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.workshoprecycler.fragments.ProfileFragment;
import com.example.workshoprecycler.fragments.TweetFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {

    // Membuat Bottom Navigation dengan cara lawas

    private Fragment fragment;

    private final BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new TweetFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();

                    getSupportActionBar().setTitle(item.getTitle());
                    return true;

                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //menghubungkan dengan bottomnav di layout dengan id nya
        BottomNavigationView navigationView = findViewById(R.id.nav_view2);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        //mengeset HomeFragment menjadi default fragment
        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.navigation_home);
        }

    }
}
