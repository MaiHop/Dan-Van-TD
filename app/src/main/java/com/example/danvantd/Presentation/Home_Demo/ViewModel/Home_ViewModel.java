package com.example.danvantd.Presentation.Home_Demo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Repository.Home_Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_ViewModel extends ViewModel {
    private Home_Repository home_repository;
    private MutableLiveData<List<Home>> list_News_LiveData = new MutableLiveData<>();

    public Home_ViewModel(Home_Repository home_repository) {
        this.home_repository = home_repository;
        this.fetch_News();
    }

    public LiveData<List<Home>> getListNewsLiveData() {
        return list_News_LiveData;
    }

    public void fetch_News(){
        home_repository.getlistTinTuc(new Callback<List<Home>>() {
            @Override
            public void onResponse(Call<List<Home>> call, Response<List<Home>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    list_News_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Home>> call, Throwable t) {
                list_News_LiveData.postValue(null);
            }
        });
    }

//    public MutableLiveData<List<Home>> getListCartLiveData() {
//        res.readGioHang();
//        return listGioHangLiveData;
//    }
}
