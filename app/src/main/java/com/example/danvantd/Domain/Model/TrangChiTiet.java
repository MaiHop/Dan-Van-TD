package com.example.danvantd.Domain.Model;

import java.io.Serializable;
import java.util.List;

public class TrangChiTiet implements Serializable {
    private int id, luotxemid_list, id_cat, id_item, id_sub;
    private long ngaytao;
    private String type, tenvi, tenkhongdauvi, tenkhongdauen, noidungvi, photo, options;
    private List<New>  list_news;
}

class New implements Serializable{
    private int id;
    private String tenvi, photo;
    private long ngaytao;
}