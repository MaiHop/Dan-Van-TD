package com.example.danvantd.Domain.Repository;

import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.Document_Detail;

import java.util.List;

import retrofit2.Callback;

public interface Document_Repository {
    public void getlistVanBan(Callback<List<Document>> callback);
    public void getVanBan(Callback<Document_Detail> callback, int id);

}
