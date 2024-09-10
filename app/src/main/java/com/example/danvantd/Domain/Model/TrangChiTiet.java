package com.example.danvantd.Domain.Model;

import java.io.Serializable;
import java.util.List;

public class TrangChiTiet implements Serializable {
    private int id, luotxemid_list, id_cat, id_item, id_sub;
    private long ngaytao;
    private String type, tenvi, tenkhongdauvi, tenkhongdauen, noidungvi, photo, options;
    private List<New>  list_news;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuotxemid_list() {
        return luotxemid_list;
    }

    public void setLuotxemid_list(int luotxemid_list) {
        this.luotxemid_list = luotxemid_list;
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

    public List<New> getList_news() {
        return list_news;
    }

    public void setList_news(List<New> list_news) {
        this.list_news = list_news;
    }
}

class New implements Serializable{
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