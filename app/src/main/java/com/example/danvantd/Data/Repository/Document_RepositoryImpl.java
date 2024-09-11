package com.example.danvantd.Data.Repository;

import com.example.danvantd.Data.API.App_api;
import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.Document_Detail;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Domain.Repository.Document_Repository;
import com.example.danvantd.Domain.Repository.News_Repository;
import com.example.danvantd.di.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Document_RepositoryImpl implements Document_Repository {
    private App_api app_api;

    @Override
    public void getlistVanBan(Callback<List<Document>> callback) {
        try {
            app_api = ServiceBuilder.buildService(App_api.class);
            Call<List<Document>> request = app_api.getlistVanBan();

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

    @Override
    public void getVanBan(Callback<Document_Detail> callback, int id) {
        try {
            app_api = ServiceBuilder.buildService(App_api.class);
            Call<Document_Detail> request = app_api.getVanBanbyId(id);
            if (callback != null) {
                request.enqueue(callback);
            } else {
                throw new IllegalArgumentException("Callback is null");
            };
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
