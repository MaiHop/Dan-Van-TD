package com.example.danvantd.Presentation.GuongDetail.ViewModel;

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

public class DetailGuong_ViewModel extends ViewModel {
    private News_Repository news_repository;
    private MutableLiveData<News_Detail> docDetail_LiveData = new MutableLiveData<>();

    public DetailGuong_ViewModel() {
        this.news_repository = new News_RepositoryImpl();
    }

    public LiveData<News_Detail> getDetailGuongLiveData() {
        return docDetail_LiveData;
    }

    public void fetch_DetailGuong(String type, int id) {
        news_repository.getNewsbyTypeandId(new Callback<News_Detail>() {
            @Override
            public void onResponse(Call<News_Detail> call, Response<News_Detail> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    docDetail_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<News_Detail> call, Throwable t) {
                docDetail_LiveData.postValue(null);
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        },type,id);
    }


}
