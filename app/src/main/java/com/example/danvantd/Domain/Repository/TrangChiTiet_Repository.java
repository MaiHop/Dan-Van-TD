package com.example.danvantd.Domain.Repository;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Domain.Model.TrangChiTiet;

import java.util.List;

import retrofit2.Callback;

public interface TrangChiTiet_Repository {
    public void getTinTuc(Callback<TrangChiTiet> callback, int id);
}
