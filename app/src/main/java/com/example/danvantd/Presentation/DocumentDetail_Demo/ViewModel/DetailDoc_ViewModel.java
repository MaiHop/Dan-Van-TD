package com.example.danvantd.Presentation.DocumentDetail_Demo.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.danvantd.Data.Repository.Document_RepositoryImpl;
import com.example.danvantd.Domain.Model.Document_Detail;
import com.example.danvantd.Domain.Repository.Document_Repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDoc_ViewModel extends ViewModel {
    private Document_Repository document_repository;
    private MutableLiveData<Document_Detail> docDetail_LiveData = new MutableLiveData<>();

    public DetailDoc_ViewModel() {
        this.document_repository = new Document_RepositoryImpl();
    }

    public LiveData<Document_Detail> getDetailDocLiveData() {
        return docDetail_LiveData;
    }

    public void fetch_DetailDoc(int id) {
        document_repository.getVanBan(new Callback<Document_Detail>() {
            @Override
            public void onResponse(Call<Document_Detail> call, Response<Document_Detail> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Cập nhật dữ liệu vào LiveData
                    docDetail_LiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Document_Detail> call, Throwable t) {
                docDetail_LiveData.postValue(null);
                Log.e("API Error", "Không thể kết nối đến API", t);
            }
        },id);
    }


}
