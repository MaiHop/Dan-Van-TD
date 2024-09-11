package com.example.danvantd.Presentation.DetailPage_Demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.Image;
import com.example.danvantd.Presentation.DetailPage_Demo.ViewHolder.DetailNew_Image_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class DetailNew_Image_Adapter extends RecyclerView.Adapter<DetailNew_Image_ViewHolder>{
    private List<Image> list_img;
    private LayoutInflater minflater;

    public DetailNew_Image_Adapter(Context context, List<Image> list_img) {
        this.list_img = list_img;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DetailNew_Image_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_detailnew_image, parent, false);

        return new DetailNew_Image_ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list_img.size();
    }

    @Override
    public void onBindViewHolder(@NonNull DetailNew_Image_ViewHolder holder, int position) {
        Image img = list_img.get(position);

        holder.updateUI(img);

    }


}
