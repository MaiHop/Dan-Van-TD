package com.example.danvantd.Presentation.DetailPage_Demo.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.danvantd.Data.Repository.News_RepositoryImpl;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Domain.Repository.News_Repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailNew_ViewModel extends ViewModel {
    private News_Repository news_repository;
    private MutableLiveData<News_Detail> detailPage_LiveData = new MutableLiveData<>();

    public DetailNew_ViewModel() {
        this.news_repository = new News_RepositoryImpl();
    }

    public LiveData<News_Detail> getDetailNewLiveData() {
        return detailPage_LiveData;
    }

    public void fetch_DetailNew(int id) {
        news_repository.getTinTuc(new Callback<News_Detail>() {
            @Override
            public void onResponse(Call<News_Detail> call, Response<News_Detail> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    detailPage_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<News_Detail> call, Throwable t) {
                detailPage_LiveData.postValue(null);
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        },id);
    }


//    public MutableLiveData<List<Home>> getListCartLiveData() {
//        res.readGioHang();
//        return listGioHangLiveData;
//    }
}
