package com.example.danvantd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.danvantd.Data.API.App_api;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.TrangChiTiet;
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
        App_api api = ServiceBuilder.buildService(App_api.class);
        Call<TrangChiTiet> request = api.getTinTucbyId(282);
        request.enqueue(new Callback<TrangChiTiet>() {
            @Override
            public void onResponse(Call<TrangChiTiet> call, Response<TrangChiTiet> response) {
                if(response.isSuccessful() && response.body() != null){
                    tv_listTInTuc
                }
            }

            @Override
            public void onFailure(Call<TrangChiTiet> call, Throwable t) {
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }


}