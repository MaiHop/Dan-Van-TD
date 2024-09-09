package com.example.danvantd.Data.API;


import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.Tintuc;
import com.example.danvantd.Domain.Model.TrangChiTiet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface App_api {
    @GET("ajax/ajax_news.php?type=tin-tuc&noibat=1")
    Call<List<Home>> getlistTinTuc();

    @GET("ajax/ajax_news.php")
    Call<TrangChiTiet> getTinTucbyId(@Query("id") int id);


}
