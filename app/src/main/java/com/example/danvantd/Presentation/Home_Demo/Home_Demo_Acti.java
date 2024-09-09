package com.example.danvantd.Presentation.Home_Demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Repository.Home_Repository;
import com.example.danvantd.Presentation.Home_Demo.Adapter.Home_Adapter;
import com.example.danvantd.Presentation.Home_Demo.ViewModel.Home_ViewModel;
import com.example.danvantd.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_Demo_Acti extends AppCompatActivity {
    private Home_ViewModel homeViewModel;
    private RecyclerView rv_ListNews;

    private Home_Repository home_repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_demo);

        rv_ListNews = findViewById(R.id.rv_ListNews);

        this.rv_ListNews.setLayoutManager(new LinearLayoutManager(this));

        home_repository.getlistTinTuc(new Callback<List<Home>>() {
            @Override
            public void onResponse(Call<List<Home>> call, Response<List<Home>> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.d("ListSIZE",String.valueOf(response.body().size()));
                }
            }

            @Override
            public void onFailure(Call<List<Home>> call, Throwable t) {

            }
        });

//        homeViewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
//        // Observe dữ liệu từ LiveData
//        homeViewModel.getListNewsLiveData().observe(this, new Observer<List<Home>>() {
//            @Override
//            public void onChanged(List<Home> homes) {
//                if(!homes.isEmpty()){
//                    Log.d("ListSIZE",String.valueOf(homes.size()));
//                }
//            }
//        });

        // Gọi hàm để lấy dữ liệu
//        homeViewModel.fetch_News();
    }
}