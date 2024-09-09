package com.example.danvantd.Data.Repository;

import com.example.danvantd.Data.API.Home_api;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.Domain.Repository.Home_Repository;
import com.example.danvantd.Interface.Home_Interface;
import com.example.danvantd.Service.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_RepositoryImpl implements Home_Repository {
    private Home_api home_api;

    @Override
    public void getlistTinTuc(List<Tintuc> list) {
        try {
            home_api = ServiceBuilder.buildService(Home_api.class);
            Call<List<Tintuc>> request = home_api.getlistTinTuc();
            request.enqueue(new Callback<List<Tintuc>>() {
                @Override
                public void onResponse(Call<List<Tintuc>> call, Response<List<Tintuc>> response) {
//                    this.getlistTinTuc(response.body());
                }

                @Override
                public void onFailure(Call<List<Tintuc>> call, Throwable t) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
