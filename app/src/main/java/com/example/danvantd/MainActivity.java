package com.example.danvantd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.danvantd.Data.API.News_api;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.di.ServiceBuilder;


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
        News_api api = ServiceBuilder.buildService(News_api.class);
        Call<News_Detail> request = api.getTinTucbyTypeandId("tin-tuc",282);
        request.enqueue(new Callback<News_Detail>() {
            @Override
            public void onResponse(Call<News_Detail> call, Response<News_Detail> response) {
                if(response.isSuccessful() && response.body() != null){
                    News_Detail d = response.body();
//                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                        tv_listTInTuc.setText(Html.fromHtml(d.getNoidungvi(), Html.FROM_HTML_MODE_LEGACY));
//                    } else {
//                        tv_listTInTuc.setText(Html.fromHtml(d.getNoidungvi()));
//                    }
                    tv_listTInTuc.setText(d.getNoidungvi());
                }
            }

            @Override
            public void onFailure(Call<News_Detail> call, Throwable t) {
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }


}