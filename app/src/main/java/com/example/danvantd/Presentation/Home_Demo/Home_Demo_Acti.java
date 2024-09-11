package com.example.danvantd.Presentation.Home_Demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Presentation.Home_Demo.Adapter.Home_Adapter;
import com.example.danvantd.Presentation.Home_Demo.ViewModel.Home_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class Home_Demo_Acti extends AppCompatActivity {
    private Home_ViewModel home_viewModel;
    private RecyclerView rv_home_News;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_demo);

        rv_home_News = findViewById(R.id.rv_home_News);

        this.rv_home_News.setLayoutManager(new LinearLayoutManager(this));

        home_viewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
        // Observe dữ liệu từ LiveData
        home_viewModel.getListNewsLiveData().observe(this, new Observer<List<Home>>() {
            @Override
            public void onChanged(List<Home> homes) {
                if(!homes.isEmpty()){
                    Home_Adapter adapter = new Home_Adapter(Home_Demo_Acti.this, homes);
                    rv_home_News.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        home_viewModel.fetch_News();
    }
}