package com.example.danvantd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.danvantd.Data.API.App_api;
import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Domain.Model.Image;
import com.example.danvantd.di.ServiceBuilder;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv_listTInTuc,tv_Test_Noidungvi_content, tv_Test_Noidungvi_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_listTInTuc = findViewById(R.id.tv_listTinTuc);
        tv_Test_Noidungvi_content = findViewById(R.id.tv_Test_Noidungvi_content);
        tv_Test_Noidungvi_image = findViewById(R.id.tv_Test_Noidungvi_image);
        App_api api = ServiceBuilder.buildService(App_api.class);
        Call<List<Document>> request = api.getlistVanBan();
        request.enqueue(new Callback<List<Document>>() {
            @Override
            public void onResponse(Call<List<Document>> call, Response<List<Document>> response) {
                if(response.isSuccessful() && response.body() != null){
//                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                        tv_listTInTuc.setText(Html.fromHtml(d.getNoidungvi(), Html.FROM_HTML_MODE_LEGACY));
//                    } else {
//                        tv_listTInTuc.setText(Html.fromHtml(d.getNoidungvi()));
//                    }
                    Log.d("OKOKOK", String.valueOf(response.body().size()));
                }
            }

            @Override
            public void onFailure(Call<List<Document>> call, Throwable t) {
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }


}