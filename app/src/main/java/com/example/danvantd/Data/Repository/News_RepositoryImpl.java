package com.example.danvantd.Data.Repository;

import com.example.danvantd.Data.API.News_api;
import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Domain.Repository.News_Repository;
import com.example.danvantd.di.ServiceBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class News_RepositoryImpl implements News_Repository {
    private News_api news_api;


    @Override
    public void getlistNews_Home(Callback<List<News>> callback) {
        try {
            news_api = ServiceBuilder.buildService(News_api.class);
            Call<List<News>> request = news_api.getlistTinTuc_Home();
            if (callback != null) {
                request.enqueue(callback);
            } else {
                throw new IllegalArgumentException("Callback is null");
            };
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getlistNewsbyType(Callback<List<News>> callback,String type) {
        try {
            news_api = ServiceBuilder.buildService(News_api.class);
            Call<List<News>> request = news_api.getlistTinTucbyType(type);
            if (callback != null) {
                request.enqueue(callback);
            } else {
                throw new IllegalArgumentException("Callback is null");
            };
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getNewsbyTypeandId(Callback<News_Detail> callback, String type, int id) {
        try {
            news_api = ServiceBuilder.buildService(News_api.class);
            Call<News_Detail> request = news_api.getTinTucbyTypeandId(type,id);
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
