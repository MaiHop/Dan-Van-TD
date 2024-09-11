package com.example.danvantd.Presentation.Document_Demo.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.danvantd.Data.Repository.Document_RepositoryImpl;
import com.example.danvantd.Data.Repository.News_RepositoryImpl;
import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Repository.Document_Repository;
import com.example.danvantd.Domain.Repository.News_Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Document_ViewModel extends ViewModel {
    private Document_Repository document_repository;
    private MutableLiveData<List<Document>> list_Document_LiveData = new MutableLiveData<>();

    public Document_ViewModel() {
        this.document_repository = new Document_RepositoryImpl();
    }

    public LiveData<List<Document>> getListNewsLiveData() {
        return list_Document_LiveData;
    }

    public void fetch_Document(){
        document_repository.getlistVanBan(new Callback<List<Document>>() {
            @Override
            public void onResponse(Call<List<Document>> call, Response<List<Document>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    list_Document_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Document>> call, Throwable t) {
                list_Document_LiveData.postValue(null);
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        });
    }

}
