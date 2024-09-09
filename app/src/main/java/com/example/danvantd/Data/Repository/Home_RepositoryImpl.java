package com.example.danvantd.Data.Repository;

import com.example.danvantd.Data.API.Home_api;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.Domain.Repository.Home_Repository;
import com.example.danvantd.di.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_RepositoryImpl implements Home_Repository {
    private Home_api home_api;

    @Override
    public void getlistTinTuc(Callback<List<Home>> callback) {
        try {
            home_api = ServiceBuilder.buildService(Home_api.class);
            Call<List<Home>> request = home_api.getlistTinTuc();

            request.enqueue(callback);
//            request.enqueue(new Callback<List<Tintuc>>() {
//                @Override
//                public void onResponse(Call<List<Tintuc>> call, Response<List<Tintuc>> response) {
////                    this.getlistTinTuc(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<List<Tintuc>> call, Throwable t) {
//
//                }
//            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getTinTuc() {
        try {
            home_api = ServiceBuilder.buildService(Home_api.class);
            Call<Tintuc> request = home_api.getTinTuc();
            request.enqueue(new Callback<Tintuc>() {
                @Override
                public void onResponse(Call<Tintuc> call, Response<Tintuc> response) {

                }

                @Override
                public void onFailure(Call<Tintuc> call, Throwable t) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
