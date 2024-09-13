package com.example.danvantd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.danvantd.Presentation.DocumentDetail.DetailDocument_Fragment;
import com.example.danvantd.Presentation.Document.Document_Fragment;
import com.example.danvantd.Presentation.GuongDetail.DetailGuong_Fragment;
import com.example.danvantd.Presentation.Guong.Guong_Fragment;
import com.example.danvantd.Presentation.NewsDetail.DetailNew_Fragment;
import com.example.danvantd.Presentation.News.Home_Fragment;
import com.example.danvantd.Presentation.News.New_Fragment;
import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_TINTUC = 1;
    private static final int FRAGMENT_VANBAN = 2;
    private static final int FRAGMENT_GUONG = 3;

    private int mCurrentFragment = FRAGMENT_HOME;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    private TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        onInIt();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id",-1);
        String type = bundle.getString("type");
        String detail = bundle.getString("chitiet");

        //Kiểm tra có phải qua detail ko
        if(detail.equals("")||type.equals("")){
            replaceFragment(new Home_Fragment());
            navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
            toolbar_title.setText(getString(R.string.title_home));
        }else{
            //Kiểm tra trả về chi tiết cái gì
            switch (detail){
                case "vanban":
                    //Gọi fragment
                    DetailDocument_Fragment detaidoc = new DetailDocument_Fragment();
                    //Set setArguments là bundle
                    detaidoc.setArguments(bundle);
                    replaceFragment(detaidoc);
                    navigationView.getMenu().findItem(R.id.nav_vanban).setChecked(true);
                    toolbar_title.setText(getString(R.string.title_chittiet));
                    mCurrentFragment = FRAGMENT_VANBAN;
                    break;
                case "guong":
                    //Gọi fragment
                    DetailGuong_Fragment detaiguong = new DetailGuong_Fragment();
                    //Set setArguments là bundle
                    detaiguong.setArguments(bundle);
                    replaceFragment(detaiguong);
                    navigationView.getMenu().findItem(R.id.nav_guongDienHinh).setChecked(true);
                    toolbar_title.setText(getString(R.string.title_chittiet));
                    mCurrentFragment = FRAGMENT_GUONG;
                    break;
                case "tintuc":
                    //Gọi fragment
                    DetailNew_Fragment detailNewFragment = new DetailNew_Fragment();
                    //Set setArguments là bundle
                    detailNewFragment.setArguments(bundle);
                    replaceFragment(detailNewFragment);
                    navigationView.getMenu().findItem(R.id.nav_tintuc).setChecked(true);
                    toolbar_title.setText(getString(R.string.title_chittiet));
                    mCurrentFragment = FRAGMENT_TINTUC;
                    break;
            }
        }

        // Tắt tiêu đề mặc định của Toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    protected void onInIt(){
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar_title = findViewById(R.id.toolbar_title);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home){
            if (mCurrentFragment != FRAGMENT_HOME){
                replaceFragment(new Home_Fragment());
                mCurrentFragment = FRAGMENT_HOME;
                toolbar_title.setText(getString(R.string.title_home));
            }
        } else if (id == R.id.nav_tintuc) {
            if (mCurrentFragment != FRAGMENT_TINTUC){
                replaceFragment(new New_Fragment());
                mCurrentFragment = FRAGMENT_TINTUC;
                toolbar_title.setText(getString(R.string.title_tintuc));

            }
        } else if (id == R.id.nav_vanban) {
            if (mCurrentFragment != FRAGMENT_VANBAN){
                replaceFragment(new Document_Fragment());
                mCurrentFragment = FRAGMENT_VANBAN;
                toolbar_title.setText(getString(R.string.title_vanban));

            }
        } else if (id == R.id.nav_guongDienHinh) {
            if (mCurrentFragment != FRAGMENT_GUONG){
                replaceFragment(new Guong_Fragment());
                mCurrentFragment = FRAGMENT_GUONG;
                toolbar_title.setText(getString(R.string.title_guongdienhinh));
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_content, fragment);
        transaction.commit();
    }
}