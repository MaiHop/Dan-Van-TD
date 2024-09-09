package com.example.danvantd.Presentation.Home_Demo.ViewHolder;

import static java.security.AccessController.getContext;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.R;

public class Home_ViewHolder extends RecyclerView.ViewHolder {

    ImageView iv_Photo;
    TextView tv_Tenvi, tv_Motavi;

    public Home_ViewHolder(@NonNull View itemView) {
        super(itemView);

        init();
    }

    public void updateUI(Home home) {
        Glide.with(itemView)
                .load(home.getPhoto())
                .placeholder(R.drawable.ic_launcher_background) // ảnh hiển thị khi đang tải
                .error(R.drawable.ic_launcher_background)            // ảnh hiển thị khi có lỗi
                .into(iv_Photo);


    }

    private void init() {
        this.iv_Photo = itemView.findViewById(R.id.iv_Photo);
        this.tv_Tenvi = itemView.findViewById(R.id.tv_Tenvi);
        this.tv_Motavi = itemView.findViewById(R.id.tv_Motavi);
    }
}
