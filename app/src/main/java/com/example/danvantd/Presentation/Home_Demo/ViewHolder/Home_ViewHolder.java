package com.example.danvantd.Presentation.Home_Demo.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.R;

public class Home_ViewHolder extends RecyclerView.ViewHolder {

    ImageView iv_home_Photo;
    TextView tv_home_Tenvi, tv_home_Motavi;
    public LinearLayout ll_item_home;

    public Home_ViewHolder(@NonNull View itemView) {
        super(itemView);

        init();

    }



    public void updateUI(Home home) {
        Glide.with(itemView)
                .load(home.getPhoto())
                .placeholder(R.drawable.loading) // ảnh hiển thị khi đang tải
                .error(R.drawable.placeholder_image)            // ảnh hiển thị khi có lỗi
                .into(iv_home_Photo);
        this.tv_home_Tenvi.setText(home.getTenvi());
        this.tv_home_Motavi.setText(home.getMotavi());


    }

    private void init() {
        this.iv_home_Photo = itemView.findViewById(R.id.iv_home_Photo);
        this.tv_home_Tenvi = itemView.findViewById(R.id.tv_home_Tenvi);
        this.tv_home_Motavi = itemView.findViewById(R.id.tv_home_Motavi);
        this.ll_item_home = itemView.findViewById(R.id.ll_item_home);
    }
}
