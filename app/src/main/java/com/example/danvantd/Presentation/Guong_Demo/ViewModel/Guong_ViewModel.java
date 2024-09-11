package com.example.danvantd.Presentation.Guong_Demo.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.danvantd.Data.Repository.News_RepositoryImpl;
import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Domain.Repository.News_Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Guong_ViewModel extends ViewModel {
    private News_Repository news_repository;
    private MutableLiveData<List<News>> list_News_LiveData = new MutableLiveData<>();

    public Guong_ViewModel() {
        this.news_repository = new News_RepositoryImpl();
    }

    public LiveData<List<News>> getListNewsLiveData() {
        return list_News_LiveData;
    }

    public void fetch_News_Home(){
        news_repository.getlistNews_Home(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    list_News_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                list_News_LiveData.postValue(null);
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }

    public void fetch_News(String type){
        news_repository.getlistNewsbyType(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    list_News_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                list_News_LiveData.postValue(null);
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        },type);
    }

}
