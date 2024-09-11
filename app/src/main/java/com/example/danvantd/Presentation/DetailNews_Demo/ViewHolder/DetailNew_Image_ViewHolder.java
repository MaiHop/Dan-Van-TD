package com.example.danvantd.Presentation.DetailNews_Demo.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.Image;
import com.example.danvantd.R;

public class DetailNew_Image_ViewHolder extends RecyclerView.ViewHolder {

    ImageView iv_detailnew_Photo;
    TextView tv_detailnew_Tenvi;

    public DetailNew_Image_ViewHolder(@NonNull View itemView) {
        super(itemView);

        init();
    }

    public void updateUI(Image img) {
        Glide.with(itemView)
                .load(img.getSrc())
                .placeholder(R.drawable.loading) // ảnh hiển thị khi đang tải
                .error(R.drawable.placeholder_image)            // ảnh hiển thị khi có lỗi          // ảnh hiển thị khi có lỗi
                .into(iv_detailnew_Photo);
        this.tv_detailnew_Tenvi.setText(img.getContent());

    }

    private void init() {
        this.iv_detailnew_Photo = itemView.findViewById(R.id.iv_detailnew_Photo);
        this.tv_detailnew_Tenvi = itemView.findViewById(R.id.tv_detailnew_Tenvi);
    }
}
