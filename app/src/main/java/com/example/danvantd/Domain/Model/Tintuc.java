package com.example.danvantd.Domain.Model;

import java.io.Serializable;
import java.util.Date;

public class Tintuc implements Serializable {
    private int id, doc_sohieu,luotxem,id_list, id_cat, id_item, id_sub;
    private String tenvi, motavi, photo, type, tenkhongdauvi, tenkhongdauen, noidungvi;
    private long doc_ngaybanhanh,ngaytao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoc_sohieu() {
        return doc_sohieu;
    }

    public void setDoc_sohieu(int doc_sohieu) {
        this.doc_sohieu = doc_sohieu;
    }

    public int getLuotxem() {
        return luotxem;
    }

    public void setLuotxem(int luotxem) {
        this.luotxem = luotxem;
    }

    public int getId_list() {
        return id_list;
    }

    public void setId_list(int id_list) {
        this.id_list = id_list;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_sub() {
        return id_sub;
    }

    public void setId_sub(int id_sub) {
        this.id_sub = id_sub;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTenkhongdauvi() {
        return tenkhongdauvi;
    }

    public void setTenkhongdauvi(String tenkhongdauvi) {
        this.tenkhongdauvi = tenkhongdauvi;
    }

    public String getTenkhongdauen() {
        return tenkhongdauen;
    }

    public void setTenkhongdauen(String tenkhongdauen) {
        this.tenkhongdauen = tenkhongdauen;
    }

    public String getNoidungvi() {
        return noidungvi;
    }

    public void setNoidungvi(String noidungvi) {
        this.noidungvi = noidungvi;
    }

    public long getDoc_ngaybanhanh() {
        return doc_ngaybanhanh;
    }

    public void setDoc_ngaybanhanh(long doc_ngaybanhanh) {
        this.doc_ngaybanhanh = doc_ngaybanhanh;
    }

    public long getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(long ngaytao) {
        this.ngaytao = ngaytao;
    }
}
