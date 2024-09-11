package com.example.danvantd.Domain.Model;

import java.io.Serializable;

public class Home implements Serializable {
    private int id;
    private String tenvi, motavi, photo;
    private long ngaytao;

    public Home() {
    }

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

    public String getMotavi() {
        return motavi;
    }

    public void setMotavi(String motavi) {
        this.motavi = motavi;
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
