package com.example.danvantd.Repository;

import com.example.danvantd.Data.API.Home_api;
import com.example.danvantd.Interface.Home_Interface;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.Service.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_Repository {
    private Home_Interface home_interface;

    public Home_Repository(Home_Interface home_interface) {
        this.home_interface = home_interface;
    }

    public void readlistTinTuc(){
        Home_api api = ServiceBuilder.buildService(Home_api.class);
        Call<List<Tintuc>> request = api.getlistTinTuc();
        request.enqueue(new Callback<List<Tintuc>>() {
            @Override
            public void onResponse(Call<List<Tintuc>> call, Response<List<Tintuc>> response) {
                home_interface.getlistTinTuc(response.body());
            }

            @Override
            public void onFailure(Call<List<Tintuc>> call, Throwable t) {

            }
        });
    }

}
