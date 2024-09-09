package com.example.danvantd.Data.Repository;

import com.example.danvantd.Data.API.App_api;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.Domain.Repository.Home_Repository;
import com.example.danvantd.di.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_RepositoryImpl implements Home_Repository {
    private App_api app_api;

    @Override
    public void getlistTinTuc(Callback<List<Home>> callback) {
        try {
            app_api = ServiceBuilder.buildService(App_api.class);
            Call<List<Home>> request = app_api.getlistTinTuc();

            // Đảm bảo callback không phải null
            if (callback != null) {
                request.enqueue(callback);
            } else {
                throw new IllegalArgumentException("Callback is null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
