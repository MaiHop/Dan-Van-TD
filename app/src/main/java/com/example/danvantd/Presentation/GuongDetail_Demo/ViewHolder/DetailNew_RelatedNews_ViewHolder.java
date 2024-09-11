package com.example.danvantd.Presentation.GuongDetail_Demo.ViewHolder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.RelatedNews;
import com.example.danvantd.R;

public class DetailNew_RelatedNews_ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_detailnew_RelatedNews;

    public LinearLayout ll_detailnew_RelatedNews;
    public DetailNew_RelatedNews_ViewHolder(@NonNull View itemView) {
        super(itemView);

        init();
    }

    public void updateUI(RelatedNews n) {
        this.tv_detailnew_RelatedNews.setText(n.getTenvi());

    }

    private void init() {
        this.tv_detailnew_RelatedNews = itemView.findViewById(R.id.tv_detailnew_RelatedNews);
        this.ll_detailnew_RelatedNews = itemView.findViewById(R.id.ll_detailnew_RelatedNews);
    }
}
