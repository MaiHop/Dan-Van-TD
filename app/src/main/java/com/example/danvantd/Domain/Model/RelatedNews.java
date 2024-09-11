package com.example.danvantd.Domain.Model;

import java.io.Serializable;

public class RelatedNews implements Serializable {
    private int id;
    private String tenvi, photo;
    private long ngaytao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenvi() {
        return tenvi;
    }

    public void setTenvi(String tenvi) {
        this.tenvi = tenvi;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(long ngaytao) {
        this.ngaytao = ngaytao;
    }
}
