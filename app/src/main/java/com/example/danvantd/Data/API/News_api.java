package com.example.danvantd.Data.API;


import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Domain.Model.News_Detail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface News_api {
    //Trang Home
    @GET("ajax/ajax_news.php?type=tin-tuc&noibat=1")
    Call<List<News>> getlistTinTuc_Home();

    //Lấy tin tức
    @GET("ajax/ajax_news.php")
    Call<List<News>> getlistTinTucbyType(@Query("type") String type);

    //Trang chi tiết tin tức
    @GET("ajax/ajax_news.php")
    Call<News_Detail> getTinTucbyTypeandId(@Query("type") String type,@Query("id") int id);

}
