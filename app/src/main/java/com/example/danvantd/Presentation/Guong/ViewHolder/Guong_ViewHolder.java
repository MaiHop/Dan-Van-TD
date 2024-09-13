package com.example.danvantd.Presentation.Guong.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.R;

public class Guong_ViewHolder extends RecyclerView.ViewHolder {

    ImageView iv_news_Photo;
    TextView tv_news_Tenvi, tv_news_Motavi;
    public LinearLayout ll_item_news;

    public Guong_ViewHolder(@NonNull View itemView) {
        super(itemView);

        init();

    }



    public void updateUI(News news) {
        Glide.with(itemView)
                .load(news.getPhoto())
                .placeholder(R.drawable.loading) // ảnh hiển thị khi đang tải
                .error(R.drawable.placeholder_image)            // ảnh hiển thị khi có lỗi
                .into(iv_news_Photo);
        this.tv_news_Tenvi.setText(news.getTenvi());
        this.tv_news_Motavi.setText(news.getMotavi());


    }

    private void init() {
        this.iv_news_Photo = itemView.findViewById(R.id.iv_news_Photo);
        this.tv_news_Tenvi = itemView.findViewById(R.id.tv_news_Tenvi);
        this.tv_news_Motavi = itemView.findViewById(R.id.tv_news_Motavi);
        this.ll_item_news = itemView.findViewById(R.id.ll_item_news);
    }
}
