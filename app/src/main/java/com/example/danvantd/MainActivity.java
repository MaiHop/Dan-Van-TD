package com.example.danvantd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.danvantd.Data.API.Home_api;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.di.ServiceBuilder;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv_listTInTuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_listTInTuc = findViewById(R.id.tv_listTinTuc);
        Home_api api = ServiceBuilder.buildService(Home_api.class);
        Call<List<Home>> request = api.getlistTinTuc();
        request.enqueue(new Callback<List<Home>>() {
            @Override
            public void onResponse(Call<List<Home>> call, Response<List<Home>> response) {
                if(response.isSuccessful() && response.body() != null){
                    for(Home h : response.body()){
                        Log.d("ID: ", h.getTenvi());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Home>> call, Throwable t) {
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }
}