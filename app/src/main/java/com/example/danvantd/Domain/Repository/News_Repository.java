package com.example.danvantd.Domain.Repository;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.News_Detail;

import java.util.List;

import retrofit2.Callback;

public interface News_Repository {

    public void getlistTinTuc(Callback<List<Home>> callback);
    public void getTinTuc(Callback<News_Detail> callback, int id);
}
