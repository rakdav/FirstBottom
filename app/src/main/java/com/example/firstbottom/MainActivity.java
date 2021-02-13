package com.example.firstbottom;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.firstbottom.ui.dashboard.DashboardFragment;
import com.example.firstbottom.ui.home.HomeFragment;
import com.example.firstbottom.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment, HomeFragment.class,null).commit();
        bottomNavigationView=findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                Fragment fragment=null;
                switch (id)
                {
                    case R.id.navigation_home:
                        Toast.makeText(getApplicationContext(), "navigation_home", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,HomeFragment.class,null).commit();
                        return true;
                    case R.id.navigation_dashboard:
                        Toast.makeText(getApplicationContext(), "navigation_dashboard", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,DashboardFragment.class,null).commit();
                        return true;
                    case R.id.navigation_notifications:
                        Toast.makeText(getApplicationContext(), "navigation_notifications", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,NotificationsFragment.class,null).commit();
                        return true;
                }
                return false;
            }
        });
    }


}