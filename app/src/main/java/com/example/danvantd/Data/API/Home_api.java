package com.example.danvantd.Data.API;


import com.example.danvantd.Domain.Model.Tintuc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Home_api {
    @GET("ajax/ajax_news.php?type=tin-tuc&noibat=1")
    Call<List<Tintuc>> getlistTinTuc();

    @GET("ajax/ajax_news.php?id=282")
    Call<Tintuc> getTinTuc();

//    @GET("DacDiem/get")
//    Call<Tintuc> getDacDiem(@Query("id") Integer id);
//
//    @POST("DacDiem/create")
//    Call<Tintuc> createDacDiem(@Body DacDiem t);
//
//    @PUT("DacDiem/update")
//    Call<DacDiem> updateDacDiem(@Body DacDiem t);
//
//    @PUT("DacDiem/delete")
//    Call<DacDiem> deleteDacDiem(@Body DacDiem t);

}
