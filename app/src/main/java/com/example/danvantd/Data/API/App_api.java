package com.example.danvantd.Data.API;


import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.Document_Detail;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.News_Detail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface App_api {
    //Trang Home
    @GET("ajax/ajax_news.php?type=tin-tuc&noibat=1")
    Call<List<Home>> getlistTinTuc();

    //Trang chi tiết tin tức
    @GET("ajax/ajax_news.php")
    Call<News_Detail> getTinTucbyId(@Query("id") int id);

    //Trang văn bản công tác
    @GET("ajax/ajax_news.php?type=van-ban-cong-tac")
    Call<List<Document>> getlistVanBan();

    @GET("ajax/ajax_news.php?")
    Call<Document_Detail> getVanBanbyId(@Query("type") String type,@Query("id") int id);
}
