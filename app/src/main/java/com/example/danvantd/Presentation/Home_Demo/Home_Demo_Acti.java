package com.example.danvantd.Presentation.Home_Demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Presentation.Home_Demo.Adapter.Home_Adapter;
import com.example.danvantd.Presentation.Home_Demo.ViewModel.Home_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class Home_Demo_Acti extends AppCompatActivity {
    private Home_ViewModel homeViewModel;
    private RecyclerView rv_ListNews;
    private TextView tb_title;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_demo);

        rv_ListNews = findViewById(R.id.rv_home_News);

        this.toolbar =findViewById(R.id.toolbar);
        this.tb_title =findViewById(R.id.tb_tilte);
        tb_title.setText("This is home");

        this.rv_ListNews.setLayoutManager(new LinearLayoutManager(this));

        homeViewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
        // Observe dữ liệu từ LiveData
        homeViewModel.getListNewsLiveData().observe(this, new Observer<List<Home>>() {
            @Override
            public void onChanged(List<Home> homes) {
                if(!homes.isEmpty()){
                    Home_Adapter adapter = new Home_Adapter(Home_Demo_Acti.this, homes);
                    rv_ListNews.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        homeViewModel.fetch_News();
    }
}