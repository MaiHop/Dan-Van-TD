package com.example.danvantd.Domain.Repository;

import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Domain.Model.News_Detail;

import java.util.List;

import retrofit2.Callback;

public interface News_Repository {

    public void getlistNews_Home(Callback<List<News>> callback);
    public void getlistNewsbyType(Callback<List<News>> callback,String type);
    public void getNewsbyTypeandId(Callback<News_Detail> callback,String type, int id);
}
