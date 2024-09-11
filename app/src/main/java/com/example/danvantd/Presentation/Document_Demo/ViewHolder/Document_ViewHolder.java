package com.example.danvantd.Presentation.Document_Demo.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.R;

public class Document_ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_document_Tenvi, tv_docment_Motavi;
    public LinearLayout ll_item_document;

    public Document_ViewHolder(@NonNull View itemView) {
        super(itemView);

        init();

    }



    public void updateUI(Document document) {
        this.tv_document_Tenvi.setText(document.getTenvi());
        this.tv_docment_Motavi.setText("Số hiệu: "+document.getDoc_sohieu()+" .Ngày ban hành: "+ document.getDoc_ngaybanhanh());


    }

    private void init() {
        this.tv_document_Tenvi = itemView.findViewById(R.id.tv_document_Tenvi);
        this.tv_docment_Motavi = itemView.findViewById(R.id.tv_docment_Motavi);
        this.ll_item_document = itemView.findViewById(R.id.ll_item_document);
    }
}
