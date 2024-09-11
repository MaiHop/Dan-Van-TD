package com.example.danvantd.Domain.Model;

import java.io.Serializable;

public class Document implements Serializable {
    private int id;
    private String tenvi, motavi, photo, doc_sohieu,doc_ngaybanhanh;
    private long ngaytao;

    public Document() {
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

    public String getDoc_sohieu() {
        return doc_sohieu;
    }

    public void setDoc_sohieu(String doc_sohieu) {
        this.doc_sohieu = doc_sohieu;
    }

    public String getDoc_ngaybanhanh() {
        return doc_ngaybanhanh;
    }

    public void setDoc_ngaybanhanh(String doc_ngaybanhanh) {
        this.doc_ngaybanhanh = doc_ngaybanhanh;
    }

    public long getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(long ngaytao) {
        this.ngaytao = ngaytao;
    }
}
