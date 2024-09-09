package com.example.danvantd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.danvantd.Data.API.Home_api;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.di.ServiceBuilder;


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
        Call<Tintuc> request = api.getTinTuc();
        request.enqueue(new Callback<Tintuc>() {
            @Override
            public void onResponse(Call<Tintuc> call, Response<Tintuc> response) {
                if (response.isSuccessful() && response.body() != null){
                    Tintuc tt =response.body();
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        tv_listTInTuc.setText(Html.fromHtml(tt.getNoidungvi(), Html.FROM_HTML_MODE_LEGACY));
                    } else {
                        tv_listTInTuc.setText(Html.fromHtml(tt.getNoidungvi()));
                    }
                }
            }

            @Override
            public void onFailure(Call<Tintuc> call, Throwable t) {
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }
}