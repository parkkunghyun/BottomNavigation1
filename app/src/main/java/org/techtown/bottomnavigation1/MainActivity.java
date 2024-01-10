package org.techtown.bottomnavigation1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.techtown.bottomnavigation1.Fragment.FragHome;
import org.techtown.bottomnavigation1.Fragment.FragSettings;
import org.techtown.bottomnavigation1.Fragment.FragSearch;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private String TAG = "메인";
    Fragment fragment_home;
    Fragment fragment_star;
    Fragment fragment_group;
    Fragment fragment_hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home = new FragHome();
        fragment_hotel = new FragSettings();
        fragment_star = new FragSearch();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Log.i(TAG, "바텀 네비게이션 클릭");
                        if (item.getItemId() == R.id.home) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commit();
                            return true;
                        }
                        else if (item.getItemId() == R.id.search) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_star).commit();
                            return true;
                        }
                        else if (item.getItemId() == R.id.settings) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_hotel).commit();
                            return true;
                        }

                        return true;
                    }
                }
        );
    }
}