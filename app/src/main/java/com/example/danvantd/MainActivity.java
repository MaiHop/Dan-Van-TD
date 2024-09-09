package com.example.danvantd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.danvantd.Data.API.Home_api;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.Service.ServiceBuilder;

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
        Call<List<Tintuc>> request = api.getlistTinTuc();
        request.enqueue(new Callback<List<Tintuc>>() {
            @Override
            public void onResponse(Call<List<Tintuc>> call, Response<List<Tintuc>> response) {
                if(response.isSuccessful() && response.body() !=null){
                    for (Tintuc tt : response.body()){
                        Log.d("ID TT: ", String.valueOf(tt.getId()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Tintuc>> call, Throwable t) {
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }
}