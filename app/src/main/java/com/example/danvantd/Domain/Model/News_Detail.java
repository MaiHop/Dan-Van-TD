package com.example.danvantd.Domain.Model;

import java.io.Serializable;
import java.util.List;

public class News_Detail implements Serializable {
    private int id, luotxem,id_list, id_cat, id_item, id_sub;
    private long ngaytao;
    private String type, tenvi, tenkhongdauvi, tenkhongdauen, noidungvi, photo, options;
    private List<News> news;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(long ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTenvi() {
        return tenvi;
    }

    public void setTenvi(String tenvi) {
        this.tenvi = tenvi;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}


