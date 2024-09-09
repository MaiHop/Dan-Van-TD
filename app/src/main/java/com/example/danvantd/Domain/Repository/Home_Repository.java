package com.example.danvantd.Domain.Repository;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.Tintuc;

import java.util.List;

import retrofit2.Callback;

public interface Home_Repository {

    public void getlistTinTuc(Callback<List<Home>> callback);
    public void getTinTuc();
}
